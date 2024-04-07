package com.academie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.academie.entities.Matiere;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, String> {
	
}
