package com.dbConnection.practiceB.wsint;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbConnection.practiceB.entity.Persona;

@RestController
@RequestMapping("/personas")
@CrossOrigin
public interface ServicioInt {
	
	@GetMapping(path="/consultar")
	public List<Persona> buscarPersona();

	@PostMapping("/guardar")
	public Persona guardar(@RequestBody Persona persona);
	
}
