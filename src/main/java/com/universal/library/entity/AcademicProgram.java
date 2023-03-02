package com.universal.library.entity;

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
