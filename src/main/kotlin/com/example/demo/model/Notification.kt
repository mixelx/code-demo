package com.example.demo.model

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Notification(
    @Id
    val id: UUID = UUID.randomUUID(),
    val message: String,
    val recipient: String,
    val isRead: Boolean = false,
)