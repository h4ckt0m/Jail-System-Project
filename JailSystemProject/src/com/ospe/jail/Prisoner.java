package com.ospe.jail;

import java.io.Serializable;

public class Prisoner extends Person implements Serializable{
	private int num_preso;
	private int niv_amenaza;
	private int num_celda;
	private String condena;
	private String crimen;
	private String ingreso;
	private boolean visitas;
	private boolean llamadas;

	//Constructors
	
	public Prisoner() {
		super();
	}

	public Prisoner(String nombre, String apellidos, String DNI, String f_nac, String nacionalidad, String sexo,
			int altura, double peso, int num_preso, int niv_amenaza, int num_celda, String condena, String crimen,
			String ingreso, boolean visitas, boolean llamadas) {
		super(nombre, apellidos, DNI, f_nac, nacionalidad, sexo, altura, peso);
		this.num_preso = num_preso;
		this.niv_amenaza = niv_amenaza;
		this.num_celda = num_celda;
		this.condena = condena;
		this.crimen = crimen;
		this.ingreso = ingreso;
		this.visitas = visitas;
		this.llamadas = llamadas;
	}

	// Getter and Setters
	public int getNum_preso() {
		return num_preso;
	}

	public void setNum_preso(int num_preso) {
		this.num_preso = num_preso;
	}

	public int getNiv_amenaza() {
		return niv_amenaza;
	}

	public void setNiv_amenaza(int niv_amenaza) {
		this.niv_amenaza = niv_amenaza;
	}

	public int getNum_celda() {
		return num_celda;
	}

	public void setNum_celda(int num_celda) {
		this.num_celda = num_celda;
	}

	public String getCondena() {
		return condena;
	}

	public void setCondena(String condena) {
		this.condena = condena;
	}

	public String getCrimen() {
		return crimen;
	}

	public void setCrimen(String crimen) {
		this.crimen = crimen;
	}

	public String getIngreso() {
		return ingreso;
	}

	public void setIngreso(String ingreso) {
		this.ingreso = ingreso;
	}

	public boolean isVisitas() {
		return visitas;
	}

	public void setVisitas(boolean visitas) {
		this.visitas = visitas;
	}

	public boolean isLlamadas() {
		return llamadas;
	}

	public void setLlamadas(boolean llamadas) {
		this.llamadas = llamadas;
	}

	public String toString() {
		String s = "\nDNI: " + DNI + "\nNombre: " + nombre + "\nApellidos: " + apellidos
				+ "\nFecha de nacimiento (día/mes/año): " + f_nac + "\nNacionalidad: " + nacionalidad + "\nSexo (h/m): "
				+ sexo + "\nAltura (cm): " + altura + "\nPeso (kg): " + peso + "\nNúmero de preso: " + num_preso
				+ "\nNivel de amenaza: " + niv_amenaza + "\nNúmero de celda: " + num_celda + "\nCrimen: " + crimen
				+ "\nTiempo de condena(años,meses,días): " + condena + "\nIngreso (día/mes/año): " + ingreso;
		if (visitas) {
			s = s + "\nVisitas: sí";
		} else {
			s = s + "\nVisitas: no";
		}
		if (llamadas) {
			s = s + "\nLlamadas: sí\n\n";
		} else {
			s = s + "\nLlamadas: no\n\n";
		}
		return s;
	}
	
	public String toCSV(char i) {
        String s = DNI + i + nombre + i + apellidos
                + i + f_nac + i + nacionalidad + i
                + sexo + i + altura + i + peso + i + num_preso
                + i + niv_amenaza + i + num_celda + i + crimen
                + i + condena + i + ingreso;
        if (visitas) {
            s = s + i + "sí";
        } else {
            s = s + i + "no";
        }
        if (llamadas) {
            s = s + i + "sí\n";
        } else {
            s = s + i + "no\n";
        }
        return s;
    }

}