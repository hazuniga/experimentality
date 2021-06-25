package com.experimentality.productos.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.experimentality.catalogo.entity.Color;
import com.experimentality.catalogo.entity.Talla;
import com.experimentality.catalogo.entity.TipoProducto;

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
	
	@ManyToOne
	@JoinColumn(name = "id_producto")
	@MapsId("producto")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "id_color")
	@MapsId("color")
	private Color color;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_producto")
	@MapsId("tipoProducto")
	private TipoProducto tipoProducto;
	
	@ManyToOne
	@JoinColumn(name = "id_talla")
	@MapsId("talla")
	private Talla talla;
	
	@OneToMany(mappedBy = "caracteristica")
	private List<Imagen> imagenes;

	public List<Imagen> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<Imagen> imagenes) {
		this.imagenes = imagenes;
	}

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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public Talla getTalla() {
		return talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
	}
	
	
}
