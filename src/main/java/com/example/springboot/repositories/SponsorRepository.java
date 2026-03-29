package com.example.springboot.repositories;

import com.example.springboot.models.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface SponsorRepository extends JpaRepository <Sponsor,Long> {

}
