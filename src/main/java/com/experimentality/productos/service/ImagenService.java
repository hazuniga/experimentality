package com.experimentality.productos.service;

import java.util.List;

import com.experimentality.productos.entity.Imagen;

public interface ImagenService {

	/**
	 * Función que registra los datos de ubicación de una imagen y su nombre
	 * @param imagen
	 * @return
	 */
	public Imagen guardar(Imagen imagen);
	
	/**
	 * Función que lista todas las imagenes registradas
	 * @return
	 */
	public List<Imagen> listarImagenes();
	
	/**
	 * Función que lista las imágenes asociadas a un producto
	 * @param idProducto
	 * @return
	 */
	public List<Imagen> listarImagenes(int idProducto);
	
	/**
	 * Función que actualiza la información de una imagen registrada en el 
	 * sistema
	 * @param imagen
	 * @return
	 */
	public boolean actualizar(Imagen imagen);
	
	/**
	 * Función que recupera una imagen por su id
	 * @param idImagen
	 * @return
	 */
	public Imagen getImagen(int idImagen);
}
