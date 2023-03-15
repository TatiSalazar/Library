package com.universal.library.services;

import com.universal.library.entities.Loan;
import com.universal.library.entities.Student;
import com.universal.library.entities.UserLibrary;
import com.universal.library.exceptions.*;

public interface ILibraryService {

    public UserLibrary saveUserLibrary(UserLibrary userLibrary) throws StudentNotFoundException, UserExistException;

    public String authUserLibrary(UserLibrary userLibrary) throws UserLibraryNotFoundException, AuthenticatedException;

    public Loan saveLoanLibrary(Loan loan) throws AuthenticatedException, BookNotFoundException, AvailableBookException;
}
