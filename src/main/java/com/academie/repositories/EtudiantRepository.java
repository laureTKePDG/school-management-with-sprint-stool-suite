package com.academie.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.academie.entities.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, String>{
	
	@Query("SELECT e FROM Etudiant e ORDER By e.anneeEtud DESC")
	public List<Etudiant> getEtudiantByOrder();
	
	public List<Etudiant> findByNomEtudContaining(String nom);
	
	public List<Etudiant> findByMailEtudContaining(String mail);
}
