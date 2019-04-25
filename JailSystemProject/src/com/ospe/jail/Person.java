package com.ospe.jail;
import com.google.gson.annotations.Expose;

public class Person {

	@Expose protected String nombre;
	@Expose protected String apellidos;
	@Expose protected String DNI;
	@Expose protected String f_nac;
	@Expose protected String nacionalidad;
	@Expose protected String sexo;
	@Expose protected int altura;
	@Expose protected double peso;

	// Constructors

	public Person() {

	}

	public Person(String nombre, String apellidos, String DNI, String f_nac, String nacionalidad, String sexo,
			int altura, double peso) {

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.DNI = DNI;
		this.f_nac = f_nac;
		this.nacionalidad = nacionalidad;
		this.sexo = sexo;
		this.altura = altura;
		this.peso = peso;

	}

	// Getters and Setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getF_nac() {
		return f_nac;
	}

	public void setF_nac(String f_nac) {
		this.f_nac = f_nac;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
}
