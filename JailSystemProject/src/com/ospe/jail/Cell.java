package com.ospe.jail;

public class Cell {

	
	protected int cap_actual;
	protected int cap_maxima;
	protected boolean llena;
	protected boolean estado_puerta;
	protected String numero_celda;
	protected int nivel_seguridad;
	protected String tipo_celda;
	protected int piso;
	
	
	//Constructors
	
	public Cell() {
		
	}
	
	public Cell(int cap_actual,int cap_maxima,boolean llena,boolean estado_puerta,
			String numero_celda, int nivel_seguridad,String tipo_celda,int piso) {
		
		this.cap_actual = cap_actual;
		this.cap_maxima = cap_maxima;
		this.llena = llena;
		this.estado_puerta = estado_puerta;
		this.numero_celda = numero_celda;
		this.nivel_seguridad = nivel_seguridad;
		this.tipo_celda = tipo_celda;
		this.piso = piso;
		
	}
	
	//Getters and Setters

	public int getCap_actual() {
		return cap_actual;
	}

	public void setCap_actual(int cap_actual) {
		this.cap_actual = cap_actual;
	}

	public int getCap_maxima() {
		return cap_maxima;
	}

	public void setCap_maxima(int cap_maxima) {
		this.cap_maxima = cap_maxima;
	}

	public boolean isLlena() {
		return llena;
	}

	public void setLlena(boolean llena) {
		this.llena = llena;
	}

	public boolean isEstado_puerta() {
		return estado_puerta;
	}

	public void setEstado_puerta(boolean estado_puerta) {
		this.estado_puerta = estado_puerta;
	}

	public String getNumero_celda() {
		return numero_celda;
	}

	public void setNumero_celda(String numero_celda) {
		this.numero_celda = numero_celda;
	}

	public int getNivel_seguridad() {
		return nivel_seguridad;
	}

	public void setNivel_seguridad(int nivel_seguridad) {
		this.nivel_seguridad = nivel_seguridad;
	}

	public String getTipo_celda() {
		return tipo_celda;
	}

	public void setTipo_celda(String tipo_celda) {
		this.tipo_celda = tipo_celda;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}
	
	
	
	
	
	
}
