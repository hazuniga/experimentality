package com.experimentality.ventas.service;

import java.util.List;

import com.experimentality.ventas.entity.PaisVenta;

public interface PaisVentaService {

	/**
	 * Función que retorna la lista de paises en los que se ofrece un producto,
	 * obteniendo su precio y porcentaje de descuento
	 * @param idProducto
	 * @return
	 */
	public List<PaisVenta> listarPaisesVentaPorProducto(int idProducto);
	
	/**
	 * Función que registra el precio y el porcentaje de descuento de un producto 
	 * vinculandolo a un pais.
	 * Se retorna true si el registro fue almacenado de lo contrario retorna un false
	 * si el producto no fue registrado ya sea porque tiene un porcentaje de descuento no 
	 * permitido o sucede un inconveniente con la base de datos
	 * @param paisVenta
	 * @return
	 */
	public boolean guardar(PaisVenta paisVenta);
}
