package com.academie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academie.entities.Matiere;
import com.academie.repositories.MatiereRepository;

@Service
public class MatiereService  implements MatiereInterface{
	
	@Autowired
	MatiereRepository matiereRepository;

	@Override
	public Matiere createOrUpdate(Matiere m) {
		return matiereRepository.save(m);
	}

	@Override
	public List<Matiere> getAll() {
		return matiereRepository.findAll();
	}

	@Override
	public Matiere delete(String codeMat) {
		if(codeMat == "")
			return null;
		Matiere m = matiereRepository.findById(codeMat).get();
		if(m.equals(null))
			return null;
		matiereRepository.delete(m);
		return m;
	}

	@Override
	public void deleteAll() {
		matiereRepository.deleteAll();
	}

	@Override
	public long count() {
		return matiereRepository.count();
	}

}
