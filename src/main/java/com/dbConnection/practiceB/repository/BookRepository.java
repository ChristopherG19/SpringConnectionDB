package com.dbConnection.practiceB.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbConnection.practiceB.entity.Book;

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, Serializable>{
	public List<Book> findByGeneroContaining(String genre);
}
