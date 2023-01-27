package com.dbConnection.practiceB.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dbConnection.practiceB.entity.Book;

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, Serializable>{
	public List<Book> findByGeneroContaining(String genre);
	
	@Procedure(name="insertBook")
	public void insertBook(@Param("b_id") int b_id, @Param("a_id") int a_id, 
			@Param("title") String title, @Param("cantPages") int cantPages, @Param("genre") String genre);
}
