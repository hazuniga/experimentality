package com.experimentality.catalogo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.experimentality.catalogo.entity.TipoProducto;

public interface TipoProductoDao extends CrudRepository<TipoProducto, Integer>{

	@Query(value = "SELECT	TIPO_PRODUCTO\r\n" + 
			"FROM	TIPO_PRODUCTOS\r\n" + 
			"WHERE	LOWER(TIPO_PRODUCTO) = LOWER(?1)", nativeQuery = true)
	public String findByNameTipo(String tipoProducto);
}
