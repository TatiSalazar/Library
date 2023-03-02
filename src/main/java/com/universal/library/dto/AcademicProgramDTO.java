package com.universal.library.dto;

import com.universal.library.entity.Faculty;
import lombok.*;


import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AcademicProgramDTO {
    private String name;

    private Faculty faculty;
    private List<StudentDTO> students;
}
