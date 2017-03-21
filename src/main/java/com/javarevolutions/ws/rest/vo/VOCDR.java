package com.javarevolutions.ws.rest.vo;

import java.io.Serializable;

public class VOCDR implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String server;
	private String numero;
	private String duracion;
	private String ring;
	
	public VOCDR() {
		// TODO Auto-generated constructor stub
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getRing() {
		return ring;
	}
	public void setRing(String ring) {
		this.ring = ring;
	}
	

	
}
