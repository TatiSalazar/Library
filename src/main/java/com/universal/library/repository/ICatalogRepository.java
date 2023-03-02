package com.universal.library.repository;

import com.universal.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICatalogRepository extends JpaRepository<Book, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM Book LIMIT ?1")
    public List<Book> findFirstByOrderByTitle(int limit);
    public List<Book> findByIsbnIgnoreCaseContaining(String isbn);
    public List<Book> findByTitleIgnoreCaseContaining(String title);
    public List<Book> findByAuthorIgnoreCaseContaining(String author);
}
