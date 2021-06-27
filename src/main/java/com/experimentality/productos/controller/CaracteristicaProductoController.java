package com.experimentality.productos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.experimentality.productos.entity.CaracteristicaProducto;
import com.experimentality.productos.service.CaracteristicaProductoService;

@RestController
@RequestMapping("api/Caracteristica")
public class CaracteristicaProductoController {

	@Autowired
	private CaracteristicaProductoService caracteristicaService;
	
	@GetMapping("/buscarCaracteristicaProducto/{idProducto}")
	public ResponseEntity<?> listarCaracteristicasProductos(@PathVariable("idProducto") int idProducto){
		List<CaracteristicaProducto> list = new ArrayList<>();
		list.addAll(this.caracteristicaService.listarCarecteristicaProducto(idProducto));
		
		
		return new ResponseEntity<List<CaracteristicaProducto>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/listarProductosMasBuscados")
	public ResponseEntity<?> listarProductosMasBuscados(){
		List<CaracteristicaProducto> list = new ArrayList<>();
		list.addAll(this.caracteristicaService.listaProductosMasBuscados());
		
		
		return new ResponseEntity<List<CaracteristicaProducto>>(list, HttpStatus.OK);
	}
}
