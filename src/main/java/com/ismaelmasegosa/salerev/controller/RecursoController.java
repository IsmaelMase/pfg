package com.ismaelmasegosa.salerev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ismaelmasegosa.salerev.entities.Recurso;
import com.ismaelmasegosa.salerev.repository.RecursoRepository;
import com.ismaelmasegosa.salerev.service.serviceImpl.RecursoServiceImpl;

@RestController
@RequestMapping("/api/recurso")
@CrossOrigin("*")
public class RecursoController {

	@Autowired
	@Qualifier("recursoService")
	private RecursoServiceImpl recursoService;
	
	
	@GetMapping(value = "/recursos")
    public List<Recurso> getAllRecursos() {
        return recursoService.findAllRecursos();
    }
	
	@GetMapping(value = "/aulas")
    public List<Recurso> getAllAulas() {
        return recursoService.findAllAulas();
    }
	
	@GetMapping(value = "/allRecursos")
    public List<Recurso> getAll() {
        return recursoService.findAll();
    }
	
    @PostMapping(value = "/saveRecurso")
    public ResponseEntity<?> saveRecurso(@Valid @RequestBody Recurso recurso) {
        return recursoService.addRecurso(recurso);
    }
    
    @DeleteMapping(value = "/removeRecurso/{id}")
    public ResponseEntity<?> deleteRecurso(@PathVariable("id") String id) {
    	return recursoService.removeRecurso(id);
    }
	
}
