package com.dbConnection.practiceB.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbConnection.practiceB.entity.Persona;
import com.dbConnection.practiceB.repository.PersonaRepository;
import com.dbConnection.practiceB.wsint.IntPersona;

@Component
public class ControladorPersona implements IntPersona{

	@Autowired
	PersonaRepository personaRepository;
	
	@Override
	public List<Persona> buscarPersona() {
		return personaRepository.findAll();
	}

	@Override
	public Persona guardar(Persona persona) {
		return personaRepository.save(persona);
	}

}
