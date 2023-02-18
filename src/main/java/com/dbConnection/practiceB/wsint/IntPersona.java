package com.dbConnection.practiceB.wsint;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbConnection.practiceB.dto.SalidaFuncionDTO;
import com.dbConnection.practiceB.dto.SalidaProcedimientoDTO;
import com.dbConnection.practiceB.dto.SalidaProcedimientoDTO2;
import com.dbConnection.practiceB.dto.SalidaProcedimientoDTOFusion;
import com.dbConnection.practiceB.entity.Persona;

@RestController
@RequestMapping("/personas")
@CrossOrigin
public interface IntPersona {
	
	@GetMapping("/consultar")
	public List<Persona> buscarPersona();
	
	@GetMapping("/consultar/nombre/{nombre}")
	public List<Persona> buscarPersonaPorNombre(@PathVariable("nombre") String nombre);

	@GetMapping("/consultar/nombre2/{nombre}")
	public List<Map<String, Object>> buscarPorNombre(@PathVariable("nombre") String nombre);
	
	@GetMapping("/consultar/edadmenor/{edad}")
	public List<Persona> buscarPorMenorEdad(@PathVariable("edad") Integer edad);
	
	@PostMapping("/guardar")
	public Persona guardar(@RequestBody Persona persona);
	
	@DeleteMapping("/eliminar/{id}")
	public void deletePerson(@PathVariable("id") String id);
	
	@GetMapping("/funcion/{texto}/{numero}")
	public SalidaFuncionDTO ejectuarFuncion(@PathVariable String texto,@PathVariable int numero);
	
	@GetMapping("/proce/{texto}/{numeroA}/{numeroB}")
	public SalidaProcedimientoDTO ejectuarProcedimientoDe(@PathVariable String texto, @PathVariable Double numeroA, @PathVariable Double numeroB);
	
	@GetMapping("/proce2/{texto}/{numeroA}/{numeroB}")
	public SalidaProcedimientoDTO2 ejectuarProcedimientoSinDe(@PathVariable String texto, @PathVariable int numeroA, @PathVariable int numeroB);
	
	@GetMapping("/proce3/{texto}/{numeroA}/{numeroB}")
	public SalidaProcedimientoDTOFusion ejectuarProcedimientoFusion(@PathVariable String texto, @PathVariable Double numeroA, @PathVariable Double numeroB);
}
