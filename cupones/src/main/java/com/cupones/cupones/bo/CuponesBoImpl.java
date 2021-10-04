package com.cupones.cupones.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cupones.cupones.dao.AsignacionDao;
import com.cupones.cupones.dao.CuponesDao;
import com.cupones.cupones.dao.UsuarioDao;
import com.cupones.cupones.dto.AsignacionDto;
import com.cupones.cupones.dto.CuponDto;
import com.cupones.cupones.dto.UsuarioDto;
import com.cupones.cupones.dto.rest.CuponUsuarioDto;

@Service
public class CuponesBoImpl implements CuponesBo{

	@Autowired
	AsignacionDao asignacionDao;
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@Autowired
	CuponesDao cuponesDao;
	
	@Override
	public List<UsuarioDto> obtenerUsuarios() {
		List<UsuarioDto> list =  usuarioDao.findAll();
		for(UsuarioDto usr : list) {
			if(usr.getIdUsuarioRef() > 0) {
				Optional<UsuarioDto> usuarioRef =  usuarioDao.findById(usr.getIdUsuarioRef());
				if(usuarioRef.isPresent()) {
					String nombrecompleto = "";
					if(usuarioRef.get().getNombre() != null) {
						nombrecompleto += usuarioRef.get().getNombre();
					}
					if(usuarioRef.get().getApellidoPaterno() != null) {
						nombrecompleto += " " + usuarioRef.get().getApellidoPaterno();
					}
					if(usuarioRef.get().getApellidoMaterno() != null) {
						nombrecompleto += " " + usuarioRef.get().getApellidoMaterno();;
					}
					usr.setNombreRef(nombrecompleto);
				}
			}
		}
		return list;
	}

	@Override
	public UsuarioDto guardarUsuario(UsuarioDto usuario) {
		List<CuponDto> cuponesDisponibles = cuponesDao.findAll();
		int idUsuario = usuarioDao.findAll().size();
		usuario.setIdUsuario(idUsuario + 1);
		UsuarioDto usuariobd = usuarioDao.save(usuario);
		int idAsignacion = asignacionDao.findAll().size();
		for(CuponDto cupon : cuponesDisponibles) {
			AsignacionDto asignacion = new AsignacionDto();
			asignacion.setIdAsignacion(++idAsignacion);
			asignacion.setIdUsuario(usuariobd.getIdUsuario());
			asignacion.setEstatus(1);
			asignacion.setIdCupon(cupon.getIdCupon());
			asignacionDao.save(asignacion);
		}
		return usuariobd;
	}

	@Override
	public int actualizarCupon(CuponUsuarioDto cuponUsuarioDto) {
		// TODO Auto-generated method stub
		List<AsignacionDto> list = asignacionDao.findAll();
		int idAsignacion = 0;
		for(AsignacionDto asignacionDto : list) {
			if(asignacionDto.getIdCupon() == cuponUsuarioDto.getIdCupon()
					&& asignacionDto.getIdUsuario() == cuponUsuarioDto.getIdUsuario()) {
				idAsignacion = asignacionDto.getIdAsignacion();
				asignacionDto.setEstatus(2);
				asignacionDao.save(asignacionDto);
				break;
			}
		}
		return idAsignacion;
	}

}
