package com.example.demo.service

import com.example.demo.dto.CommonRequestDto
import com.example.demo.enumerated.SearchableType
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service

@Service
class SearchService(
    private val searchServices: List<BaseSearchService<*>>,
    private val objectMapper: ObjectMapper
) {
    fun search(requestDto: CommonRequestDto): String {
        return searchServices.associateBy { it.type }
            .get(requestDto.searchableType)
            ?.search(requestDto)
            ?.let { objectMapper.writeValueAsString(it) }
            ?: throw UnsupportedOperationException("Unsupported searchable type: ${requestDto.searchableType}")
    }

    private fun searchV2(requestDto: CommonRequestDto): String {
        return STRATEGY_MAP.get(requestDto.searchableType)
            ?.invoke(this, requestDto)
            ?: throw UnsupportedOperationException()
    }

    private fun searchTasks(requestDto: CommonRequestDto): String {
        TODO()
    }

    private fun searchNotifications(requestDto: CommonRequestDto): String {
        TODO()
    }

    private fun searchMeetings(requestDto: CommonRequestDto): String {
        TODO()
    }

    private fun searchEducationMaterials(requestDto: CommonRequestDto): String {
        TODO()
    }

    companion object {
        private val STRATEGY_MAP = mapOf(
            SearchableType.TASKS to SearchService::searchTasks,
            SearchableType.EDUCATION_MATERIALS to SearchService::searchEducationMaterials,
            SearchableType.NOTIFICATIONS to SearchService::searchNotifications,
            SearchableType.MEETINGS to SearchService::searchMeetings
        )
    }
}