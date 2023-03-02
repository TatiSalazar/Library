package com.universal.library.repository;

import com.universal.library.entity.UserLibrary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<UserLibrary, Long> {
    public UserLibrary findByEmail(String email);
}
