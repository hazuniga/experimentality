package com.experimentality.reportes.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.experimentality.productos.entity.Producto;

@Entity
@Table(name = "productos_buscados")
public class ProductosBuscados implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8155404043167139126L;

	@Id
	@Column(name = "id_producto_buscado")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_producto")
	@MapsId("producto")
	private Producto producto;
	
	@Column(name = "fecha_busqueda")
	private Date fechaBusqueda;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Date getFechaBusqueda() {
		return fechaBusqueda;
	}

	public void setFechaBusqueda(Date fechaBusqueda) {
		this.fechaBusqueda = fechaBusqueda;
	}
	
	
}
