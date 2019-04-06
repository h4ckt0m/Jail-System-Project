package com.ospe.jail;

import java.util.HashMap;
import java.text.DecimalFormat;

public class PrisonerStats {

	public static final int YEAR = 2019;
	DecimalFormat numberFormat = new DecimalFormat("#.##");

	public String Stats(HashMap<Integer, Prisoner> Prisoners) {
		double sumaAlturas = 0;
		double sumaAmenazas = 0;
		double sumaEdades = 0;
		for (Prisoner p : Prisoners.values()) {
			sumaAlturas = sumaAlturas + p.getAltura();
			sumaAmenazas = sumaAmenazas + p.getNiv_amenaza();
			sumaEdades = sumaEdades + (YEAR - (getTheDate(p.getF_nac())[2]));
		}
		double mediaAlturas = sumaAlturas / Prisoners.size();
		double mediaAmenazas = sumaAmenazas / Prisoners.size();
		double mediaEdades = sumaEdades / Prisoners.size();
		String s = "Media de alturas de los presos: " + numberFormat.format(mediaAlturas) + " cm"
				+ "\nMedia de niveles de amenaza de los presos: " + numberFormat.format(mediaAmenazas)
				+ "\nMedia de edades de los presos: " + numberFormat.format(mediaEdades) + " años";
		return s;
	}

	public int[] getTheDate(String s) {
		int[] date = new int[3];
		String dayS = Character.toString(s.charAt(0)) + Character.toString(s.charAt(1));
		String monthS = Character.toString(s.charAt(3)) + Character.toString(s.charAt(4));
		String yearS = Character.toString(s.charAt(6)) + Character.toString(s.charAt(7))
				+ Character.toString(s.charAt(8)) + Character.toString(s.charAt(9));
		try {
			date[0] = Integer.parseInt(dayS);
			date[1] = Integer.parseInt(monthS);
			date[2] = Integer.parseInt(yearS);
		} catch (NumberFormatException e) {
			System.out.println("Invalid date format");
		}

		return date;
	}
}
