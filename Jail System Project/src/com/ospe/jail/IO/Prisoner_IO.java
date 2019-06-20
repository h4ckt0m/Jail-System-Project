package com.ospe.jail.IO;

import java.util.Scanner;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import com.ospe.jail.*;

public class Prisoner_IO {
	private Scanner read = new Scanner(System.in);
	private DecimalFormat numberFormat = new DecimalFormat("#.##");
	public static final int YEAR = 2019;
	private static Prisoner_IO instanciaPIO;

	public static synchronized Prisoner_IO getInstance() {
		if (instanciaPIO == null) {
			instanciaPIO = new Prisoner_IO();
		}
		return instanciaPIO;
	}

	public void leer(HashMap<Integer, Prisoner> Prisoners) {
		System.out.println("\nInsert prisoner number: ");
		int id = read.nextInt();
		if (Prisoners.containsKey(id)) {
			System.out.println(Prisoners.get(id));

		} else {
			System.out.println("There is no prisoner registered with that number.");
		}
	}

	public void crear(HashMap<Integer, Prisoner> Prisoners, HashMap<Integer, Cell> cells) {
		Prisoner p = new Prisoner();
		int cellId = 0;
		System.out.println("\nInsert new prisoner DNI: ");
		p.setDNI(read.nextLine());

		System.out.println("\nInsert new prisoner name: ");
		p.setNombre(read.nextLine());

		System.out.println("\nInsert new prisoner last names: ");
		p.setApellidos(read.nextLine());

		System.out.println("\nInsert new prisoner birth date (día/mes/año): ");
		p.setF_nac(read.nextLine());

		System.out.println("\nInsert new prisoner nationality: ");
		p.setNacionalidad(read.nextLine());

		System.out.println("\nInsert new prisoner sex (h/m): ");
		p.setSexo(read.nextLine());

		System.out.println("\nInsert new prisoner height (cm): ");
		p.setAltura(read.nextInt());

		System.out.println("\nInsert new prisoner weight (kg): ");
		p.setPeso(read.nextDouble());

		System.out.println("\nInsert new prisoner number: ");
		p.setNum_preso(read.nextInt());

		System.out.println("\nInsert new prisoner threat level: ");
		p.setNiv_amenaza(read.nextInt());

		System.out.println("\nInsert new prisoner cell number: ");
		int x = 0;
		while (x == 0) {
			cellId = read.nextInt();
			if (cells.containsKey(cellId)) {
				if (cells.get(cellId).isLlena()) {
					System.out.println("\nThis cell is full.Introduce a valid cell number: ");
				} else {
					p.setCelda(cells.get(cellId));
					x = 1;
				}
			} else {
				System.out.println("\nThat cell does not exist. Introduce a valid cell number: ");
			}
		}
		read.nextLine();
		System.out.println("\nInsert new prisoner crime description: ");
		p.setCrimen(read.nextLine());

		System.out.println("\nInsert new prisoner time of condemnation (años, meses, días): ");
		p.setCondena(read.nextLine());

		System.out.println("\nInsert new prisoner entrance date (día/mes/año): ");
		p.setIngreso(read.nextLine());

		System.out.println("\nHas the new prisoner visits permission? (si/no): ");
		if (read.nextLine().equals("si")) {
			p.setVisitas(true);
		} else {
			p.setVisitas(false);
		}

		System.out.println("\nHas the new prisoner calls permission? (si/no): ");
		if (read.nextLine().equals("si")) {
			p.setLlamadas(true);
		} else {
			p.setLlamadas(false);
		}
		cells.get(cellId).getPresos().add(p);
		cells.get(cellId).setCap_actual();
		cells.get(cellId).setLlena();
		cells.get(cellId).getPabellon().setNum_presos();
		Prisoners.put(p.getNum_preso(), p);
	}

	public void editar(HashMap<Integer, Prisoner> Prisoners, HashMap<Integer, Cell> cells) {
		System.out.println("\nInsert number of the prisoner you want to edit: ");
		int id = read.nextInt();
		if (Prisoners.containsKey(id)) {
			Prisoner p = Prisoners.get(id);
			System.out.println("\nWhich field would you like to change?" + "\nPlease make a selection:\n" + "\n1.DNI"
					+ "\n2.Nombre" + "\n3.Apellidos" + "\n4.Fecha de nacimiento" + "\n5.Nacionalidad" + "\n6.Sexo"
					+ "\n7.Altura" + "\n8.Peso" + "\n9.Número de preso" + "\n10.Nivel de amenaza"
					+ "\n11.Número de celda" + "\n12.Crimen" + "\n13.Tiempo de condena" + "\n14.Ingreso"
					+ "\n15.Visitas" + "\n16.Llamadas" + "\n0.Exit");
			int choice = read.nextInt();
			read.nextLine();
			switch (choice) {
			case 0:
				System.out.println("End of editor.");
				break;
			case 1:
				System.out.println("\nInsert prisoner's new DNI: ");
				p.setDNI(read.nextLine());
				break;
			case 2:
				System.out.println("\nInsert prisoner's new name: ");
				p.setNombre(read.nextLine());
				break;
			case 3:
				System.out.println("\nInsert prisoner's new last names: ");
				p.setApellidos(read.nextLine());
				break;
			case 4:
				System.out.println("\nInsert prisoner's new birth date (día/mes/año): ");
				p.setF_nac(read.nextLine());
				break;
			case 5:
				System.out.println("\nInsert prisoner's new nationality: ");
				p.setNacionalidad(read.nextLine());
				break;
			case 6:
				System.out.println("\nInsert prisoner's new sex (h/m): ");
				p.setSexo(read.nextLine());
				break;
			case 7:
				System.out.println("\nInsert prisoner's new height (cm): ");
				p.setAltura(read.nextInt());
				break;
			case 8:
				System.out.println("\nInsert prisoner's new weight (kg): ");
				p.setPeso(read.nextDouble());
				break;
			case 9:
				System.out.println("\nInsert prisoner's new number: ");
				p.setNum_preso(read.nextInt());
				Prisoners.remove(id);// aunque de normal se reescribe, si cambia el nº preso quedarian los dos, asi
				// que hay que borrar el antiguo
				Prisoners.put(p.getNum_preso(), p);
				break;
			case 10:
				System.out.println("\nInsert prisoner's new threat level: ");
				p.setNiv_amenaza(read.nextInt());
				break;
			case 11:
				System.out.println("\nInsert prisoner's new cell number: ");
				int x = 0;
				int oldId = p.getCelda().getNum_celda();
				cells.get(oldId).getPresos().remove(p);
				cells.get(oldId).setCap_actual();
				cells.get(oldId).setLlena();
				cells.get(oldId).getPabellon().setNum_presos();
				int cellId = 0;
				while (x == 0) {
					cellId = read.nextInt();
					if (cells.containsKey(cellId)) {
						if (cells.get(cellId).isLlena()) {
							System.out.println("\nThis cell is full.Introduce a valid cell number: ");
						} else {
							p.setCelda(cells.get(cellId));
							x = 1;
						}
					} else {
						System.out.println("\nThat cell does not exist. Introduce a valid cell number: ");
					}
				}
				cells.get(cellId).getPresos().add(p);
				cells.get(cellId).setCap_actual();
				cells.get(cellId).setLlena();
				cells.get(cellId).getPabellon().setNum_presos();
				read.nextLine();
				break;
			case 12:
				System.out.println("\nInsert prisoner's new crime description: ");
				p.setCrimen(read.nextLine());
				break;
			case 13:
				System.out.println("\nInsert prisoner's new time of condemnation (años, meses, días): ");
				p.setCondena(read.nextLine());
				break;
			case 14:
				System.out.println("\nInsert prisoner's new entry date (día/mes/año): ");
				p.setIngreso(read.nextLine());
				break;
			case 15:
				System.out.println("\nHas the prisoner visits permission? (si/no): ");
				if (read.nextLine().equals("si")) {
					p.setVisitas(true);
				} else {
					p.setVisitas(false);
				}
				break;
			case 16:
				System.out.println("\nHas the prisoner calls permission? (si/no): ");
				if (read.nextLine().equals("si")) {
					p.setLlamadas(true);
				} else {
					p.setLlamadas(false);
				}
				break;
			default:
				System.out.println("That is not a valid selection.");
				break;
			}
		} else {
			System.out.println("There is no prisoner registered with that number.");
		}

	}

	public void borrar(HashMap<Integer, Prisoner> Prisoners, HashMap<Integer, Cell> cells) {
		System.out.println("\nInsert number of the prisoner you want to delete: ");
		int id = read.nextInt();
		if (Prisoners.containsKey(id)) {
			cells.get(Prisoners.get(id).getCelda().getNum_celda()).getPresos().remove(Prisoners.get(id));
			cells.get(Prisoners.get(id).getCelda().getNum_celda()).setCap_actual();
			cells.get(Prisoners.get(id).getCelda().getNum_celda()).setLlena();
			cells.get(Prisoners.get(id).getCelda().getNum_celda()).getPabellon().setNum_presos();
			Prisoners.remove(id);
			System.out.println("Prisoner deleted");
		} else {
			System.out.println("There is no prisoner with that number");
		}
	}

	public void leerListado(HashMap<Integer, Prisoner> Prisoners) {
		for (Prisoner p : Prisoners.values()) {
			System.out.print(p.getNum_preso() + ", " + p.getNombre() + " " + p.getApellidos() + "\n");
		}
	}

	public int[] getTheDate(String s) {
		int[] date = new int[3];
		String dayS = Character.toString(s.charAt(0)) + Character.toString(s.charAt(1));
		String monthS = Character.toString(s.charAt(3)) + Character.toString(s.charAt(4));
		String yearS = Character.toString(s.charAt(6)) + Character.toString(s.charAt(7))
				+ Character.toString(s.charAt(8)) + Character.toString(s.charAt(9));
		try {
			date[0] = Integer.parseInt(dayS);
			date[1] = Integer.parseInt(monthS);
			date[2] = Integer.parseInt(yearS);
		} catch (NumberFormatException e) {
			System.out.println("Invalid date format");
		}

		return date;
	}

	public void realizarConsulta(HashMap<Integer, Prisoner> Prisoners, String mainPath) {

		HashMap<Integer, Prisoner> Query = new HashMap<Integer, Prisoner>(Prisoners);
		ArrayList<Integer> deleteos = new ArrayList<Integer>();
		int exit = 1;
		while (exit == 1) {
			try {
				System.out.println("\nIn which field would you like to put the restriction?"
						+ "\nPlease make a selection:\n" + "\n1.Search by DNI" + "\n2.Search by name"
						+ "\n3.Search by age" + "\n4.Search by nationality" + "\n5.Search by height"
						+ "\n6.Search by weight" + "\n7.Search by threat level" + "\n8.Search by cell number"
						+ "\n9.Search by time of condemnation" + "\n10.Search by entrance date"
						+ "\n11.Search by visits" + "\n12.Search by calls" + "\n0.Exit");
				int choice = read.nextInt();
				read.nextLine();
				switch (choice) {

				case 0:
					System.out.println("End of query.");
					break;
				case 1:
					System.out.println("\nInsert DNI: ");
					String dni = read.nextLine();
					for (Prisoner p : Query.values()) {
						if (!p.getDNI().equals(dni)) {
							deleteos.add(p.getNum_preso());
						}
					}
					break;
				case 2:
					System.out.println("\nInsert name: ");
					String name = read.nextLine();
					for (Prisoner p : Query.values()) {
						if (!p.getNombre().equals(name)) {
							deleteos.add(p.getNum_preso());
						}
					}
					break;
				case 3:
					System.out.println("\nInsert minimum age(years): ");
					int minAge = read.nextInt();
					System.out.println("\nInsert maximum age(years): ");
					int maxAge = read.nextInt();
					for (Prisoner p : Query.values()) {
						int age = (YEAR - ((getTheDate(p.getF_nac()))[2]));
						if ((age < minAge) || (age > maxAge)) {
							deleteos.add(p.getNum_preso());
						}
					}
					break;
				case 4:
					System.out.println("\nInsert nationality: ");
					String nat = read.nextLine();
					for (Prisoner p : Query.values()) {
						if (!p.getNacionalidad().equals(nat)) {
							deleteos.add(p.getNum_preso());
						}
					}
					break;
				case 5:
					System.out.println("\nInsert minimum height(cm): ");
					int minHeight = read.nextInt();
					System.out.println("\nInsert maximum height(cm): ");
					int maxHeight = read.nextInt();
					for (Prisoner p : Query.values()) {
						if ((p.getAltura() < minHeight) || (p.getAltura() > maxHeight)) {
							deleteos.add(p.getNum_preso());
						}
					}
					break;
				case 6:
					System.out.println("\nInsert minimum weight(kg): ");
					String minW = read.nextLine();
					System.out.println("\nInsert maximum weight(kg): ");
					String maxW = read.nextLine();
					double minWeight = Double.parseDouble(minW);
					double maxWeight = Double.parseDouble(maxW);
					for (Prisoner p : Query.values()) {
						if ((p.getPeso() < minWeight) || (p.getPeso() > maxWeight)) {
							deleteos.add(p.getNum_preso());
						}
					}
					break;
				case 7:
					System.out.println("\nInsert minimum threat level: ");
					int minT = read.nextInt();
					System.out.println("\nInsert maximum threat level: ");
					int maxT = read.nextInt();
					for (Prisoner p : Query.values()) {
						if ((p.getNiv_amenaza() < minT) || (p.getNiv_amenaza() > maxT)) {
							deleteos.add(p.getNum_preso());
						}
					}
					break;
				case 8:
					System.out.println("\nInsert cell number: ");
					int cell = read.nextInt();
					for (Prisoner p : Query.values()) {
						if ((p.getCelda().getNum_celda()) != cell) {
							deleteos.add(p.getNum_preso());
						}
					}
					break;
				case 9:
					System.out.println("\nInsert minimum time of condemnation(years): ");
					int minC = read.nextInt();
					System.out.println("\nInsert maximum time of condemnation(years): ");
					int maxC = read.nextInt();
					for (Prisoner p : Query.values()) {
						String s = p.getCondena();
						int c = Integer.parseInt(Character.toString(s.charAt(0)) + Character.toString(s.charAt(1))
								+ Character.toString(s.charAt(2)));
						if ((c >= maxC) || (c < minC)) {
							deleteos.add(p.getNum_preso());
						}
					}
					break;
				case 10:
					System.out.println("\nInsert minimum year: ");
					int minY = read.nextInt();
					System.out.println("\nInsert maximum year: ");
					int maxY = read.nextInt();
					for (Prisoner p : Query.values()) {
						String s = p.getIngreso();
						int y = Integer.parseInt(Character.toString(s.charAt(6)) + Character.toString(s.charAt(7))
								+ Character.toString(s.charAt(8)) + Character.toString(s.charAt(9)));
						if ((y < minY) || (y > maxY)) {
							deleteos.add(p.getNum_preso());
						}
					}
					break;
				case 11:
					System.out.println("\nDo you want prisoners with(1) or without(0) visits permission?");
					int visit = read.nextInt();
					for (Prisoner p : Query.values()) {
						if (((visit == 0) && (p.isVisitas())) || ((visit == 1) && (!p.isVisitas()))) {
							deleteos.add(p.getNum_preso());
						}
					}
					break;
				case 12:
					System.out.println("\nDo you want prisoners with(1) or without(0) calls permission?");
					int call = read.nextInt();
					for (Prisoner p : Query.values()) {
						if (((call == 0) && (p.isLlamadas())) || ((call == 1) && (!p.isLlamadas()))) {
							deleteos.add(p.getNum_preso());
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
			exportCSV(Query, mainPath);
			System.out.println("\nConsulta guardada.");
		}
	}

	public void exportCSV(HashMap<Integer, Prisoner> query, String mainPath) {
		System.out.println("Name your query: ");
		String nameCSV = read.nextLine();
		String archCSV = mainPath + "exports/" + nameCSV + ".csv";

		try {
			FileWriter writer = new FileWriter(archCSV);
			writer.write(
					"DNI;NOMBRE;APELLIDOS;F_NAC;NACIONALIDAD;SEXO;ALTURA(cm);PESO(kg);NUM_PRESO;NIV_AMENAZA;NUM_CELDA;CRIMEN;CONDENA(aa,mm,dd);INGRESO;VISITAS;LLAMADAS\n");
			for (Prisoner p : query.values()) {
				writer.write(p.toCSV(';'));
			}
			writer.flush();
			writer.close();
			System.out.println("\nCSV saved");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String stats(HashMap<Integer, Prisoner> Prisoners) {
		double sumaAlturas = 0;
		double sumaAmenazas = 0;
		double sumaEdades = 0;
		double sumaVisitas = 0;
		double sumaLlamadas = 0;
		for (Prisoner p : Prisoners.values()) {
			sumaAlturas = sumaAlturas + p.getAltura();
			sumaAmenazas = sumaAmenazas + p.getNiv_amenaza();
			sumaEdades = sumaEdades + (YEAR - (getTheDate(p.getF_nac())[2]));
			if (p.isVisitas()) {
				sumaVisitas = sumaVisitas + 1;
			}
			if (p.isLlamadas()) {
				sumaLlamadas = sumaLlamadas + 1;
			}
		}
		double mediaAlturas = sumaAlturas / Prisoners.size();
		double mediaAmenazas = sumaAmenazas / Prisoners.size();
		double mediaEdades = sumaEdades / Prisoners.size();
		double porcentajeVisitas = (sumaVisitas / Prisoners.size()) * 100;
		double porcentajeLlamadas = (sumaLlamadas / Prisoners.size()) * 100;

		String s = "\nPrisoners height average: " + numberFormat.format(mediaAlturas) + " cm"
				+ "\r\nPrisoners threat level average: " + numberFormat.format(mediaAmenazas) + " over 3"
				+ "\r\nPrisoners age average: " + numberFormat.format(mediaEdades) + " years"
				+ "\r\nPercentage of prisoners with visits permission: " + numberFormat.format(porcentajeVisitas) + "%"
				+ "\r\nPercentage of prisoners with calls permission: " + numberFormat.format(porcentajeLlamadas) + "%";
		return s;
	}
}
