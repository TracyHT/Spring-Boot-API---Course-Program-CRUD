package com.example.Lab09.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "course_program")
public class CourseProgram {

    @EmbeddedId  
    private CourseProgramId id;  // This field will hold the composite key (courseId + programId)

    @ManyToOne
    @MapsId("courseId")  
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    private Course course;

    @ManyToOne
    @MapsId("programId") 
    @JoinColumn(name = "program_id", referencedColumnName = "id", nullable = false)
    private Program program;

    @Column(name = "course_code", nullable = false)
    private String courseCode;

    @Column(name = "course_type_id", nullable = false)
    private Long courseTypeId;
}
