import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class PrisonerQuery {
	static JSONParser parser = new JSONParser();
	static Scanner read = new Scanner(System.in);
	static ArrayList<String> llaves = new ArrayList<String>();
	static ArrayList<JSONObject> prisoners = new ArrayList<JSONObject>();
	public static final int YEAR = 2019;

	public static void main(String[] args) {
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("src/prisoners.json"));
			for (Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				llaves.add(key);
			}
			System.out.println("\nIn which field would you like to put the restriction?"
					+ "\nPlease make a selection:\n"
					+ "\n1.Search by DNI"
					+ "\n2.Search by name"
					+ "\n3.Search by age"
					+ "\n4.Search by nationality"
					+ "\n5.Search by height"
					+ "\n6.Search by weight"
					+ "\n7.Search by threat level"
					+ "\n8.Search by cell number"
					+ "\n9.Search by time of condemnation"
					+ "\n10.Search by entrance date"
					+ "\n11.Search by visits"
					+ "\n12.Search by calls"
					+ "\n0.Exit");
			int choice = read.nextInt();
			read.nextLine();
			switch (choice) {

			case 0:
				System.out.println("End of query.");
				break;
			case 1:
				System.out.println("\nInsert DNI: ");
				String dni = read.nextLine();
				for (int i = 0; i < llaves.size(); i++) {
					JSONObject jsonObject2 = (JSONObject) jsonObject.get(llaves.get(i));
					String d = (String) jsonObject2.get("DNI");
					if (d.equals(dni)) {
						prisoners.add(jsonObject2);
					}
				}
				break;
			case 2:
				System.out.println("\nInsert name: ");
				String name = read.nextLine();
				for (int i = 0; i < llaves.size(); i++) {
					JSONObject jsonObject2 = (JSONObject) jsonObject.get(llaves.get(i));
					String d = (String) jsonObject2.get("Nombre");
					if (d.equals(name)) {
						prisoners.add(jsonObject2);
					}
				}
				break;
			case 3:
				System.out.println("\nInsert minimum age(years): ");
				int minAge = read.nextInt();
				System.out.println("\nInsert maximum age(years): ");
				int maxAge = read.nextInt();
				for (int i = 0; i < llaves.size(); i++) {
					JSONObject jsonObject2 = (JSONObject) jsonObject.get(llaves.get(i));
					int age = (YEAR - ((getTheDate((String) jsonObject2.get("Fecha_de_nacimiento")))[2]));
					if ((age >= minAge) && (age <= maxAge)) {
						prisoners.add(jsonObject2);
					}
				}
				break;
			case 4:
				System.out.println("\nInsert nationality: ");
				String nat = read.nextLine();
				for (int i = 0; i < llaves.size(); i++) {
					JSONObject jsonObject2 = (JSONObject) jsonObject.get(llaves.get(i));
					String d = (String) jsonObject2.get("Nacionalidad");
					if (d.equals(nat)) {
						prisoners.add(jsonObject2);
					}
				}
				break;
			case 5:
				System.out.println("\nInsert minimum height(cm): ");
				int minHeight = read.nextInt();
				System.out.println("\nInsert maximum height(cm): ");
				int maxHeight = read.nextInt();
				for (int i = 0; i < llaves.size(); i++) {
					JSONObject jsonObject2 = (JSONObject) jsonObject.get(llaves.get(i));
					int h = Integer.parseInt((String) jsonObject2.get("Altura(cm)"));
					if ((h >= minHeight) && (h <= maxHeight)) {
						prisoners.add(jsonObject2);
					}
				}
				break;
			case 6:
				System.out.println("\nInsert minimum weight(kg): ");
				String minW = read.nextLine();
				System.out.println("\nInsert maximum weight(kg): ");
				String maxW = read.nextLine();
				double  minWeight= Double.parseDouble(minW);
				double  maxWeight= Double.parseDouble(maxW);
				for (int i = 0; i < llaves.size(); i++) {
					JSONObject jsonObject2 = (JSONObject) jsonObject.get(llaves.get(i));
					double w = Double.parseDouble((String) jsonObject2.get("Peso(kg)"));
					if ((w >= minWeight) && (w <= maxWeight)) {
						prisoners.add(jsonObject2);
					}
				}
				break;
			case 7:
				System.out.println("\nInsert minimum threat level: ");
				int minT = read.nextInt();
				System.out.println("\nInsert maximum threat level: ");
				int maxT = read.nextInt();
				for (int i = 0; i < llaves.size(); i++) {
					JSONObject jsonObject2 = (JSONObject) jsonObject.get(llaves.get(i));
					int t = Integer.parseInt((String) jsonObject2.get("Nivel_de_amenaza"));
					if ((t >= minT) && (t <= maxT)) {
						prisoners.add(jsonObject2);
					}
				}
				break;
			case 8:
				System.out.println("\nInsert cell number: ");
				int cell = read.nextInt();
				for (int i = 0; i < llaves.size(); i++) {
					JSONObject jsonObject2 = (JSONObject) jsonObject.get(llaves.get(i));
					int c = Integer.parseInt((String) jsonObject2.get("Num_de_celda"));
					if (c == cell) {
						prisoners.add(jsonObject2);
					}
				}
				break;
			case 9:
				System.out.println("\nInsert minimum time of condemnation(years): ");
				int minC = read.nextInt();
				System.out.println("\nInsert maximum time of condemnation(years): ");
				int maxC = read.nextInt();
				for (int i = 0; i < llaves.size(); i++) {
					JSONObject jsonObject2 = (JSONObject) jsonObject.get(llaves.get(i));
					String s = (String) jsonObject2.get("Tiempo_condena");
					int c = Integer.parseInt(Character.toString(s.charAt(0)) + Character.toString(s.charAt(1))
							+ Character.toString(s.charAt(2)));
					if ((c >= minC) && (c < maxC)) {
						prisoners.add(jsonObject2);
					}
				}
				break;
			case 10:
				System.out.println("\nInsert minimum year: ");
				int minY = read.nextInt();
				System.out.println("\nInsert maximum year: ");
				int maxY = read.nextInt();
				for (int i = 0; i < llaves.size(); i++) {
					JSONObject jsonObject2 = (JSONObject) jsonObject.get(llaves.get(i));
					String s = (String) jsonObject2.get("Ingreso");
					int y = Integer.parseInt(Character.toString(s.charAt(6)) + Character.toString(s.charAt(7))
							+ Character.toString(s.charAt(8)) + Character.toString(s.charAt(9)));
					if ((y >= minY) && (y < maxY)) {
						prisoners.add(jsonObject2);
					}
				}
				break;
			case 11:
				System.out.println("\nDo you want prisoners with(1) or without(0) visits permission?");
				int visit = read.nextInt();
				for (int i = 0; i < llaves.size(); i++) {
					JSONObject jsonObject2 = (JSONObject) jsonObject.get(llaves.get(i));
					long v = (long) jsonObject2.get("Visitas");
					if (v == visit) {
						prisoners.add(jsonObject2);
					}
				}
				break;
			case 12:
				System.out.println("\nDo you want prisoners with(1) or without(0) calls permission?");
				int call = read.nextInt();
				for (int i = 0; i < llaves.size(); i++) {
					JSONObject jsonObject2 = (JSONObject) jsonObject.get(llaves.get(i));
					long ca = (long) jsonObject2.get("Llamadas");
					if (ca == call) {
						prisoners.add(jsonObject2);
					}
				}
				break;
			default:
				System.out.println("That is not a valid selection.");
				break;
			}
			for (int j = 0; j < prisoners.size(); j++) {
				printPrisoner(prisoners.get(j));
				System.out.println("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printPrisoner(JSONObject obj2) {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int[] getTheDate(String s) {
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
}
