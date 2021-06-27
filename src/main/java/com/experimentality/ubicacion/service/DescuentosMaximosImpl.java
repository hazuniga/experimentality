package com.experimentality.ubicacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.experimentality.ubicacion.dao.DescuentosMaximosDao;

@Service
public class DescuentosMaximosImpl implements DescuentosMaximosService{

	@Autowired
	private DescuentosMaximosDao objDao;
	
	@Override
	public Double getDescuentoPais(int idPais) {
		return this.objDao.getDescuentoPais(idPais);
	}

}
