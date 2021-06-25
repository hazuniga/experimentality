package com.experimentality.catalogo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "colores")
public class Color implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -506698737186201738L;

	@Id
	@Column(name = "id_color")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "color")
	private String nombreColor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreColor() {
		return nombreColor;
	}

	public void setNombreColor(String nombreColor) {
		this.nombreColor = nombreColor;
	}
	
	
	
}