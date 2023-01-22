package com.dbConnection.practiceB.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbConnection.practiceB.entity.Photo;
import com.dbConnection.practiceB.entity.UserInsta;
import com.dbConnection.practiceB.repository.PhotoRepository;
import com.dbConnection.practiceB.repository.UserInstaRepository;
import com.dbConnection.practiceB.wsint.PhotoInt;

@Component
public class ControladorPhoto implements PhotoInt{
	
	@Autowired
	PhotoRepository photoRepository;
	
	@Autowired
	UserInstaRepository userInstaRepository;
	
	@Override
	public List<Photo> buscarFotos() {
		return photoRepository.findAll();
	}

	@Override
	public Photo guardar(Photo foto) {
		
		try {
			UserInsta a = this.verificacion(foto);
			if(userInstaRepository.findById(a.getId()).equals(Optional.empty())) {
				return foto;
			} else {
				return photoRepository.save(foto);
			}
			
		} catch (Exception e){
			System.out.println(e);
		}

		return foto;
	}

	@Override
	public UserInsta verificacion(Photo foto) {
		return foto.getUserInsta();
	}
}
