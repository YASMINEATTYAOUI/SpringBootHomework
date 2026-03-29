package com.example.springboot.repositories;

import com.example.springboot.models.Pilote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PiloteRepository extends JpaRepository<Pilote,Long> {

    Pilote findByLibelle(String libelle);
}
