package com.experimentality.ubicacion.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.experimentality.ubicacion.entity.DescuentosMaximos;

public interface DescuentosMaximosDao extends CrudRepository<DescuentosMaximos, Integer>{

	@Query(value = "select	porcentaje\r\n" + 
			"from	descuentos_maximos\r\n" + 
			"where 	id_pais = ?1", nativeQuery = true)
	public Double getDescuentoPais(int idPais);
}
