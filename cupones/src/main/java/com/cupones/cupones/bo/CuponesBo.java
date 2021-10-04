package com.cupones.cupones.bo;

import java.util.List;

import com.cupones.cupones.dto.UsuarioDto;
import com.cupones.cupones.dto.rest.CuponUsuarioDto;

public interface CuponesBo {
	
	public List<UsuarioDto> obtenerUsuarios();
	
	public UsuarioDto guardarUsuario(UsuarioDto usuario);
	
	public int actualizarCupon(CuponUsuarioDto cuponUsuarioDto);

}
