package com.ospe.jail;

import java.util.Scanner;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Cell_IO {
	Scanner read = new Scanner(System.in);
	DecimalFormat numberFormat = new DecimalFormat("#.##");
	public static final int YEAR = 2019;

	public void leer(HashMap<Integer, Cell> Cells) {
		System.out.println("\nInsert cell number: ");
		int id = read.nextInt();
		if (Cells.containsKey(id)) {
			System.out.println(Cells.get(id));

		} else {
			System.out.println("There is no cell registered with that number.");
		}
	}

	public void crear(HashMap<Integer, Cell> Cells, HashMap<Integer, Pavilion> pavilions) {
		Cell c = new Cell();
		int pab = 0;
		System.out.println("\nInsert new cell type(Individual/Doble): ");
		c.setTipo_celda(read.nextLine());
		read.nextLine();

		System.out.println("\nIs the cell door opened or closed right now?: ");
		if (read.nextLine().equals("opened")) {
			c.setEstado_puerta(true);
		} else {
			c.setEstado_puerta(false);
		}

		System.out.println("\nInsert new cell number: ");
		c.setNum_celda(read.nextInt());

		System.out.println("\nInsert new cell security level: ");
		c.setNivel_seguridad(read.nextInt());

		System.out.println("\nInsert new cell floor: ");
		c.setPiso(read.nextInt());
		System.out.println("\nInsert new cell pavilion number: ");
		int x = 0;
		while (x == 0) {
			pab = read.nextInt();
			if (pavilions.containsKey(pab)) {
				c.setPabellon(pavilions.get(pab));
				x = 1;
			} else {
				System.out.println("\nThat pavilion does not exist. Introduce a valid pavilion number: ");
			}
		}
		c.setCap_actual();
		c.setLlena();
		pavilions.get(pab).getCeldas().add(c);
		pavilions.get(pab).setNum_celdas();
		Cells.put(c.getNum_celda(), c);
	}

	public void editar(HashMap<Integer, Cell> Cells,HashMap<Integer, Pavilion> pavilions) {
		Cell c = new Cell();
		System.out.println("\nInsert number of the cell you want to edit: ");
		int num = read.nextInt();
		if (Cells.containsKey(num)) {
			c = Cells.get(num);
			System.out.println("\nWhich field would you like to change?" + "\nPlease make a selection:\n"
					+ "\n1.Tipo de celda" + "\n2.Estado de la puerta" + "\n3.Número de celda" + "\n4.Nivel de seguridad"
					+ "\n5.Piso" + "\n6.Pabellón" + "\n0.Exit");
			int choice = read.nextInt();
			read.nextLine();
			switch (choice) {
			case 0:
				System.out.println("End of editor.");
				break;
			case 1:
				System.out.println("\nInsert cell's new type(Individual/Doble): ");
				c.setTipo_celda(read.nextLine());
				c.setLlena();
				break;
			case 2:
				System.out.println("\nIs the cell door opened or closed right now?: ");
				if (read.nextLine().equals("opened")) {
					c.setEstado_puerta(true);
				} else {
					c.setEstado_puerta(false);
				}
				break;
			case 3:
				System.out.println("\nInsert cell's new number: ");
				c.setNum_celda(read.nextInt());
				Cells.remove(num);// aunque de normal se reescribe, si cambia el nº celda quedarian los dos, asi
				// que hay que borrar el antiguo
				Cells.put(c.getNum_celda(), c);
				break;
			case 4:
				System.out.println("\nInsert cell's new security level: ");
				c.setNivel_seguridad(read.nextInt());
				break;
			case 5:
				System.out.println("\nInsert cell's new floor: ");
				c.setPiso(read.nextInt());
				break;
			case 6:
				System.out.println("\nInsert cell's new pavilion number: ");
				int x = 0;
				int oldId=c.getPabellon().getNum_pabellon();
				pavilions.get(oldId).getCeldas().remove(c);
				pavilions.get(oldId).setNum_celdas();
				pavilions.get(oldId).setNum_presos();
				int pId = 0;
				while (x == 0) {
					pId = read.nextInt();
					if (pavilions.containsKey(pId)) {
						c.setPabellon(pavilions.get(pId));
							x = 1;
					} else {
						System.out.println("\nThat pavilion does not exist. Introduce a valid pavilion number: ");
					}
				}
				pavilions.get(pId).getCeldas().add(c);
				pavilions.get(pId).setNum_celdas();
				pavilions.get(pId).setNum_presos();
				read.nextLine();
				break;
			default:
				System.out.println("That is not a valid selection.");
				break;
			}
			c.setCap_actual();
			c.setLlena();
		} else {
			System.out.println("There is no cell registered with that number.");
		}
	}

	public void borrar(HashMap<Integer, Cell> Cells,HashMap<Integer, Pavilion> pavilions) {
		System.out.println("\nInsert number of the cell you want to delete: ");
		int id = read.nextInt();
		if (Cells.containsKey(id)) {
			if (Cells.get(id).getCap_actual() == 0) {
				pavilions.get(Cells.get(id).getPabellon().getNum_pabellon()).getCeldas().remove(id);
				pavilions.get(Cells.get(id).getPabellon().getNum_pabellon()).setNum_celdas();
				pavilions.get(Cells.get(id).getPabellon().getNum_pabellon()).setNum_presos();	
				Cells.remove(id);
				System.out.println("cell deleted");
			} else {
				System.out.println("Error. Cell selected is not empty and will not be deleted.");
			}
		} else {
			System.out.println("There is no cell with that number");
		}
	}

	public void leerListado(HashMap<Integer, Cell> Cells) {
		for (Cell c : Cells.values()) {
			String s;
			if (c.isEstado_puerta()) {
				s = "puerta abierta";
			} else {
				s = "puerta cerrada";
			}
			System.out.print(c.getNum_celda() + ", " + c.getTipo_celda() + ", " + s + "\n");
		}
	}

	public void realizarConsulta(HashMap<Integer, Cell> Cells) {

		HashMap<Integer, Cell> Query = new HashMap<Integer, Cell>(Cells);
		ArrayList<Integer> deleteos = new ArrayList<Integer>();
		int exit = 1;
		while (exit == 1) {
			try {
				System.out.println("\nIn which field would you like to put the restriction?"
						+ "\nPlease make a selection:\n" + "\n1.Search by current capacity" + "\n2.Search by cell type"
						+ "\n3.Search by fill" + "\n4.Search by door status" + "\n5.Search by security level"
						+ "\n6.Search by floor"+ "\n7.Search by pavilion" + "\n0.Exit");
				int choice = read.nextInt();
				read.nextLine();
				switch (choice) {
				case 0:
					System.out.println("End of query.");
					break;
				case 1:
					System.out.println("\nInsert minimum current capacity(0, 1 or 2): ");
					int minC = read.nextInt();
					System.out.println("\nInsert maximum current capacity(0, 1 or 2): ");
					int maxC = read.nextInt();
					for (Cell c : Query.values()) {
						if ((c.getCap_actual() < minC) || (c.getCap_actual() > maxC)) {
							deleteos.add(c.getNum_celda());
						}
					}
					break;
				case 2:
					System.out.println("\nInsert cell type(Individual/Doble): ");
					String type = read.nextLine();
					for (Cell c : Query.values()) {
						if (!c.getTipo_celda().equals(type)) {
							deleteos.add(c.getNum_celda());
						}
					}
					break;
				case 3:
					System.out.println("\nDo you want full(1) or not full(0) cells?");
					int full = read.nextInt();
					for (Cell c : Query.values()) {
						if (((full == 0) && (c.isLlena())) || ((full == 1) && (!c.isLlena()))) {
							deleteos.add(c.getNum_celda());
						}
					}
					break;
				case 4:
					System.out.println("\nDo you want opened(1) or closed(0) cells?");
					int door = read.nextInt();
					for (Cell c : Query.values()) {
						if (((door == 0) && (c.isEstado_puerta())) || ((door == 1) && (!c.isEstado_puerta()))) {
							deleteos.add(c.getNum_celda());
						}
					}
					break;
				case 5:
					System.out.println("\nInsert minimum security level: ");
					int minS = read.nextInt();
					System.out.println("\nInsert maximum security level: ");
					int maxS = read.nextInt();
					for (Cell c : Query.values()) {
						if ((c.getNivel_seguridad() < minS) || (c.getNivel_seguridad() > maxS)) {
							deleteos.add(c.getNum_celda());
						}
					}
					break;
				case 6:
					System.out.println("\nInsert minimum floor: ");
					int minF = read.nextInt();
					System.out.println("\nInsert maximum floor: ");
					int maxF = read.nextInt();
					for (Cell c : Query.values()) {
						if ((c.getPiso() < minF) || (c.getPiso() > maxF)) {
							deleteos.add(c.getNum_celda());
						}
					}
					break;
				case 7:
					System.out.println("\nInsert pavilion number: ");
					int pabb = read.nextInt();
					for (Cell c : Query.values()) {
						if ((c.getPabellon().getNum_pabellon()) != pabb) {
							deleteos.add(c.getNum_celda());
						}
					}
					break;
				default:
					System.out.println("That is not a valid selection.");
					break;
				}
				for (int i : deleteos) {
					Query.remove(i);
				}
				deleteos.clear();
				System.out.println("Do you like to add another restriction?(yes(1)/ no(0))");
				exit = read.nextInt();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		System.out.println("Do you like to visualize(0) or visualize and export it to CSV(1)?");
		int opt = read.nextInt();
		read.nextLine();
		if (opt == 0) {
			System.out.println("\n" + Query);
		} else if (opt == 1) {
			System.out.println("\n" + Query);
			exportCSV(Query);
			System.out.println("\nConsulta guardada.");
		}
	}

	public void exportCSV(HashMap<Integer, Cell> query) {
		System.out.println("Name your query: ");
		String nameCSV = read.nextLine();
		String archCSV = "src/com/ospe/jail/exports/" + nameCSV + ".csv";

		try {
			FileWriter writer = new FileWriter(archCSV);
			writer.write(
					"CAPACIDAD ACTUAL;TIPO DE CELDA;LLENA;ESTADO DE PUERTA;NUM_CELDA;NIV_SEGURIDAD;PISO;NUM_PABELLON;PRESOS CONTENIDOS\n");
			for (Cell c : query.values()) {
				writer.write(c.toCSV(';'));
			}
			writer.flush();
			writer.close();
			System.out.println("\nCSV saved");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public String stats(HashMap<Integer, Cell> cells) {
		double sumaCapacidades = 0;
		double sumaSeguridad = 0;
		double sumaLlenas = 0;
		double sumaAbiertas = 0;
		for (Cell c : cells.values()) {
			sumaCapacidades = sumaCapacidades + c.getCap_actual();
			sumaSeguridad = sumaSeguridad + c.getNivel_seguridad();
			if (c.isLlena()) {
				sumaLlenas = sumaLlenas + 1;
			}
			if (c.isEstado_puerta()) {
				sumaAbiertas = sumaAbiertas + 1;
			}
		}
		double mediaCapacidades = sumaCapacidades / cells.size();
		double mediaSeguridad = sumaSeguridad / cells.size();
		double porcentajeLlenas = (sumaLlenas/cells.size())*100;
		double porcentajeAbiertas = (sumaAbiertas/cells.size())*100;
				
		String s = "\nMedia de capacidades actuales de las celdas: " + numberFormat.format(mediaCapacidades) + " presos por celda"
				+ "\r\nMedia de niveles de seguridad de las celdas: " + numberFormat.format(mediaSeguridad) + " sobre 5"
				+ "\r\nPorcentaje de celdas llenas: "+numberFormat.format(porcentajeLlenas)+"%"
				+ "\r\nPorcentaje de celdas abiertas: "+numberFormat.format(porcentajeAbiertas)+"%";
		return s;
	}
}