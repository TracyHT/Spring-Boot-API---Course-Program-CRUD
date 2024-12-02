package com.example.Lab09.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Lab09.dto.program.ProgramRequest;
import com.example.Lab09.dto.program.ProgramResponse;
import com.example.Lab09.entity.Program;
import com.example.Lab09.repository.ProgramRepository;
import com.example.Lab09.services.ProgramService;
import com.example.Lab09.utils.ResponseUtil;

@Service
public class ProgramServiceImpl implements ProgramService {

    @Autowired
    private ProgramRepository programRepository;

    @Override
    public ProgramResponse createProgram(ProgramRequest programRequest) {
        Program program = new Program();
        program.setId(programRequest.getId());
        program.setName(programRequest.getName());
        program.setDuration(programRequest.getDuration());
        program.setVersion(programRequest.getVersion());
        program.setMajor_id(programRequest.getMajor_id());
        program.setProgram_type_id(programRequest.getProgram_type_id());
        program.setValid_from(programRequest.getValid_from());

        Program savedProgram = programRepository.save(program);

        return ProgramResponse.builder()
            .responseCode(ResponseUtil.CREATED_CODE)
            .responseMessage(ResponseUtil.PROGRAM_CREATED_SUCCESS)
            .ProgramInfo(savedProgram)
            .programs(null) 
            .build();
    }

    @Override
    public ProgramResponse getAllPrograms() {
        Iterable<Program> programs = programRepository.findAll();
        return ProgramResponse.builder()
            .responseCode(programs.iterator().hasNext() ? ResponseUtil.SUCCESS_CODE : ResponseUtil.NOT_FOUND_CODE)
            .responseMessage(programs.iterator().hasNext() ? ResponseUtil.PROGRAM_FOUND : ResponseUtil.PROGRAM_NOT_FOUND)
            .programs(programs)
            .ProgramInfo(null)  
            .build();
    }

    @Override
    public ProgramResponse updateProgram(int id, ProgramRequest programRequest) {
        Program existingProgram = programRepository.findById(id).orElse(null);

        if (existingProgram != null) {
            existingProgram.setName(programRequest.getName());
            existingProgram.setDuration(programRequest.getDuration());
            existingProgram.setVersion(programRequest.getVersion());
            existingProgram.setMajor_id(programRequest.getMajor_id());
            existingProgram.setProgram_type_id(programRequest.getProgram_type_id());
            existingProgram.setValid_from(programRequest.getValid_from());

            Program updatedProgram = programRepository.save(existingProgram);

            return ProgramResponse.builder()
                .responseCode(ResponseUtil.SUCCESS_CODE)
                .responseMessage(ResponseUtil.PROGRAM_UPDATED_SUCCESS)
                .ProgramInfo(updatedProgram)
                .programs(null)
                .build();
        } else {
            return ProgramResponse.builder()
                .responseCode(ResponseUtil.NOT_FOUND_CODE)
                .responseMessage(ResponseUtil.PROGRAM_NOT_FOUND)
                .ProgramInfo(null)
                .programs(null)
                .build();
        }
    }

    @Override
    public ProgramResponse deleteProgram(int id) {
        Program existingProgram = programRepository.findById(id).orElse(null);

        if (existingProgram != null) {
            programRepository.deleteById(id);

            return ProgramResponse.builder()
                .responseCode(ResponseUtil.SUCCESS_CODE)
                .responseMessage(ResponseUtil.PROGRAM_DELETED_SUCCESS)
                .ProgramInfo(null)
                .programs(null)
                .build();
        } else {
            return ProgramResponse.builder()
                .responseCode(ResponseUtil.NOT_FOUND_CODE)
                .responseMessage(ResponseUtil.PROGRAM_NOT_FOUND)
                .ProgramInfo(null)
                .programs(null)
                .build();
        }
    }
}
