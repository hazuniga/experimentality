package com.experimentality.productos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.experimentality.productos.entity.CaracteristicaProducto;

public interface CaracteristicaProductoDao extends CrudRepository<CaracteristicaProducto, Integer>{

	@Query(value = "select	cp.*,\r\n" + 
			"		p.*,\r\n" + 
			"		pv.*,\r\n" + 
			"		c.*,\r\n" + 
			"		tp.*,\r\n" + 
			"		t.*,\r\n" + 
			"		i.*\r\n" + 
			"from	productos_buscados pb\r\n" + 
			"		inner join caracteristicas_productos cp\r\n" + 
			"				on cp.id_caracteristica = pb.id_caracteristica\r\n" + 
			"				inner join productos p\r\n" + 
			"						on p.id_producto = cp.id_producto\r\n" + 
			"						inner join pais_venta pv\r\n" + 
			"								on p.id_producto = pv.id_producto\r\n" + 
			"				inner join colores c\r\n" + 
			"						on c.id_color = cp.id_color\r\n" + 
			"				inner join tipo_productos tp\r\n" + 
			"						on tp.id_tipo_producto = cp.id_tipo_producto\r\n" + 
			"				inner join tallas t\r\n" + 
			"						on t.id_talla = cp.id_talla\r\n" + 
			"				inner join imagenes i\r\n" + 
			"						on i.id_caracteristica = cp.id_caracteristica\r\n" + 
			"group by 	pb.id_caracteristica,\r\n" + 
			"			cp.id_caracteristica,\r\n" + 
			"			p.id_producto,\r\n" + 
			"			pv.id_pais,\r\n" + 
			"			pv.id_producto,\r\n" + 
			"			c.id_color,\r\n" + 
			"			tp.id_tipo_producto,\r\n" + 
			"			t.id_talla,\r\n" + 
			"			i.id_imagen", nativeQuery = true)
	public List<CaracteristicaProducto> productosMasBuscados();
}
