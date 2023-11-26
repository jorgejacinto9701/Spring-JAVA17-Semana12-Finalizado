package com.empresa.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.empresa.entidades.Producto;

public interface ProductoService {

	public abstract List<Producto> listaProducto(String filtro, Pageable pageable);
	public abstract List<Object> listaReporteProducto(Date fechaDesde, Date fechaHasta);
}
