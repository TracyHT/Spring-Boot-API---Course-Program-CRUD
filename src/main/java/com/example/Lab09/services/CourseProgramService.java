package com.example.Lab09.services;

import com.example.Lab09.dto.course_program.CourseProgramRequest;
import com.example.Lab09.dto.course_program.CourseProgramResponse;

public interface CourseProgramService {
    CourseProgramResponse createCourseProgram(CourseProgramRequest courseProgramRequest);
    CourseProgramResponse getAllCoursePrograms();
    CourseProgramResponse updateCourseProgram(String courseId, Integer programId, CourseProgramRequest courseProgramRequest);
    CourseProgramResponse deleteCourseProgram(String courseId, Integer programId);
}
