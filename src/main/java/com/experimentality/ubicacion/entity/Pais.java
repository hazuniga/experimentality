package com.experimentality.ubicacion.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paises")
public class Pais implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4322745748778632889L;

	@Id
	@Column(name = "id_pais")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "pais")
	private String pais;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
	
}
