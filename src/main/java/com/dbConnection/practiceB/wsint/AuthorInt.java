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

import com.dbConnection.practiceB.entity.Author;

@RestController
@RequestMapping("/authors")
@CrossOrigin
public interface AuthorInt {
	
	@GetMapping(path="/consultar")
	public List<Author> buscarAutor();

	@PostMapping("/guardar")
	public Author guardar(@RequestBody Author autor);
	
	@DeleteMapping("/eliminar/{id}")
	public void deleteAuthor(@PathVariable("id") int id);
	
	@GetMapping("/consultar/isAlive/{estado}")
	public List<Author> buscarPorIsAlive(@PathVariable("estado") String estado);

}
