package com.dbConnection.practiceB.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbConnection.practiceB.entity.Photo;

@Repository("photoRepository")
public interface PhotoRepository extends JpaRepository<Photo, Serializable>{
	public List<Photo> findByUrlEndingWith(String extension);
}
