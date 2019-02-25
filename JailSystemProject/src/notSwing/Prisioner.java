package notSwing;

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
	
	public Prisioner(int num_preso,int niv_amenaza,int num_celda,String condena,String crimen,
			String ingreso,boolean visitas,boolean llamadas) {
		super(nombre,apellidos,DNI,f_nac,nacionalidad,sexo,altura,peso);
		this.num_preso = num_preso;
		this.niv_amenaza = niv_amenaza;
		
	}
}
