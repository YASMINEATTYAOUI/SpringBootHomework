package com.example.springboot.repositories;

import com.example.springboot.models.Championnat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampionnatRepository extends JpaRepository<Championnat,Long> {
}
