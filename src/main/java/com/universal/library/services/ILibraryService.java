package com.universal.library.services;

import com.universal.library.entity.Student;
import com.universal.library.entity.UserLibrary;
import com.universal.library.exceptions.UserLibraryNotFoundException;

public interface ILibraryService {

    public UserLibrary saveUserLibrary(UserLibrary userLibrary);

    public Student authUserLibrary(UserLibrary userLibrary) throws UserLibraryNotFoundException;
}
