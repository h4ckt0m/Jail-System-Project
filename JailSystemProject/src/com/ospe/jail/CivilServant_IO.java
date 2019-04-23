package com.ospe.jail;

import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CivilServant_IO {

	Scanner read = new Scanner(System.in);
	DecimalFormat numberFormat = new DecimalFormat("#.##");
	public static final int YEAR = 2019;

	public void leer(HashMap<String, CivilServant> CivilServants) {
		System.out.println("\nInsert civil servant Id: ");
		String id = read.nextLine();
		if (CivilServants.containsKey(id)) {
			System.out.println(CivilServants.get(id));

		} else {
			System.out.println("There is no civil servant registered with that Id.");
		}

	}

	public void leerListado(HashMap<String, CivilServant> CivilServants) {
		for (CivilServant cs : CivilServants.values()) {
			System.out.print(cs.getId_funcionario() + ", " + cs.getNombre() + " " + cs.getApellidos() + "\n");
		}
	}

	public void crear(HashMap<String, CivilServant> CivilServants) {
		CivilServant cs = new CivilServant();
		System.out.println("\nInsert new civil servant DNI: ");
		cs.setDNI(read.nextLine());

		System.out.println("\nInsert new civil servant name: ");
		cs.setNombre(read.nextLine());

		System.out.println("\nInsert new civil servant last names: ");
		cs.setApellidos(read.nextLine());

		System.out.println("\nInsert new civil servant birth date (día/mes/año): ");
		cs.setF_nac(read.nextLine());

		System.out.println("\nInsert new civil servant nationality: ");
		cs.setNacionalidad(read.nextLine());

		System.out.println("\nInsert new civil servant sex (h/m): ");
		cs.setSexo(read.nextLine());

		System.out.println("\nInsert new civil servant height (cm): ");
		cs.setAltura(read.nextInt());

		System.out.println("\nInsert new civil servant weight (kg): ");
		cs.setPeso(read.nextDouble());

		System.out.println("\nInsert new civil servant Id: ");
		cs.setId_funcionario(read.nextLine());

		System.out.println("\nInsert new civil servant salary: ");
		cs.setSueldo(read.nextFloat());

		System.out.println("\nInsert new civil servant position: ");
		cs.setCargo(read.nextLine());

		System.out.println("\nInsert new civil servant pavilion: ");
		cs.setPavilion_func(read.nextInt());

		System.out.println("\nInsert civil servant shift: ");
		cs.setTurno(read.nextLine());

		CivilServants.put(cs.getId_funcionario(), cs);
	}

	public void editar(HashMap<String, CivilServant> CivilServants) {
		CivilServant cs = new CivilServant();
		System.out.println("\nInsert Id of the civil servant you want to edit: ");
		String id = read.nextLine();
		if (CivilServants.containsKey(id)) {
			cs = CivilServants.get(id);
			System.out.println("\nWhich field would you like to change?" + "\nPlease make a selection:\n" + "\n1.DNI"
					+ "\n2.Nombre" + "\n3.Apellidos" + "\n4.Fecha de nacimiento" + "\n5.Nacionalidad" + "\n6.Sexo"
					+ "\n7.Altura" + "\n8.Peso" + "\n9.Id funcionario" + "\n10.Sueldo" + "\n11.Cargo"
					+ "\n12.Pabellon asignado" + "\n13.Turno" + "\n0.Exit");
			int choice = read.nextInt();
			read.nextLine();
			switch (choice) {
			case 0:
				System.out.println("End of editor.");
				break;
			case 1:
				System.out.println("\nInsert civil servant's new DNI: ");
				cs.setDNI(read.nextLine());
				break;
			case 2:
				System.out.println("\nInsert civil servant's new name: ");
				cs.setNombre(read.nextLine());
				break;
			case 3:
				System.out.println("\nInsert civil servant's new last names: ");
				cs.setApellidos(read.nextLine());
				break;
			case 4:
				System.out.println("\nInsert civil servant's new birth date (día/mes/año): ");
				cs.setF_nac(read.nextLine());
				break;
			case 5:
				System.out.println("\nInsert civil servant's new nationality: ");
				cs.setNacionalidad(read.nextLine());
				break;
			case 6:
				System.out.println("\nInsert civil servant's new sex (h/m): ");
				cs.setSexo(read.nextLine());
				break;
			case 7:
				System.out.println("\nInsert civil servant's new height (cm): ");
				cs.setAltura(read.nextInt());
				break;
			case 8:
				System.out.println("\nInsert civil servant's new weight (kg): ");
				cs.setPeso(read.nextDouble());
				break;
			case 9:
				System.out.println("\nInsert civil servant's new Id: ");
				cs.setId_funcionario(read.nextLine());
				CivilServants.remove(id);// aunque de normal se reescribe, si cambia el id de funcionario quedarian los
											// dos, asi
				// que hay que borrar el antiguo
				CivilServants.put(cs.getId_funcionario(), cs);
				break;
			case 10:
				System.out.println("\nInsert civil servant's new salary: ");
				cs.setSueldo(read.nextFloat());
				break;
			case 11:
				System.out.println("\nInsert civil servant's new position: ");
				cs.setCargo(read.nextLine());
				break;
			case 12:
				System.out.println("\nInsert civil servant's new pavilion: ");
				cs.setPavilion_func(read.nextInt());
				break;
			case 13:
				System.out.println("\nInsert civil servant's new shift: ");
				cs.setTurno(read.nextLine());
				break;
			default:
				System.out.println("That is not a valid selection.");
				break;
			}
		} else {
			System.out.println("There is no civil servant registered with that Id.");
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

	public void borrar(HashMap<String, CivilServant> CivilServants) {
		System.out.println("\nInsert id of the civil servant you want to delete: ");
		String id = read.nextLine();
		if (CivilServants.containsKey(id)) {
			CivilServants.remove(id);
			System.out.println("Civil servant deleted");
		} else {
			System.out.println("There is no civil servant with that Id");
		}
	}

	public void realizarConsulta(HashMap<String, CivilServant> CivilServants) {

		HashMap<String, CivilServant> Query = new HashMap<String, CivilServant>(CivilServants);
		ArrayList<String> deleteos = new ArrayList<String>();
		int exit = 1;
		while (exit == 1) {
			try {
				System.out.println("\nIn which field would you like to put the restriction?"
						+ "\nPlease make a selection:\n" + "\n1.Search by DNI" + "\n2.Search by name"
						+ "\n3.Search by age" + "\n4.Search by nationality" + "\n5.Search by height"
						+ "\n6.Search by weight" + "\n7.Search by salary" + "\n8.Search by position"
						+ "\n9.Search by pavilion" + "\n10.Search by shift" + "\n0.Exit");
				int choice = read.nextInt();
				read.nextLine();
				switch (choice) {

				case 0:
					System.out.println("End of query.");
					break;
				case 1:
					System.out.println("\nInsert DNI: ");
					String dni = read.nextLine();
					for (CivilServant cs : Query.values()) {
						if (!cs.getDNI().equals(dni)) {
							deleteos.add(cs.getId_funcionario());
						}
					}
					break;
				case 2:
					System.out.println("\nInsert name: ");
					String name = read.nextLine();
					for (CivilServant cs : Query.values()) {
						if (!cs.getNombre().equals(name)) {
							deleteos.add(cs.getId_funcionario());
						}
					}
					break;
				case 3:
					System.out.println("\nInsert minimum age(years): ");
					int minAge = read.nextInt();
					System.out.println("\nInsert maximum age(years): ");
					int maxAge = read.nextInt();
					for (CivilServant cs : Query.values()) {
						int age = (YEAR - ((getTheDate(cs.getF_nac()))[2]));
						if ((age < minAge) || (age > maxAge)) {
							deleteos.add(cs.getId_funcionario());
						}
					}
					break;
				case 4:
					System.out.println("\nInsert nationality: ");
					String nat = read.nextLine();
					for (CivilServant cs : Query.values()) {
						if (!cs.getNacionalidad().equals(nat)) {
							deleteos.add(cs.getId_funcionario());
						}
					}
					break;
				case 5:
					System.out.println("\nInsert minimum height(cm): ");
					int minHeight = read.nextInt();
					System.out.println("\nInsert maximum height(cm): ");
					int maxHeight = read.nextInt();
					for (CivilServant cs : Query.values()) {
						if ((cs.getAltura() < minHeight) || (cs.getAltura() > maxHeight)) {
							deleteos.add(cs.getId_funcionario());
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
					for (CivilServant cs : Query.values()) {
						if ((cs.getPeso() < minWeight) || (cs.getPeso() > maxWeight)) {
							deleteos.add(cs.getId_funcionario());
						}
					}
					break;
				case 7:
					System.out.println("\nInsert minimum salary: ");
					float minS = read.nextFloat();
					System.out.println("\nInsert maximum salary: ");
					float maxS = read.nextFloat();
					for (CivilServant cs : Query.values()) {
						if ((cs.getSueldo() < minS) || (cs.getSueldo() > maxS)) {
							deleteos.add(cs.getId_funcionario());
						}
					}
					break;
				case 8:
					System.out.println("\nInsert position: ");
					String pos = read.nextLine();
					for (CivilServant cs : Query.values()) {
						if (!cs.getNacionalidad().equals(pos)) {
							deleteos.add(cs.getId_funcionario());
						}
					}
					break;
				case 9:
					System.out.println("\nInsert pavilion: ");
					int pav = read.nextInt();
					for (CivilServant cs : Query.values()) {
						if (cs.getPavilion_func() != pav) {
							deleteos.add(cs.getId_funcionario());
						}
					}
					break;
				case 10:
					System.out.println("\nInsert shift: ");
					String shi = read.nextLine();
					for (CivilServant cs : Query.values()) {
						if (!cs.getTurno().equals(shi)) {
							deleteos.add(cs.getId_funcionario());
						}
					}
					break;
				default:
					System.out.println("That is not a valid selection.");
					break;
				}
				for (int i = 0; i < deleteos.size(); i++) {
					Query.remove(deleteos.get(i));
				}
				deleteos.clear();
				System.out.println("Do you like to add another restriction?(yes(1)/ no(0))");
				exit = read.nextInt();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		System.out.println("Do you like to visulize(1) or visualize and export it to CSV(2)?");
		int opt = read.nextInt();
		if (opt == 1) {
			System.out.println("\n" + Query);
		} else if (opt == 2) {
			System.out.println("\n" + Query);
			exportCSV(Query);
			System.out.println("\nConsulta guardada.");
		}
	}

	public void exportCSV(HashMap<String, CivilServant> query) {
		read.nextLine();
		System.out.println("Name your query: ");
		String nameCSV = read.nextLine();
		String archCSV = "src/" + nameCSV + ".csv";
		try {
			FileWriter writer = new FileWriter(archCSV);
			writer.write(
					"DNI;NOMBRE;APELLIDOS;F_NAC;NACIONALIDAD;SEXO;ALTURA(cm);PESO(kg);CARGO;ID_FUNC;SUELDO;PABELLON;TURNO\n");
			for (CivilServant cs : query.values()) {
				writer.write(cs.toCSV(';'));
			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public String stats(HashMap<String, CivilServant> CivilServants) {
		double sumaAlturas = 0;
		double sumaEdades = 0;
		double sumaMorning = 0;
		double sumaTarde = 0;
		double sumaNoche = 0;
		for (CivilServant cs : CivilServants.values()) {
			sumaAlturas = sumaAlturas + cs.getAltura();
			sumaEdades = sumaEdades + (YEAR - (getTheDate(cs.getF_nac())[2]));
			if (cs.getTurno().equals("mañana")) {
				sumaMorning = sumaMorning + 1;
			}
			if (cs.getTurno().equals("tarde")) {
				sumaTarde = sumaTarde + 1;
			}
			if (cs.getTurno().equals("noche")) {
				sumaNoche = sumaNoche + 1;
			}
		}
		double mediaAlturas = sumaAlturas / CivilServants.size();
		double mediaEdades = sumaEdades / CivilServants.size();
		double porcentajeMorning = (sumaMorning/CivilServants.size())*100;
		double porcentajeTarde = (sumaTarde/CivilServants.size())*100;
		double porcentajeNoche = (sumaNoche/CivilServants.size())*100;
		
		String s = "\nMedia de alturas de los funcionarios: " + numberFormat.format(mediaAlturas) + " cm"
				+ "\r\nMedia de edades de los funcionarios: " + numberFormat.format(mediaEdades) + " años"
				+ "\r\nPorcentaje de funcionarios con turno de mañana: "+numberFormat.format(porcentajeMorning)+"%"
				+ "\r\nPorcentaje de funcionarios con turno de tarde: "+numberFormat.format(porcentajeTarde)+"%"
				+ "\r\nPorcentaje de funcionarios con turno de noche: "+numberFormat.format(porcentajeNoche)+"%";
		return s;
	}
	
}
