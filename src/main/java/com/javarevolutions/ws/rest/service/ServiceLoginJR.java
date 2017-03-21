package com.javarevolutions.ws.rest.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.javarevolutions.ws.rest.vo.VOCDR;
import com.javarevolutions.ws.rest.vo.VOUsuario;

import connection.bd.JavaConnection;

@Path("/javaRevolutions")
public class ServiceLoginJR {

	@POST
	@Path("/validaUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public VOUsuario validaUsuario(VOUsuario vo){
		
		vo.setUserValido(false);
		if (vo.getUsuario().equals("Java") && vo.getPassword().equals("Revolutions")) {
			vo.setUserValido(true);
		}
		
		return vo ;
	//probar servicio http://localhost:8080/RestJR/services/javaRevolutions/validaUsuario
		
		/*{
		"usuario": "andres",
		"password": "Revolutions"
			}*/
		
	}
	
	@POST
	@Path("/validaUsuario2")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<VOCDR> validaUsuario2(){
		
		JavaConnection vi = new JavaConnection();
		List<VOCDR> list=vi.conectadb();
		
		return list;
		
	//probar servicio http://localhost:8080/RestJR/services/javaRevolutions/validaUsuario2	
		
	}
}

