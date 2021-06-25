package com.experimentality.productos.dao;

import org.springframework.data.repository.CrudRepository;

import com.experimentality.productos.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Integer>{

}
