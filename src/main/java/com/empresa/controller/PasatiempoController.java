package com.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.empresa.service.UsuarioService;

@Controller
public class PasatiempoController {

	
	@Autowired
	private UsuarioService usuarioService;

	
}
