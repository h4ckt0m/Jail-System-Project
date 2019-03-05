package notSwing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Scanner;

public class Prisioner extends Person {

	private int num_preso;
	private int niv_amenaza;
	private int num_celda;
	private String condena;
	private String crimen;
	private String ingreso;
	private boolean visitas;
	private boolean llamadas;

	// Constructors

	public Prisioner() {
		super();
	}

	public Prisioner(String nombre, String apellidos, String DNI, String f_nac, String nacionalidad, String sexo,
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

		JSONParser parser = new JSONParser();
		try {
			Object object = parser.parse(new FileReader("src/prisoners.json"));

			// convert Object to JSONObject

			JSONObject jsonObject = (JSONObject) object;

			// Reading the String
			Scanner read = new Scanner(System.in);
			System.out.println("\nInsert prisoner number: ");
			String id = read.next();

			if (jsonObject.containsKey(id)) {
				JSONObject obj2 = (JSONObject) jsonObject.get(id);
				String DNI = (String) obj2.get("DNI");
				String Nombre = (String) obj2.get("Nombre");
				String Apellidos = (String) obj2.get("Apellidos");
				String FechNac = (String) obj2.get("Fecha_de_nacimiento");
				String Nacionalidad = (String) obj2.get("Nacionalidad");
				String Sexo = (String) obj2.get("Sexo(h/m)");
				String Altura = (String) obj2.get("Altura(cm)");
				String Peso = (String) obj2.get("Peso(kg)");
				String Num_Preso = (String) obj2.get("Num_Preso");
				String Nivel_de_amenaza = (String) obj2.get("Nivel_de_amenaza");
				String Num_de_celda = (String) obj2.get("Num_de_celda");
				String Crimen = (String) obj2.get("Crimen");
				String Tiempo_condena = (String) obj2.get("Tiempo_condena");
				String Ingreso = (String) obj2.get("Ingreso");
				long Visitas = (long) obj2.get("Visitas");
				long Llamadas = (long) obj2.get("Llamadas");

				System.out.println("DNI: " + DNI);
				System.out.println("Nombre: " + Nombre);
				System.out.println("Apellidos: " + Apellidos);
				System.out.println("Fecha de nacimiento (día/mes/año): " + FechNac);
				System.out.println("Nacionalidad: " + Nacionalidad);
				System.out.println("Sexo (h/m): " + Sexo);
				System.out.println("Altura (cm): " + Altura);
				System.out.println("Peso (kg): " + Peso);
				System.out.println("Número de preso: " + Num_Preso);
				System.out.println("Nivel de amenaza: " + Nivel_de_amenaza);
				System.out.println("Número de celda: " + Num_de_celda);
				System.out.println("Crimen: " + Crimen);
				System.out.println("Tiempo de condena(años,meses,días): " + Tiempo_condena);
				System.out.println("Ingreso (día/mes/año): " + Ingreso);
				if (Visitas == 1) {
					System.out.println("Visitas: sí");
				} else {
					System.out.println("Visitas: no");
				}
				if (Llamadas == 1) {
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

		JSONParser parser = new JSONParser();
		try {
			Object object = parser.parse(new FileReader("src/prisoners.json"));
			JSONObject jsonObject = (JSONObject) object;
			Scanner read = new Scanner(System.in);
			System.out.println("\nInsert number of the prisoner you want to edit: ");
			String id = read.next();

			if (jsonObject.containsKey(id)) {
				JSONObject jsonObject2 = (JSONObject) jsonObject.get(id);
				System.out.println("\nWhich field would you like to change?");
				System.out.println("Please make a selection:");
				System.out.println("\n1.DNI");
				System.out.println("2.Nombre");
				System.out.println("3.Apellidos");
				System.out.println("4.Fecha de nacimiento");
				System.out.println("5.Nacionalidad");
				System.out.println("6.Sexo");
				System.out.println("7.Altura");
				System.out.println("8.Peso");
				System.out.println("9.Número de preso");
				System.out.println("10.Nivel de amenaza");
				System.out.println("11.Número de celda");
				System.out.println("12.Crimen");
				System.out.println("13.Tiempo de condena");
				System.out.println("14.Ingreso");
				System.out.println("15.Visitas");
				System.out.println("16.Llamadas");
				System.out.println("0.Exit");
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
				try (FileWriter file = new FileWriter("src/Ejemplo_presos.json")) {

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

		JSONParser parser = new JSONParser();
		try {
			Object object = parser.parse(new FileReader("src/prisoners.json"));
			JSONObject jsonObject = (JSONObject) object;
			Scanner read = new Scanner(System.in);
			System.out.println("\nInsert number of the prisoner you want to delete: ");
			String id = read.nextLine();

			if (jsonObject.containsKey(id)) {
				jsonObject.remove(id);
				System.out.println("Prisoner found");

				try (FileWriter file = new FileWriter("src/Ejemplo_presos.json")) {

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

		JSONParser parser = new JSONParser();
		try {
			Object object = parser.parse(new FileReader("src/prisoners.json"));
			JSONObject jsonObject = (JSONObject) object;
			Object object2 = parser.parse(new FileReader("src/newPrisoner.json"));
			JSONObject jsonObject2 = (JSONObject) object2;
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

			jsonObject.put(id, object2);
			System.out.println("New prisoner saved");

			try (FileWriter file = new FileWriter("src/Ejemplo_presos.json")) {

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