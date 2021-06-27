package com.experimentality.catalogo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
	public ResponseEntity<?> guardar(@Validated @RequestBody Color color) {
		Color obj = new Color();
		obj = this.colorService.guardar(color);

		return new ResponseEntity<Color>(obj, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> listarColores(){
		List<Color> list = new ArrayList<>();
		list.addAll(this.colorService.listarColores());
		
		return new ResponseEntity<List<Color>>(list, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> actualizar(@RequestBody Color color) {
		boolean option;
		option = this.colorService.actualizar(color);
		
		return new ResponseEntity<Boolean>(option,HttpStatus.OK);
	}
	
	@GetMapping("/buscarColor/{idColor}")
	public ResponseEntity<?> buscarColor(@PathVariable("idColor") int idColor){
		Color obj = new Color();
		obj = this.colorService.getColor(idColor);
		
		return new ResponseEntity<Color>(obj, HttpStatus.OK);
	}
}
