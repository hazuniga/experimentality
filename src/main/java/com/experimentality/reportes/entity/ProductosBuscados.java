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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.experimentality.productos.entity.CaracteristicaProducto;

@Entity
@Table(name = "productos_buscados")
public class ProductosBuscados implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8155404043167139126L;

	@Id
	@Column(name = "id_producto_buscado")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productos_buscados_id_producto_buscado_seq")
	@SequenceGenerator(name="productos_buscados_id_producto_buscado_seq", sequenceName="productos_buscados_id_producto_buscado_seq", allocationSize=1)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_caracteristica")
	@MapsId("caracteristica")
	private CaracteristicaProducto caracteristica;
	
	@Column(name = "fecha_busqueda")
	private Date fechaBusqueda;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaBusqueda() {
		return fechaBusqueda;
	}

	public void setFechaBusqueda(Date fechaBusqueda) {
		this.fechaBusqueda = fechaBusqueda;
	}

	public CaracteristicaProducto getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(CaracteristicaProducto caracteristica) {
		this.caracteristica = caracteristica;
	}
	
	
}
