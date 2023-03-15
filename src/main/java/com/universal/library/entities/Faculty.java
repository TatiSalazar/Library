package com.universal.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Faculty {
    @Id
    @GeneratedValue
    private Long faculty_id;
    private String name;

    @JsonIgnore
    @OneToMany
    @Column(nullable = true)
    private List<AcademicProgram> academic_programs;
}
