package test;

public class CivilServant extends Person {

	protected String cargo;
	protected String id_funcionario;
	protected float sueldo;
	protected int pavilion_func;
	protected String turno;
	
	
	//Constructors
	
	public CivilServant() {
		super();
	}
	
	public CivilServant(String nombre, String apellidos, String DNI, String f_nac, String nacionalidad, String sexo,
			float altura, float peso,String cargo,String id_funcionario,float sueldo,int pavilion_func,String turno) {
		
		super(nombre, apellidos, DNI, f_nac, nacionalidad, sexo, altura, peso);
		this.cargo = cargo;
		this.id_funcionario = id_funcionario;
		this.sueldo = sueldo;
		this.pavilion_func = pavilion_func;
		this.turno = turno;
		
	}
	
	//Getters and Setters 

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(String id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public int getPavilion_func() {
		return pavilion_func;
	}

	public void setPavilion_func(int pavilion_func) {
		this.pavilion_func = pavilion_func;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	
	
	
	
	
}
