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
@Table(name = "tipo_productos")
public class TipoProducto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4537579938534006599L;

	@Id
	@Column(name = "id_tipo_producto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_productos_id_tipo_producto_seq")
	@SequenceGenerator(name="tipo_productos_id_tipo_producto_seq", sequenceName="tipo_productos_id_tipo_producto_seq", allocationSize=1)
	private int id;
	
	@Column(name = "tipo_producto")
	@NotNull
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
