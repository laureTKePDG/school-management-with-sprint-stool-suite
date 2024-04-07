package com.academie.controllers;


import java.util.List;

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

import com.academie.entities.Etudiant;
import com.academie.services.EtudiantService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/etudiant")
public class EtudiantController {
	@Autowired
	EtudiantService etudiantService;
	
	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createOrUpdateEtudiant(@RequestBody Etudiant e) throws Exception{
		return new ResponseEntity<>(etudiantService.createOrUpdateEtudiant(e), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll() throws Exception{
		return new ResponseEntity<>(etudiantService.getAllEtudiants(), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable("code") String codeEtud){
		Etudiant e = etudiantService.deleteEtudiant(codeEtud);
		if(e == null)
			return new  ResponseEntity<>("Echec de suppression" , HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteAll()throws Exception{
		etudiantService.deleteAll();
		return new ResponseEntity<>("Opération Reussie", HttpStatus.OK);
	}
	
	@GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> count() throws Exception{
		return new ResponseEntity<>(etudiantService.countEtudiant(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/search", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<?> search(@RequestBody String pattern) throws Exception{
		 List<Etudiant> liste;
		 liste = etudiantService.findByEtudiantName(pattern);
		 liste.addAll(etudiantService.findByEtudiantEmail(pattern));
		 return new ResponseEntity<>(liste, HttpStatus.OK);
	 }
}
