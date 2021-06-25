package com.experimentality.catalogo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tallas")
public class Talla implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6889038293029113727L;
	
	@Id
	@Column(name = "id_talla")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "talla")
	private String talla;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	
}
