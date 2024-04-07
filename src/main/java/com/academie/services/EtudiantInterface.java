package com.academie.services;

import java.util.List;

import com.academie.entities.Etudiant;


public interface EtudiantInterface {
	
	public Etudiant createOrUpdateEtudiant(Etudiant e);

	public List<Etudiant> getAllEtudiants();

	public Etudiant deleteEtudiant(String codeEtudiant);

	public void deleteAll();

	public List<Etudiant> findByEtudiantName(String etudiantName);

	public List<Etudiant> findByEtudiantEmail(String etudiantEmail);
	
	public long countEtudiant();
}
