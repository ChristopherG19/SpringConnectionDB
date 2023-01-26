package com.dbConnection.practiceB.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class BookServicio {

	@Autowired
	NamedParameterJdbcTemplate nPJT;
	
	public List<Map<String, Object>> buscarLibroPorNombre(String nombre){
		String query = "select b.id, b.title, b.genre, b.cantpages, CONCAT(CONCAT(a.firstname, ' '), a.lastname) as AuthorName, "
				+ "a.isAlive from book b join author a on a.id = b.authorid where title = :nom";
		SqlParameterSource sps = new MapSqlParameterSource()
				.addValue("nom", nombre);
		return nPJT.queryForList(query, sps);
	};
	
}
