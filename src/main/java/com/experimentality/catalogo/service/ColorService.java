package com.experimentality.catalogo.service;

import java.util.List;

import com.experimentality.catalogo.entity.Color;

public interface ColorService {

	/**
	 * Función que registra la información del color 
	 * @param color
	 * @return
	 */
	public Color guardar(Color color);
	
	/**
	 * Función que lista todos los colores de la base de datos
	 * @return
	 */
	public List<Color> listarColores();
	
	/**
	 * Función que retorna un true si la actualización del color se realiza correctamente
	 * de lo contrario retorna un false
	 * @param color
	 * @return
	 */
	public boolean actualizar(Color color);
	
	/**
	 * Función que retorna un color de acuerdo a su identificador
	 * @param idColor
	 * @return
	 */
	public Color getColor(int idColor);
}
