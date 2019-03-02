
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class prisonerWriter_newPrisoner {

	public static void main(String[] args) {

		//JSONObject obj = new JSONObject(src/Ejemplo_presos.json);
		JSONParser parser = new JSONParser();
		try {
            Object object = parser.parse(new FileReader("src/Ejemplo_presos.json"));
            JSONObject jsonObject = (JSONObject)object;
            Object object2 = parser.parse(new FileReader("src/nuevoPreso.json"));
            JSONObject jsonObject2 = (JSONObject)object2;
            Scanner read = new Scanner(System.in);
            
			System.out.println("\nInsert new prisoner DNI: ");
			String dni = read.nextLine();
			jsonObject2.put("DNI",dni);
			
			System.out.println("\nInsert new prisoner name: ");
			String name = read.nextLine();
			jsonObject2.put("Nombre",name);
			
			System.out.println("\nInsert new prisoner last names: ");
			String lNames = read.nextLine();
			jsonObject2.put("Apellidos",lNames);
			
			System.out.println("\nInsert new prisoner birth date (día/mes/año): ");
			String birth = read.nextLine();
			jsonObject2.put("Fecha_de_nacimiento",birth);
			
			System.out.println("\nInsert new prisoner nationality: ");
			String nat = read.nextLine();
			jsonObject2.put("Nacionalidad",nat);
			
			System.out.println("\nInsert new prisoner sex (h/m): ");
			String sex = read.nextLine();
			jsonObject2.put("Sexo(h/m)",sex);
			
			System.out.println("\nInsert new prisoner height (cm): ");
			String height = read.nextLine();
			jsonObject2.put("Altura(cm)",height);
			
			System.out.println("\nInsert new prisoner weight (kg): ");
			String weight = read.nextLine();
			jsonObject2.put("Peso(kg)",weight);
			
			System.out.println("\nInsert new prisoner number: ");
			String id = read.nextLine();
			jsonObject2.put("Num_Preso",id);
			
			System.out.println("\nInsert new prisoner threat level: ");
			String threat = read.nextLine();
			jsonObject2.put("Nivel_de_amenaza",threat);
			
			System.out.println("\nInsert new prisoner cell number: ");
			String cell = read.nextLine();
			jsonObject2.put("Num_de_celda",cell);
			
			System.out.println("\nInsert new prisoner crime description: ");
			String crime = read.nextLine();
			jsonObject2.put("Crimen",crime);
			
			System.out.println("\nInsert new prisoner time of condemnation (años, meses, días): ");
			String TC = read.nextLine();
			jsonObject2.put("Tiempo_condena",TC);
			
			System.out.println("\nInsert new prisoner entry date (día/mes/año): ");
			String entry = read.nextLine();
			jsonObject2.put("Ingreso",entry);
			
			System.out.println("\nHas the new prisoner visits permission? (si/no): ");
			String visits = read.nextLine();
			if(visits.equals("si")) {jsonObject2.put("Visitas",1);}else {jsonObject2.put("Visitas",0);}
						
			System.out.println("\nHas the new prisoner calls permission? (si/no): ");
			String calls = read.nextLine();
			if(calls.equals("si")) {jsonObject2.put("Llamadas",1);}else {jsonObject2.put("Llamadas",0);}
			
            jsonObject.put(id,object2);
            System.out.println("New prisoner saved");
            
            
            
            
            try (FileWriter file = new FileWriter("src/Ejemplo_presos.json")) {

                file.write(jsonObject.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
                       
		
	}

}
