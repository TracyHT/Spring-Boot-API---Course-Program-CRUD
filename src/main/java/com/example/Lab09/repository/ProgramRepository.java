package com.example.Lab09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Lab09.entity.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {
}
