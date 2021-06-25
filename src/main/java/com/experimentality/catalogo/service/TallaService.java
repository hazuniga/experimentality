package com.experimentality.catalogo.service;

import java.util.List;

import com.experimentality.catalogo.entity.Talla;

public interface TallaService {

	/**
	 * Función que registra la información de la talla
	 * @param talla
	 * @return
	 */
	public Talla guardar(Talla talla);
	
	/**
	 * Función que lista todas las opciones de talla disponibles 
	 * @return
	 */
	public List<Talla> listarTallas();
	
	/**
	 * Función que returna un true si la talla se actualiza correctamente
	 * de lo contrario returna un false
	 * @param talla
	 * @return
	 */
	public boolean actualizar(Talla talla);
	
	/**
	 * Función que retorna una talla de acuerdo a su id
	 * @param idTalla
	 * @return
	 */
	public Talla getTalla(int idTalla);
}
