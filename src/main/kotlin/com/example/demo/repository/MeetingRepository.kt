package com.example.demo.repository;

import com.example.demo.model.Meeting
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface MeetingRepository : JpaRepository<Meeting, UUID>