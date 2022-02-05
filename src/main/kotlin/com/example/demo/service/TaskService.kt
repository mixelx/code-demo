package com.example.demo.service

import com.example.demo.events.TaskUpdatedEvent
import com.example.demo.model.Task
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class TaskService(private val eventPublisher: ApplicationEventPublisher) {
    fun updateTask(task: Task) {
        // some logic...
        eventPublisher.publishEvent(TaskUpdatedEvent(task, this))
    }
}