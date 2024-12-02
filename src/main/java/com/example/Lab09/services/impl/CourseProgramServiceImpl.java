package com.example.Lab09.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Lab09.dto.course_program.CourseProgramRequest;
import com.example.Lab09.dto.course_program.CourseProgramResponse;
import com.example.Lab09.entity.Course;
import com.example.Lab09.entity.Program;
import com.example.Lab09.entity.CourseProgram;
import com.example.Lab09.repository.CourseProgramRepository;
import com.example.Lab09.repository.CourseRepository;
import com.example.Lab09.repository.ProgramRepository;
import com.example.Lab09.services.CourseProgramService;
import com.example.Lab09.utils.ResponseUtil;

@Service
public class CourseProgramServiceImpl implements CourseProgramService {

    @Autowired
    private CourseProgramRepository courseProgramRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ProgramRepository programRepository;

    @Override
    public CourseProgramResponse getAllCoursePrograms() {
        List<CourseProgram> coursePrograms = courseProgramRepository.findAll();
        return CourseProgramResponse.builder()
            .responseCode(coursePrograms.isEmpty() ? ResponseUtil.NOT_FOUND_CODE : ResponseUtil.SUCCESS_CODE)
            .responseMessage(coursePrograms.isEmpty() ? ResponseUtil.COURSE_PROGRAM_NOT_FOUND : ResponseUtil.COURSE_PROGRAM_FOUND)
            .coursePrograms(coursePrograms)  
            .build();
    }

    @Override
    public CourseProgramResponse createCourseProgram(CourseProgramRequest courseProgramRequest) {
        Optional<Course> course = courseRepository.findById(String.valueOf(courseProgramRequest.getCourse_id())); 
        Optional<Program> program = programRepository.findById(courseProgramRequest.getProgram_id()); 
        if (course.isPresent() && program.isPresent()) {
            CourseProgram courseProgram = new CourseProgram();
            courseProgram.setCourse(course.get());
            courseProgram.setProgram(program.get());
            courseProgram.setCourseCode(courseProgramRequest.getCourse_code());
            courseProgram.setCourseTypeId(courseProgramRequest.getCourse_type_id());

            CourseProgram savedCourseProgram = courseProgramRepository.save(courseProgram);

            return CourseProgramResponse.builder()
                .responseCode(ResponseUtil.CREATED_CODE)
                .responseMessage(ResponseUtil.COURSE_PROGRAM_CREATED_SUCCESS)
                .courseProgramInfo(savedCourseProgram) 
                .build();
        } else {
            return CourseProgramResponse.builder()
                .responseCode(ResponseUtil.NOT_FOUND_CODE)
                .responseMessage(ResponseUtil.COURSE_PROGRAM_NOT_FOUND)
                .build();
        }
    }

    @Override
    public CourseProgramResponse updateCourseProgram(String courseId, Integer programId, CourseProgramRequest courseProgramRequest) {
        Optional<Course> course = courseRepository.findById(courseId); 
        Optional<Program> program = programRepository.findById(programId); 

        if (course.isPresent() && program.isPresent()) {
            CourseProgram courseProgram = courseProgramRepository.findByCourseAndProgram(course.get(), program.get());

            if (courseProgram != null) {
                courseProgram.setCourseCode(courseProgramRequest.getCourse_code());
                courseProgram.setCourseTypeId(courseProgramRequest.getCourse_type_id());

                CourseProgram updatedCourseProgram = courseProgramRepository.save(courseProgram);

                return CourseProgramResponse.builder()
                    .responseCode(ResponseUtil.SUCCESS_CODE)
                    .responseMessage(ResponseUtil.COURSE_PROGRAM_UPDATED_SUCCESS)
                    .courseProgramInfo(updatedCourseProgram) 
                    .build();
            } else {
                return CourseProgramResponse.builder()
                    .responseCode(ResponseUtil.NOT_FOUND_CODE)
                    .responseMessage(ResponseUtil.COURSE_PROGRAM_NOT_FOUND)
                    .build();
            }
        } else {
            return CourseProgramResponse.builder()
                .responseCode(ResponseUtil.NOT_FOUND_CODE)
                .responseMessage(ResponseUtil.COURSE_PROGRAM_NOT_FOUND)
                .build();
        }
    }

    @Override
    public CourseProgramResponse deleteCourseProgram(String courseId, Integer programId) {
        Optional<Course> course = courseRepository.findById(courseId); 
        Optional<Program> program = programRepository.findById(programId); 

        if (course.isPresent() && program.isPresent()) {
            CourseProgram courseProgram = courseProgramRepository.findByCourseAndProgram(course.get(), program.get());

            if (courseProgram != null) {
                courseProgramRepository.delete(courseProgram);

                return CourseProgramResponse.builder()
                    .responseCode(ResponseUtil.SUCCESS_CODE)
                    .responseMessage(ResponseUtil.COURSE_PROGRAM_DELETED_SUCCESS)
                    .build();
            } else {
                return CourseProgramResponse.builder()
                    .responseCode(ResponseUtil.NOT_FOUND_CODE)
                    .responseMessage(ResponseUtil.COURSE_PROGRAM_NOT_FOUND)
                    .build();
            }
        } else {
            return CourseProgramResponse.builder()
                .responseCode(ResponseUtil.NOT_FOUND_CODE)
                .responseMessage(ResponseUtil.COURSE_PROGRAM_NOT_FOUND)
                .build();
        }
    }
}
