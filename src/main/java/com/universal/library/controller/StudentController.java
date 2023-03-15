package com.universal.library.controller;

import com.universal.library.dto.StudentDTO;
import com.universal.library.entities.Student;
import com.universal.library.exceptions.StudentNotFoundException;
import com.universal.library.services.IStudentService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
public class StudentController {

    private IStudentService studentService;
    @Autowired
    private ModelMapper modelMapper;

    private final Logger LOGGER =
            (Logger) LoggerFactory.getLogger(StudentController.class);

    public StudentController(IStudentService studentService, ModelMapper modelMapper) {
        this.studentService = studentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/api/students/{document}")
    public ResponseEntity<StudentDTO> getStudentByDocument(@PathVariable("document") String document) throws StudentNotFoundException {
        Optional<Student> student = Optional.ofNullable(studentService.getStudentByDocument(document));
        StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
        if(!student.isPresent()) {
            throw new StudentNotFoundException("Student not found");
        }
        LOGGER.info("Student found");
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }
}



