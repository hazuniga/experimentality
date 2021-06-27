package com.experimentality.productos.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que recopila los datos para facilitar el almacenamiento de un producto
 * 
 * @author Andres Zuñiga G
 *
 */

public class ProductoDto {

	/**
	 * Atributos para producto
	 */
	private int id;
	private String nombreProducto;
	private String descripcion;
	private String genero;
	
	/**
	 * Atributos para pais_venta
	 */
	private PaisVentaDto paisVenta;
	
	/**
	 * Atributos para caracteristicas_producto
	 */
	private CaracteristicaDto caracteristica;
	
	/**
	 * Atributo para imagen
	 */
	private List<ImagenDto> imagenes;

	
	public ProductoDto(int id, String nombreProducto, String descripcion, String genero, PaisVentaDto paisVenta, CaracteristicaDto caracteristica, List<ImagenDto> imagenes) {
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
		this.genero = genero;
		this.paisVenta = paisVenta;
		this.caracteristica = caracteristica;
		this.imagenes = imagenes;
	}
	
	public ProductoDto() {
		this.id = 0;
		this.nombreProducto = "";
		this.descripcion = "";
		this.genero = "";
		this.paisVenta = new PaisVentaDto();
		this.caracteristica = new CaracteristicaDto();
		this.imagenes = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public PaisVentaDto getPaisVenta() {
		return paisVenta;
	}

	public void setPaisVenta(PaisVentaDto paisVenta) {
		this.paisVenta = paisVenta;
	}

	public CaracteristicaDto getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(CaracteristicaDto caracteristica) {
		this.caracteristica = caracteristica;
	}

	public List<ImagenDto> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<ImagenDto> imagenes) {
		this.imagenes = imagenes;
	}
	
	
}
