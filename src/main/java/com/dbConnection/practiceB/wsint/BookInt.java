package com.dbConnection.practiceB.wsint;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbConnection.practiceB.entity.Book;

@RestController
@RequestMapping("/books")
@CrossOrigin
public interface BookInt {
	
	@GetMapping(path="/consultar")
	public List<Book> buscarLibros();

	@PostMapping("/guardar")
	public Book guardar(@RequestBody Book book);

}
