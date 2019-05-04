package com.store.records.service

import com.store.records.messages.Customer
import com.store.records.messages.Order
import mu.KotlinLogging
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

const val STORE_QUEUE = "allEvents"
const val CUSTOMER_RELATIONS_QUEUE = "customerRelationsDepartment"
const val ORDER_DISPATCH_QUEUE = "orderDispatchDepartment"

@Service
class EventConsumer {
    private val logger = KotlinLogging.logger { }

    @RabbitListener(queues = [CUSTOMER_RELATIONS_QUEUE])
    fun receiveNewCustomer(message: Customer) {
        logger.info(
            "Received Customer Details " +
                "{}", message
        )
    }

    @RabbitListener(queues = [ORDER_DISPATCH_QUEUE])
    fun receiveNewOrders(message: Order) {
        logger.info(
            "Received Order " +
                "{}", message
        )
    }

    @RabbitListener(queues = [STORE_QUEUE])
    fun allStoreEvents(message: Any) {
        logger.info(
            "Receiving all events " +
                "{}", message
        )
    }
}