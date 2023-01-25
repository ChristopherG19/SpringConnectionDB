package com.dbConnection.practiceB.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="BOOK")
public class Book implements Serializable{

	private static final long serialVersionUID = 7326668259281656946L;

	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="AUTHORID")
	private int authorId;

	@Column(name = "TITLE")
	private String titulo;
	
	@Column(name = "CANTPAGES")
	private int CantPages;
	
	@Column(name = "GENRE")
	private String genero;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getCantPages() {
		return CantPages;
	}

	public void setCantPages(int cantPages) {
		CantPages = cantPages;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
