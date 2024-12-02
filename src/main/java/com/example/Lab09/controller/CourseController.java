package com.example.Lab09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Lab09.dto.course.CourseRequest;
import com.example.Lab09.dto.course.CourseResponse;
import com.example.Lab09.services.CourseService;


@RestController
@RequestMapping("/api")
public class CourseController {
    
    @Autowired
    CourseService courseService;

    @PostMapping("/course")
    public CourseResponse createCourse(@RequestBody CourseRequest courseRequest) {
        return courseService.createCourse(courseRequest);
    }

    @GetMapping("/courses")
    public CourseResponse getAllCourses() {
        return courseService.getAllCourses(); 
    }

    @GetMapping("/course/{id}")
    public CourseResponse getCourseById(@PathVariable String id) {
        return courseService.getCourseById(id);
    }

    @PutMapping("/course/{id}")
    public CourseResponse updateCourse(@PathVariable String id, @RequestBody CourseRequest courseRequest) {
        return courseService.updateCourse(id, courseRequest);
    }

    @DeleteMapping("/course/{id}")
    public CourseResponse deleteCourse(@PathVariable String id) {
        return courseService.deleteCourse(id);
    }
}
