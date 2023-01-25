package com.dbConnection.practiceB.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="FACTURA")
public class Factura implements Serializable{

	private static final long serialVersionUID = 6680564433715190282L;

	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name = "MONTO")
	private int monto;
	
	@Column(name = "LUGAR")
	private String lugar;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CLIENTEID")
	private Cliente cliente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
