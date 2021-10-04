package com.cupones.cupones.dto.rest;

public class RestUsuarioDto {
	
	private int codigo;
	private String descripcion;
	private ResultadoUsuarioDto resultado;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ResultadoUsuarioDto getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoUsuarioDto resultado) {
		this.resultado = resultado;
	}
	
	

}
