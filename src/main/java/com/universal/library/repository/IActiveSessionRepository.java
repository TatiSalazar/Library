package com.universal.library.repository;

import com.universal.library.entities.ActiveSessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActiveSessionRepository  extends JpaRepository<ActiveSessions,Long> {
    public ActiveSessions findByDocument(String document);
    public String removeByDocument(String document);
}
