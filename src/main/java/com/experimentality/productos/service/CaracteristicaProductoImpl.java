package com.experimentality.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.experimentality.productos.dao.CaracteristicaProductoDao;
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

}
