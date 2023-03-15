package com.universal.library.dto;

import lombok.*;


import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AcademicProgramDTO {
    private String name;

    private FacultyDTO faculty;
    private List<String> students;
}
