package com.universal.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private String type_document;
    @Id
    @GeneratedValue
    private String document;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String phone;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    private AcademicProgram academic_program;
}
