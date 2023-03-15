package com.universal.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcademicProgram {

    @Id
    @GeneratedValue
    private Long program_id;
    private String name;
    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    private Faculty faculty;

    @JsonIgnore
    @OneToMany
    @Column(nullable = true)
    private List<Student> students;


}
