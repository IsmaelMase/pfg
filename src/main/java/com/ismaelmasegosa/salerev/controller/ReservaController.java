package com.ismaelmasegosa.salerev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ismaelmasegosa.salerev.entities.Curso;
import com.ismaelmasegosa.salerev.entities.Reserva;
import com.ismaelmasegosa.salerev.repository.CursoRepository;
import com.ismaelmasegosa.salerev.repository.ReservaRepository;
import com.ismaelmasegosa.salerev.repository.UsuarioRepository;
import com.ismaelmasegosa.salerev.service.serviceImpl.ReservaServiceImpl;

@RestController
@RequestMapping("/api/reverva")
@CrossOrigin("*")
public class ReservaController {

	@Autowired
	@Qualifier("reservaService")
	private ReservaServiceImpl reservaService;
	
	@Autowired
	@Qualifier("reservaRepository")
	private ReservaRepository reservaRepository;
	
	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRespository;
	
	@Autowired
	@Qualifier("cursoRepository")
	private CursoRepository cursoRespository;
	
	@GetMapping(value = "/reservas")
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }
	
	@GetMapping(value = "/reservasByUsuario/{id}")
    public List<Reserva> getReservasByUsuario(@PathVariable("id") String id) {
        return reservaRepository.findByUsuario(usuarioRespository.findById(id));
    }
	
	@GetMapping(value = "/reservasByCurso/{id}")
    public List<Reserva> getReservasByCurso(@PathVariable("id") String id) {
        return reservaRepository.findByCurso(cursoRespository.findById(id));
    }
	
	

    @PostMapping(value = "/saveReserva")
    public boolean saveReserva(@Valid @RequestBody Reserva reserva) {
        return reservaService.addReserva(reserva);
    }
    
    @DeleteMapping(value = "/removeReserva/{id}")
    public boolean deleteReserva(@PathVariable("id") String id) {
    	return reservaService.removeReserva(id);
    }
}
