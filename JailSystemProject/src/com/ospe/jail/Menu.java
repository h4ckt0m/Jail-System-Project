package com.ospe.jail;


import java.util.Scanner;
import java.util.Vector;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import com.google.gson.Gson;
import com.ospe.jail.Menu;
import com.ospe.jail.Person;
import com.ospe.jail.Prisoner;


public class Menu {

	boolean exit;
	boolean power = false;
	static Login log = new Login();
	static Prisoner p = new Prisoner();
	static HashMap Prisoners = new HashMap();

	private void log_menu_eng() {

		System.out.println("+-----------------------------------+");
		System.out.println("|       Welcome,please log in       |");
		System.out.println("|          into the system          |");
		System.out.println("+-----------------------------------+");

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

	private void printHeadereng() {
		System.out.println("+-----------------------------------+");
		System.out.println("|       Welcome to Jail System      |");
		System.out.println("|        Security Project App       |");
		System.out.println("+-----------------------------------+");
	}

	private void printHeaderesp() {
		System.out.println("+-----------------------------------+");
		System.out.println("|       Bienvenido a Jail System    |");
		System.out.println("|        Security Project App       |");
		System.out.println("+-----------------------------------+");
	}

		
	
//Ejecucion principal programa
	public void runMenu() {
		log_menu_eng();
		int ret = -1;
		while (ret == -1) {
			ret = log.login();
			if (ret == 1) {
				printHeadereng();
				power = true;
				while (!exit) {
					log.printMenuPower();
					int choice = getInput();
					performAction(choice);
				}

			} else if (ret == 0) {
				printHeadereng();
				power = false;
				while (!exit) {
					log.printMenu();
					int choice = getInput();
					performAction(choice);
				}
			}
		}
	}

	
	public static void JsonToHash() {
        JSONParser parser = new JSONParser();
        Vector<String> llaves = new Vector();
        Gson gson = new Gson();
        Prisoner pr = new Prisoner();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("src/com/ospe/jail/prisoners.json"));
            for (Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext();) {
                String key = (String) iterator.next();
                llaves.addElement(key);
            }
            for (int i = 0; i < llaves.size(); i++) {
                JSONObject jsonObject2 = (JSONObject) jsonObject.get(llaves.elementAt(i));
                pr = (Prisoner) gson.fromJson(jsonObject2.toString(), Prisoner.class);
                Prisoners.put(pr.getNum_preso(), pr);
                System.out.println(Prisoners);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
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
			System.out.println("\nThank you for using our application.");
			break;

		case 1:
			System.out.println("\nOption 1 Selected");
			while (!exit) {
				log.printMenuRegister();
				System.out.println("\nEnter your choice: ");
				Scanner optm1 = new Scanner(System.in);
				int opcion = optm1.nextInt();
				switch(opcion) {
			
				case 0:
					
					if (power == true) {
						printHeadereng();
						while (!exit) {
							log.printMenuPower();
							int choice2 = getInput();
							performAction(choice2);
						}

					} else if (power == false) {
						printHeadereng();
						while (!exit) {
							log.printMenu();
							int choice2 = getInput();
							performAction(choice2);
						}
					}
					break;

				case 1:
					//p.newPrisoner();
					break;

				case 2:
					//p.prisonerReader();
					break;

				case 3:
					//p.prisonerEditor();
					break;

				case 4:
					//p.prisonerDeleter();
					break;

				default:
					System.out.println("\nAn unknown error has ocurred");

				}

			}
			break;

		case 2:
			System.out.println("\nOption 2 Selected");
			break;

		case 3:
			System.out.println("\nOption 3 Selected");
			break;

		case 4:
			System.out.println("\nOption 4 Selected");
			break;

		case 5:
			System.out.println("\nOption 5 Selected");
			break;

		default:
			System.out.println("\nAn unknown error has ocurred.");
			break;
		}

	}
}





