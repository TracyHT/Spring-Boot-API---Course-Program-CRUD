package com.example.Lab09.dto.course;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseInfo {
    private String id;
    private Long course_level_id;
    private String name;
    private String name_vn;
    private Long credit_theory;
    private Long credit_lab;
    private String description;
}
