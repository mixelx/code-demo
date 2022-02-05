package com.example.demo.model

import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Meeting(
    @Id
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val dateStart: LocalDateTime,
    val author: String,
)