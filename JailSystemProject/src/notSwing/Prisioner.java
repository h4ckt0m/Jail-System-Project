package notSwing;

import notSwing.Person;

public class Prisioner extends Person {

	private int num_preso;
	private int niv_amenaza;
	private int num_celda;
	private String condena;
	private String crimen;
	private String ingreso;
	private boolean visitas;
	private boolean llamadas;
	
	
	
	//Constructors
	
	public Prisioner() {
		super();
	}
	
	public Prisioner(String nombre,String apellidos,String DNI,String f_nac,String nacionalidad,
			String sexo,float altura,float peso,int num_preso,int niv_amenaza,int num_celda,String condena,String crimen,
			String ingreso,boolean visitas,boolean llamadas) {
		super(nombre,apellidos,DNI,f_nac,nacionalidad,sexo,altura,peso);
		this.num_preso = num_preso;
		this.niv_amenaza = niv_amenaza;
		
	}
	
	//Getter and Setters

	public int getNum_preso() {
		return num_preso;
	}

	public void setNum_preso(int num_preso) {
		this.num_preso = num_preso;
	}

	public int getNiv_amenaza() {
		return niv_amenaza;
	}

	public void setNiv_amenaza(int niv_amenaza) {
		this.niv_amenaza = niv_amenaza;
	}

	public int getNum_celda() {
		return num_celda;
	}

	public void setNum_celda(int num_celda) {
		this.num_celda = num_celda;
	}

	public String getCondena() {
		return condena;
	}

	public void setCondena(String condena) {
		this.condena = condena;
	}

	public String getCrimen() {
		return crimen;
	}

	public void setCrimen(String crimen) {
		this.crimen = crimen;
	}

	public String getIngreso() {
		return ingreso;
	}

	public void setIngreso(String ingreso) {
		this.ingreso = ingreso;
	}

	public boolean isVisitas() {
		return visitas;
	}

	public void setVisitas(boolean visitas) {
		this.visitas = visitas;
	}

	public boolean isLlamadas() {
		return llamadas;
	}

	public void setLlamadas(boolean llamadas) {
		this.llamadas = llamadas;
	}
	
	
	
	
	

}
