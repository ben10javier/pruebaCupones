package com.cupones.cupones.dto.rest;

import java.util.List;

import com.cupones.cupones.dto.UsuarioDto;

public class ResultadoUsuarioDto {

	private List<UsuarioDto> usuarios;

	public List<UsuarioDto> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioDto> usuarios) {
		this.usuarios = usuarios;
	}
	
}
