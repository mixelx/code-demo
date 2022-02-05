package com.example.demo.service

import com.example.demo.dto.CommonRequestDto
import com.example.demo.enumerated.SearchableType

interface BaseSearchService<T> {
    val type: SearchableType
    fun search(request: CommonRequestDto): T
}