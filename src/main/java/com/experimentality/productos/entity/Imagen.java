package com.experimentality.productos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "imagenes")
public class Imagen implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9070133473432170727L;

	
	@Id
	@Column(name = "id_imagen")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_caracteristica")
	@MapsId("caracteristica")
	private CaracteristicaProducto caracteristica;
	
	@Column(name = "imagen")
	private String imagen;
	
	@Column(name = "ruta")
	private String ruta;
	
	@Column(name = "tipo")
	private char tipo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CaracteristicaProducto getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(CaracteristicaProducto caracteristica) {
		this.caracteristica = caracteristica;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
	
	
}
