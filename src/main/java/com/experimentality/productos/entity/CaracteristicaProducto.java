package com.experimentality.productos.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.experimentality.catalogo.entity.Color;
import com.experimentality.catalogo.entity.Talla;
import com.experimentality.catalogo.entity.TipoProducto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "caracteristicas_productos")
public class CaracteristicaProducto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3845737418081006302L;

	@Id
	@Column(name = "id_caracteristica")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caracteristicas_productos_id_caracteristica_seq")
	@SequenceGenerator(name="caracteristicas_productos_id_caracteristica_seq", sequenceName="caracteristicas_productos_id_caracteristica_seq", allocationSize=1)
	private int id;
	
	/**
	 * Estas variables se definen para evitar cargar sus objetos correspondientes al momento de realizar operaciones de registro
	 * y edición
	 */
	@Column(name = "id_tipo_producto")
	@NotNull
	private Integer idTipoProducto;
	
	@Column(name = "id_producto")
	@NotNull
	private Integer idProducto;
	
	@Column(name = "id_talla")
	@NotNull
	private Integer idTalla;
	
	@Column(name = "id_color")
	@NotNull
	private Integer idColor;
	
	/**
	 * Estas variables se utilizan para la carga de objetos al momento de listar las características
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto", insertable = false, updatable = false)
	@MapsId("producto")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Producto producto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_color", insertable = false, updatable = false)
	//@MapsId("color")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Color color;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_producto", insertable = false, updatable = false)
	//@MapsId("tipoProducto")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private TipoProducto tipoProducto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_talla", insertable = false, updatable = false)
	//@MapsId("talla")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
