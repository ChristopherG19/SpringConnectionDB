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

import com.dbConnection.practiceB.entity.UserInsta;

@RestController
@RequestMapping("/users")
@CrossOrigin
public interface UserInt {
	@GetMapping(path="/consultar")
	public List<UserInsta> buscarUsuario();

	@PostMapping("/guardar")
	public UserInsta guardar(@RequestBody UserInsta usuario);
	
	@DeleteMapping("/eliminar/{id}")
	public void deleteUserInsta(@PathVariable("id") int id);
}
