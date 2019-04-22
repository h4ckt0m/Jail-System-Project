package com.ospe.jail;


public class Menu {
	public void menuPrincipal() {
		System.out.println("+-----------------------------------+");
		System.out.println("|       Welcome to Jail System      |");
		System.out.println("|        Security Project App       |");
		System.out.println("+-----------------------------------+");
		System.out.println("\nPlease make a selection: ");
		System.out.println("\n1) Register Management");
		System.out.println("2) Import database files in JSON");
		System.out.println("3) Export database files in CSV");
		System.out.println("4) Send files by email");
		System.out.println("0) Exit");
	}
	
	public void menuBasic() {
		System.out.println("+-----------------------------------+");
		System.out.println("|       Welcome to Jail System      |");
		System.out.println("|        Security Project App       |");
		System.out.println("+-----------------------------------+");
		System.out.println("\nPlease make a selection: ");
		System.out.println("\n1) Register Management");
		System.out.println("\n0) Exit");
	}
	
	public void seleccionTipoDato() {
		System.out.println("\nSelect the data type you want to work with: ");
		System.out.println("\n1) Prisoners");
		System.out.println("2) Civil Servants");
		System.out.println("3) Visitors");
		System.out.println("4) Cells");
		System.out.println("5) Pavilions");
		System.out.println("0) Go back");
	}

	public void gestorPresos() {
		System.out.println("\nSelect the action you want to perform: ");
		System.out.println("\n1) Show list of all prisoners");
		System.out.println("2) Read one prisoner");
		System.out.println("3) Create a new prisoner");
		System.out.println("4) Edit an existing prisoner");
		System.out.println("5) Delete an existing prisoner");
		System.out.println("6) Make a query");
		System.out.println("7) Show prisoner statistics");
		System.out.println("0) Go back");
	}
	public void gestorFuncionarios() {
		System.out.println("\nSelect the action you want to perform: ");
		System.out.println("\n1) Show list of all civil servants");
		System.out.println("2) Read one civil servant");
		System.out.println("3) Create a new civil servant");
		System.out.println("4) Edit an existing civil servant");
		System.out.println("5) Delete an existing civil servant");
		System.out.println("6) Make a query");
		System.out.println("7) Show civil servant statistics");
		System.out.println("0) Go back");
	}
	public void gestorVisitantes() {
		System.out.println("\nSelect the action you want to perform: ");
		System.out.println("\n1) Show list of all visitors");
		System.out.println("2) Read one visitor");
		System.out.println("3) Create a new visitor");
		System.out.println("4) Edit an existing visitor");
		System.out.println("5) Delete an existing visitor");
		System.out.println("6) Make a query");
		System.out.println("7) Show visitor statistics");
		System.out.println("0) Go back");
	}
	public void gestorCeldas() {
		System.out.println("\nSelect the action you want to perform: ");
		System.out.println("\n1) Show list of all cells");
		System.out.println("2) Read one cell");
		System.out.println("3) Create a new cell");
		System.out.println("4) Edit an existing cell");
		System.out.println("5) Delete an existing cell");
		System.out.println("6) Make a query");
		System.out.println("7) Show cell statistics");
		System.out.println("0) Go back");
	}
	public void gestorPabellones() {
		System.out.println("\nSelect the action you want to perform: ");
		System.out.println("\n1) Show list of all pavilions");
		System.out.println("2) Read one pavilion");
		System.out.println("3) Create a new pavilion");
		System.out.println("4) Edit an existing pavilion");
		System.out.println("5) Delete an existing pavilion");
		System.out.println("6) Show pavilion statistics");
		System.out.println("0) Go back");
	}	
}
