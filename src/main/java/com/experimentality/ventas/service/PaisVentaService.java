package com.experimentality.ventas.service;

import java.util.List;

import com.experimentality.productos.dto.PaisVentaDto;
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
	public PaisVenta guardar(PaisVenta paisVenta);
	
	/**
	 * Función que valida si el descuento que se desea ingresar es permitido para el país
	 * al cual se hara el registro de venta del producto.
	 * En caso de estar permitido retorna un true de lo contrario un false
	 * @param paisVenta
	 * @return
	 */
	public boolean validarDescuento(int idPais, Double descuento);
	
	/**
	 * Función que prepara y registra el pais de venta ademas del precio y el porcentaje de decuento
	 * @param paisVenta
	 * @param idCaracteristica
	 */
	public void guardarPaisVenta(PaisVentaDto paisVenta, int idCaracteristica);
}
