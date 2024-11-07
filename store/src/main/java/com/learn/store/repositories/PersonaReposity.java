package com.learn.store.repositories;

import com.learn.store.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaReposity extends JpaRepository<Persona, Long> {
}
