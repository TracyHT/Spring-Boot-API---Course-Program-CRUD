package com.example.Lab09.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Lab09.entity.Course;

public interface CourseRepository extends JpaRepository<Course, String> {

    
}
