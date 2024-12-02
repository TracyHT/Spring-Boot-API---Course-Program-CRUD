package com.example.Lab09.dto.program;

import com.example.Lab09.entity.Program;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgramResponse {
    private String responseCode;
    private String responseMessage;
    private Program ProgramInfo;
    private Iterable<Program> programs;
}
