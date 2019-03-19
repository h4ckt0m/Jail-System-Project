package test;

public class Visitor extends Person {

	protected String preso_visitado;
	protected String fecha_visita;
	protected String hora_visita;
	protected String relacion_preso;
	protected int numero_visitantes;
	protected String solicitante_visita;
	
	
	//Constructors
	
	public Visitor() {
		super();
	}
	
	
	public Visitor(String nombre, String apellidos, String DNI, String f_nac, String nacionalidad, String sexo,
			float altura, float peso,String preso_visitado,String fecha_visita,String hora_visita,String relacion_preso,
			int numero_visitantes,String solicitante_visita) {
		
		super(nombre, apellidos, DNI, f_nac, nacionalidad, sexo, altura, peso);
		this.preso_visitado = preso_visitado;
		this.fecha_visita = fecha_visita;
		this.hora_visita = hora_visita;
		this.relacion_preso = relacion_preso;
		this.numero_visitantes = numero_visitantes;
		this.solicitante_visita = solicitante_visita;
		
		
	}

	//Getters and Setters

	public String getPreso_visitado() {
		return preso_visitado;
	}


	public void setPreso_visitado(String preso_visitado) {
		this.preso_visitado = preso_visitado;
	}


	public String getFecha_visita() {
		return fecha_visita;
	}


	public void setFecha_visita(String fecha_visita) {
		this.fecha_visita = fecha_visita;
	}


	public String getHora_visita() {
		return hora_visita;
	}


	public void setHora_visita(String hora_visita) {
		this.hora_visita = hora_visita;
	}


	public String getRelacion_preso() {
		return relacion_preso;
	}


	public void setRelacion_preso(String relacion_preso) {
		this.relacion_preso = relacion_preso;
	}


	public int getNumero_visitantes() {
		return numero_visitantes;
	}


	public void setNumero_visitantes(int numero_visitantes) {
		this.numero_visitantes = numero_visitantes;
	}


	public String getSolicitante_visita() {
		return solicitante_visita;
	}


	public void setSolicitante_visita(String solicitante_visita) {
		this.solicitante_visita = solicitante_visita;
	}
	
	
	
	
}
