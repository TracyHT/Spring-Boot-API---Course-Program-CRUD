package com.example.Lab09.dto.program;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgramRequest {
    private int id;
    private String name;
    private int duration;
    private String version;
    private int major_id;
    private int program_type_id;
    private String valid_from;
}