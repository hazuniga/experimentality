package com.experimentality.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.experimentality.productos.dao.ImagenDao;
import com.experimentality.productos.entity.Imagen;

@Service
public class ImagenImpl implements ImagenService{

	@Autowired
	private ImagenDao objDao;
	
	@Override
	public Imagen guardar(Imagen imagen) {
		return this.objDao.save(imagen);
	}

	@Override
	public List<Imagen> listarImagenes() {
		return (List<Imagen>) this.objDao.findAll();
	}

	@Override
	public List<Imagen> listarImagenes(int idProducto) {
		return this.objDao.getImagenesByProducto(idProducto);
	}

	@Override
	public boolean actualizar(Imagen imagen) {
		try {
			this.objDao.save(imagen);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Imagen getImagen(int idImagen) {
		return this.objDao.findById(idImagen).orElse(new Imagen());
	}

}
