package com.dbConnection.practiceB.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbConnection.practiceB.entity.Factura;
import com.dbConnection.practiceB.repository.FacturaRepository;
import com.dbConnection.practiceB.wsint.FacturaInt;

@Component
public class ControladorFactura implements FacturaInt{

	@Autowired
	FacturaRepository facturaRepository;
	
	@Override
	public List<Factura> buscarFactura() {
		return facturaRepository.findAll();
	}

	@Override
	public Factura guardar(Factura factura) {
		return facturaRepository.save(factura);
	}

	@Override
	public void deleteFactura(int id) {
		facturaRepository.deleteById(id);
	}

}
