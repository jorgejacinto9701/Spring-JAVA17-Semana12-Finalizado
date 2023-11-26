package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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
	
	@ResponseBody
	@GetMapping("/listaUsuario")
	public List<Usuario> listaUsuario(){
		return usuarioService.listaUsuario();
	}
	
	@ResponseBody
	@GetMapping("/listaPasatiempo")
	public List<Pasatiempo> listaPasatiempo(){
		return  pasatiempoService.listaPasatiempo();
	}
	
	
	@ResponseBody
	@GetMapping("/listaPasatiempoPorUsuario")
	public List<Pasatiempo> listaPasatiempoPorUsuario(int idUsuario){
		return  usuarioService.traerPasatiempoDeUsuario(idUsuario);
	}
	
	@ResponseBody
	@PostMapping("/registraPasatiempo")
	public HashMap<String, Object> registro(int idUsuario, int idPasatiempo){
		HashMap<String, Object> maps = new HashMap<String, Object>();
		UsuarioHasPasatiempoPK pk = new UsuarioHasPasatiempoPK();
		pk.setIdPasatiempo(idPasatiempo);
		pk.setIdUsuario(idUsuario);

		UsuarioHasPasatiempo obj = new UsuarioHasPasatiempo();
		obj.setUsuarioHasPasatiempoPK(pk);
		
		Optional<UsuarioHasPasatiempo> existentPasatiempo = usuarioService.buscaPasatiempo(pk);
        if (existentPasatiempo.isEmpty()) {
        	UsuarioHasPasatiempo objSalida = usuarioService.insertaPasatiempo(obj);
        	if (objSalida == null) {
        		maps.put("mensaje", "Error en el registro");		
        	}else {
        		maps.put("mensaje", "Registro exitoso");
        	}
        }else {
        	maps.put("mensaje", "Ya existe el pasatiempo");
        }
        List<Pasatiempo> lstPasatiempo =  usuarioService.traerPasatiempoDeUsuario(idUsuario);
        maps.put("lista", lstPasatiempo);
        maps.put("usuario", idUsuario);
		return maps;
	}
	
	@ResponseBody
	@PostMapping("/eliminaPasatiempo")
	public HashMap<String, Object> elimina(int idUsuario, int idPasatiempo){
		HashMap<String, Object> maps = new HashMap<String, Object>();
		
		UsuarioHasPasatiempoPK pk = new UsuarioHasPasatiempoPK();
		pk.setIdPasatiempo(idPasatiempo);
		pk.setIdUsuario(idUsuario);

		UsuarioHasPasatiempo obj = new UsuarioHasPasatiempo();
		obj.setUsuarioHasPasatiempoPK(pk);
		
		usuarioService.eliminaPasatiempo(obj);
		maps.put("mensaje", "Eliminación exitosa");
		
		List<Pasatiempo> lstPasatiempo =  usuarioService.traerPasatiempoDeUsuario(idUsuario);
        maps.put("lista", lstPasatiempo);
        maps.put("usuario", idUsuario);
		
		return maps;
	}
}



