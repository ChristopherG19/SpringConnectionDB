package com.dbConnection.practiceB.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class PersonaServicio {
	
	@Autowired
	NamedParameterJdbcTemplate nPJT;
	
	public List<Map<String, Object>> buscarPorNombre(String nombre){
		String query = "select * from persona where nombre = :nom";
		SqlParameterSource sps = new MapSqlParameterSource()
				.addValue("nom", nombre);
		return nPJT.queryForList(query, sps);
	};
	
}
