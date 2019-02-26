package notSwing;

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Menu {

	boolean exit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu menu = new Menu();
		menu.runMenu();

	}

	private void log_menu_eng() {
		Scanner sceng = new Scanner(System.in);
		System.out.println("+-----------------------------------+");
		System.out.println("|       Welcome,please log in       |");
		System.out.println("|          into the system          |");
		System.out.println("+-----------------------------------+");
		System.out.println("\nInsert user: ");
		String us = sceng.nextLine();
		System.out.println("\nInsert password: ");
		String passw = sceng.nextLine();
		
		
	}
	
	private void log_menu_esp() {
		Scanner scesp = new Scanner(System.in);
		System.out.println("+-----------------------------------+");
		System.out.println("|  Bienvenido,por favor introduzca  |");
		System.out.println("|  sus credenciales en el sistema   |");
		System.out.println("+-----------------------------------+");
		System.out.println("\nIntroduzca el usuario: ");
		String us = scesp.nextLine();
		System.out.println("\nInserte la contraseña: ");
		String passw = scesp.nextLine();
	}

	private void printHeader() {
		System.out.println("+-----------------------------------+");
		System.out.println("|       Welcome to Jail System      |");
		System.out.println("|        Security Project App       |");
		System.out.println("+-----------------------------------+");
	}

	private void printMenu() {
		System.out.println("\nPlease make a selection");
		System.out.println("1) Register Management");
		System.out.println("2) Searching");
		System.out.println("3) Stats");
		System.out.println("4) Export / Import");
		System.out.println("5) Mail");
		System.out.println("0) Exit");
	}

	public void runMenu() {
		select_language();
		printHeader();
		while (!exit) {
			printMenu();
			int choice = getInput();
			performAction(choice);
		}
	}

	public void select_language() {
		Scanner sclang = new Scanner(System.in);
		System.out.println("Seleccione su idioma / Select your language: 1.Español  2.English ");
		System.out.println("\n");
		
		int opt = sclang.nextInt();
		try {
			if (opt == 1) {
				System.out.println("Ha seleccionado el idioma español");
				System.out.println("\n");
				log_menu_esp();
			}else {
				System.out.println("You have selected the english language");
				log_menu_eng();
			}
		} catch(Exception e){
			System.out.println("Error escriba la opcion de nuevo / Error write the option again");
			
		}	
	}
	

	public void JSON_Reader() {
		JSONParser parser = new JSONParser();
		try {
			Object object = parser.parse(new FileReader(
					"C:\\Users\\Admin\\Desktop\\Eclipse Workspace\\JSP_Local\\src\\notSwing\\users.json"));

			// convert Object to JSONObject
			JSONObject jsonObject = (JSONObject) object;

			// Reading the String
			String id_func = (String) jsonObject.get("Id_func");
			String password = (String) jsonObject.get("Password");
			boolean poweruser = (boolean) jsonObject.get("PowerUser");

			// Printing all the values
			System.out.println("Id_func: " + id_func);
			System.out.println("PowerUser: " + poweruser);
			System.out.println("Password:" + password);

		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void login() {

	}

	private int getInput() {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		while (choice < 0 || choice > 5) {
			try {
				System.out.println("\nEnter your choice:  ");
				choice = Integer.parseInt(sc.nextLine());

			} catch (NumberFormatException e) {
				System.out.println("Invalid selection. Please try again.");

			}
		}
		return choice;
	}

	private void performAction(int choice) {
		switch (choice) {

		case 0:
			exit = true;
			System.out.println("Thank you for using our application.");
			break;

		case 1:
			System.out.println("Option 1 Selected");
			break;

		case 2:
			System.out.println("Option 2 Selected");
			break;

		case 3:
			System.out.println("Option 3 Selected");
			break;

		case 4:
			System.out.println("Option 4 Selected");
			break;

		case 5:
			System.out.println("Option 5 Selected");
			break;

		default:
			System.out.println("An unknown error has ocurred.");
			break;
		}

	}
}