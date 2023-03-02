package com.universal.library.services;

import com.universal.library.entity.Book;

import java.util.List;

public interface ICatalogService {
    public List<Book> getBooks(int limit);
    public List<Book> getBooksByIsbn(String isbn);
    public List<Book> getBooksByTitle(String title);
    public List<Book> getBooksByAuthor(String author);
    public List<Book> getBooksBySearch(String typeQuery, String textSearch);

}
