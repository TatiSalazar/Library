package com.universal.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FacultyDTO {
    private String name;
    private List<AcademicProgramDTO> academic_programs;
}
