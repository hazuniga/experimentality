package com.experimentality.catalogo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_productos")
public class TipoProducto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4537579938534006599L;

	@Id
	@Column(name = "id_tipo_producto")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "tipo_producto")
	private String tipoProducto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	
}
