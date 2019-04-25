package com.ospe.jail;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class CivilServant extends Person implements Serializable{

	@Expose private String cargo;
	@Expose private String id_funcionario;
	@Expose private float sueldo;
	@Expose private int pavilion_func;
	@Expose private String turno;
	
	
	//Constructors
	
	public CivilServant() {
		super();
	}
	
	public CivilServant(String nombre, String apellidos, String DNI, String f_nac, String nacionalidad, String sexo,
			int altura, double peso,String cargo,String id_funcionario,float sueldo,int pavilion_func,String turno) {
		
		super(nombre, apellidos, DNI, f_nac, nacionalidad, sexo, altura, peso);
		this.cargo = cargo;
		this.id_funcionario = id_funcionario;
		this.sueldo = sueldo;
		this.pavilion_func = pavilion_func;
		this.turno = turno;
		
	}
	
	//Getters and Setters 

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(String id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public int getPavilion_func() {
		return pavilion_func;
	}

	public void setPavilion_func(int pavilion_func) {
		this.pavilion_func = pavilion_func;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	public String toString() {
		String s = "\nDNI: " + DNI + "\nNombre: " + nombre + "\nApellidos: " + apellidos
				+ "\nFecha de nacimiento (día/mes/año): " + f_nac + "\nNacionalidad: " + nacionalidad + "\nSexo (h/m): "
				+ sexo + "\nAltura (cm): " + altura + "\nPeso (kg): " + peso + "\nCargo: " + cargo
				+ "\nId_Funcionario: " + id_funcionario + "\nSueldo: " + sueldo + "\nPabellon Asignado: " + pavilion_func
				+ "\nTurno: " + turno + "\n\n";
		
		return s;
	}
	
	public String toCSV(char i) {
        String s = DNI + i + nombre + i + apellidos
                + i + f_nac + i + nacionalidad + i
                + sexo + i + altura + i + peso + i + cargo
                + i + id_funcionario + i + sueldo + i + pavilion_func
                + i + turno + "\n";
        return s;
    }
	
	
	
	
	
}
