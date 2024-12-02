package com.example.Lab09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Lab09.dto.program.ProgramRequest;
import com.example.Lab09.dto.program.ProgramResponse;
import com.example.Lab09.services.ProgramService;

@RestController
@RequestMapping("/api")
public class ProgramController {

    @Autowired
    ProgramService programService;

    @PostMapping("/program")
    public ProgramResponse createProgram(@RequestBody ProgramRequest programRequest) {
        return programService.createProgram(programRequest);
    }

    @GetMapping("/programs")
    public ProgramResponse getAllPrograms() {
        return programService.getAllPrograms();
    }

    @PutMapping("/program/{id}")
    public ProgramResponse updateProgram(@PathVariable Integer id, @RequestBody ProgramRequest programRequest) {
        return programService.updateProgram(id, programRequest);
    }

    @DeleteMapping("/program/{id}")
    public ProgramResponse deleteProgram(@PathVariable Integer id) {
        return programService.deleteProgram(id);
    }
}
