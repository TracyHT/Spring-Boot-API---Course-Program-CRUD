package com.example.Lab09.dto.course;

import java.util.List;

import com.example.Lab09.entity.Course;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {
    private String responeCode;
    private String responeMessage;
    private Course CourseInfo;
    private List<Course> courses;
}

