package com.experimentality.ubicacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.experimentality.ubicacion.dao.PaisDao;
import com.experimentality.ubicacion.entity.Pais;

@Service
public class PaisImpl implements PaisService{

	@Autowired
	private PaisDao objDao;
	
	@Override
	public Pais getPais(int idPais) {
		return this.objDao.findById(idPais).orElse(new Pais());
	}

}
