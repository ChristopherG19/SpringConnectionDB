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

import com.dbConnection.practiceB.entity.Factura;

@RestController
@RequestMapping("/facturas")
@CrossOrigin
public interface FacturaInt {
	
	@GetMapping(path="/consultar")
	public List<Factura> buscarFactura();
	
	@GetMapping(path="/consultar/montos/{montoA}/{montoB}")
	public List<Factura> buscarByMontos(@PathVariable("montoA") int montoA, 
			@PathVariable("montoB") int montoB);

	@PostMapping("/guardar")
	public Factura guardar(@RequestBody Factura factura);
	
	@DeleteMapping("/eliminar/{id}")
	public void deleteFactura(@PathVariable("id") int id);

}
