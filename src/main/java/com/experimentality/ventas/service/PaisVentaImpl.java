package com.experimentality.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.experimentality.productos.dto.PaisVentaDto;
import com.experimentality.productos.service.CaracteristicaProductoService;
import com.experimentality.ubicacion.service.DescuentosMaximosService;
import com.experimentality.ubicacion.service.PaisService;
import com.experimentality.ventas.dao.PaisVentaDao;
import com.experimentality.ventas.entity.PaisVenta;
import com.experimentality.ventas.entity.PaisVentaPK;

@Service
public class PaisVentaImpl implements PaisVentaService{

	@Autowired
	private PaisVentaDao objDao;
	
	@Autowired
	private DescuentosMaximosService descuentosService;
	
	@Autowired
	private PaisService paisService;
	
	@Autowired
	private CaracteristicaProductoService caracteristicaService;
	
	@Override
	public List<PaisVenta> listarPaisesVentaPorProducto(int idProducto) {
		return this.objDao.findPaisesVenta(idProducto);
	}

	@Override
	public PaisVenta guardar(PaisVenta paisVenta) {
		return this.objDao.save(paisVenta);
	}

	@Override
	public boolean validarDescuento(int idPais, Double descuento) {
		Double promo = this.descuentosService.getDescuentoPais(idPais);
		if(descuento <= promo) {
			return true;
		}
		return false;
	}

	@Override
	public void guardarPaisVenta(PaisVentaDto paisVenta, int idCaracteristica) {
		PaisVenta obj = new PaisVenta();
		PaisVentaPK objId = new PaisVentaPK(); 
		
		obj.setPorcentajeDescuento(paisVenta.getPorcentajeDescuento());
		obj.setPrecio(paisVenta.getPrecio());
		objId.setIdCaracteristica(idCaracteristica);
		objId.setIdPais(paisVenta.getIdPais());
		obj.setId(objId);
		obj.setPais(this.paisService.getPais(paisVenta.getIdPais()));
		obj.setIdCaracteristica(this.caracteristicaService.getCaracteristica(idCaracteristica));
		
		this.guardar(obj);
		
	}

}
