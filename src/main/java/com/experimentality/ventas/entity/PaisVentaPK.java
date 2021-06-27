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
	
	@Column(name = "id_caracteristica")
	private Integer idCaracteristica;
	
	
	public PaisVentaPK(Integer idPais, Integer idCaracteristica) {
		this.idPais = idPais;
		this.idCaracteristica = idCaracteristica;
	}

	public PaisVentaPK() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public Integer getIdCaracteristica() {
		return idCaracteristica;
	}

	public void setIdCaracteristica(Integer idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}
	
}
