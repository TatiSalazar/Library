package com.universal.library.controller;

import com.universal.library.entities.AcademicProgram;
import com.universal.library.entities.Student;
import com.universal.library.repository.IStudentRepository;
import com.universal.library.services.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IStudentService studentService;
    @MockBean
    private IStudentRepository IStudentRepository;
    @MockBean
    private AcademicProgram academicProgram;
    @MockBean
    private Student student;

    @BeforeEach
    void setUp(){
        Student student =
                Student.builder()
                .type_document("CC")
                .document("82-965-6511")
                .name("Sophi")
                .phone("549-591-5786")
                        .academic_program(new AcademicProgram())
                .build();
        Mockito.when(IStudentRepository.findByDocument("82-965-6511")).thenReturn(student);
    }



    @Test
    public void getStudentByDocument()  throws Exception{
        Mockito.when(studentService.getStudentByDocument("82-965-6511")).thenReturn(student);
        mockMvc.perform(get("/api/students/82-965-6511")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.document").value(student.getDocument()));



    }

}