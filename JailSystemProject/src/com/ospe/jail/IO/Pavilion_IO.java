package com.ospe.jail.IO;

import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import com.ospe.jail.*;

public class Pavilion_IO {
	Scanner read = new Scanner(System.in);
	DecimalFormat numberFormat = new DecimalFormat("#.##");
	public static final int YEAR = 2019;

	public void leer(HashMap<Integer, Pavilion> pavilions) {
		System.out.println("\nInsert pavilion number: ");
		int id = read.nextInt();
		if (pavilions.containsKey(id)) {
			System.out.println(pavilions.get(id));

		} else {
			System.out.println("There is no pavilion registered with that number.");
		}
	}

	public void crear(HashMap<Integer, Pavilion> pavilions) {
		Pavilion p = new Pavilion();
		System.out.println("\nInsert new pavilion number: ");
		p.setNum_pabellon(read.nextInt());

		System.out.println("\nInsert new pavilion number of guards: ");
		p.setNum_guardias(read.nextInt());

		System.out.println("\nInsert new pavilion number of common rooms: ");
		p.setNum_salasComunes(read.nextInt());
		p.setNum_celdas();
		p.setNum_presos();
		pavilions.put(p.getNum_pabellon(), p);
	}

	public void editar(HashMap<Integer, Pavilion> pavilions) {
		Pavilion p = new Pavilion();
		System.out.println("\nInsert number of the pavilion you want to edit: ");
		int num = read.nextInt();
		if (pavilions.containsKey(num)) {
			p = pavilions.get(num);
			System.out.println("\nWhich field would you like to change?" + "\nPlease make a selection:\n"
					+ "\n1.Número de pabellón" + "\n2.Número de guardias" + "\n3.Número de salas comunes" + "\n0.Exit");
			int choice = read.nextInt();
			read.nextLine();
			switch (choice) {
			case 0:
				System.out.println("End of editor.");
				break;
			case 1:
				System.out.println("\nInsert pavilion's new number: ");
				p.setNum_pabellon(read.nextInt());
				pavilions.remove(num);// aunque de normal se reescribe, si cambia el nº celda quedarian los dos, asi
				// que hay que borrar el antiguo
				pavilions.put(p.getNum_pabellon(), p);
				break;
			case 2:
				System.out.println("\nInsert pavilion's new number of guards: ");
				p.setNum_guardias(read.nextInt());
				break;
			case 3:
				System.out.println("\nInsert pavilion's new number of common rooms: ");
				p.setNum_salasComunes(read.nextInt());
				break;
			default:
				System.out.println("That is not a valid selection.");
				break;
			}
		} else {
			System.out.println("There is no pavilion registered with that number.");
		}
	}

	public void borrar(HashMap<Integer, Pavilion> pavilions) {
		System.out.println("\nInsert number of the pavilion you want to delete: ");
		int id = read.nextInt();
		if (pavilions.containsKey(id)) {
			if (pavilions.get(id).getCeldas().size() == 0) {
				pavilions.remove(id);
				System.out.println("Pavilion deleted");
			} else {
				System.out.println("Error. Pavilion selected is not empty and will not be deleted.");
			}
		} else {
			System.out.println("There is no pavilion with that number");
		}
	}

	public void leerListado(HashMap<Integer, Pavilion> pavilions) {
		for (Pavilion p : pavilions.values()) {
			System.out.print(p.getNum_pabellon() + ", " + p.getNum_celdas() + " celdas, " + p.getNum_presos() + " presos\n");
		}
	}

	public void exportCSV(HashMap<Integer, Pavilion> query) {
		System.out.println("Name your query: ");
		String nameCSV = read.nextLine();
		String archCSV = "src/com/ospe/jail/exports/" + nameCSV + ".csv";

		try {
			FileWriter writer = new FileWriter(archCSV);
			writer.write(
					"NUM_PABELLON;NUM_CELDAS;NUM_PRESOS;NUM_GUARDIAS;NUM_SALAS_COMUNES;CELDAS CONTENIDAS\n");
			for (Pavilion p : query.values()) {
				writer.write(p.toCSV(';'));
			}
			writer.flush();
			writer.close();
			System.out.println("\nCSV saved");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public String stats(HashMap<Integer, Pavilion> pavilions) {
		double sumaCeldas = 0;
		double sumaPresos = 0;
		double sumaGuardias = 0;
		double sumaSalas = 0;
		for (Pavilion p : pavilions.values()) {
			sumaCeldas = sumaCeldas + p.getNum_celdas();
			sumaPresos = sumaPresos + p.getNum_presos();
			sumaGuardias=sumaGuardias+p.getNum_guardias();
			sumaSalas=sumaSalas+p.getNum_salasComunes();
		}
		double mediaCeldas = sumaCeldas / pavilions.size();
		double mediaPresos = sumaPresos / pavilions.size();
		double mediaGuardias = sumaGuardias / pavilions.size();
		double mediaSalas = sumaSalas / pavilions.size();
				
		String s = "\nMedia de celdas por pabellón: " + numberFormat.format(mediaCeldas) + " celdas"
				+ "\r\nMedia de presos por pabellón: " + numberFormat.format(mediaPresos) + " presos"
				+ "\r\nMedia de guardias por pabellón: "+numberFormat.format(mediaGuardias)+" guardias"
				+ "\r\nMedia de salas comunes por pabellón: "+numberFormat.format(mediaSalas)+" salas";
		return s;
	}
}
