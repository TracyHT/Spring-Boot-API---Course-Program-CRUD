package com.example.Lab09.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "program")
public class Program {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    private String name;
    private Integer duration;
    private String version;
    private Integer major_id;
    private Integer program_type_id;
    private String valid_from;

}
