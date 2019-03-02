
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Scanner;

public class prisonerDeleter {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
            Object object = parser.parse(new FileReader("src/Ejemplo_presos.json"));            
            JSONObject jsonObject = (JSONObject)object;
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
			}
			else {System.out.println("There is no prisoner with that number");}
	   }
		catch (Exception e) {
				e.printStackTrace();
			}
	}}

