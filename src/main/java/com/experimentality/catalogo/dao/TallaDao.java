package com.experimentality.catalogo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.experimentality.catalogo.entity.Talla;

public interface TallaDao extends CrudRepository<Talla, Integer>{

	@Query(value = "SELECT	TALLA\r\n" + 
			"FROM	TALLAS\r\n" + 
			"WHERE	LOWER(TALLA) = LOWER(?1)", nativeQuery = true)
	public String findByNameTalla(String talla);
}
