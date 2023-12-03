package com.empresa.entidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoResponse {

	private int idProducto;
	private String nombre;
	private double precio;
	private int cantidad;
	private double monto;
	
}
