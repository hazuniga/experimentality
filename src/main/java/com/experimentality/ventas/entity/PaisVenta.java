package com.experimentality.ventas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.experimentality.productos.entity.Producto;
import com.experimentality.ubicacion.entity.Pais;

@Entity
@Table(name = "pais_venta")
public class PaisVenta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 254855850679704408L;

	@EmbeddedId
	private PaisVentaPK id;
	
	@ManyToOne
	@JoinColumn(name = "id_pais")
	@MapsId("idPais")
	private Pais pais;
	
	@ManyToOne
	@JoinColumn(name = "id_producto")
	@MapsId("idProducto")
	private Producto producto;
	
	@Column(name = "precio")
	private Double precio;
	
	@Column(name = "porcentaje_descuento")
	private Double porcentajeDescuento;

	public PaisVenta(Pais pais, Producto producto) {
		this.id = new PaisVentaPK(pais.getId(), producto.getId());
	}
	
	public PaisVenta() {
		// TODO Auto-generated constructor stub
	}

	public PaisVentaPK getId() {
		return id;
	}

	public void setId(PaisVentaPK id) {
		this.id = id;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
	
}
