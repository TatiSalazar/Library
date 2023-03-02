package com.universal.library.controller;

import com.universal.library.dto.StudentDTO;
import com.universal.library.dto.UserLibraryDTO;
import com.universal.library.entity.Student;
import com.universal.library.entity.UserLibrary;
import com.universal.library.exceptions.UserLibraryNotFoundException;
import com.universal.library.services.ILibraryService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LibraryController {

    @Autowired
    private ILibraryService libraryService;
    @Autowired
    private ModelMapper modelMapper;

    private final Logger LOGGER =
            (Logger) LoggerFactory.getLogger(LibraryController.class);

    @PostMapping("/api/library/users")
    public ResponseEntity<UserLibraryDTO> saveUserLibrary(@Valid @RequestBody UserLibrary userLibrary) throws UserLibraryNotFoundException {
        Optional<UserLibrary> userLibrarySave = Optional.ofNullable(libraryService.saveUserLibrary(userLibrary));
        UserLibraryDTO userLibraryDTO = modelMapper.map(userLibrarySave, UserLibraryDTO.class);
        if(!userLibrarySave.isPresent()){
            throw new UserLibraryNotFoundException("User of Library not found");
        }
        LOGGER.info("UserLibrary saved");
        return new ResponseEntity<>(userLibraryDTO, HttpStatus.OK);
    }

    @PostMapping("/api/library/auth")
    public ResponseEntity<StudentDTO> authUserLibrary(@Valid @RequestBody UserLibrary userLibrary) throws UserLibraryNotFoundException {
        Optional<Student> student = Optional.ofNullable(libraryService.authUserLibrary(userLibrary));
        StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
        if(!student.isPresent()){
            throw new UserLibraryNotFoundException("User of Library not found");
        }
        LOGGER.info("User of Library found");
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }
}
