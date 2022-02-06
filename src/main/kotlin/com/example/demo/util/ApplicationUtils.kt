package com.example.demo.util

import org.springframework.context.ApplicationEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class ApplicationUtilsInitializer(applicationEventPublisher: ApplicationEventPublisher) {
    init {
        eventPublisher = applicationEventPublisher
    }
}

private lateinit var eventPublisher: ApplicationEventPublisher

fun ApplicationEvent.publish() = eventPublisher.publishEvent(this)