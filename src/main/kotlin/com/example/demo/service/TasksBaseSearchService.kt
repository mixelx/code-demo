package com.example.demo.service

import com.example.demo.dto.CommonRequestDto
import com.example.demo.enumerated.SearchableType
import com.example.demo.enumerated.SearchableType.TASKS
import com.example.demo.model.Task
import com.example.demo.repository.TaskRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class TasksBaseSearchService(private val taskRepository: TaskRepository) : BaseSearchService<Task> {
    override val type: SearchableType
        get() = TASKS

    override fun search(request: CommonRequestDto): Task {
        return taskRepository.findByIdOrNull(request.id) ?: throw EntityNotFoundException()
    }
}