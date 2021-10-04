package com.cupones.cupones.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cupones.cupones.dto.CuponDto;

public interface CuponesDao extends JpaRepository<CuponDto, Integer> {

}
