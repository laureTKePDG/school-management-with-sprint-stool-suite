package com.academie.services;

import java.util.List;

import com.academie.entities.Evaluation;
import com.academie.entities.EvaluationPK;


public interface EvalutionInterface {

	public Evaluation createOrUpdateEvaluation(Evaluation e);

	public List<Evaluation> getAllEvaluations();

	public Evaluation deleteEvaluation(EvaluationPK code);

	public void deleteAll();

	public List<Evaluation> findByEtudiantCode(String etudiantCode);
	
	public long countEvaluation(String etudiantCode);
}
