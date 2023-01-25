package com.dbConnection.practiceB.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbConnection.practiceB.entity.Cliente;
import com.dbConnection.practiceB.repository.ClienteRepository;
import com.dbConnection.practiceB.wsint.ClienteInt;

@Component
public class ControladorCliente implements ClienteInt{

	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> buscarCliente() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente guardar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public void deleteCliente(int id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			clienteRepository.delete(cliente.get());
		}
	}

}
