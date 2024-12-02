package com.example.Lab09.dto.course_program;

import com.example.Lab09.entity.CourseProgram;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseProgramResponse {
    private String responseCode;
    private String responseMessage;
    private CourseProgram courseProgramInfo;
    private Iterable<CourseProgram> coursePrograms;
}
