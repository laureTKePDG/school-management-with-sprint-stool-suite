package com.academie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academie.entities.Etudiant;
import com.academie.repositories.EtudiantRepository;

@Service
public class EtudiantService implements EtudiantInterface{
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Override
	public Etudiant createOrUpdateEtudiant(Etudiant e) {
		if(!e.getMailEtud().contains("@")) 
			return null;
		return etudiantRepository.save(e);
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		return etudiantRepository.findAll();
	}

	@Override
	public Etudiant deleteEtudiant(String codeEtudiant) {
		if(codeEtudiant == "")
			return null;
		Etudiant e  = etudiantRepository.findById(codeEtudiant).get();
		if(e.equals(null))
			return null;
		etudiantRepository.delete(e);
		return e;
	}

	@Override
	public void deleteAll() {
		etudiantRepository.deleteAll();
	}

	@Override
	public List<Etudiant> findByEtudiantName(String etudiantName) {
		return etudiantRepository.findByNomEtudContaining(etudiantName);
	}

	@Override
	public List<Etudiant> findByEtudiantEmail(String etudiantEmail) {
		return etudiantRepository.findByMailEtudContaining(etudiantEmail);
	}

	@Override
	public long countEtudiant() {
		return etudiantRepository.count();
	}

}
