package com.example.demo.init

import com.example.demo.model.EducationMaterial
import com.example.demo.model.Meeting
import com.example.demo.model.Notification
import com.example.demo.model.Task
import com.example.demo.repository.EducationMaterialRepository
import com.example.demo.repository.MeetingRepository
import com.example.demo.repository.NotificationRepository
import com.example.demo.repository.TaskRepository
import org.apache.commons.lang3.RandomStringUtils.randomAlphabetic
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class StartupDataInitializer(
    private val taskRepository: TaskRepository,
    private val meetingRepository: MeetingRepository,
    private val notificationRepository: NotificationRepository,
    private val educationMaterialRepository: EducationMaterialRepository,
) {
    @EventListener(ApplicationReadyEvent::class)
    fun initData() {
        initTasks()
        initMeetings()
        initNotifications()
        initEducationMaterials()
    }

    private fun initTasks() {
        (0..5).forEach { _ ->
            taskRepository.save(
                Task(
                    name = randomAlphabetic(5),
                    description = randomAlphabetic(5)
                )
            )
        }
    }

    private fun initEducationMaterials() {
        (0..5).forEach { _ ->
            educationMaterialRepository.save(
                EducationMaterial(
                    title = randomAlphabetic(5),
                    author = randomAlphabetic(5),
                    content = randomAlphabetic(5)
                )
            )
        }
    }

    private fun initNotifications() {
        (0..5).forEach { _ ->
            notificationRepository.save(
                Notification(
                    message = randomAlphabetic(5),
                    recipient = randomAlphabetic(5)
                )
            )
        }
    }

    private fun initMeetings() {
        (0..5).forEach {
            meetingRepository.save(
                Meeting(
                    title = randomAlphabetic(5),
                    dateStart = LocalDateTime.now().plusDays(it.toLong()),
                    author = randomAlphabetic(5)
                )
            )
        }
    }
}