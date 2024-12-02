package com.example.Lab09.dto.course;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private String Id;
    private Long course_level_id;
    private String name;
    private String name_vn;
    private Long credit_theory;
    private Long credit_lab;
    private String description;
    
    @CreationTimestamp
    private LocalDateTime createAt;
    
}