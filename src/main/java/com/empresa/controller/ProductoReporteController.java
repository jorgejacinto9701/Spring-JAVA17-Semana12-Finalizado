package com.empresa.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entidades.ProductoResponse;
import com.empresa.service.ProductoService;

@Controller
public class ProductoReporteController {

	@Autowired
	private ProductoService productoService;

	@ResponseBody
	@GetMapping("/listaReporteProducto")
	public List<ProductoResponse> listaPasatiempo(@DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDesde, 
											 	 @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaHasta){
		
		ArrayList<ProductoResponse> lstSalida = new ArrayList<ProductoResponse>();
		List<Object[]> lstProducto = productoService.listaReporte(fechaDesde, fechaHasta);
		for (Object[] array : lstProducto) {
			ProductoResponse objReporteProducto = new ProductoResponse();
			objReporteProducto.setIdProducto( (Integer)(array[0]));
			objReporteProducto.setNombre( (String)array[1] );
			objReporteProducto.setPrecio( (Double)array[2] );
			objReporteProducto.setCantidad( ((BigDecimal)(array[3])).intValue());
			objReporteProducto.setMonto( (Double)array[4] );
			lstSalida.add(objReporteProducto);
		}
		
		return lstSalida;
	}
}
