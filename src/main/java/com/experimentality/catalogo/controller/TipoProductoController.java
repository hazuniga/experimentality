package com.experimentality.catalogo.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.experimentality.catalogo.entity.TipoProducto;
import com.experimentality.catalogo.service.TipoProductoService;

@RestController
@RequestMapping("api/TipoProducto")
public class TipoProductoController {

	@Autowired
	private TipoProductoService tipoService;
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody TipoProducto tipoProducto) {
		Map<String, Object> response = new HashMap<>();

		TipoProducto obj = new TipoProducto();
		try {
			if(tipoProducto.getTipoProducto() == "" || tipoProducto.getTipoProducto().isEmpty()) {
				response.put("mensaje", "Registro no almacenado");
				response.put("Error", "No existen datos para almacenar" + " " + "Objeto sin datos");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NO_CONTENT);
			}
			else {
				obj = this.tipoService.guardar(tipoProducto);
				if(obj.getTipoProducto() == null || obj.getTipoProducto() == "") {
					response.put("mensaje", "Registro no almacenado");
					response.put("Error", "Existe información con el registro enviado" + " " + "No se pueden realizar dos registros similares");
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
				}
			}
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la inserción en la base de datos");
			response.put("Error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<TipoProducto>(obj, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> listarTiposProducto(){
		List<TipoProducto> list = new ArrayList<>();
		Map<String, Object> response = new HashMap<>();
		try {
			list.addAll(this.tipoService.listarTiposProducto());
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage()+" "+ e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);//Error 500
		}
		
		return new ResponseEntity<List<TipoProducto>>(list, HttpStatus.OK);//correcto 200
	}
	
	@PutMapping
	public ResponseEntity<?> actualizar(@RequestBody TipoProducto tipoProducto) {
		Map<String, Object> response = new HashMap<>();
		
		boolean option;
		try {
			option = this.tipoService.actualizar(tipoProducto);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la actualización en la base de datos");
			response.put("Error", e.getMessage()+" "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Boolean>(option,HttpStatus.OK);
	}
	
	@GetMapping("/buscarTipoProducto/{idProducto}")
	public ResponseEntity<?> buscarTipoProducto(@PathVariable("idTipoProducto") int idTipoProducto){
		TipoProducto obj = new TipoProducto();
		Map<String, Object> response = new HashMap<>();
		try {
			obj = this.tipoService.getTipoProducto(idTipoProducto);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage()+" "+ e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);//Error 500
		}
		
		return new ResponseEntity<TipoProducto>(obj, HttpStatus.OK);//correcto 200
	}
}
