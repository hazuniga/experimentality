package com.experimentality.productos.dto;

public class PaisVentaDto {
	
	private int idPais;
	private Double precio;
	private Double porcentajeDescuento;
	
	public PaisVentaDto(Double precio, Double porcentajeDescuento) {
		this.precio = precio;
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
	public PaisVentaDto() {
		this.idPais = 0;
		this.precio = 0.0;
		this.porcentajeDescuento = 0.0;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
	
}
