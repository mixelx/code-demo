package com.example.demo.model

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Task(
    @Id
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val description: String,
    val isCompleted: Boolean = false,
)