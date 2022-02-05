package com.example.demo.dto

import com.example.demo.enumerated.SearchableType
import java.util.UUID

data class CommonRequestDto(
    val id: UUID,
    val searchableType: SearchableType,
)