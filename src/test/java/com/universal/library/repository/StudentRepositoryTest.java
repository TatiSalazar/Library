package com.universal.library.repository;

import com.universal.library.entity.AcademicProgram;
import com.universal.library.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
@AutoConfigureTestDatabase
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TestEntityManager entityManager;
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
        entityManager.persist(student);
    }

    @Test
    public void getStudentByDocument(){
        Student student = studentRepository.findByDocument("82-965-6511");
        assertEquals(student.getDocument(), "82-965-6511");
    }

}