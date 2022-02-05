package com.example.demo.model

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class EducationMaterial(
    @Id
    val id: UUID  = UUID.randomUUID(),
    val title: String,
    val author: String,
    val content: String,
)