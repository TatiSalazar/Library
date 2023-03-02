package com.universal.library.services;

import com.universal.library.entity.Student;
import com.universal.library.entity.UserLibrary;
import com.universal.library.repository.LibraryRepository;
import com.universal.library.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements ILibraryService{

    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public UserLibrary saveUserLibrary(UserLibrary userLibrary) {
        return libraryRepository.save(userLibrary);
    }

    @Override
    public Student authUserLibrary(UserLibrary userLibrary)  {
        return studentRepository.findByEmail(userLibrary.getEmail());
    }
}
