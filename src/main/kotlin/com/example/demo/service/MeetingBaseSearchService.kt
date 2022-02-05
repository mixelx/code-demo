package com.example.demo.service

import com.example.demo.dto.CommonRequestDto
import com.example.demo.enumerated.SearchableType
import com.example.demo.model.Meeting
import com.example.demo.repository.MeetingRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class MeetingBaseSearchService(private val meetingRepository: MeetingRepository) : BaseSearchService<Meeting> {
    override val type: SearchableType
        get() = SearchableType.MEETINGS

    override fun search(request: CommonRequestDto): Meeting {
        return meetingRepository.findByIdOrNull(request.id) ?: throw EntityNotFoundException()
    }
}