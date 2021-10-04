package com.cupones.cupones.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cupones")
public class CuponDto {
	@Id
	@Column(name="id_cupon", unique = true, nullable = false)
	private int idCupon;
	
	@Column(length=50)
	private String restaurante;
	
	@Column(name="rfc_restaurante", length=50)
	private String rfcRestaurante;
	
	@Column(length=200)
	private String descripcion;
	
	private int estatus;
	
	@Column(name="fecha_caducidad")
	private String fechaCaducidad;
	
	public int getIdCupon() {
		return idCupon;
	}
	public void setIdCupon(int idCupon) {
		this.idCupon = idCupon;
	}
	public String getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(String restaurante) {
		this.restaurante = restaurante;
	}
	public String getRfcRestaurante() {
		return rfcRestaurante;
	}
	public void setRfcRestaurante(String rfcRestaurante) {
		this.rfcRestaurante = rfcRestaurante;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

}
