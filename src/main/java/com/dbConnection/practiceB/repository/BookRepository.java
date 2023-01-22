package com.dbConnection.practiceB.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbConnection.practiceB.entity.Book;

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, Serializable>{

}
