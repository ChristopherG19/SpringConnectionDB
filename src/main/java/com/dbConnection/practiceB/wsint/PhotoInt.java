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

import com.dbConnection.practiceB.entity.Photo;

@RestController
@RequestMapping("/photos")
@CrossOrigin
public interface PhotoInt {
	@GetMapping(path="/consultar")
	public List<Photo> buscarFotos();
	
	@GetMapping(path="/consultar/urls/{extension}")
	public List<Photo> buscarByExtension(@PathVariable("extension") String extension);

	@PostMapping("/guardar")
	public Photo guardar(@RequestBody Photo foto);
	
	@DeleteMapping("/eliminar/{id}")
	public void deletePhoto(@PathVariable("id") int id);
}
