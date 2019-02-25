package notSwing;

import java.util.Scanner;

public class Menu {
	
	boolean exit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu menu = new Menu();
		menu.runMenu();
		
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
        System.out.println("5) Mail XDDD");
        System.out.println("0) Exit");
		
	}
	
	public void runMenu() {
		printHeader();
		while(!exit) {
			printMenu();
			int choice = getInput();
			performAction(choice);
		}
	}
	
	private int getInput() {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		while (choice < 0 || choice > 5) {
			try {
				System.out.println("\nEnter your choice:  ");
				choice = Integer.parseInt(sc.nextLine());
				
			}catch(NumberFormatException e){
				System.out.println("Invalid selection. Please try again.");
				
			}
		}
		return choice;
	}
	
	
	private int getUser() { //JSON User
		Scanner sc = new Scanner(System.in);
		int user = -1;
		while (choice < 0 || choice > 5) {
			try {
				System.out.println("\n  ");
				choice = Integer.parseInt(sc.nextLine());
				
			}catch(NumberFormatException e){
				System.out.println("");
				
			}
		}
		return user;
	}
	
	
	private int getPassword() { //JSON Pass
		Scanner sc = new Scanner(System.in);
		int password = -1;
		while (choice < 0 || choice > 5) {
			try {
				System.out.println("\nEnter your choice:  ");
				choice = Integer.parseInt(sc.nextLine());
				
			}catch(NumberFormatException e){
				System.out.println("Invalid selection. Please try again.");
				
			}
		}
		return password;
	}
	
	private void performAction(int choice) {
		switch(choice){
		
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
