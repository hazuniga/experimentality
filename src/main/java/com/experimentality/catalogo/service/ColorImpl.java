package com.experimentality.catalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.experimentality.catalogo.dao.ColorDao;
import com.experimentality.catalogo.entity.Color;

@Service
public class ColorImpl implements ColorService{

	@Autowired
	private ColorDao objDao;
	
	@Override
	public Color guardar(Color color) {
		if(color != null) {
			return this.objDao.save(color); 
		}
		return new Color();
	}

	@Override
	public List<Color> listarColores() {
		return (List<Color>) this.objDao.findAll();
	}

	@Override
	public boolean actualizar(Color color) {
		try {
			this.objDao.save(color);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Color getColor(int idColor) {
		return this.objDao.findById(idColor).orElse(new Color());
	}

}
