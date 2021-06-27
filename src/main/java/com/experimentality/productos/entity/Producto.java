package com.experimentality.productos.entity;

/**
 * Entidad que contiene el registro de los productos ofertados en la tienda
 */

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.experimentality.ventas.entity.PaisVenta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "productos")
public class Producto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5260791329512609895L;
	
	
	@Id
	@Column(name = "id_producto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productos_id_producto_seq")
	@SequenceGenerator(name="productos_id_producto_seq", sequenceName="productos_id_producto_seq", allocationSize=1)
	private int id;
	
	@NotNull
	@Column(name = "nombre_producto")
	private String nombreProducto;
	
	@Column(name = "descripcion")
	private String descripcion;
		
	@Column(name = "genero")
	private char genero;

	@OneToMany(mappedBy = "producto")
	private List<PaisVenta> paisesVenta;
	
	@OneToMany(mappedBy = "producto")
	@JsonIgnore
	private List<CaracteristicaProducto> caracteristicas;
	
	public List<CaracteristicaProducto> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<CaracteristicaProducto> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public int getId() {
		return id;
	}

	public List<PaisVenta> getPaisesVenta() {
		return paisesVenta;
	}

	public void setPaisesVenta(List<PaisVenta> paisesVenta) {
		this.paisesVenta = paisesVenta;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}
	
}
