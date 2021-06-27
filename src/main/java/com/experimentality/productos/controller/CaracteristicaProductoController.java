package com.experimentality.productos.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
		Map<String, Object> response = new HashMap<>();
		try {
			list.addAll(this.caracteristicaService.listarCarecteristicaProducto(idProducto));
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage()+" "+ e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);//Error 500
		}
		
		return new ResponseEntity<List<CaracteristicaProducto>>(list, HttpStatus.OK);//correcto 200
	}
}
