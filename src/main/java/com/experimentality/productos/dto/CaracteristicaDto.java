package com.experimentality.productos.dto;

public class CaracteristicaDto {
	private int idTalla;
	private int idColor;
	private int idTipoProducto;
	
	public CaracteristicaDto(int idTalla, int idColor, int idTipoProducto) {
		this.idTalla = idTalla;
		this.idColor = idColor;
		this.idTipoProducto = idTipoProducto;
	}
	
	public CaracteristicaDto() {
		this.idTalla = 0;
		this.idColor = 0;
		this.idTipoProducto = 0;
	}

	public int getIdTalla() {
		return idTalla;
	}

	public void setIdTalla(int idTalla) {
		this.idTalla = idTalla;
	}

	public int getIdColor() {
		return idColor;
	}

	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}

	public int getIdTipoProducto() {
		return idTipoProducto;
	}

	public void setIdTipoProducto(int idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}
	
	
}
