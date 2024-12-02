package com.example.Lab09.dto.course_program;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseProgramRequest {
    private String course_id;
    private int program_id;
    private String course_code;
    private Long course_type_id;
}
