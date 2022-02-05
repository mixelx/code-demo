package com.example.demo.repository;

import com.example.demo.model.EducationMaterial
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface EducationMaterialRepository : JpaRepository<EducationMaterial, UUID>