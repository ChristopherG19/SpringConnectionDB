package com.dbConnection.practiceB.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbConnection.practiceB.entity.Persona;

@Repository("personaRepository")
public interface PersonaRepository extends JpaRepository<Persona, Serializable>{
	public List<Persona> findByNombre(String nombre);
	public List<Persona> findByEdadLessThan(Integer edad);
}
