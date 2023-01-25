package com.dbConnection.practiceB.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="AUTHOR")
public class Author implements Serializable{

	private static final long serialVersionUID = -872160360158939850L;

	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "CANTBOOKS")
	private int cantBooks;
	
	@Column(name = "ISALIVE")
	private String isAlive;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "AUTHORID")
	private List<Book> books;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getCantBooks() {
		return cantBooks;
	}

	public void setCantBooks(int cantBooks) {
		this.cantBooks = cantBooks;
	}

	public String getIsAlive() {
		return isAlive;
	}

	public void setIsAlive(String isAlive) {
		this.isAlive = isAlive;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
