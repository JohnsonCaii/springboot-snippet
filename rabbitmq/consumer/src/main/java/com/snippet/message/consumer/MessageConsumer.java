package com.snippet.message.consumer;

import org.springframework.messaging.handler.annotation.Payload;

/**
 * Created by caie on 09/11/2017.
 */
public interface MessageConsumer<T> {

    void onMessage(@Payload T message);
}
