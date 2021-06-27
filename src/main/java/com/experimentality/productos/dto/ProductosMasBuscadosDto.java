package com.experimentality.productos.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene los atributos necesarios para enviar la lista de productos más buscados
 * por los usuarios
 * @author Andres Zuñiga Garzon
 *
 */
public class ProductosMasBuscadosDto {

	private String nombreProducto;
	private String descripcion;
	private String color;
	private String talla;
	private Double precio;
	private Double precioConDescuento;
	private Double porcentajeDescuento;
	private List<ImagenDto> imagenes;
	
	public ProductosMasBuscadosDto(String nombreProducto, String descripcion, String color, String talla, Double precio,
			Double precioConDescuento, Double porcentajeDescuento, List<ImagenDto> imagenes) {
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
		this.color = color;
		this.talla = talla;
		this.precio = precio;
		this.precioConDescuento = precioConDescuento;
		this.porcentajeDescuento = porcentajeDescuento;
		this.imagenes = imagenes;
	}
	
	public ProductosMasBuscadosDto() {
		this.nombreProducto = "";
		this.descripcion = "";
		this.color = "";
		this.talla = "";
		this.precio = 0.0;
		this.precioConDescuento = 0.0;
		this.porcentajeDescuento = 0.0;
		this.imagenes = new ArrayList<>();
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getPrecioConDescuento() {
		return precioConDescuento;
	}

	public void setPrecioConDescuento(Double precioConDescuento) {
		this.precioConDescuento = precioConDescuento;
	}

	public Double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public List<ImagenDto> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<ImagenDto> imagenes) {
		this.imagenes = imagenes;
	}
	
	
}
