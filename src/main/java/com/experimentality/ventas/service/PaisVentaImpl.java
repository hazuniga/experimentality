package com.experimentality.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.experimentality.ubicacion.service.DescuentosMaximosService;
import com.experimentality.ventas.dao.PaisVentaDao;
import com.experimentality.ventas.entity.PaisVenta;

@Service
public class PaisVentaImpl implements PaisVentaService{

	@Autowired
	private PaisVentaDao objDao;
	
	@Autowired
	private DescuentosMaximosService descuentosService;
	
	@Override
	public List<PaisVenta> listarPaisesVentaPorProducto(int idProducto) {
		return this.objDao.findPaisesVenta(idProducto);
	}

	@Override
	public boolean guardar(PaisVenta paisVenta) {
		Double descuento = this.descuentosService.getDescuentoPais(paisVenta.getId().getIdPais());
		if(descuento <= paisVenta.getPorcentajeDescuento()) {
			try {
				this.objDao.save(paisVenta);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}

}
