package com.ospe.jail;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;

public class Pavilion {

	@Expose
	private int num_pabellon;
	@Expose
	private int num_celdas;
	@Expose
	private int num_presos;
	@Expose
	private int num_guardias;
	@Expose
	private int num_salasComunes;
	@Expose
	private ArrayList<Cell> celdas = new ArrayList<Cell>();

	// Constructors

	public Pavilion() {
	}

	public Pavilion(int num_pabellon, int numero_guardias, int num_salasComunes, ArrayList<Cell> celdas) {
		this.num_pabellon = num_pabellon;
		this.num_guardias = numero_guardias;
		this.num_salasComunes = num_salasComunes;
		this.celdas = celdas;
		setNum_celdas();
		setNum_presos();
	}

	public int getNum_pabellon() {
		return num_pabellon;
	}

	public void setNum_pabellon(int num_pabellon) {
		this.num_pabellon = num_pabellon;
	}

	public int getNum_celdas() {
		return num_celdas;
	}

	public void setNum_celdas() {
		this.num_celdas = celdas.size();
	}

	public int getNum_presos() {
		return num_presos;
	}

	public void setNum_presos() {
		int sum = 0;
		for (Cell c : celdas) {
			sum = sum + c.getPresos().size();
		}
		this.num_presos = sum;
	}

	public int getNum_guardias() {
		return num_guardias;
	}

	public void setNum_guardias(int num_guardias) {
		this.num_guardias = num_guardias;
	}

	public int getNum_salasComunes() {
		return num_salasComunes;
	}

	public void setNum_salasComunes(int num_salasComunes) {
		this.num_salasComunes = num_salasComunes;
	}

	public ArrayList<Cell> getCeldas() {
		return celdas;
	}

	public void setCeldas(ArrayList<Cell> celdas) {
		this.celdas = celdas;
	}

	@Override
	public String toString() {
		String s = "\nNúmero de pabellón: " + num_pabellon + "\nNúmero de celdas: " + num_celdas
				+ "\nNúmero de presos: " + num_presos + "\nNúmero de guardias: " + num_guardias
				+ "\nNúmero de salas comunes: " + num_salasComunes + "\nCeldas contenidas: \n";
		for (Cell c : celdas) {
			s = s + "\t" + c.getNum_celda() + ", " + c.getTipo_celda() + ", ";
			String p;
			if (c.isEstado_puerta()) {
				p = "puerta abierta";
			} else {
				p = "puerta cerrada";
			}
			s = s + p + "\n\tPresos:\n";

			for (Prisoner pr : c.getPresos()) {
				s = s + "\t\t" + pr.getNum_preso() + ", " + pr.getNombre() + "\n";
			}
			s = s + "\n";
		}
		return s;
	}

	public String toCSV(char i) {
		String s = "" + num_pabellon + i + num_celdas + i + num_presos + i + num_guardias + i + num_salasComunes + i;
		for (Cell c : celdas) {
			s = s + c.getNum_celda() + ",";
		}
		s = s + "\n";
		return s;
	}
}