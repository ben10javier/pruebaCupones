package com.cupones.cupones.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioDto {

	@Id
	@Column(unique = true, nullable = false, name="id_usuario")
	private Integer idUsuario;
	
	@Column(unique = true, nullable = false, length=70)
	private String correo;
	
	@Column(length=50)
	private String nombre;
	
	@Column(name="apellido_paterno", length=50)
	private String apellidoPaterno;
	
	@Column(name="apellido_materno", length=50)
	private String apellidoMaterno;
	
	@Column(length=50)
	private String contrasena;
	
	private int estatus;

	@Column(name="id_usuario_ref", nullable = true)
	private Integer idUsuarioRef;
	
	private String nombreRef;
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	public Integer getIdUsuarioRef() {
		if(idUsuarioRef == null) {
			return 0;
		}
		return idUsuarioRef;
	}
	public void setIdUsuarioRef(Integer idUsuarioRef) {
		this.idUsuarioRef = idUsuarioRef;
	}
	public String getNombreRef() {
		return nombreRef;
	}
	public void setNombreRef(String nombreRef) {
		this.nombreRef = nombreRef;
	}

}
