package com.example.Lab09.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Lab09.dto.course.CourseRequest;
import com.example.Lab09.dto.course.CourseResponse;
import com.example.Lab09.entity.Course;
import com.example.Lab09.repository.CourseRepository;
import com.example.Lab09.services.CourseService;
import com.example.Lab09.utils.ResponseUtil;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;
    
    @Override
    public CourseResponse getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return CourseResponse.builder()
            .responeCode(courses.isEmpty() ? ResponseUtil.NOT_FOUND_CODE : ResponseUtil.SUCCESS_CODE)
            .responeMessage(courses.isEmpty() ? ResponseUtil.COURSE_NOT_FOUND : ResponseUtil.COURSE_FOUND)
            .CourseInfo(null)
            .courses(courses)
            .build();
    }

    public CourseResponse getCourseById(String id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            return CourseResponse.builder()
                .responeCode(ResponseUtil.SUCCESS_CODE)
                .responeMessage(ResponseUtil.COURSE_FOUND)
                .CourseInfo(optionalCourse.get())
                .courses(null)
                .build();
        } else {
            return CourseResponse.builder()
                .responeCode(ResponseUtil.NOT_FOUND_CODE)
                .responeMessage(ResponseUtil.COURSE_NOT_FOUND)
                .CourseInfo(null)
                .courses(null)
                .build();
        }
    }
    
    public CourseResponse createCourse(CourseRequest courseRequest) {
        Course course = new Course();
        course.setId(courseRequest.getId());
        course.setName(courseRequest.getName());
        course.setName_vn(courseRequest.getName_vn());
        course.setCourse_level_id(courseRequest.getCourse_level_id());
        course.setCredit_lab(courseRequest.getCredit_lab());
        course.setCredit_theory(courseRequest.getCredit_theory());
        course.setDescription(courseRequest.getDescription());
        course.setCreateAt(courseRequest.getCreateAt());
        course.setModifiedAt(courseRequest.getCreateAt());

        Course savedCourse = courseRepository.save(course);

        return CourseResponse.builder()
            .responeCode(ResponseUtil.CREATED_CODE)
            .responeMessage(ResponseUtil.COURSE_CREATED_SUCCESS)
            .CourseInfo(savedCourse)
            .courses(null)
            .build();
    }

    public CourseResponse updateCourse(String id, CourseRequest courseRequest) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            course.setName(courseRequest.getName());
            course.setName_vn(courseRequest.getName_vn());
            course.setCourse_level_id(courseRequest.getCourse_level_id());
            course.setCredit_lab(courseRequest.getCredit_lab());
            course.setCredit_theory(courseRequest.getCredit_theory());
            course.setDescription(courseRequest.getDescription());
            course.setModifiedAt(courseRequest.getCreateAt());

            courseRepository.save(course);

            return CourseResponse.builder()
                .responeCode(ResponseUtil.SUCCESS_CODE)
                .responeMessage(ResponseUtil.COURSE_UPDATED_SUCCESS)
                .CourseInfo(course)
                .courses(null)
                .build();
        } else {
            return CourseResponse.builder()
                .responeCode(ResponseUtil.NOT_FOUND_CODE)
                .responeMessage(ResponseUtil.COURSE_NOT_FOUND)
                .CourseInfo(null)
                .courses(null)
                .build();
        }
    }

    public CourseResponse deleteCourse(String id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            courseRepository.deleteById(id);
            return CourseResponse.builder()
                .responeCode(ResponseUtil.SUCCESS_CODE)
                .responeMessage(ResponseUtil.COURSE_DELETED_SUCCESS)
                .CourseInfo(null)
                .courses(null)
                .build();
        } else {
            return CourseResponse.builder()
                .responeCode(ResponseUtil.NOT_FOUND_CODE)
                .responeMessage(ResponseUtil.COURSE_NOT_FOUND)
                .CourseInfo(null)
                .courses(null)
                .build();
        }
    }
    
}
