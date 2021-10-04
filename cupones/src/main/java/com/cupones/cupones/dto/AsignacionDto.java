package com.cupones.cupones.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asignacion")
public class AsignacionDto {

	@Id
	@Column(name="id_asignacion", unique = true, nullable = false)
	private Integer idAsignacion;
	
	@Column(name="id_usuario", nullable = false)
	private int idUsuario;
	
	@Column(name="id_cupon", nullable = false)
	private int idCupon;
	
	private int estatus;
	
	public int getIdAsignacion() {
		return idAsignacion;
	}
	public void setIdAsignacion(int idAsignacion) {
		this.idAsignacion = idAsignacion;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdCupon() {
		return idCupon;
	}
	public void setIdCupon(int idCupon) {
		this.idCupon = idCupon;
	}
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	
	
}
