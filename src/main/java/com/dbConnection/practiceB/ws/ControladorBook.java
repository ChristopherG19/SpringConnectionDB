package com.dbConnection.practiceB.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbConnection.practiceB.entity.Author;
import com.dbConnection.practiceB.entity.Book;
import com.dbConnection.practiceB.repository.AuthorRepository;
import com.dbConnection.practiceB.repository.BookRepository;
import com.dbConnection.practiceB.wsint.BookInt;

@Component
public class ControladorBook implements BookInt{
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public List<Book> buscarLibros() {
		return bookRepository.findAll();
	}

	@Override
	public Book guardar(Book book) {
		
		try {
			Author a = this.verificacion(book);
			if(authorRepository.findById(a.getId()).equals(Optional.empty())) {
				return book;
			} else {
				return bookRepository.save(book);
			}
			
		} catch (Exception e){
			System.out.println(e);
		}
		
		return book;
	}

	@Override
	public Author verificacion(Book book) {
		return book.getAuthor();
	}
}
