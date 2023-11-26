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
	
	
	@Query(value =  " select p.idProducto as 'idProducto', p.nombre as 'nombre', sum(bsp.cantidad) as 'cantidad'  "
			+ "from boleta_has_producto bsp  "
			+ "inner join producto p on bsp.idProducto = p.idProducto "
			+ "inner join boleta b on b.idBoleta = bsp.idBoleta "
			+ "where b.fecha >=  ?1 and b.fecha <= ?2 "
			+ "group by p.idProducto, p.nombre "
			+ "order by 3 desc " , nativeQuery = true)
	
	public abstract List<Object> listaReporteProducto(Date fechaDesde, Date fechaHasta);
	
	
}
