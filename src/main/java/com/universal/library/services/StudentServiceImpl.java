package com.universal.library.services;

import com.universal.library.entities.Student;
import com.universal.library.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository IStudentRepository;

    @Override
    public Student getStudentByDocument(String document) {
        return IStudentRepository.findByDocument(document);
    }
    @Override
    public Student getStudentByEmail(String email) {
        return IStudentRepository.findByEmail(email);
    }
}

