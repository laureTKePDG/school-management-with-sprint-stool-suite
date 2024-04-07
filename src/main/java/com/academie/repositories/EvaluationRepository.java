package com.academie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.academie.entities.Evaluation;
import com.academie.entities.EvaluationPK;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, EvaluationPK>{
	
	@Query("SELECT e FROM Evaluation e WHERE e.etudiant.codeEtud = :codeEtudiant")
	List<Evaluation> findByCodeEtudiant(String codeEtudiant);
}
