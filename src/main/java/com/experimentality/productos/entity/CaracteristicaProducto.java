package com.experimentality.productos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "caracteristicas_productos")
public class CaracteristicaProducto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3845737418081006302L;

	@Id
	@Column(name = "id_caracteristica")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/*colacar relaciones con objetos*/
}
