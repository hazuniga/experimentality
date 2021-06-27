package com.experimentality.productos.service;

import java.util.List;

import com.experimentality.productos.dto.ImagenDto;
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
	 * Se obtiene una imagen con las caracteristicas diferenciales y el tipo 
	 * es decir, frontal o tracera
	 * @param idCategoria
	 * @param nombre
	 * @param tipo
	 * @return
	 */
	public Imagen getImagen(int idCategoria, String nombre, String tipo);
	
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
	
	/**
	 * Ajusta y registra las imagenes al sistema
	 * @param imagenes
	 * @param idCaracteristica
	 */
	public void guardarImagen(List<ImagenDto> imagenes, int idCaracteristica);
}
