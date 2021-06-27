package com.experimentality.productos.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.experimentality.productos.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Integer>{

	@Query(value = "select  nombre_producto\r\n" + 
			"from	productos\r\n" + 
			"where	lower(nombre_producto) = lower(?1)", nativeQuery = true)
	public String findProductByName(String nombre_producto);
	
	@Query(value = "select * from COALESCE(findProduct(?1,?2,?3),0)", nativeQuery = true)
	public int findProduct(String nombre, String descripcion, String genero);
}
