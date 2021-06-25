package com.experimentality.ventas.dao;

import org.springframework.data.repository.CrudRepository;

import com.experimentality.ventas.entity.PaisVenta;
import com.experimentality.ventas.entity.PaisVentaPK;

public interface PaisVentaDao extends CrudRepository<PaisVenta, PaisVentaPK>{

}
