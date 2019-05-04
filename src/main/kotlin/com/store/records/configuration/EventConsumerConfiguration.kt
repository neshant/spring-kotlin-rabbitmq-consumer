package com.store.records.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.rabbit.core.RabbitTemplate

@Configuration
class EventConsumerConfiguration {

    @Bean
    fun rabbitTemplate(
        connectionFactory: ConnectionFactory,
        jackson2MessageConverter: Jackson2JsonMessageConverter
    ): RabbitTemplate {
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.messageConverter = jackson2MessageConverter
        return rabbitTemplate
    }

    @Bean
    fun jackson2MessageConverter(): Jackson2JsonMessageConverter {
        return Jackson2JsonMessageConverter()
    }
}
