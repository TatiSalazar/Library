package com.universal.library.repository;

import com.universal.library.entities.UserLibrary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibraryRepository extends JpaRepository<UserLibrary, Long> {
    public UserLibrary findByDocument(String document);
}
