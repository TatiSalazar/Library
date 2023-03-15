package com.universal.library.services;

import com.universal.library.entities.Student;

public interface IStudentService {
    public Student getStudentByDocument(String email);
    public Student getStudentByEmail(String email);



}
