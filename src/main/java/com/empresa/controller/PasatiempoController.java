package com.empresa.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entidades.Pasatiempo;
import com.empresa.entidades.Usuario;
import com.empresa.entidades.UsuarioHasPasatiempo;
import com.empresa.entidades.UsuarioHasPasatiempoPK;
import com.empresa.service.PasatiempoService;
import com.empresa.service.UsuarioService;

@Controller
public class PasatiempoController {

	@Autowired 
	private UsuarioService usuarioService;
	
	@Autowired 
	private PasatiempoService pasatiempoService;
	
	@ResponseBody()
	@GetMapping("/listaPasatiempo")
	public List<Pasatiempo> lista(){
		return pasatiempoService.listaPasatiempo(); 
	}
	
	@ResponseBody()
	@GetMapping("/listaUsuario")
	public List<Usuario> listaUsuario(){
		return usuarioService.listaUsuario(); 
	}
	
	@ResponseBody()
	@GetMapping("/listaPasatiempoPorUsuario")
	public List<Pasatiempo> listaPasatiempoUsuario(int idUsuario){
		return usuarioService.traerPasatiempoDeUsuario(idUsuario);
	}
	
	@ResponseBody()
	@PostMapping("/registraPasatiempo")
	public HashMap<String, Object> registro(int idUsuario, int idPasatiempo){
		HashMap<String, Object> maps = new HashMap<>();
		
		UsuarioHasPasatiempoPK pk = new UsuarioHasPasatiempoPK();
		pk.setIdPasatiempo(idPasatiempo);
		pk.setIdUsuario(idUsuario);
		
		UsuarioHasPasatiempo usp = new UsuarioHasPasatiempo();
		usp.setUsuarioHasPasatiempoPK(pk);
		
		if (usuarioService.buscaPasatiempo(pk).isPresent()) {
			maps.put("mensaje", "El pasatiempo ya existe");
		}else {
			UsuarioHasPasatiempo objUsp = usuarioService.insertaPasatiempo(usp);
			if (objUsp == null) {
				maps.put("mensaje", "Error en el registro");
			}else {
				maps.put("mensaje", "Registro existoso");
			}
		}
		
		List<Pasatiempo> lstSalida = usuarioService.traerPasatiempoDeUsuario(idUsuario);
		maps.put("lista", lstSalida);
		maps.put("usuario", idUsuario);
		return maps;
	}
	
	
	@ResponseBody()
	@PostMapping("/eliminaPasatiempo")
	public HashMap<String, Object> elimina(int idUsuario, int idPasatiempo){
		HashMap<String, Object> maps = new HashMap<>();
		
		UsuarioHasPasatiempoPK pk = new UsuarioHasPasatiempoPK();
		pk.setIdPasatiempo(idPasatiempo);
		pk.setIdUsuario(idUsuario);
		
		UsuarioHasPasatiempo usp = new UsuarioHasPasatiempo();
		usp.setUsuarioHasPasatiempoPK(pk);
		
		if (usuarioService.buscaPasatiempo(pk).isPresent()) {
			usuarioService.eliminaPasatiempo(usp);
			maps.put("mensaje", "Se eliminó el pasatiempo");
		}else {
			maps.put("mensaje", "No existe pasatiempo");
		}
		
		List<Pasatiempo> lstSalida = usuarioService.traerPasatiempoDeUsuario(idUsuario);
		maps.put("lista", lstSalida);
		maps.put("usuario", idUsuario);
		return maps;
	}
}

