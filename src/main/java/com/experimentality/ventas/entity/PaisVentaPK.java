package com.experimentality.ventas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PaisVentaPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3622332443545666658L;

	@Column(name = "id_pais")
	private Integer idPais;
	
	@Column(name = "id_producto")
	private Integer idProducto;
	
	public PaisVentaPK(Integer idPais, Integer idProducto) {
		this.idPais = idPais;
		this.idProducto = idProducto;
	}

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	
	
}
