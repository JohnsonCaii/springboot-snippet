package com.rabbit.common.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    public static final String EXCHANGE = "test_exchange";
    public static final String ROUTE_KEY = "test_routing_key";
    public static final String QUEUE = "test_queue";

    public static final String BROADCAST_EXCHANGE = "broad_cast_exchange_fanout";
    public static final String BROADCAST_QUEUE_1 = "broad_cast_queue_1";
    public static final String BROADCAST_QUEUE_2 = "broad_cast_queue_2";


    @Configuration
    class RabbitRelatedConfiguration {
        @Bean
        public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
            RabbitTemplate template = new RabbitTemplate(connectionFactory);
            template.setMessageConverter(new Jackson2JsonMessageConverter());
            return template;
        }

        @Bean
        public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
            SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
            factory.setConnectionFactory(connectionFactory);
            factory.setMessageConverter(new Jackson2JsonMessageConverter());
            return factory;
        }
    }

    @Configuration
    class QueueConfiguration {
        @Bean(name = QUEUE)
        public Queue testQueue() {
            return new Queue(QUEUE);
        }

        @Bean(name = BROADCAST_QUEUE_1)
        public Queue broadCastQueue() {
            return new Queue(BROADCAST_QUEUE_1);
        }

        @Bean(name = BROADCAST_QUEUE_2)
        public Queue broadCastQueue_2() {
            return new Queue(BROADCAST_QUEUE_2);
        }
    }

    @Configuration
    class ExchangeConfiguration {
        @Bean(name = EXCHANGE)
        public Exchange testExchange() {
            return new DirectExchange(EXCHANGE);
        }

        @Bean(name = BROADCAST_EXCHANGE)
        public Exchange broadCastExchange() {
            return new FanoutExchange(BROADCAST_EXCHANGE);
        }
    }

    @Configuration
    class BindingConfiguration {
        @Bean
        @Autowired
        public Binding queueBindExchange(@Qualifier(value = QUEUE) Queue queue,
                                         @Qualifier(value = EXCHANGE) Exchange exchange) {
            return BindingBuilder.bind(queue).to(exchange).with(ROUTE_KEY).noargs();
        }


        @Bean
        @Autowired
        public Binding broadCastExchangeBind(@Qualifier(value = BROADCAST_QUEUE_1) Queue queue,
                                             @Qualifier(value = BROADCAST_EXCHANGE) Exchange exchange) {
            return BindingBuilder.bind(queue).to(exchange).with("").noargs();
        }

        @Bean
        @Autowired
        public Binding broadCastExchangeBind_2(@Qualifier(value = BROADCAST_QUEUE_2) Queue queue,
                                               @Qualifier(value = BROADCAST_EXCHANGE) Exchange exchange) {
            return BindingBuilder.bind(queue).to(exchange).with("").noargs();
        }
    }

}
