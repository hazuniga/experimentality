package com.experimentality.productos.service;

import java.util.List;

import com.experimentality.productos.dto.ProductoDto;
import com.experimentality.productos.entity.CaracteristicaProducto;

public interface CaracteristicaProductoService {

	/**
	 * Función que guarda la asociación de las diferentes caracteristicas que posee un producto
	 * y lo registra
	 * @param caracteristica
	 * @return
	 */
	public CaracteristicaProducto guardar(CaracteristicaProducto caracteristica);
	
	/**
	 * Función que retorna las caracteristicas relacionadas de un producto
	 * @param idProducto
	 * @return
	 */
	public List<CaracteristicaProducto> listarCarecteristicaProducto(int idProducto);
	
	/**
	 * Función que retorna un true para actualizar una caracteristica o la asociación de cada una de ellas
	 * @param caracteristica
	 * @return
	 */
	public boolean actualizar(CaracteristicaProducto caracteristica);
	
	/**
	 * Función que retorna una característica de acuerdo a su id 
	 * @param idCaracteristica
	 * @return
	 */
	public CaracteristicaProducto getCaracteristica(int idCaracteristica);
	
	/**
	 * Función que retorna la lista de las características de los productos más buscados
	 * @return
	 */
	public List<CaracteristicaProducto> listaProductosMasBuscados();
	
	/**
	 * Función que copia los datos de un ProductoDto para que sean accesibles al almacenamiento 
	 * mediante CaracteristicaProducto.
	 * Retorna el id que se genera de guardar el registro
	 * @param producto
	 * @param idProducto
	 * @return
	 */
	public int guardarCaracteristica(ProductoDto producto, int idProducto);
}
