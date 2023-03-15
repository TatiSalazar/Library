package com.universal.library.services;

import com.universal.library.entities.Book;

import java.util.List;

public interface ICatalogService {
    public List<Book> getBooks(int limit);
    public Book getBooksByIsbn(String isbn);
    public List<Book> getBooksByTitle(String title);
    public List<Book> getBooksByAuthor(String author);
    public List<Book> getBooksBySearch(String typeQuery, String textSearch);

}
