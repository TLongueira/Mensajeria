package com.tlongueira.mensajeria.dto;

import java.io.Serializable;


public class Notificacion implements Serializable {

	private static final long serialVersionUID = 1L;
	private String app;
	private String mensaje;
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Notificacion(String app, String mensaje) {
		super();
		this.app = app;
		this.mensaje = mensaje;
	}
	public Notificacion() {
		super();
	}
	
}
