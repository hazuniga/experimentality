package com.experimentality.productos.service;

import java.util.List;

import com.experimentality.productos.dto.ProductoDto;
import com.experimentality.productos.dto.ProductosMasBuscadosDto;
import com.experimentality.productos.entity.Producto;

public interface ProductoService {
	
	/**
	 * Función para registrar la información del producto
	 * @param producto
	 * @return
	 */
	public Producto guardar(Producto producto);
	
	/**
	 * Función que registra un producto completo, es decir, con características, imagenes, así como pais, 
	 * precio y porcentaje de descuento
	 * @param producto
	 * @return
	 */
	public ProductoDto guardarProducto(ProductoDto producto);
	
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
	public boolean actualizar(ProductoDto producto);
	
	/**
	 * Función que retorna un producto de acuerdo al id ingresado
	 * @param idProducto
	 * @return
	 */
	public Producto getProducto(int idProducto);
	
	/**
	 * Función que retorna la lista de los prodcutos más buscados en una lista de tipo
	 * productosMasBuscadosDto
	 * @return
	 */
	public List<ProductosMasBuscadosDto> listarProductosMasBuscados();
	
	/**
	 * Función que compara los campos de un producto para validar si existe o no.
	 * En caso de no existir retorna un cero de lo contrario retorna el id del producto
	 * @param producto
	 * @return
	 */
	public int buscarProducto(ProductoDto producto);
}
