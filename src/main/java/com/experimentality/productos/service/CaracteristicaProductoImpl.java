package com.experimentality.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.experimentality.productos.dao.CaracteristicaProductoDao;
import com.experimentality.productos.dto.CaracteristicaDto;
import com.experimentality.productos.dto.ProductoDto;
import com.experimentality.productos.entity.CaracteristicaProducto;

@Service
public class CaracteristicaProductoImpl implements CaracteristicaProductoService{

	@Autowired
	private CaracteristicaProductoDao objDao;
	
	@Override
	public CaracteristicaProducto guardar(CaracteristicaProducto caracteristica) {
		return this.objDao.save(caracteristica);
	}

	@Override
	public List<CaracteristicaProducto> listarCarecteristicaProducto(int idProducto) {
		return (List<CaracteristicaProducto>) this.objDao.findAll();
	}

	@Override
	public boolean actualizar(CaracteristicaProducto caracteristica) {
		try {
			this.objDao.save(caracteristica);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public CaracteristicaProducto getCaracteristica(int idCaracteristica) {
		return this.objDao.findById(idCaracteristica).orElse(new CaracteristicaProducto());
	}

	@Override
	public List<CaracteristicaProducto> listaProductosMasBuscados() {
		return this.objDao.productosMasBuscados();
	}

	@Override
	public int guardarCaracteristica(ProductoDto producto, int idProducto) {
		CaracteristicaProducto caracteristica = new CaracteristicaProducto();
		
		caracteristica.setIdProducto(idProducto);
		caracteristica.setIdColor(producto.getCaracteristica().getIdColor());
		caracteristica.setIdTalla(producto.getCaracteristica().getIdTalla());
		caracteristica.setIdTipoProducto(producto.getCaracteristica().getIdTipoProducto());
		
		caracteristica = this.guardar(caracteristica);
		
		return caracteristica.getId();
	}

	@Override
	public CaracteristicaProducto getCaracteristicaPorProducto(int idProducto, CaracteristicaDto caracteristica) {
		return this.objDao.findByCaracteristicas(idProducto, caracteristica.getIdTalla(), caracteristica.getIdColor(), caracteristica.getIdTipoProducto());
	}

	@Override
	public boolean validarCaracteristicas(int idProducto, CaracteristicaDto caracteristica) {
		CaracteristicaProducto obj = new CaracteristicaProducto();
		obj = this.objDao.findByCaracteristicas(idProducto, caracteristica.getIdTalla(), caracteristica.getIdColor(), caracteristica.getIdTipoProducto());
		if(obj.getIdColor() == null) {
			return false;
		}
		return true;
	}

}
