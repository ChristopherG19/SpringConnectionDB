package com.dbConnection.practiceB.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbConnection.practiceB.entity.UserInsta;
import com.dbConnection.practiceB.repository.UserInstaRepository;
import com.dbConnection.practiceB.wsint.UserInt;

@Component
public class ControladorUser implements UserInt{

	@Autowired
	UserInstaRepository userInstaRepository;
	
	@Override
	public List<UserInsta> buscarUsuario() {
		return userInstaRepository.findAll();
	}

	@Override
	public UserInsta guardar(UserInsta usuario) {
		return userInstaRepository.save(usuario);
	}

	@Override
	public void deleteUserInsta(int id) {
		Optional<UserInsta> userI = userInstaRepository.findById(id);
		if (userI.isPresent()) {
			userInstaRepository.delete(userI.get());
		}
	}
	
}
