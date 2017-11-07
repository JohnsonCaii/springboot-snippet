package com.snippet.task;

import com.snippet.repository.TransferRecordRepository;
import com.snippet.repository.model.TransferCurrency;
import com.snippet.repository.model.TransferRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by caie on 23/08/2017.
 */
@Component
public class TransferTask implements CommandLineRunner {

    @Value("${task_consumer.threads}")
    private Integer consumerThreads;

    @Value("${task_consumer.loop_wait_time}")
    private Integer loopWaitTime;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("consumerThreads: " + consumerThreads);
        System.out.println("loopWaitTime: " + loopWaitTime);
    }

}

@Component
class TransferRecordTask {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final AsyncProcess asyncProcess;

    @Autowired
    public TransferRecordTask(AsyncProcess asyncProcess) {
        this.asyncProcess = asyncProcess;
    }

    @Scheduled(initialDelay = 2000, fixedRateString = "${task_consumer.loop_wait_time}")
    public void scheduled() throws ExecutionException, InterruptedException {
        logger.info("开始循环");
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            futures.add(asyncProcess.testAsync(i));
        }


        while (true) {
            if (futures.stream().allMatch(Future::isDone)) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }

        logger.info("结束循环");

    }

}

@Component
class AsyncProcess {

    private final TransferRecordRepository transferRecordRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public AsyncProcess(TransferRecordRepository transferRecordRepository) {
        this.transferRecordRepository = transferRecordRepository;
    }

    @Async
    @Transactional
    public Future<String> testAsync(Integer i) throws InterruptedException {

        logger.info("async process thread name: {}, Integer: {}", Thread.currentThread().getName(), i);

        TransferRecord transferRecord = new TransferRecord();

        transferRecord.setUserId(1);
        transferRecord.setCurrency(TransferCurrency.CNY);
        transferRecord.setAmount(new BigDecimal(1));
        transferRecord.setUpdatedAt(new Date());
        transferRecordRepository.save(transferRecord);

        return new AsyncResult<>("return value: " + i);

    }
}

@Configuration
class SpringTaskScheduleBeanExample {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public TaskScheduler poolScheduler(@Value("${task_consumer.threads}") Integer consumerThreads) {
        logger.info(" 初始化 task 线程数为: {}", consumerThreads);
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("transfer-pool");
        scheduler.setPoolSize(consumerThreads);
        return scheduler;
    }

}