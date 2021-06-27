package com.experimentality.catalogo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		TipoProducto obj = new TipoProducto();
		obj = this.tipoService.guardar(tipoProducto);

		return new ResponseEntity<TipoProducto>(obj, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> listarTiposProducto(){
		List<TipoProducto> list = new ArrayList<>();
		list.addAll(this.tipoService.listarTiposProducto());
		
		return new ResponseEntity<List<TipoProducto>>(list, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> actualizar(@RequestBody TipoProducto tipoProducto) {
		boolean option = this.tipoService.actualizar(tipoProducto);
		
		return new ResponseEntity<Boolean>(option,HttpStatus.OK);
	}
	
	@GetMapping("/buscarTipoProducto/{idProducto}")
	public ResponseEntity<?> buscarTipoProducto(@PathVariable("idTipoProducto") int idTipoProducto){
		TipoProducto obj = new TipoProducto();
		obj = this.tipoService.getTipoProducto(idTipoProducto);
		
		return new ResponseEntity<TipoProducto>(obj, HttpStatus.OK);
	}
}
