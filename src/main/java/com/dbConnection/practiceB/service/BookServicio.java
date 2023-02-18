package com.dbConnection.practiceB.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.dbConnection.practiceB.repository.BookRepository;


@Service
public class BookServicio {

	@Autowired
	NamedParameterJdbcTemplate nPJT;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SQL_STORED_PROC = "CREATE OR REPLACE PROCEDURE insertBook(b_id NUMBER,a_id NUMBER, title VARCHAR2, cantPages NUMBER, genre VARCHAR2) AS BEGIN INSERT INTO BOOK VALUES(b_id, a_id, title, cantPages, genre); END;";

	private final BookRepository bookRepository;
	
	public List<Map<String, Object>> buscarLibroPorNombre(String nombre) {
		String query = "select b.id, b.title, b.genre, b.cantpages, CONCAT(CONCAT(a.firstname, ' '), a.lastname) as AuthorName, "
				+ "a.isAlive from book b join author a on a.id = b.authorid where title = :nom";
		SqlParameterSource sps = new MapSqlParameterSource().addValue("nom", nombre);
		return nPJT.queryForList(query, sps);
	};

	public BookServicio(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public void Start(int b_id, int a_id, String title, int cantPages, String genre) {
		bookRepository.insertBook(b_id, a_id, title, cantPages, genre);
	}

}
