package com.experimentality.catalogo.service;

import java.util.List;

import com.experimentality.catalogo.entity.TipoProducto;

public interface TipoProductoService {

	/**
	 * Función que registra la información de un Tipo de Producto 
	 * @param tipoProducto
	 * @return
	 */
	public TipoProducto guardar(TipoProducto tipoProducto);
	
	/**
	 * Función que lista todas las opciones de tipo de producto disponibles
	 * @return
	 */
	public List<TipoProducto> listarTiposProducto();
	
	/**
	 * Función que retorna un true si el tipo de producto se acutaliza correctamente
	 * de lo contrario retorna un false
	 * @param tipoProducto
	 * @return
	 */
	public boolean actualizar(TipoProducto tipoProducto);
	
	/**
	 * Función que retorna un tipo de producto de acuerdo a su id
	 * @param idTipoProducto
	 * @return
	 */
	public TipoProducto getTipoProducto(int idTipoProducto);
}
