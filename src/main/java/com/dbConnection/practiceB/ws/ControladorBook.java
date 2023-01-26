package com.dbConnection.practiceB.ws;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbConnection.practiceB.entity.Book;
import com.dbConnection.practiceB.repository.BookRepository;
import com.dbConnection.practiceB.service.BookServicio;
import com.dbConnection.practiceB.wsint.BookInt;

@Component
public class ControladorBook implements BookInt{
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	BookServicio bS;
	
	@Override
	public List<Book> buscarLibros() {
		return bookRepository.findAll();
	}

	@Override
	public Book guardar(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}

	@Override
	public List<Book> buscarByGenero(String genre) {
		return bookRepository.findByGeneroContaining(genre);
	}

	@Override
	public List<Map<String, Object>> buscarLibroPorNombre(String nombre) {
		return bS.buscarLibroPorNombre(nombre);
	}
}
