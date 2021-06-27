package com.experimentality.catalogo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "tallas")
public class Talla implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6889038293029113727L;
	
	@Id
	@Column(name = "id_talla")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tallas_id_talla_seq")
	@SequenceGenerator(name="tallas_id_talla_seq", sequenceName="tallas_id_talla_seq", allocationSize=1)
	private int id;
	
	@Column(name = "talla")
	@NotNull
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
