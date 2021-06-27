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

import com.experimentality.catalogo.entity.Talla;
import com.experimentality.catalogo.service.TallaService;

@RestController
@RequestMapping("api/Talla")
public class TallaController {
	
	@Autowired
	private TallaService tallaService;
	
	@PostMapping
	public ResponseEntity<?> guardar(@Validated @RequestBody Talla talla) {
		Talla obj = new Talla();
		obj = this.tallaService.guardar(talla);

		return new ResponseEntity<Talla>(obj, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> listarTallas(){
		List<Talla> list = new ArrayList<>();
		list.addAll(this.tallaService.listarTallas());
		
		return new ResponseEntity<List<Talla>>(list, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> actualizar(@RequestBody Talla talla) {
		boolean option;
		option = this.tallaService.actualizar(talla);
		
		return new ResponseEntity<Boolean>(option,HttpStatus.OK);
	}
	
	@GetMapping("/buscarTalla/{idTalla}")
	public ResponseEntity<?> buscarTalla(@PathVariable("idTalla") int idTalla){
		Talla obj = new Talla();
		obj = this.tallaService.getTalla(idTalla);
		
		return new ResponseEntity<Talla>(obj, HttpStatus.OK);
	}

}
