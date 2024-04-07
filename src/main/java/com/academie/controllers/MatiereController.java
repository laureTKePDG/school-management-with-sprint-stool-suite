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

import com.academie.entities.Matiere;
import com.academie.services.MatiereService;

@RestController
@CrossOrigin("*")
@RequestMapping("/matiere")
public class MatiereController {
	
	@Autowired
	MatiereService matiereService;
	
	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createOrUpdate(@RequestBody Matiere m) throws Exception{
		return new ResponseEntity<>(matiereService.createOrUpdate(m), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll() throws Exception{
		return new ResponseEntity<>(matiereService.getAll(), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable("code") String codeMat){
		Matiere m = matiereService.delete(codeMat);
		if(m.equals(null))
			return new  ResponseEntity<>("Echec de suppression" , HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(m, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteAll()throws Exception{
		matiereService.deleteAll();
		return new ResponseEntity<>("Opération Reussie", HttpStatus.OK);
	}
	
	@GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> count() throws Exception{
		return new ResponseEntity<>(matiereService.count(), HttpStatus.OK);
	}
	
}
