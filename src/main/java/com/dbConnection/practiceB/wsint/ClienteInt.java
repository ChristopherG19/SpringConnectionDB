package com.dbConnection.practiceB.wsint;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbConnection.practiceB.entity.Cliente;

@RestController
@RequestMapping("/clientes")
@CrossOrigin
public interface ClienteInt {

	@GetMapping(path="/consultar")
	public List<Cliente> buscarCliente();

	@PostMapping("/guardar")
	public Cliente guardar(@RequestBody Cliente cliente);
	
	@DeleteMapping("/eliminar/{id}")
	public void deleteCliente(@PathVariable("id") int id);
}
