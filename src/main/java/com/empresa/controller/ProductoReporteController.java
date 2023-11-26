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

import com.empresa.entidades.ReporteProducto;
import com.empresa.service.ProductoService;

@Controller
public class ProductoReporteController {


	@Autowired
	private ProductoService productoService;
	
	@ResponseBody
	@GetMapping("/listaReporteProducto")
	public List<ReporteProducto> listaPasatiempo(@DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDesde, 
											 	 @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaHasta){
		
		List<ReporteProducto> lsrReporte = new ArrayList<ReporteProducto>();
		List<Object> lstproducto =  productoService.listaReporteProducto(fechaDesde, fechaHasta);
		for (Object object : lstproducto) {
			Object[] array =  (Object[])object;
			
			ReporteProducto objReporteProducto = new ReporteProducto();
			objReporteProducto.setIdProducto( ((Integer)(array[0])).intValue());
			objReporteProducto.setNombre( (String)(array[1]));
			objReporteProducto.setCantidad( ((BigDecimal)(array[2])).intValue());
			lsrReporte.add(objReporteProducto);
		}
		return lsrReporte;
	}
}
