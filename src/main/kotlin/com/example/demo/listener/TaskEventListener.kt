package com.example.demo.listener

import com.example.demo.events.TaskUpdatedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class TaskEventListener {
    @EventListener
    fun handleTaskUpdatedEvent(taskUpdatedEvent: TaskUpdatedEvent) {
        TODO()
    }
}