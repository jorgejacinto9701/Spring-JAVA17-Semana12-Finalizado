package com.empresa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EnlaceController {

	//Login
	@GetMapping("/")
	public String verLogin() {	return "intranetLogin";  }
	
	@GetMapping("/verIntranetHome")
	public String verIntranetHome() {	return "intranetHome";  }

	//Registro
	@GetMapping("/verRegistroAlumno")
	public String verRegistroAlumno() {	return "intranetRegistroAlumno";	}

	@GetMapping("/verRegistroLibro")
	public String verRegistroLibro() {	return "intranetRegistroLibro";	}

	@GetMapping("/verRegistroTesis")
	public String verRegistroTesis() {	return "intranetRegistroTesis";	}

	@GetMapping("/verRegistroAutor")
	public String verRegistroAutor() {	return "intranetRegistroAutor";	}

	@GetMapping("/verRegistroSala")
	public String verRegistroSala() {	return "intranetRegistroSala";	}

	@GetMapping("/verRegistroProveedor")
	public String verRegistroProveedor() {	return "intranetRegistroProveedor";	}

	@GetMapping("/verRegistroEditorial")
	public String verRegistroEditorial() {	return "intranetRegistroEditorial";	}

	@GetMapping("/verRegistroRevista")
	public String verRegistroRevista() {	return "intranetRegistroRevista";	}	

	@GetMapping("/verRegistroEjemplo")
	public String verRegistroEjemplo() {	return "intranetRegistroEjemplo";	}
	
	//Crud
	@GetMapping("/verCrudAlumno")
	public String verCrudAlumno() {	return "intranetCrudAlumno";	}

	@GetMapping("/verCrudLibro")
	public String verCrudLibro() {	return "intranetCrudLibro";	}

	@GetMapping("/verCrudTesis")
	public String verCrudTesis() {	return "intranetCrudTesis";	}

	@GetMapping("/verCrudAutor")
	public String verCrudAutor() {	return "intranetCrudAutor";	}

	@GetMapping("/verCrudSala")
	public String verCrudSala() {	return "intranetCrudSala";	}

	@GetMapping("/verCrudProveedor")
	public String verCrudProveedor() {	return "intranetCrudProveedor";	}

	@GetMapping("/verCrudEditorial")
	public String verCrudEditorial() {	return "intranetCrudEditorial";	}

	@GetMapping("/verCrudRevista")
	public String verCrudRevista() {	return "intranetCrudRevista";	}	
	
	//Consulta
	@GetMapping("/verConsultaAlumno")
	public String verConsultaAlumno() {	return "intranetConsultaAlumno";	}

	@GetMapping("/verConsultaLibro")
	public String verConsultaLibro() {	return "intranetConsultaLibro";	}

	@GetMapping("/verConsultaTesis")
	public String verConsultaTesis() {	return "intranetConsultaTesis";	}

	@GetMapping("/verConsultaAutor")
	public String verConsultaAutor() {	return "intranetConsultaAutor";	}

	@GetMapping("/verConsultaSala")
	public String verConsultaSala() {	return "intranetConsultaSala";	}

	@GetMapping("/verConsultaProveedor")
	public String verConsultaProveedor() {	return "intranetConsultaProveedor";	}

	@GetMapping("/verConsultaEditorial")
	public String verConsultaEditorial() {	return "intranetConsultaEditorial";	}

	@GetMapping("/verConsultaRevista")
	public String verConsultaRevista() {	return "intranetConsultaRevista";	}	
	
	//Transaccion
	@GetMapping("/VerAsignacionRol")
	public String VerAsignacionRol() {	return "intranetTransaccionAsignacionRol";	}

	@GetMapping("/VerAsignacionOpcion")
	public String VerAsignacionOpcion() {	return "intranetTransaccionAsignacionOpcion";	}

	@GetMapping("/VerAsignacionLibro")
	public String VerAsignacionLibro() {	return "intranetTransaccionAsignacionLibro";	}

	@GetMapping("/verPrestamoLibro")
	public String verPrestamoLibro() {	return "intranetTransaccionPrestamoLibro";	}

	@GetMapping("/verDevolucionLibro")
	public String verDevolucionLibro() {	return "intranetTransaccionDevolucionLibro";	}

	@GetMapping("/verReservaSala")
	public String verReservaSala() {	return "intranetTransaccionReservaSala";	}

	@GetMapping("/verReporteLibro")
	public String verReporteLibro() {	return "intranetTransaccionReporteLibro";	}

	@GetMapping("/verReporteSala")
	public String verReporteSala() {	return "intranetTransaccionReporteSala";	}
	
	//Boleta
	@GetMapping("/verBoleta")
	public String verBoleta() {	return "intranetTransaccionBoleta";	}

	@GetMapping("/verAsignacionPasatiempo")
	public String verAsignacionPasatiempo() {	return "intranetAsignacionPasatiempo";	}
	
	@GetMapping("/verReporteProducto")
	public String verReporteProducto() {	return "intranetReporteProducto";	}
}
