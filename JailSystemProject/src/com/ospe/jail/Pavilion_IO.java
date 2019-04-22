package com.ospe.jail;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Pavilion_IO {
	Scanner read = new Scanner(System.in);
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
			System.out.print("Numero del pabellon: " + p.getNum_pabellon() + " || Numero de celdas: " + p.getNum_celdas() + " || Numero de presos: " + p.getNum_presos() + "\n");
			System.out.println("-----------------------------------------------------------------------");
		}
	}

	public void exportCSV(HashMap<Integer, Pavilion> query) {
		System.out.println("Name your query: ");
		String nameCSV = read.nextLine();
		String archCSV = "src/" + nameCSV + ".csv";

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
}
