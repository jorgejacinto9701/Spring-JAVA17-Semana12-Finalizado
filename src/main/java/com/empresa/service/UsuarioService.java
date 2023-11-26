package com.empresa.service;

import java.util.List;

import com.empresa.entidades.Opcion;
import com.empresa.entidades.Rol;
import com.empresa.entidades.Usuario;

public interface UsuarioService {

	public abstract Usuario login(Usuario bean);
	public abstract List<Opcion> traerEnlacesDeUsuario(int idUsuario);
	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);
	public abstract Usuario buscaPorLogin(String login);
	
}




