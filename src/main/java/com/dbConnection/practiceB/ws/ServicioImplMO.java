package com.dbConnection.practiceB.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbConnection.practiceB.entity.Photo;
import com.dbConnection.practiceB.repository.PhotoRepository;
import com.dbConnection.practiceB.wsint.ServicioIntMO;

@Component
public class ServicioImplMO implements ServicioIntMO{
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
}
