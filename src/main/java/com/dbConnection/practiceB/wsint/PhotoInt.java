package com.dbConnection.practiceB.wsint;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbConnection.practiceB.entity.UserInsta;
import com.dbConnection.practiceB.entity.Photo;

@RestController
@RequestMapping("/photos")
@CrossOrigin
public interface PhotoInt {
	@GetMapping(path="/consultar")
	public List<Photo> buscarFotos();

	@PostMapping("/guardar")
	public Photo guardar(@RequestBody Photo foto);
	
	public UserInsta verificacion(Photo foto);
}
