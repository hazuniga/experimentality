package com.experimentality.ventas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.experimentality.ventas.entity.PaisVenta;
import com.experimentality.ventas.entity.PaisVentaPK;

public interface PaisVentaDao extends CrudRepository<PaisVenta, PaisVentaPK>{

	@Query(value = "select	*\r\n" + 
			"from	pais_venta\r\n" + 
			"where	id_producto = ?1", nativeQuery = true)
	public List<PaisVenta> findPaisesVenta(int idProducto);
}
