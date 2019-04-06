package com.ospe.jail;

import java.io.Serializable;

public class Visitor extends Person implements Serializable {

	private String id_visitor;
	private int preso_visitado;
	private String fecha_visita;
	private String hora_visita;
	private String relacion_preso;
	private int numero_visitantes;
	private String solicitante_visita;
	
	
	
	//Constructors
	
	public Visitor() {
		super();
	}
	
	
	public Visitor(String nombre, String apellidos, String DNI, String f_nac, String nacionalidad, String sexo,
			int altura, double peso, String id_visitor, int preso_visitado,String fecha_visita,String hora_visita,String relacion_preso,
			int numero_visitantes,String solicitante_visita) {
		
		super(nombre, apellidos, DNI, f_nac, nacionalidad, sexo, altura, peso);
		this.id_visitor = id_visitor;
		this.preso_visitado = preso_visitado;
		this.fecha_visita = fecha_visita;
		this.hora_visita = hora_visita;
		this.relacion_preso = relacion_preso;
		this.numero_visitantes = numero_visitantes;
		this.solicitante_visita = solicitante_visita;
		
		
		
	}

	//Getters and Setters

	public String getId_visitor() {
		return id_visitor;
	}


	public void setId_visitor(String id_visitor) {
		this.id_visitor = id_visitor;
	}
	
	public int getPreso_visitado() {
		return preso_visitado;
	}


	public void setPreso_visitado(int preso_visitado) {
		this.preso_visitado = preso_visitado;
	}


	public String getFecha_visita() {
		return fecha_visita;
	}


	public void setFecha_visita(String fecha_visita) {
		this.fecha_visita = fecha_visita;
	}


	public String getHora_visita() {
		return hora_visita;
	}


	public void setHora_visita(String hora_visita) {
		this.hora_visita = hora_visita;
	}


	public String getRelacion_preso() {
		return relacion_preso;
	}


	public void setRelacion_preso(String relacion_preso) {
		this.relacion_preso = relacion_preso;
	}


	public int getNumero_visitantes() {
		return numero_visitantes;
	}


	public void setNumero_visitantes(int numero_visitantes) {
		this.numero_visitantes = numero_visitantes;
	}


	public String getSolicitante_visita() {
		return solicitante_visita;
	}


	public void setSolicitante_visita(String solicitante_visita) {
		this.solicitante_visita = solicitante_visita;
	}
	
	


	public String toString() {
		String s = "\nDNI: " + DNI + "\nNombre: " + nombre + "\nApellidos: " + apellidos
				+ "\nFecha de nacimiento (día/mes/año): " + f_nac + "\nNacionalidad: " + nacionalidad + "\nSexo (h/m): "
				+ sexo + "\nAltura (cm): " + altura + "\nPeso (kg): " + peso + "\nId del visitante: " + id_visitor + "\nPreso visitado: " 
				+  preso_visitado + "\nFecha de visita: " + fecha_visita + "\nHora de visita: " + hora_visita + "\nRelacion con el preso: " + relacion_preso
				+ "\nNumero de visitantes: " + numero_visitantes + "\nSolicitante de la visita: " + solicitante_visita;
		
		return s;
	}
	
	public String toCSV(char i) {
        String s = DNI + i + nombre + i + apellidos
                + i + f_nac + i + nacionalidad + i
                + sexo + i + altura + i + peso + i + id_visitor + i + preso_visitado
                + i + fecha_visita + i + hora_visita + i + relacion_preso
                + i + numero_visitantes + i + solicitante_visita;
        return s;
    }
	
	
}
