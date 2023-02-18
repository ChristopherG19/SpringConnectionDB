package com.dbConnection.practiceB.dto;

public class SalidaProcedimientoDTOFusion {
	private String texto;
	private Integer resultadoSinDecimales;
	private Double resultadoConDecimales;
	private String salida;
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Integer getResultadoSinDecimales() {
		return resultadoSinDecimales;
	}
	public void setResultadoSinDecimales(Integer resultadoSinDecimales) {
		this.resultadoSinDecimales = resultadoSinDecimales;
	}
	public Double getResultadoConDecimales() {
		return resultadoConDecimales;
	}
	public void setResultadoConDecimales(Double resultadoConDecimales) {
		this.resultadoConDecimales = resultadoConDecimales;
	}
	public String getSalida() {
		return salida;
	}
	public void setSalida(String salida) {
		this.salida = salida;
	}
	
}
