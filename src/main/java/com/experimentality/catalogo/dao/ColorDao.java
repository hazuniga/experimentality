package com.experimentality.catalogo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.experimentality.catalogo.entity.Color;

public interface ColorDao extends CrudRepository<Color, Integer>{

	/**
	 * Función que retorna un valor númerico en caso de encontrar coincidencias en los
	 * registros de base de datos
	 * @param color
	 * @return
	 */
	@Query(value = "SELECT	COLOR\r\n" + 
			"FROM	COLORES\r\n" + 
			"WHERE	upper(COLOR) = upper(?1)", nativeQuery = true)
	public String findByNameColor(String color);
}
