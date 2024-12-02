package com.example.Lab09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Lab09.dto.course_program.CourseProgramRequest;
import com.example.Lab09.dto.course_program.CourseProgramResponse;
import com.example.Lab09.services.CourseProgramService;

@RestController
@RequestMapping("/api/course_program")
public class CourseProgramController {

    @Autowired
    private CourseProgramService courseProgramService;

    @PostMapping
    public CourseProgramResponse createCourseProgram(@RequestBody CourseProgramRequest courseProgramRequest) {
        return courseProgramService.createCourseProgram(courseProgramRequest);
    }

    @GetMapping
    public CourseProgramResponse getAllCoursePrograms() {
        return courseProgramService.getAllCoursePrograms();
    }

    @PutMapping("/{courseId}/{programId}")
    public CourseProgramResponse updateCourseProgram(
            @PathVariable String courseId,
            @PathVariable Integer programId,
            @RequestBody CourseProgramRequest courseProgramRequest) {
        return courseProgramService.updateCourseProgram(courseId, programId, courseProgramRequest);
    }

    @DeleteMapping("/{courseId}/{programId}")
    public CourseProgramResponse deleteCourseProgram(@PathVariable String courseId, @PathVariable Integer programId) {
        return courseProgramService.deleteCourseProgram(courseId, programId);
    }
}
