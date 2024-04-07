package com.academie.services;

import java.util.List;

import com.academie.entities.Matiere;

public interface MatiereInterface {
	
	public Matiere createOrUpdate(Matiere m);
	
	public List<Matiere> getAll();
	
	public Matiere delete(String codeMat);
	
	public void deleteAll();
	
	public long count();

}
