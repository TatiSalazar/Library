package com.universal.library.services;

import com.universal.library.entities.*;
import com.universal.library.enums.BookEnum;
import com.universal.library.exceptions.*;
import com.universal.library.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements ILibraryService {

    @Autowired
    private ILibraryRepository libraryRepository;
    @Autowired
    private IStudentRepository studentRepository;
    @Autowired
    private IActiveSessionRepository activeSessionsRepository;
    @Autowired
    private ICatalogRepository catalogRepository;
    @Autowired
    private ILoanRepository loanRepository;
    @Autowired
    private IBookRepository bookRepository;


    @Override
    public UserLibrary saveUserLibrary(UserLibrary userLibrary) throws StudentNotFoundException, UserExistException {
        Student student = studentRepository.findByEmail(userLibrary.getDocument());

        if(student == null){
            throw new StudentNotFoundException("Student not found");
        }
        UserLibrary userLibraryExist = libraryRepository.findByDocument(userLibrary.getDocument());

        if(userLibraryExist != null){
            throw new UserExistException("User exist");
        }

        return libraryRepository.save(userLibrary);
    }

    @Override
    public String authUserLibrary(UserLibrary userLibrary) throws UserLibraryNotFoundException {
        UserLibrary user = libraryRepository.findByDocument(userLibrary.getDocument());

        if (user == null) {
            throw new UserLibraryNotFoundException("User not found");
        }

        int randomNumber = (int) Math.floor(Math.random() * (50000 - 50 + 1) + 50);
        String fakeToken = "generatedFakeToken".concat("" + randomNumber);

        ActiveSessions newActiveSessions = new ActiveSessions();
        newActiveSessions.setId((long) randomNumber);
        newActiveSessions.setDocument(userLibrary.getDocument());
        newActiveSessions.setToken(fakeToken);

        Optional<ActiveSessions> savedSession = Optional.ofNullable(activeSessionsRepository.findByDocument(userLibrary.getDocument()));

        if (savedSession.isPresent()) {
            activeSessionsRepository.removeByDocument(userLibrary.getDocument());
        }

        activeSessionsRepository.save(newActiveSessions);

        return fakeToken;
    }

    @Override
    public Loan saveLoanLibrary(Loan loan) throws AuthenticatedException, BookNotFoundException, AvailableBookException {
        Optional<ActiveSessions> currentSession = Optional.ofNullable(activeSessionsRepository.findByDocument(loan.getDocument()));
        BookEnum.UNAVAILABLE.getStatus("Unavailable").toString();
        if (!currentSession.isPresent()) {
            throw new AuthenticatedException("Authentication failed");
        }
        Optional<Book> book = Optional.ofNullable(catalogRepository.findByIsbnIgnoreCaseContaining(loan.getIsbn()));

        if (book.isPresent()) {
            if (BookEnum.getStatus(book.get().getAvailable()).equals(BookEnum.AVAILABLE)) {
                loan.setCreate_at(new Date());
                loan.setStatus(BookEnum.AVAILABLE.toString());

                bookRepository.updateAvailableFromIsbn("Unavailable", loan.getIsbn());
                return loanRepository.save(loan);
            } else {
                throw new AvailableBookException("Book not available for loan");
            }
        } else {
            throw new BookNotFoundException("Book not found");
        }

    }


}
