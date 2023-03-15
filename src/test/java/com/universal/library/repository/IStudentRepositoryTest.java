package com.universal.library.repository;

import com.universal.library.entities.AcademicProgram;
import com.universal.library.entities.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
@AutoConfigureTestDatabase
class IStudentRepositoryTest {

    @Autowired
    private IStudentRepository IStudentRepository;
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
        Student student = IStudentRepository.findByDocument("82-965-6511");
        assertEquals(student.getDocument(), "82-965-6511");
    }

}