package com.experimentality.productos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.experimentality.productos.entity.Imagen;

public interface ImagenDao extends CrudRepository<Imagen, Integer>{

	@Query(value = "select	i.*\r\n" + 
			"from	imagenes i\r\n" + 
			"		inner join caracteristicas_productos cp\r\n" + 
			"				on i.id_caracteristica = cp.id_caracteristica\r\n" + 
			"where	cp.id_producto = ?1", nativeQuery = true)
	public List<Imagen> getImagenesByProducto(int idProducto);
	
	@Query(value = "select *\r\n" + 
			"from	imagenes\r\n" + 
			"where	id_caracteristica = ?1 and lower(imagen) = lower(?2) and lower(tipo) = lower(?3)", nativeQuery = true)
	public Imagen getImagen(int idCaracteristica, String imagen, String tipo);
}
