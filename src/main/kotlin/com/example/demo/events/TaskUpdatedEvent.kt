package com.example.demo.events

import com.example.demo.model.Task
import org.springframework.context.ApplicationEvent

class TaskUpdatedEvent(task: Task, source: Any) : ApplicationEvent(source)