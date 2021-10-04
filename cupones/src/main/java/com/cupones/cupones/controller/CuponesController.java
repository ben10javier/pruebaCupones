package com.cupones.cupones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cupones.cupones.bo.CuponesBo;
import com.cupones.cupones.dto.UsuarioDto;
import com.cupones.cupones.dto.rest.CuponUsuarioDto;
import com.cupones.cupones.dto.rest.RestResultadoDto;
import com.cupones.cupones.dto.rest.RestUsuarioDto;
import com.cupones.cupones.dto.rest.ResultadoUsuarioDto;

@RestController
@RequestMapping("/cupones")
public class CuponesController {
	
	@Autowired
	CuponesBo cuponesBo;
	
	@GetMapping("/obtenerUsuarios")
	public RestUsuarioDto obtenerUsuarios(){
		ResultadoUsuarioDto resultadousuarioDto = new ResultadoUsuarioDto();
		resultadousuarioDto.setUsuarios(cuponesBo.obtenerUsuarios());
		RestUsuarioDto restUsuarioDto = new RestUsuarioDto();
		restUsuarioDto.setCodigo(200);
		restUsuarioDto.setDescripcion("Operación exitosa");
		restUsuarioDto.setResultado(resultadousuarioDto);
		return restUsuarioDto;		
	}
	
	@PostMapping("/guardarUsuario")
	public RestResultadoDto guardarUsuario(@RequestBody UsuarioDto usuarioDto) {
		UsuarioDto usuarioNuevo = cuponesBo.guardarUsuario(usuarioDto);
		RestResultadoDto restResultadoDto = new RestResultadoDto();
		restResultadoDto.setCodigo(201);
		restResultadoDto.setDescripcion("Operación exitosa");
		restResultadoDto.setResultado("Se guardó correctamente el usuario con id " + usuarioNuevo.getIdUsuario());
		return restResultadoDto;
	}
	
	@PutMapping("/utilizarCupon")
	public RestResultadoDto utilizarCupon(@RequestBody CuponUsuarioDto cuponUsuarioDto) {
		int idActualizado = cuponesBo.actualizarCupon(cuponUsuarioDto);
		RestResultadoDto restResultadoDto = new RestResultadoDto();
		if(idActualizado > 0) {
			restResultadoDto.setCodigo(200);
			restResultadoDto.setDescripcion("Operación exitosa");
			restResultadoDto.setResultado("Se actualizó correctamente el idAsignacion " + idActualizado);
		}else {
			restResultadoDto.setCodigo(404);
			restResultadoDto.setDescripcion("Problemas al procesar su solicitud");
			restResultadoDto.setResultado("No se encontraron cupones");
		}
		return restResultadoDto;
	}

}
