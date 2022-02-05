package com.example.demo.service

import com.example.demo.dto.CommonRequestDto
import com.example.demo.enumerated.SearchableType
import com.example.demo.model.Notification
import com.example.demo.repository.NotificationRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class NotificationBaseSearchService(private val notificationRepository: NotificationRepository) :
    BaseSearchService<Notification> {
    override val type: SearchableType
        get() = SearchableType.NOTIFICATIONS

    override fun search(request: CommonRequestDto): Notification {
        return notificationRepository.findByIdOrNull(request.id) ?: throw EntityNotFoundException()
    }
}