package com.experimentality.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.experimentality.productos.dao.ProductoDao;
import com.experimentality.productos.entity.Producto;

@Service
public class ProductoImpl implements ProductoService{

	@Autowired
	private ProductoDao objDao;

	@Override
	public Producto guardar(Producto producto) {
		return this.objDao.save(producto);
	}

	@Override
	public List<Producto> listarProductos() {
		return (List<Producto>) this.objDao.findAll();
	}

	@Override
	public boolean actualizar(Producto producto) {
		try {
			this.objDao.save(producto);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Producto getProducto(int idProducto) {
		return this.objDao.findById(idProducto).orElse(new Producto());
	}
	
	
}
