package com.cupones.cupones.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cupones.cupones.dto.UsuarioDto;

public interface UsuarioDao extends JpaRepository<UsuarioDto, Integer> {

}
