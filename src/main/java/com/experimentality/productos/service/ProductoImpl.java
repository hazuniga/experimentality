package com.experimentality.productos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.experimentality.catalogo.service.ColorService;
import com.experimentality.catalogo.service.TallaService;
import com.experimentality.catalogo.service.TipoProductoService;
import com.experimentality.productos.dao.ProductoDao;
import com.experimentality.productos.dto.ImagenDto;
import com.experimentality.productos.dto.ProductoDto;
import com.experimentality.productos.dto.ProductosMasBuscadosDto;
import com.experimentality.productos.entity.CaracteristicaProducto;
import com.experimentality.productos.entity.Imagen;
import com.experimentality.productos.entity.Producto;
import com.experimentality.ventas.service.PaisVentaService;

@Service
public class ProductoImpl implements ProductoService{

	@Autowired
	private ProductoDao objDao;
	
	@Autowired
	private ColorService colorService;
	
	@Autowired
	private TallaService tallaService;
	
	@Autowired
	private TipoProductoService tipoService;
	
	@Autowired
	private PaisVentaService ventaService;
	
	@Autowired
	private CaracteristicaProductoService caracteristicaService;
	
	@Autowired
	private ImagenService imagenService;

	@Override
	public Producto guardar(Producto producto) {
		return this.objDao.save(producto);
	}

	@Override
	public ProductoDto guardarProducto(ProductoDto producto) {
		Producto objProducto = new Producto();
		if(validarParaAlmacenamiento(producto)) {
			int id = 0;
			id = this.buscarProducto(producto);
			int idCaracteristica = 0;
			
			if(id == 0) {
				objProducto = this.guardar(this.prepararProducto(producto));
			}else {
				objProducto.setId(id);
				if(this.caracteristicaService.validarCaracteristicas(id, producto.getCaracteristica())) {
					return new ProductoDto();
				}
			}
			
			producto.setId(id);
			idCaracteristica = this.caracteristicaService.guardarCaracteristica(producto, objProducto.getId());
			this.imagenService.guardarImagen(producto.getImagenes(), idCaracteristica);
			this.ventaService.guardarPaisVenta(producto.getPaisVenta(), idCaracteristica);
			
			return producto;
		}
		
		return new ProductoDto();
	}
	
	@Override
	public List<Producto> listarProductos() {
		return (List<Producto>) this.objDao.findAll();
	}

	@Override
	public boolean actualizar(ProductoDto producto) {
		try {
			Producto objProducto = new Producto();
			CaracteristicaProducto objCaracteristica = new CaracteristicaProducto();
			Imagen imagen = new Imagen();
			
			int id = this.buscarProducto(producto);
			objCaracteristica = this.caracteristicaService.getCaracteristicaPorProducto(id, producto.getCaracteristica());
			imagen = this.imagenService.getImagen(objCaracteristica.getId(), producto.getImagenes().get(0).getImagen(), producto.getImagenes().get(0).getTipo());
			producto.setId(id);
			objProducto.setId(id);
			
			objProducto = this.guardar(this.prepararProducto(producto));
			this.caracteristicaService.actualizar(objCaracteristica);
			this.imagenService.actualizar(imagen);
			this.ventaService.guardarPaisVenta(producto.getPaisVenta(), objCaracteristica.getId());
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Producto getProducto(int idProducto) {
		return this.objDao.findById(idProducto).orElse(new Producto());
	}

	@Override
	public List<ProductosMasBuscadosDto> listarProductosMasBuscados() {
		return lista(this.caracteristicaService.listaProductosMasBuscados());
	}
	
	/**
	 * Función que retorna una lista de productos más buscados de acuerdo con los datos especificados para
	 * la construcción del endpoint
	 * @param productosMasBuscados
	 * @return
	 */
	private List<ProductosMasBuscadosDto> lista(List<CaracteristicaProducto> productosMasBuscados){
		List<ProductosMasBuscadosDto> buscados = new ArrayList<>();
		ProductosMasBuscadosDto obj;
		ImagenDto img;
		List<ImagenDto> imagenes;
		
		for (int i = 0; i < productosMasBuscados.size(); i++) {
			obj = new ProductosMasBuscadosDto();
			imagenes = new ArrayList<>();
			
			obj.setNombreProducto(productosMasBuscados.get(i).getProducto().getNombreProducto());
			obj.setDescripcion(productosMasBuscados.get(i).getProducto().getDescripcion());
			obj.setColor(productosMasBuscados.get(i).getColor().getNombreColor());
			obj.setTalla(productosMasBuscados.get(i).getTalla().getTalla());
			obj.setPrecio(productosMasBuscados.get(i).getPaisesVenta().get(0).getPrecio());
			obj.setPorcentajeDescuento(productosMasBuscados.get(i).getPaisesVenta().get(0).getPorcentajeDescuento());
			obj.setPrecioConDescuento(obj.getPrecio() - ((obj.getPrecio()*obj.getPorcentajeDescuento())/100));
			
			for (int j = 0; j < productosMasBuscados.get(i).getImagenes().size(); j++) {
				img = new ImagenDto();
				
				productosMasBuscados.get(i).getImagenes().get(j).getRuta();
				productosMasBuscados.get(i).getImagenes().get(j).getTipo();
				productosMasBuscados.get(i).getImagenes().get(j).getImagen();
				
				imagenes.add(img);
			}
			
			obj.setImagenes(imagenes);
			
			buscados.add(obj);
		}
		
		return buscados;
	}

	/**
	 * Función que valida si están dadas las condiciones (si los datos existen) para realizar el almacenamiento de un nuevo producto
	 * a la base de datos. 
	 * En caso de retornar true es porque se puede proseguir con el almacenamiento, de lo contrario se suspenderá
	 * el proceso de registro
	 * @param producto
	 * @return
	 */
	private boolean validarParaAlmacenamiento(ProductoDto producto) {
		
		boolean response = false;
		
		if(this.colorService.getColor(producto.getCaracteristica().getIdColor()).getNombreColor() == null ||
				this.colorService.getColor(producto.getCaracteristica().getIdColor()).getNombreColor() == "") {
			return response;
		}
		if(this.tallaService.getTalla(producto.getCaracteristica().getIdTalla()).getTalla() == null ||
				this.tallaService.getTalla(producto.getCaracteristica().getIdTalla()).getTalla() == "") {
			return response;
		}
		if(this.tipoService.getTipoProducto(producto.getCaracteristica().getIdTipoProducto()).getTipoProducto() == null ||
				this.tipoService.getTipoProducto(producto.getCaracteristica().getIdTipoProducto()).getTipoProducto() == "") {
			return response;
		}
		if(!this.ventaService.validarDescuento(producto.getPaisVenta().getIdPais(), producto.getPaisVenta().getPorcentajeDescuento())) {
			return response;
		}
		
		return !response;
	}
	
	
	/**
	 * Función que setea los valores de tipo ProductoDto a Producto
	 * @param producto
	 * @return
	 */
	private Producto prepararProducto(ProductoDto producto) {
		Producto pro = new Producto();
		
		pro.setNombreProducto(producto.getNombreProducto());
		pro.setDescripcion(producto.getDescripcion());
		pro.setGenero(producto.getGenero());
		
		return pro;
	}

	@Override
	public int buscarProducto(ProductoDto producto) {
		int id = 0;
		id = this.objDao.findProduct(producto.getNombreProducto(), producto.getDescripcion(), producto.getGenero());
		return id;
	}
	
}
