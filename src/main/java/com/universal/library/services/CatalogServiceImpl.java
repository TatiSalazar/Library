package com.universal.library.services;

import com.universal.library.entity.Book;
import com.universal.library.repository.ICatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements ICatalogService {
    @Autowired
    private ICatalogRepository catalogRepository;

    @Override
    public List<Book> getBooks(int limit) {
        return catalogRepository.findFirstByOrderByTitle(limit);
    }

    @Override
    public List<Book> getBooksByIsbn(String isbn) {
        return catalogRepository.findByIsbnIgnoreCaseContaining(isbn);
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return catalogRepository.findByTitleIgnoreCaseContaining(title);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return catalogRepository.findByAuthorIgnoreCaseContaining(author);
    }

    @Override
    public List<Book> getBooksBySearch(String typeQuery, String textSearch) {
        List<Book> result = null;

        switch (typeQuery) {
            case "isbn":
                result = catalogRepository.findByIsbnIgnoreCaseContaining(textSearch);
                break;
            case "title":
                result = catalogRepository.findByTitleIgnoreCaseContaining(textSearch);
                break;
            case "author":
                result = catalogRepository.findByAuthorIgnoreCaseContaining(textSearch);
                break;
            default:
                result = null;
                break;
        }
        return result;
    }
}
