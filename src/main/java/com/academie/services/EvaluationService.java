package com.academie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academie.entities.Etudiant;
import com.academie.entities.Evaluation;
import com.academie.entities.EvaluationPK;
import com.academie.entities.Matiere;
import com.academie.repositories.EtudiantRepository;
import com.academie.repositories.EvaluationRepository;
import com.academie.repositories.MatiereRepository;
@Service
public class EvaluationService implements EvalutionInterface{

	@Autowired
	EvaluationRepository evaluationRepository;
	@Autowired
	EtudiantRepository 	etudiantRepository;
	@Autowired
	MatiereRepository matiereRepository;
	
	@Override
	public Evaluation createOrUpdateEvaluation(Evaluation e) {
		Etudiant etud = etudiantRepository.findById(e.getEvaluationPK().getCodeEtud()).get();
		Matiere mat = matiereRepository.findById(e.getEvaluationPK().getCodeMat()).get();
		System.out.println(etud);
		System.out.println(mat);
		 if(!etud.equals(null) && !mat.equals(null)) {
			 return  evaluationRepository.save(e);
		 }else {
			 return null;
		 }	
	}

	@Override
	public List<Evaluation> getAllEvaluations() {
		return evaluationRepository.findAll();
	}

	@Override
	public Evaluation deleteEvaluation(EvaluationPK code) {
		Evaluation eval = evaluationRepository.findById(code).get();
		if(!eval.equals(null)) {
			evaluationRepository.delete(eval);
			return eval;
		}else {
			return null;
		}
	}

	@Override
	public void deleteAll() {
		evaluationRepository.deleteAll();
	}

	@Override
	public List<Evaluation> findByEtudiantCode(String etudiantCode) {
		return evaluationRepository.findByCodeEtudiant(etudiantCode);
	}

	@Override
	public long countEvaluation(String etudiantCode) {
		return findByEtudiantCode(etudiantCode).size();
	}

}
