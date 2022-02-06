package com.example.demo.model

import com.example.demo.events.TaskUpdatedEvent
import com.example.demo.util.publish
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.PostUpdate

@Entity
class Task(
    @Id
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val description: String,
    val isCompleted: Boolean = false,
) {
    @PostUpdate
    fun postUpdate() {
        TaskUpdatedEvent(this, this).publish()
    }
}
