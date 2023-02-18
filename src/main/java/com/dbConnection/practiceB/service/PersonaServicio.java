package com.dbConnection.practiceB.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.dbConnection.practiceB.dto.SalidaFuncionDTO;
import com.dbConnection.practiceB.dto.SalidaProcedimientoDTO;
import com.dbConnection.practiceB.dto.SalidaProcedimientoDTO2;
import com.dbConnection.practiceB.dto.SalidaProcedimientoDTOFusion;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.Date;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

@Service
public class PersonaServicio {
	
	@Autowired
	private JdbcTemplate jt;
	
	@Autowired
	NamedParameterJdbcTemplate nPJT;
	
	private static final String RETORNO  = "retorno";
	private static final String TEXTO  = "texto";
	private static final String NUMEROA  = "numeroA";
	private static final String NUMEROB  = "numeroB";
	private static final String SEGUNI  = "seguni";
	private static final String SALIDA  = "salida";
	private static final String RESULTADOD = "resultadoD";
	private static final String RESULTADOSD = "resultadoSD";
	
	public List<Map<String, Object>> buscarPorNombre(String nombre){
		String query = "select * from persona where nombre = :nom";
		SqlParameterSource sps = new MapSqlParameterSource()
				.addValue("nom", nombre);
		return nPJT.queryForList(query, sps);
	}
	
	public SalidaFuncionDTO funcionBd(String texto, int numero) {
		SalidaFuncionDTO sfd = new SalidaFuncionDTO();
		SimpleJdbcCall sjc = new SimpleJdbcCall(jt);
		
		sjc.withSchemaName(SEGUNI)
			.withCatalogName("paquete")
			.withFunctionName("funcion")
			.withoutProcedureColumnMetaDataAccess()
			.declareParameters(
					new SqlOutParameter(RETORNO, Types.DATE),
					new SqlInOutParameter(TEXTO, Types.VARCHAR),
					new SqlParameter("numero",Types.NUMERIC),
					new SqlOutParameter(SALIDA, Types.VARCHAR)
			);
			
		SqlParameterSource sps = new MapSqlParameterSource()
			.addValue(TEXTO, texto)
			.addValue("numero", numero);
			
		Map<String,Object> out = sjc.execute(sps);
		if(out.containsKey(RETORNO)) {
			sfd.setFecha((Date)out.get(RETORNO));
		}
		if(out.containsKey(TEXTO)) {
			sfd.setTexto(out.get(TEXTO).toString());
		}
		if(out.containsKey(SALIDA)) {
			sfd.setSalida(out.get(SALIDA).toString());
		}
		return sfd;
	}
	
	public SalidaProcedimientoDTO procedimientoBdD(String texto, Double numeroA, Double numeroB) {
	    SalidaProcedimientoDTO spd = new SalidaProcedimientoDTO();
	    SimpleJdbcCall sjc = new SimpleJdbcCall(jt);
	    
	    sjc.withSchemaName(SEGUNI)
	        .withCatalogName("paqueteDecimal")
	        .withProcedureName("procedimiento")
	        .withoutProcedureColumnMetaDataAccess()
	        .declareParameters(
					new SqlInOutParameter(TEXTO, Types.VARCHAR),
					new SqlParameter(NUMEROA,Types.NUMERIC),
					new SqlParameter(NUMEROB,Types.NUMERIC),
					new SqlOutParameter(RESULTADOD, Types.NUMERIC, 2),
					new SqlOutParameter(SALIDA, Types.VARCHAR)
	        );
	    
	    SqlParameterSource sps = new MapSqlParameterSource()
	    	.addValue(TEXTO, texto)
	        .addValue(NUMEROA, numeroA)
	        .addValue(NUMEROB, numeroB);
	    
	    Map<String,Object> out = sjc.execute(sps);
	    if(out.containsKey(TEXTO)) {
			spd.setTexto(out.get(TEXTO).toString());
		}
	    if(out.containsKey(RESULTADOD)) {
	    	spd.setResultado(((BigDecimal) out.get(RESULTADOD)).doubleValue());
	    }
		if(out.containsKey(SALIDA)) {
			spd.setSalida(out.get(SALIDA).toString());
		}    
	    return spd;
	}
	
	public SalidaProcedimientoDTO2 procedimientoBdSD(String texto, int numeroA, int numeroB) {
	    SalidaProcedimientoDTO2 spd = new SalidaProcedimientoDTO2();
	    SimpleJdbcCall sjc = new SimpleJdbcCall(jt);
	    
	    sjc.withSchemaName(SEGUNI)
	        .withCatalogName("paqueteNoDecimal")
	        .withProcedureName("procedimientoB")
	        .withoutProcedureColumnMetaDataAccess()
	        .declareParameters(
					new SqlInOutParameter(TEXTO, Types.VARCHAR),
					new SqlParameter(NUMEROA,Types.NUMERIC),
					new SqlParameter(NUMEROB,Types.NUMERIC),
					new SqlOutParameter(RESULTADOSD, Types.NUMERIC),
					new SqlOutParameter(SALIDA, Types.VARCHAR)
	        );
	    
	    SqlParameterSource sps = new MapSqlParameterSource()
	    	.addValue(TEXTO, texto)
	        .addValue(NUMEROA, numeroA)
	        .addValue(NUMEROB, numeroB);
	    
	    Map<String,Object> out = sjc.execute(sps);
	    if(out.containsKey(RESULTADOSD)) {
	    	spd.setResultado(((BigDecimal) out.get(RESULTADOSD)).intValue());
	    }
		if(out.containsKey(TEXTO)) {
			spd.setTexto(out.get(TEXTO).toString());
		}
		if(out.containsKey(SALIDA)) {
			spd.setSalida(out.get(SALIDA).toString());
		}    
	    return spd;
	}
	
	public SalidaProcedimientoDTOFusion procedimientoBdFusion(String texto, Double numeroA, Double numeroB) {
		SalidaProcedimientoDTOFusion spd = new SalidaProcedimientoDTOFusion();
	    SimpleJdbcCall sjc = new SimpleJdbcCall(jt);
	    
	    sjc.withSchemaName(SEGUNI)
	        .withCatalogName("paqueteFusion")
	        .withProcedureName("procedimientoC")
	        .withoutProcedureColumnMetaDataAccess()
	        .declareParameters(
					new SqlInOutParameter(TEXTO, Types.VARCHAR),
					new SqlParameter(NUMEROA,Types.NUMERIC),
					new SqlParameter(NUMEROB,Types.NUMERIC),
					new SqlOutParameter(RESULTADOD, Types.NUMERIC, 2),
					new SqlOutParameter(RESULTADOSD, Types.NUMERIC),
					new SqlOutParameter(SALIDA, Types.VARCHAR)
	        );
	    
	    SqlParameterSource sps = new MapSqlParameterSource()
	    	.addValue(TEXTO, texto)
	        .addValue(NUMEROA, numeroA)
	        .addValue(NUMEROB, numeroB);
	    
	    Map<String,Object> out = sjc.execute(sps);
		if(out.containsKey(TEXTO)) {
			spd.setTexto(out.get(TEXTO).toString());
		}
		if(out.containsKey(RESULTADOD)) {
	    	spd.setResultadoConDecimales(((BigDecimal) out.get(RESULTADOD)).doubleValue());
	    }
		if(out.containsKey(RESULTADOSD)) {
	    	spd.setResultadoSinDecimales(((BigDecimal) out.get(RESULTADOSD)).intValue());
	    }
		if(out.containsKey(SALIDA)) {
			spd.setSalida(out.get(SALIDA).toString());
		}    
	    return spd;
	}
	
}
