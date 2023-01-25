package com.dbConnection.practiceB.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbConnection.practiceB.entity.Photo;
import com.dbConnection.practiceB.repository.PhotoRepository;
import com.dbConnection.practiceB.wsint.PhotoInt;

@Component
public class ControladorPhoto implements PhotoInt{
	
	@Autowired
	PhotoRepository photoRepository;
	
	@Override
	public List<Photo> buscarFotos() {
		return photoRepository.findAll();
	}

	@Override
	public Photo guardar(Photo foto) {
		return photoRepository.save(foto);
	}

	@Override
	public void deletePhoto(int id) {
		photoRepository.deleteById(id);
	}

}
