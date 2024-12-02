package com.example.Lab09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Lab09.entity.Course;
import com.example.Lab09.entity.CourseProgram;
import com.example.Lab09.entity.CourseProgramId;
import com.example.Lab09.entity.Program;

@Repository
public interface CourseProgramRepository extends JpaRepository<CourseProgram, CourseProgramId> {

    CourseProgram findByCourseAndProgram(Course course, Program program);
}
