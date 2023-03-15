package com.universal.library.controller;

import com.universal.library.dto.BookDTO;
import com.universal.library.entities.Book;
import com.universal.library.exceptions.BookNotFoundException;
import com.universal.library.services.ICatalogService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CatalogController {
    @Autowired
    private ICatalogService catalogService;
    @Autowired
    private ModelMapper modelMapper;
    private final Logger LOGGER =
            (Logger) LoggerFactory.getLogger(CatalogController.class);

    @GetMapping("/api/library/catalog/books")
    public ResponseEntity<List<BookDTO>> getBooks(@RequestParam(name = "limit") int limit) throws BookNotFoundException {
        List<Book> books = catalogService.getBooks(limit);
        List<BookDTO> listBookDTO = books.stream().map(book -> modelMapper.map(book, BookDTO.class)).collect(Collectors.toList());
        if(books.isEmpty()){
            throw new BookNotFoundException("All Books not found");
        }
        LOGGER.info("All Books found");
        return new ResponseEntity<>(listBookDTO, HttpStatus.OK);
    }

    @GetMapping("/api/library/catalog/search")
    public ResponseEntity<List<BookDTO>> getBooksBySearch(@RequestParam("typeQuery") String typeQuery, @RequestParam("textSearch") String textSearch ) throws BookNotFoundException {
        List<Book> books = catalogService.getBooksBySearch(typeQuery,textSearch );
        List<BookDTO> listBookDTO = books.stream().map(book -> modelMapper.map(book, BookDTO.class)).collect(Collectors.toList());
        if(books.isEmpty()){
            throw new BookNotFoundException("Books not found");
        }
        LOGGER.info("Books found");
        return new ResponseEntity<>(listBookDTO, HttpStatus.OK);
    }

    @GetMapping("/api/library/catalog/books/{isbn}")
    public ResponseEntity<BookDTO> getBooksByIsbn(@PathVariable("isbn") String isbn) throws BookNotFoundException {
        Optional<Book> book =  Optional.ofNullable(catalogService.getBooksByIsbn(isbn));
        BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
        if(!book.isPresent()){
            throw new BookNotFoundException("Book not found");
        }
        LOGGER.info("Book found");
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }

    /**
    @GetMapping("/api/library/catalog/isbn/{isbn}")
    public List<Book> getBooksByIsbn(@PathVariable("isbn") String isbn) {
        List<Book> books = catalogService.getBooksByIsbn(isbn);
        LOGGER.info("Listed books");
        return books;
    }

    @GetMapping("/api/library/catalog/title/{title}")
    public List<Book> getBooksByTitle(@PathVariable("title") String title) {
        List<Book> books = catalogService.getBooksByTitle(title);
        LOGGER.info("Listed books");
        return books;
    }

    @GetMapping("/api/library/catalog/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable("author") String author) {
        List<Book> books = catalogService.getBooksByAuthor(author);
        LOGGER.info("Listed books");
        return books;
    }
    **/


}
