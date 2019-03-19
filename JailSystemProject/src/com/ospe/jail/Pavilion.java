package notSwing;

public class Pavilion {

	protected int numero_celdas;
	protected int pavilion;
	protected int numero_guardias;
	protected int numero_presos;
	protected String salas_cercanas;
	
	
	//Constructors
	
	public Pavilion() {
		
	}
	
	public Pavilion(int numero_celdas,int pavilion,int numero_guardias,
			int numero_presos,String salas_cercanas) {
		
		this.numero_celdas = numero_celdas;
		this.pavilion = pavilion;
		this.numero_guardias = numero_guardias;
		this.numero_presos = numero_presos;
		this.salas_cercanas = salas_cercanas;
		
	}
	
	//Getters and Setters

	public int getNumero_celdas() {
		return numero_celdas;
	}

	public void setNumero_celdas(int numero_celdas) {
		this.numero_celdas = numero_celdas;
	}

	public int getPavilion() {
		return pavilion;
	}

	public void setPavilion(int pavilion) {
		this.pavilion = pavilion;
	}

	public int getNumero_guardias() {
		return numero_guardias;
	}

	public void setNumero_guardias(int numero_guardias) {
		this.numero_guardias = numero_guardias;
	}

	public int getNumero_presos() {
		return numero_presos;
	}

	public void setNumero_presos(int numero_presos) {
		this.numero_presos = numero_presos;
	}

	public String getSalas_cercanas() {
		return salas_cercanas;
	}

	public void setSalas_cercanas(String salas_cercanas) {
		this.salas_cercanas = salas_cercanas;
	}
	
	
	
	
	
}
