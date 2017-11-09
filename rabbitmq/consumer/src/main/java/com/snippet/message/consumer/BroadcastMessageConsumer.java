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
public class BroadcastMessageConsumer implements MessageConsumer<UserBO> {

    @Override
    @RabbitListener(queues = RabbitConfiguration.BROADCAST_QUEUE_2)
    public void onMessage(@Payload UserBO message) {

        log.info("[broad-cast] queue-name: {},  message received => [ name: {} ]", RabbitConfiguration.BROADCAST_QUEUE_2, message.getName());

    }
}
