package com.experimentality.reportes.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	/*cambiar por una relacion*/
	private int idProducto;
	
	@Column(name = "fecha_busqueda")
	private Date fechaBusqueda;
}
