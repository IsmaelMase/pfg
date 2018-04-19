package com.ismaelmasegosa.salerev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ismaelmasegosa.salerev.entities.Curso;
import com.ismaelmasegosa.salerev.repository.CursoRepository;
import com.ismaelmasegosa.salerev.service.serviceImpl.CursoServiceImpl;

@RestController
@RequestMapping("/api/curso")
@CrossOrigin("*")
public class CursoController {

	@Autowired
	@Qualifier("cursoService")
	private CursoServiceImpl cursoService;
	
	@Autowired
	@Qualifier("cursoRepository")
	private CursoRepository cursoRepository;
	
	@GetMapping(value = "/cursos")
    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    @PostMapping(value = "/saveCurso", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public boolean saveCurso(@Valid @RequestBody Curso curso) {
        return cursoService.addCurso(curso);
    }
    
    @DeleteMapping(value = "/removeCurso/{id}")
    public boolean deleteCurso(@PathVariable("id") String id) {
    	return cursoService.removeCurso(id);
    }
}
