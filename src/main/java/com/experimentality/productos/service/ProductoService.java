package com.experimentality.productos.service;

import java.util.List;

import com.experimentality.productos.entity.Producto;

public interface ProductoService {
	
	/**
	 * Función para registrar la infomración del producto
	 * @param producto
	 * @return
	 */
	public Producto guardar(Producto producto);
	
	/**
	 * Función que retorna la lista de los productos registrados en el sistema
	 * @return
	 */
	public List<Producto> listarProductos();
	
	/**
	 * Función que actualiza el registro de un producto, retorna true si el registro
	 * se actualiza y false en caso de que no se pueda actualizar
	 * @param producto
	 * @return
	 */
	public boolean actualizar(Producto producto);
	
	/**
	 * Función que retorna un producto de acuerdo al id ingresado
	 * @param idProducto
	 * @return
	 */
	public Producto getProducto(int idProducto);
}
