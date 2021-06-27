package com.experimentality.ventas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.experimentality.productos.entity.CaracteristicaProducto;
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
	@JoinColumn(name = "id_caracteristica")
	@MapsId("idCaracteristica")
	private CaracteristicaProducto idCaracteristica;
	
	@Column(name = "precio")
	private Double precio;
	
	@Column(name = "porcentaje_descuento")
	private Double porcentajeDescuento;

	public PaisVenta(Pais pais, CaracteristicaProducto caracteristica) {
		this.id = new PaisVentaPK(pais.getId(), caracteristica.getId());
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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public CaracteristicaProducto getIdCaracteristica() {
		return idCaracteristica;
	}

	public void setIdCaracteristica(CaracteristicaProducto idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}
	
	
}
