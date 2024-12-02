package com.example.Lab09.services;

import com.example.Lab09.dto.program.ProgramRequest;
import com.example.Lab09.dto.program.ProgramResponse;

public interface ProgramService {
    ProgramResponse createProgram(ProgramRequest programRequest);
    ProgramResponse getAllPrograms();
    ProgramResponse updateProgram(int id, ProgramRequest programRequest);
    ProgramResponse deleteProgram(int id);
}
