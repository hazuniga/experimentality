package com.experimentality.ubicacion.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "descuentos_maximos")
public class DescuentosMaximos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5581178363844031910L;

	@Id
	@Column(name = "id_descuento")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/*Cambiar por una relación de uno a muchos*/
	private int idPais;
	
	@Column(name = "porcentaje")
	private Double porcentaje;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	
}
