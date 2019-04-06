package com.ospe.jail;

import java.io.FileReader;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Login {
	
	
	public int login() {
		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader("src/com/ospe/jail/users.json"));

			JSONObject jsonObject = (JSONObject) obj;
			Scanner sceng = new Scanner(System.in);
			System.out.println("\nInsert user: ");
			String us = sceng.nextLine();
			if (jsonObject.containsKey(us)) {
				JSONObject obj2 = (JSONObject) jsonObject.get(us);
				System.out.println("\nInsert password: ");
				String passw = sceng.nextLine();
				String passtest = (String) obj2.get("Password");
				String power = (String) obj2.get("PowerUser");
				if (passtest.equals(passw) && power.equals("True")) {
					System.out.println("\nCorrect Login");

					return 1;
				} else if (passtest.equals(passw) && power.equals("False")) {
					System.out.println("\nCorrect Login");

					return 0;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\nError login try again");
		return -1;

	}
	
	public void printMenuPower() {
		System.out.println("\nPlease make a selection: ");
		System.out.println("\n1) Register Management");
		System.out.println("\n2) Stats");
		System.out.println("\n3) Export");
		System.out.println("\n4) Import");
		System.out.println("\n5) Report by email");
		System.out.println("\n0) Exit");
	}
	
	public void printMenu() {
		System.out.println("\nPlease make a selection: ");
		System.out.println("\n1) Register Management");
		System.out.println("\n0) Exit");
	}
	
	public void printMenuRegister() {
		System.out.println("\nPlease select an option: ");
		System.out.println("\n1) Create a new register of a prisoner");
		System.out.println("\n2) Read info of a prisoner");
		System.out.println("\n3) Update the info of a prisoner");
		System.out.println("\n4) Delete a register of a prisoner");
		System.out.println("\n0) Go back");
	}

	
	
	
	
	
}
