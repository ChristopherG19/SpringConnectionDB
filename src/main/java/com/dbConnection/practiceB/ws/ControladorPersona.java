package com.dbConnection.practiceB.ws;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbConnection.practiceB.entity.Persona;
import com.dbConnection.practiceB.repository.PersonaRepository;
import com.dbConnection.practiceB.service.PersonaServicio;
import com.dbConnection.practiceB.wsint.IntPersona;

@Component
public class ControladorPersona implements IntPersona{

	@Autowired
	PersonaRepository personaRepository;
	
	@Autowired
	PersonaServicio pS;
	
	@Override
	public List<Persona> buscarPersona() {
		return personaRepository.findAll();
	}

	@Override
	public Persona guardar(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	public void deletePerson(String id) {
		personaRepository.deleteById(id);
	}

	// Consultas DSl
	@Override
	public List<Persona> buscarPersonaPorNombre(String nombre) {
		return personaRepository.findByNombre(nombre);
	}

	@Override
	public List<Persona> buscarPorMenorEdad(Integer edad) {
		return personaRepository.findByEdadLessThan(edad);
	}
	
	// Consultas personalizadas
	@Override
	public List<Map<String, Object>> buscarPorNombre(String nombre) {
		return pS.buscarPorNombre(nombre);
	}
	
}
