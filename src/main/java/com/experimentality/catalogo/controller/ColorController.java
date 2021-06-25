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

import com.experimentality.catalogo.entity.Color;
import com.experimentality.catalogo.service.ColorService;

@RestController
@RequestMapping("/api/Color")
public class ColorController {
	
	@Autowired
	private ColorService colorService;

	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Color color) {
		Map<String, Object> response = new HashMap<>();

		Color obj = new Color();
		try {
			if(color.getNombreColor() == "") {
				response.put("mensaje", "No existen datos para almacenar");
				response.put("Error", "El objeto se encuentra vacío" + " " + "Objeto sin datos");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NO_CONTENT);
			}
			else {
				obj = this.colorService.guardar(color);
			}
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la inserción en la base de datos");
			response.put("Error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Color>(obj, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> listarColores(){
		List<Color> list = new ArrayList<>();
		Map<String, Object> response = new HashMap<>();
		try {
			list.addAll(this.colorService.listarColores());
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage()+" "+ e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);//Error 500
		}
		
		return new ResponseEntity<List<Color>>(list, HttpStatus.OK);//correcto 200
	}
	
	@PutMapping
	public ResponseEntity<?> actualizar(@RequestBody Color color) {
		Map<String, Object> response = new HashMap<>();
		
		boolean option;
		try {
			option = this.colorService.actualizar(color);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la actualización en la base de datos");
			response.put("Error", e.getMessage()+" "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Boolean>(option,HttpStatus.OK);
	}
	
	@GetMapping("/buscarColor/{idColor}")
	public ResponseEntity<?> buscarPersona(@PathVariable("idColor") int idColor){
		Color obj = new Color();
		Map<String, Object> response = new HashMap<>();
		try {
			obj = this.colorService.getColor(idColor);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage()+" "+ e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);//Error 500
		}
		
		return new ResponseEntity<Color>(obj, HttpStatus.OK);//correcto 200
	}
}
