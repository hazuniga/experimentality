package com.experimentality.catalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.experimentality.catalogo.dao.TallaDao;
import com.experimentality.catalogo.entity.Talla;

@Service
public class TallaImpl implements TallaService{

	@Autowired
	private TallaDao objDao;
	
	@Override
	public Talla guardar(Talla talla) {
		if(this.objDao.findByNameTalla(talla.getTalla()) == "" || this.objDao.findByNameTalla(talla.getTalla()) == null) {
			return this.objDao.save(talla);
		}
		return new Talla();
	}

	@Override
	public List<Talla> listarTallas() {
		return (List<Talla>) this.objDao.findAll();
	}

	@Override
	public boolean actualizar(Talla talla) {
		try {
			this.objDao.save(talla);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Talla getTalla(int idTalla) {
		return this.objDao.findById(idTalla).orElse(new Talla());
	}

}
