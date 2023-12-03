package com.empresa.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empresa.entidades.Producto;
import com.empresa.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;
	
	@Override
	public List<Producto> listaProducto(String filtro, Pageable pageable) {
		return repository.listaProducto(filtro, pageable);
	}

	@Override
	public List<Object[]> listaReporte(Date fechaDesde, Date fechaHasta) {
		return repository.listaReporte(fechaDesde, fechaHasta);
	}
	

}
