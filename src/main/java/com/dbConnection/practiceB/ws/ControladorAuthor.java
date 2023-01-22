package com.dbConnection.practiceB.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbConnection.practiceB.entity.Author;
import com.dbConnection.practiceB.repository.AuthorRepository;
import com.dbConnection.practiceB.wsint.AuthorInt;

@Component
public class ControladorAuthor implements AuthorInt {

	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public List<Author> buscarAutor() {
		return authorRepository.findAll();
	}

	@Override
	public Author guardar(Author autor) {
		return authorRepository.save(autor);
	}

}
