package com.example.demo.controller

import com.example.demo.dto.CommonRequestDto
import com.example.demo.service.SearchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SearchController(private val searchService: SearchService) {
    @GetMapping("/search")
    fun search(requestDto: CommonRequestDto) = searchService.search(requestDto)
}