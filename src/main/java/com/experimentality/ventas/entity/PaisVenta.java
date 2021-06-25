package com.experimentality.ventas.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class PaisVenta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 254855850679704408L;

	
	private Double precio;
	
	private Double porcentajeDescuento;
}
