package com.academie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academie.entities.Evaluation;
import com.academie.entities.EvaluationPK;
import com.academie.services.EvaluationService;

@RestController
@CrossOrigin("*")
@RequestMapping("/eval")
public class EvaluationController {
	@Autowired
	EvaluationService evaluationService;
	
	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createOrUpdateEvlation(@RequestBody Evaluation e) throws Exception{
		return new ResponseEntity<>(evaluationService.createOrUpdateEvaluation(e), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll() throws Exception{
		return new ResponseEntity<>(evaluationService.getAllEvaluations(), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@RequestBody EvaluationPK code){
		Evaluation e = evaluationService.deleteEvaluation(code);
		if(e.equals(null))
			return new  ResponseEntity<>("Echec de suppression" , HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteAll()throws Exception{
		evaluationService.deleteAll();
		return new ResponseEntity<>("Opération Reussie", HttpStatus.OK);
	}
	
	@GetMapping(value = "/count/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> count(@PathVariable("code") String codeEtudiant) throws Exception{
		return new ResponseEntity<>(evaluationService.countEvaluation(codeEtudiant), HttpStatus.OK);
	}
	
	@GetMapping(value = "/search/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<?> search(@PathVariable("code") String codeEtudiant) throws Exception{
		 return new ResponseEntity<>(evaluationService.findByEtudiantCode(codeEtudiant), HttpStatus.OK);
	 }

}
