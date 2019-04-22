package com.ospe.jail;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gson.annotations.Expose;

public class Cell implements Serializable {

	@Expose
	private int cap_actual;
	@Expose
	private String tipo_celda;
	@Expose
	private boolean llena;
	@Expose
	private boolean estado_puerta;
	@Expose
	private int num_celda;
	@Expose
	private int nivel_seguridad;
	@Expose
	private int piso;
	private Pavilion pabellon;
	@Expose
	private ArrayList<Prisoner> presos = new ArrayList<Prisoner>();
	// Constructors

	public Cell() {

	}

	public Cell(String tipo_celda, boolean estado_puerta, int num_celda, int nivel_seguridad, int piso,
			Pavilion pabellon, ArrayList<Prisoner> presos) {
		this.tipo_celda = tipo_celda;
		this.estado_puerta = estado_puerta;
		this.num_celda = num_celda;
		this.nivel_seguridad = nivel_seguridad;
		this.piso = piso;
		this.pabellon = pabellon;
		this.presos = presos;
		setCap_actual();
		setLlena();
	}

	// Getters and Setters
	public int getCap_actual() {
		return cap_actual;
	}

	public void setCap_actual() {
		this.cap_actual = presos.size();
	}

	public String getTipo_celda() {
		return tipo_celda;
	}

	public void setTipo_celda(String tipo_celda) {
		this.tipo_celda = tipo_celda;
	}

	public boolean isLlena() {
		return llena;
	}

	public void setLlena() {
		int c = 0;
		if (tipo_celda.equals("Individual")) {
			c = 1;
		} else if (tipo_celda.equals("Doble")) {
			c = 2;
		}
		if (cap_actual == c) {
			llena = true;
		} else {
			llena = false;
		}
	}

	public boolean isEstado_puerta() {
		return estado_puerta;
	}

	public void setEstado_puerta(boolean estado_puerta) {
		this.estado_puerta = estado_puerta;
	}

	public int getNum_celda() {
		return num_celda;
	}

	public void setNum_celda(int num_celda) {
		this.num_celda = num_celda;
	}

	public int getNivel_seguridad() {
		return nivel_seguridad;
	}

	public void setNivel_seguridad(int nivel_seguridad) {
		this.nivel_seguridad = nivel_seguridad;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public Pavilion getPabellon() {
		return pabellon;
	}

	public void setPabellon(Pavilion pabellon) {
		this.pabellon = pabellon;
	}

	public ArrayList<Prisoner> getPresos() {
		return presos;
	}

	public void setPresos(ArrayList<Prisoner> presos) {
		this.presos = presos;
	}

	@Override
	public String toString() {
		String s = "\nCapacidad actual: " + cap_actual + "\nTipo de celda: " + tipo_celda + "\n¿Está llena? ";
		if (llena) {
			s = s + "sí";
		} else {
			s = s + "no";
		}
		s = s + "\nEstado de la puerta: ";
		if (estado_puerta) {
			s = s + "abierta";
		} else {
			s = s + "cerrada";
		}

		s = s + "\nNumero de celda: " + num_celda + "\nNivel de seguridad: " + nivel_seguridad + "\nPiso: " + piso
				+ "\nNumero de pabellon: " + pabellon.getNum_pabellon() + "\nPresos contenidos: \n";
		for (Prisoner p : presos) {
			s = s + p.getNum_preso() + ", " + p.getNombre() + " " + p.getApellidos() + "\n";
		}
		s = s + "\n";
		return s;
	}

	public String toCSV(char i) {
		String s = "" + cap_actual + i + tipo_celda + i;
		if (llena) {
			s = s + "sí";
		} else {
			s = s + "no";
		}
		s = s + i;
		if (estado_puerta) {
			s = s + "abierta";
		} else {
			s = s + "cerrada";
		}

		s = s + i + num_celda + i + nivel_seguridad + i + piso + i + pabellon.getNum_pabellon() + i;
		for (Prisoner p : presos) {
			s = s + p.getNum_preso() + ",";
		}
		s = s + "\n";
		return s;
	}
}
