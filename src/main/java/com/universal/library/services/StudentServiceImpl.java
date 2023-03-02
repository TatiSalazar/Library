package com.universal.library.services;

import com.universal.library.entity.Student;
import com.universal.library.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudentByDocument(String document) {
        return studentRepository.findByDocument(document);
    }
    @Override
    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
}

