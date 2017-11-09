package com.snippet.message.consumer;


import com.rabbit.common.config.RabbitConfiguration;
import com.rabbit.common.entity.UserBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by caie on 09/11/2017.
 */
@Component
@Slf4j
public class DirectMessageConsumer implements MessageConsumer<UserBO> {

    @RabbitListener(queues = RabbitConfiguration.QUEUE)
    @Override
    public void onMessage(@Payload UserBO userBO) {
        log.info("direct message received => [ name: {} ]", userBO.getName());
    }

}
