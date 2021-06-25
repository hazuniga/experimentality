package com.experimentality.productos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	/*cambiar por una relación de uno a muchos*/
	@Column(name = "id_caracteristica")
	private int idCaracteristica;
	
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

	public int getIdCaracteristica() {
		return idCaracteristica;
	}

	public void setIdCaracteristica(int idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
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
