package com.experimentality.productos.controller;

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

import com.experimentality.productos.entity.Producto;
import com.experimentality.productos.service.ProductoService;

@RestController
@RequestMapping("api/Producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@PostMapping
	public ResponseEntity<?> guardar(@Validated @RequestBody Producto producto) {
		Producto obj = new Producto();
		obj = this.productoService.guardar(producto);
		
		return new ResponseEntity<Producto>(obj, HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<?> listarProductos(){
		List<Producto> list = new ArrayList<>();
		list.addAll(this.productoService.listarProductos());
		
		return new ResponseEntity<List<Producto>>(list, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> actualizar(@RequestBody Producto producto) {
		boolean option = this.productoService.actualizar(producto);
		
		return new ResponseEntity<Boolean>(option,HttpStatus.OK);
	}
	
	@GetMapping("/buscarProducto/{idProducto}")
	public ResponseEntity<?> buscarProduto(@PathVariable("idProducto") int idProducto){
		Producto obj = new Producto();
		obj = this.productoService.getProducto(idProducto);
		
		return new ResponseEntity<Producto>(obj, HttpStatus.OK);
	}
}
