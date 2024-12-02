package com.example.Lab09.services;

import com.example.Lab09.dto.course.CourseRequest;
import com.example.Lab09.dto.course.CourseResponse;

public interface CourseService {
    public CourseResponse getAllCourses();
    public CourseResponse createCourse(CourseRequest courseRequest);
    public CourseResponse getCourseById(String id);
    public CourseResponse updateCourse(String id, CourseRequest courseRequest);
    public CourseResponse deleteCourse(String id);
}
