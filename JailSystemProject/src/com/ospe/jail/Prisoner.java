package notSwing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Scanner;

public class Prisoner extends Person {

	private int num_preso;
	private int niv_amenaza;
	private int num_celda;
	private String condena;
	private String crimen;
	private String ingreso;
	private boolean visitas;
	private boolean llamadas;
	JSONParser parser = new JSONParser();

	public Prisoner() {
		super();
	}

	public Prisoner(String nombre, String apellidos, String DNI, String f_nac, String nacionalidad, String sexo,
			float altura, float peso, int num_preso, int niv_amenaza, int num_celda, String condena, String crimen,
			String ingreso, boolean visitas, boolean llamadas) {
		super(nombre, apellidos, DNI, f_nac, nacionalidad, sexo, altura, peso);
		this.num_preso = num_preso;
		this.niv_amenaza = niv_amenaza;

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

	public void prisonerReader() {
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("src/prisoners.json"));
			Scanner read = new Scanner(System.in);
			System.out.println("\nInsert prisoner number: ");
			String id = read.next();

			if (jsonObject.containsKey(id)) {
				JSONObject obj2 = (JSONObject) jsonObject.get(id);
				System.out.println("DNI: " + (String) obj2.get("DNI"));
				System.out.println("Nombre: " + (String) obj2.get("Nombre"));
				System.out.println("Apellidos: " + (String) obj2.get("Apellidos"));
				System.out.println("Fecha de nacimiento (día/mes/año): " + (String) obj2.get("Fecha_de_nacimiento"));
				System.out.println("Nacionalidad: " + (String) obj2.get("Nacionalidad"));
				System.out.println("Sexo (h/m): " + (String) obj2.get("Sexo(h/m)"));
				System.out.println("Altura (cm): " + (String) obj2.get("Altura(cm)"));
				System.out.println("Peso (kg): " + (String) obj2.get("Peso(kg)"));
				System.out.println("Número de preso: " + (String) obj2.get("Num_Preso"));
				System.out.println("Nivel de amenaza: " + (String) obj2.get("Nivel_de_amenaza"));
				System.out.println("Número de celda: " + (String) obj2.get("Num_de_celda"));
				System.out.println("Crimen: " + (String) obj2.get("Crimen"));
				System.out.println("Tiempo de condena(años,meses,días): " + (String) obj2.get("Tiempo_condena"));
				System.out.println("Ingreso (día/mes/año): " + (String) obj2.get("Ingreso"));
				if (((long) obj2.get("Visitas")) == 1) {
					System.out.println("Visitas: sí");
				} else {
					System.out.println("Visitas: no");
				}
				if (((long) obj2.get("Llamadas")) == 1) {
					System.out.println("Llamadas: sí");
				} else {
					System.out.println("Llamadas: no");
				}

			} else {
				System.out.println("There is no prisoner registered with that number.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void prisonerEditor() {
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("src/prisoners.json"));
			Scanner read = new Scanner(System.in);
			System.out.println("\nInsert number of the prisoner you want to edit: ");
			String id = read.next();

			if (jsonObject.containsKey(id)) {
				JSONObject jsonObject2 = (JSONObject) jsonObject.get(id);
				System.out.println("\nWhich field would you like to change?"
						+ "\nPlease make a selection:\n"
						+ "\n1.DNI"
						+ "\n2.Nombre"
						+ "\n3.Apellidos"
						+ "\n4.Fecha de nacimiento"
						+ "\n5.Nacionalidad"
						+ "\n6.Sexo"
						+ "\n7.Altura"
						+ "\n8.Peso"
						+ "\n9.Número de preso"
						+ "\n10.Nivel de amenaza"
						+ "\n11.Número de celda"
						+ "\n12.Crimen"
						+ "\n13.Tiempo de condena"
						+ "\n14.Ingreso"
						+ "\n15.Visitas"
						+ "\n16.Llamadas"
						+ "\n0.Exit");
			int choice = read.nextInt();
				read.nextLine();
				switch (choice) {
				case 0:
					System.out.println("End of editor.");
					break;
				case 1:
					System.out.println("\nInsert prisoner's new DNI: ");
					String dni = read.nextLine();
					jsonObject2.put("DNI", dni);
					break;
				case 2:
					System.out.println("\nInsert prisoner's new name: ");
					String name = read.nextLine();
					jsonObject2.put("Nombre", name);
					break;
				case 3:
					System.out.println("\nInsert prisoner's new last names: ");
					String lNames = read.nextLine();
					jsonObject2.put("Apellidos", lNames);
					break;
				case 4:
					System.out.println("\nInsert prisoner's new birth date (día/mes/año): ");
					String birth = read.nextLine();
					jsonObject2.put("Fecha_de_nacimiento", birth);
					break;
				case 5:
					System.out.println("\nInsert prisoner's new nationality: ");
					String nat = read.nextLine();
					jsonObject2.put("Nacionalidad", nat);
					break;
				case 6:
					System.out.println("\nInsert prisoner's new sex (h/m): ");
					String sex = read.nextLine();
					jsonObject2.put("Sexo(h/m)", sex);
					break;
				case 7:
					System.out.println("\nInsert prisoner's new height (cm): ");
					String height = read.nextLine();
					jsonObject2.put("Altura(cm)", height);
					break;
				case 8:
					System.out.println("\nInsert prisoner's new weight (kg): ");
					String weight = read.nextLine();
					jsonObject2.put("Peso(kg)", weight);
					break;
				case 9:
					System.out.println("\nInsert prisoner's new number: ");
					String id2 = read.nextLine();
					jsonObject2.put("Num_Preso", id2);
					break;
				case 10:
					System.out.println("\nInsert prisoner's new threat level: ");
					String threat = read.nextLine();
					jsonObject2.put("Nivel_de_amenaza", threat);
					break;
				case 11:
					System.out.println("\nInsert prisoner's new cell number: ");
					String cell = read.nextLine();
					jsonObject2.put("Num_de_celda", cell);
					break;
				case 12:
					System.out.println("\nInsert prisoner's new crime description: ");
					String crime = read.nextLine();
					jsonObject2.put("Crimen", crime);
					break;
				case 13:
					System.out.println("\nInsert prisoner's new time of condemnation (años, meses, días): ");
					String TC = read.nextLine();
					jsonObject2.put("Tiempo_condena", TC);
					break;
				case 14:
					System.out.println("\nInsert prisoner's new entry date (día/mes/año): ");
					String entry = read.nextLine();
					jsonObject2.put("Ingreso", entry);
					break;
				case 15:
					System.out.println("\nHas the prisoner visits permission? (si/no): ");
					String visits = read.nextLine();
					if (visits.equals("si")) {
						jsonObject2.put("Visitas", 1);
					} else {
						jsonObject2.put("Visitas", 0);
					}
					break;
				case 16:
					System.out.println("\nHas the prisoner calls permission? (si/no): ");
					String calls = read.nextLine();
					if (calls.equals("si")) {
						jsonObject2.put("Llamadas", 1);
					} else {
						jsonObject2.put("Llamadas", 0);
					}
					break;
				default:
					System.out.println("That is not a valid selection.");
					break;
				}

				String newId = (String) jsonObject2.get("Num_Preso");
				jsonObject.put(newId, id);
				jsonObject.remove(id);
				jsonObject.put(newId, jsonObject2);
				try (FileWriter file = new FileWriter("src/prisoners.json")) {

					file.write(jsonObject.toJSONString());
					file.flush();
					System.out.println("Prisoner updated.");

				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("There is no prisoner registered with that number.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void prisonerDeleter() {

		try {
			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("src/prisoners.json"));
			Scanner read = new Scanner(System.in);
			System.out.println("\nInsert number of the prisoner you want to delete: ");
			String id = read.nextLine();

			if (jsonObject.containsKey(id)) {
				jsonObject.remove(id);
				System.out.println("Prisoner found");

				try (FileWriter file = new FileWriter("src/prisoners.json")) {

					file.write(jsonObject.toJSONString());
					file.flush();
					System.out.println("Prisoner deleted");

				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("There is no prisoner with that number");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newPrisoner() {

		try {
			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("src/prisoners.json"));
			JSONObject jsonObject2 = (JSONObject) parser.parse(new FileReader("src/newPrisoner.json"));
			Scanner read = new Scanner(System.in);

			System.out.println("\nInsert new prisoner DNI: ");
			String dni = read.nextLine();
			jsonObject2.put("DNI", dni);

			System.out.println("\nInsert new prisoner name: ");
			String name = read.nextLine();
			jsonObject2.put("Nombre", name);

			System.out.println("\nInsert new prisoner last names: ");
			String lNames = read.nextLine();
			jsonObject2.put("Apellidos", lNames);

			System.out.println("\nInsert new prisoner birth date (día/mes/año): ");
			String birth = read.nextLine();
			jsonObject2.put("Fecha_de_nacimiento", birth);

			System.out.println("\nInsert new prisoner nationality: ");
			String nat = read.nextLine();
			jsonObject2.put("Nacionalidad", nat);

			System.out.println("\nInsert new prisoner sex (h/m): ");
			String sex = read.nextLine();
			jsonObject2.put("Sexo(h/m)", sex);

			System.out.println("\nInsert new prisoner height (cm): ");
			String height = read.nextLine();
			jsonObject2.put("Altura(cm)", height);

			System.out.println("\nInsert new prisoner weight (kg): ");
			String weight = read.nextLine();
			jsonObject2.put("Peso(kg)", weight);

			System.out.println("\nInsert new prisoner number: ");
			String id = read.nextLine();
			jsonObject2.put("Num_Preso", id);

			System.out.println("\nInsert new prisoner threat level: ");
			String threat = read.nextLine();
			jsonObject2.put("Nivel_de_amenaza", threat);

			System.out.println("\nInsert new prisoner cell number: ");
			String cell = read.nextLine();
			jsonObject2.put("Num_de_celda", cell);

			System.out.println("\nInsert new prisoner crime description: ");
			String crime = read.nextLine();
			jsonObject2.put("Crimen", crime);

			System.out.println("\nInsert new prisoner time of condemnation (años, meses, días): ");
			String TC = read.nextLine();
			jsonObject2.put("Tiempo_condena", TC);

			System.out.println("\nInsert new prisoner entry date (día/mes/año): ");
			String entry = read.nextLine();
			jsonObject2.put("Ingreso", entry);

			System.out.println("\nHas the new prisoner visits permission? (si/no): ");
			String visits = read.nextLine();
			if (visits.equals("si")) {
				jsonObject2.put("Visitas", 1);
			} else {
				jsonObject2.put("Visitas", 0);
			}

			System.out.println("\nHas the new prisoner calls permission? (si/no): ");
			String calls = read.nextLine();
			if (calls.equals("si")) {
				jsonObject2.put("Llamadas", 1);
			} else {
				jsonObject2.put("Llamadas", 0);
			}

			jsonObject.put(id, jsonObject2);
			System.out.println("New prisoner saved");

			try (FileWriter file = new FileWriter("src/prisoners.json")) {

				file.write(jsonObject.toJSONString());
				file.flush();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}