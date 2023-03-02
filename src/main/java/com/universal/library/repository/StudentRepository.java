package com.universal.library.repository;

import com.universal.library.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public Student findByDocument(String document);
    public Student findByEmail(String email);
}
