package com.snippet.message.producer;

import com.rabbit.common.config.RabbitConfiguration;
import com.rabbit.common.entity.UserBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by caie on 09/11/2017.
 */
@Component
@Slf4j
public class DirectMessageProducer implements MessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private AtomicInteger forLoopTimes = new AtomicInteger();

    @Scheduled(initialDelay = 2000, fixedRate = 3000)
    @Override
    public void produce() {

        final UserBO userBo = UserBO.builder()
                .address("test-address")
                .age(1)
                .name("test-name => " + forLoopTimes.getAndIncrement())
                .build();
        rabbitTemplate.convertAndSend(RabbitConfiguration.EXCHANGE, RabbitConfiguration.ROUTE_KEY, userBo);

        log.info(" Direct Message => 成功发送消息 \n");
    }

}
