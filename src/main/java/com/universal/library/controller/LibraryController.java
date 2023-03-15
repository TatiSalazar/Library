package com.universal.library.controller;

import com.universal.library.dto.LoanRequestDTO;
import com.universal.library.dto.LoanResponseDTO;
import com.universal.library.dto.UserLibraryDTO;
import com.universal.library.entities.Loan;
import com.universal.library.entities.UserLibrary;
import com.universal.library.exceptions.*;
import com.universal.library.services.ILibraryService;
import jakarta.transaction.Transactional;
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
    public ResponseEntity<UserLibraryDTO> saveUserLibrary(@Valid @RequestBody UserLibrary userLibrary) throws UserLibraryNotFoundException, UserExistException, StudentNotFoundException {
        Optional<UserLibrary> userLibrarySave = Optional.ofNullable(libraryService.saveUserLibrary(userLibrary));
        UserLibraryDTO userLibraryDTO = modelMapper.map(userLibrarySave, UserLibraryDTO.class);
        if(!userLibrarySave.isPresent()){
            throw new UserLibraryNotFoundException("User of Library not found");
        }
        LOGGER.info("UserLibrary saved");
        return new ResponseEntity<>(userLibraryDTO, HttpStatus.OK);
    }

    @PostMapping("/api/library/auth")
    @Transactional
    public String authUserLibrary(@Valid @RequestBody UserLibrary userLibrary) throws UserLibraryNotFoundException, AuthenticatedException {
        String token = libraryService.authUserLibrary(userLibrary);

        LOGGER.info("User of Library authenticated");
        return token;
    }
    @PostMapping("/api/library/loans")
    @Transactional
    public ResponseEntity<LoanResponseDTO> saveLoanLibrary(@Valid @RequestBody LoanRequestDTO loanRequestDTO) throws UserLibraryNotFoundException, LoanSaveException, AuthenticatedException, BookNotFoundException, AvailableBookException {
        Loan loanTosave = modelMapper.map(loanRequestDTO, Loan.class);
        Optional<Loan> savedLoan = Optional.ofNullable(libraryService.saveLoanLibrary(loanTosave));
        LoanResponseDTO loanResponseDTO = modelMapper.map(savedLoan, LoanResponseDTO.class);
        if(!savedLoan.isPresent()){
            throw new LoanSaveException("Loan not saved");
        }
        LOGGER.info("Saved loan");
        return new ResponseEntity<>(loanResponseDTO, HttpStatus.OK);
    }
}
