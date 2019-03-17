import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Scanner;

public class PrisonerEditor {
	static Prisoner p = new Prisoner();
	static boolean exit = false;
	static Scanner read = new Scanner(System.in);
	static PrisonerEditor t = new PrisonerEditor();

	public static void main(String[] args) {

		while (!exit) {
			t.printMenuRegister();
			int ch = read.nextInt();
			t.performAction(ch);
		}
	}

	private void printMenuRegister() {
		System.out.println("\nPlease select an option: ");
		System.out.println("\n1) Create a new register of a prisoner");
		System.out.println("\n2) Read info of a prisoner");
		System.out.println("\n3) Update the info of a prisoner");
		System.out.println("\n4) Delete a register of a prisoner");
		System.out.println("\n0) Go back");
	}

	private void performAction(int choice) {
		switch (choice) {

		case 0:
			exit = true;
			System.out.println("\nThank you for using our application.");
			break;

		case 1:
			p.newPrisoner();
			break;

		case 2:
			p.prisonerReader();
			break;

		case 3:
			p.prisonerEditor();
			break;

		case 4:
			p.prisonerDeleter();
			break;

		default:
			System.out.println("\nNot a valid option.");
			break;
		}

	}
}
