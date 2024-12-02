package com.example.Lab09.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "course")
public class Course {
    @Id
    private String id;
    private Long course_level_id;
    private String name;
    private String name_vn;
    private Long credit_theory;
    private Long credit_lab;
    private String description;
    
    @CreationTimestamp
    private LocalDateTime createAt;
    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    public Course(String id, Long courseLevelId, String name, String nameVn, Long creditTheory, Long creditLab, String description) {
    this.id = id;
    this.course_level_id = courseLevelId;
    this.name = name;
    this.name_vn = nameVn;
    this.credit_theory = creditTheory;
    this.credit_lab = creditLab;
    this.description = description;
}
}