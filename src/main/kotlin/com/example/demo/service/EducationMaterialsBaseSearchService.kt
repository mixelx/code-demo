package com.example.demo.service

import com.example.demo.dto.CommonRequestDto
import com.example.demo.enumerated.SearchableType
import com.example.demo.model.EducationMaterial
import com.example.demo.repository.EducationMaterialRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class EducationMaterialsBaseSearchService(private val educationMaterialRepository: EducationMaterialRepository) :
    BaseSearchService<EducationMaterial> {
    override val type: SearchableType
        get() = SearchableType.EDUCATION_MATERIALS

    override fun search(request: CommonRequestDto): EducationMaterial {
        return educationMaterialRepository.findByIdOrNull(request.id) ?: throw EntityNotFoundException()
    }
}