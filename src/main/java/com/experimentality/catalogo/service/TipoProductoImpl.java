package com.experimentality.catalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.experimentality.catalogo.dao.TipoProductoDao;
import com.experimentality.catalogo.entity.TipoProducto;

@Service
public class TipoProductoImpl implements TipoProductoService{

	@Autowired
	private TipoProductoDao objDao;
	
	@Override
	public TipoProducto guardar(TipoProducto tipoProducto) {
		if(tipoProducto != null) {
			return this.objDao.save(tipoProducto);
		}
		return new TipoProducto();
	}

	@Override
	public List<TipoProducto> listarTiposProducto() {
		return (List<TipoProducto>) this.objDao.findAll();
	}

	@Override
	public boolean actualizar(TipoProducto tipoProducto) {
		try {
			this.objDao.save(tipoProducto);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public TipoProducto getTipoProducto(int idTipoProducto) {
		return this.objDao.findById(idTipoProducto).orElse(new TipoProducto());
	}

}
