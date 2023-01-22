package com.dbConnection.practiceB.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbConnection.practiceB.entity.UserInsta;
import com.dbConnection.practiceB.repository.UserInstaRepository;
import com.dbConnection.practiceB.wsint.ServicioIntOM;

@Component
public class ServicioImplOM implements ServicioIntOM{

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
	
}
