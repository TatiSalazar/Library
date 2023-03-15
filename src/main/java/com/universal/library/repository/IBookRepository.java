package com.universal.library.repository;

import com.universal.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
    @Modifying
    @Query(nativeQuery = true, value = "update Book set available = ?1 WHERE isbn = ?2")
    public void updateAvailableFromIsbn(String available, String isbn);
}
