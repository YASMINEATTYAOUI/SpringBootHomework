package com.example.springboot.repositories;

import com.example.springboot.models.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepository extends JpaRepository<Equipe,Long> {

    Equipe findByLibelle(String libelle);

}
