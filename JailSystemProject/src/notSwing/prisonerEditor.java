
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Scanner;

public class prisonerEditor {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
            Object object = parser.parse(new FileReader("src/Ejemplo_presos.json"));
            JSONObject jsonObject = (JSONObject)object;
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
					switch(choice) {
						case 0:
							System.out.println("End of editor.");
						break;
						case 1:
							System.out.println("\nInsert prisoner's new DNI: ");
							String dni = read.nextLine();
							jsonObject2.put("DNI",dni);
						break;	
						case 2:
							System.out.println("\nInsert prisoner's new name: ");
							String name = read.nextLine();
							jsonObject2.put("Nombre",name);
						break;	
						case 3:
							System.out.println("\nInsert prisoner's new last names: ");
							String lNames = read.nextLine();
							jsonObject2.put("Apellidos",lNames);
						break;		
						case 4:
							System.out.println("\nInsert prisoner's new birth date (día/mes/año): ");
							String birth = read.nextLine();
							jsonObject2.put("Fecha_de_nacimiento",birth);
						break;	
						case 5:
							System.out.println("\nInsert prisoner's new nationality: ");
							String nat = read.nextLine();
							jsonObject2.put("Nacionalidad",nat);
						break;	
						case 6:
							System.out.println("\nInsert prisoner's new sex (h/m): ");
							String sex = read.nextLine();
							jsonObject2.put("Sexo(h/m)",sex);
						break;
						case 7:
							System.out.println("\nInsert prisoner's new height (cm): ");
							String height = read.nextLine();
							jsonObject2.put("Altura(cm)",height);
						break;	
						case 8:
							System.out.println("\nInsert prisoner's new weight (kg): ");
							String weight = read.nextLine();
							jsonObject2.put("Peso(kg)",weight);
						break;	
						case 9:
							System.out.println("\nInsert prisoner's new number: ");
							String id2 = read.nextLine();
							jsonObject2.put("Num_Preso",id2);
						break;
						case 10:
							System.out.println("\nInsert prisoner's new threat level: ");
							String threat = read.nextLine();
							jsonObject2.put("Nivel_de_amenaza",threat);
						break;
						case 11:
							System.out.println("\nInsert prisoner's new cell number: ");
							String cell = read.nextLine();
							jsonObject2.put("Num_de_celda",cell);
						break;
						case 12:
							System.out.println("\nInsert prisoner's new crime description: ");
							String crime = read.nextLine();
							jsonObject2.put("Crimen",crime);
						break;	
						case 13:
							System.out.println("\nInsert prisoner's new time of condemnation (años, meses, días): ");
							String TC = read.nextLine();
							jsonObject2.put("Tiempo_condena",TC);
						break;
						case 14:
							System.out.println("\nInsert prisoner's new entry date (día/mes/año): ");
							String entry = read.nextLine();
							jsonObject2.put("Ingreso",entry);
						break;
						case 15:
							System.out.println("\nHas the prisoner visits permission? (si/no): ");
							String visits = read.nextLine();
							if(visits.equals("si")) {jsonObject2.put("Visitas",1);}else {jsonObject2.put("Visitas",0);}
						break;
						case 16:
							System.out.println("\nHas the prisoner calls permission? (si/no): ");
							String calls = read.nextLine();
							if(calls.equals("si")) {jsonObject2.put("Llamadas",1);}else {jsonObject2.put("Llamadas",0);}
						break;
					    default:
							System.out.println("That is not a valid selection.");
						break;
					}
			
				String newId = (String) jsonObject2.get("Num_Preso");
				jsonObject.put(newId,id);
				jsonObject.remove(id);
				jsonObject.put(newId,jsonObject2);
				try (FileWriter file = new FileWriter("src/Ejemplo_presos.json")) {

	                file.write(jsonObject.toJSONString());
	                file.flush();
					System.out.println("Prisoner updated.");

	            } catch (IOException e) {
	                e.printStackTrace();
	            }
			}
			else{System.out.println("There is no prisoner registered with that number.");}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
