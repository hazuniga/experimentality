package com.experimentality.ubicacion.entity;

import java.io.Serializable;

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

@Entity
@Table(name = "descuentos_maximos")
public class DescuentosMaximos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5581178363844031910L;

	@Id
	@Column(name = "id_descuento")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "descuentos_maximos_id_descuento_seq")
	@SequenceGenerator(name="descuentos_maximos_id_descuento_seq", sequenceName="descuentos_maximos_id_descuento_seq", allocationSize=1)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_pais")
	@MapsId("pais")
	private Pais pais;
	
	@Column(name = "porcentaje")
	private Double porcentaje;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	
}
