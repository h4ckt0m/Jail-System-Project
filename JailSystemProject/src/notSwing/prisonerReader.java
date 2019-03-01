
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Scanner;

public class prisonerReader {

	public static void main(String[] args) {
		
		JSONParser parser = new JSONParser();
		try {
            Object object = parser.parse(new FileReader("src/Ejemplo_presos.json"));
            
            //convert Object to JSONObject
            
            JSONObject jsonObject = (JSONObject)object;
            
            //Reading the String
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
					if(Visitas==1) {System.out.println("Visitas: sí");}
					else {System.out.println("Visitas: no");}
					if(Llamadas==1) {System.out.println("Llamadas: sí");}
					else {System.out.println("Llamadas: no");}
					
			}
			else{System.out.println("There is no prisoner registered with that number.");}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
}}
