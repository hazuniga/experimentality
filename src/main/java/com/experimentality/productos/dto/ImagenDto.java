package com.experimentality.productos.dto;

/**
 * Clase que contiene los atributos necesarios para guardar o recuperar una imagen
 * @author Andres Zuñiga Garzón
 *
 */
public class ImagenDto {

	private String imagen;
	private String ruta;
	private String tipo;
	
	public ImagenDto(String imagen, String ruta, String tipo) {
		this.imagen = imagen;
		this.ruta = ruta;
		this.tipo = tipo;
	}
	
	public ImagenDto() {
		this.imagen = "";
		this.ruta = "";
		this.tipo = "";
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
