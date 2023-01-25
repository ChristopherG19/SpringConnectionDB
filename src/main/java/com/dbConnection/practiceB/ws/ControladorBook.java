package com.dbConnection.practiceB.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbConnection.practiceB.entity.Book;
import com.dbConnection.practiceB.repository.BookRepository;
import com.dbConnection.practiceB.wsint.BookInt;

@Component
public class ControladorBook implements BookInt{
	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Book> buscarLibros() {
		return bookRepository.findAll();
	}

	@Override
	public Book guardar(Book book) {
		return bookRepository.save(book);
	}
}
