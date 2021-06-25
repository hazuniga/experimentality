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

import com.experimentality.catalogo.entity.Talla;
import com.experimentality.catalogo.service.TallaService;

@RestController
@RequestMapping("api/Talla")
public class TallaController {
	
	@Autowired
	private TallaService tallaService;
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Talla talla) {
		Map<String, Object> response = new HashMap<>();

		Talla obj = new Talla();
		try {
			if(talla.getTalla() == "" || talla.getTalla().isEmpty()) {
				response.put("mensaje", "Registro no almacenado");
				response.put("Error", "No existen datos para almacenar" + " " + "Objeto sin datos");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NO_CONTENT);
			}
			else {
				obj = this.tallaService.guardar(talla);
				if(obj.getTalla() == null || obj.getTalla() == "") {
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

		return new ResponseEntity<Talla>(obj, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> listarTallas(){
		List<Talla> list = new ArrayList<>();
		Map<String, Object> response = new HashMap<>();
		try {
			list.addAll(this.tallaService.listarTallas());
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage()+" "+ e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);//Error 500
		}
		
		return new ResponseEntity<List<Talla>>(list, HttpStatus.OK);//correcto 200
	}
	
	@PutMapping
	public ResponseEntity<?> actualizar(@RequestBody Talla talla) {
		Map<String, Object> response = new HashMap<>();
		
		boolean option;
		try {
			option = this.tallaService.actualizar(talla);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la actualización en la base de datos");
			response.put("Error", e.getMessage()+" "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Boolean>(option,HttpStatus.OK);
	}
	
	@GetMapping("/buscarTalla/{idTalla}")
	public ResponseEntity<?> buscarTalla(@PathVariable("idTalla") int idTalla){
		Talla obj = new Talla();
		Map<String, Object> response = new HashMap<>();
		try {
			obj = this.tallaService.getTalla(idTalla);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage()+" "+ e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);//Error 500
		}
		
		return new ResponseEntity<Talla>(obj, HttpStatus.OK);//correcto 200
	}

}
