package com.empresa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entidades.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	@Query("select x from Producto x where x.nombre like ?1")
	public abstract List<Producto> listaProducto(String filtro, Pageable pageable);

	@Modifying
	@Query("update Producto x set x.stock = x.stock - ?2 where x.idProducto = ?1 ")
	public abstract void actualizaStock(int idProducto, int cantidad);
	
	
	@Query(value = "SELECT bshp.idProducto as idProducto, p.nombre as nombre,sum(cantidad) as cantidad "
			+ "FROM boleta_has_producto bshp "
			+ "inner join boleta b on b.idBoleta = bshp.idBoleta "
			+ "inner join producto p on bshp.idProducto = p.idProducto "
			+ "where b.fecha >= ?1 and b.fecha<= ?2 "
			+ "group by bshp.idProducto,p.nombre "
			+ "order by cantidad desc" , nativeQuery = true)
	public abstract List<Object[]> listaReporte(Date fechaDesde, Date fechaHasta); 
}
