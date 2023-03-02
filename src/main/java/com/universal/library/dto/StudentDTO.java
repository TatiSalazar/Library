package com.universal.library.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO  {

    private String type_document;
    private String document;
    private String name;
    private String email;
    private String phone;
    @JsonIgnore
    private AcademicProgramDTO academic_program;
}
