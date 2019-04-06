package com.ospe.jail;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.util.Vector;
import java.util.Iterator;
import java.util.Scanner;
import java.text.DecimalFormat;

public class EjemplosEstadisticas {
	static Vector<String> llaves = new Vector();
	public static final int YEAR = 2019;

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		DecimalFormat numberFormat = new DecimalFormat("#.##");
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("src/prisoners.json"));
			double sumaAlturas = 0;
			double mediaAlturas = 0;
			double sumaAmenazas = 0;
			double mediaAmenazas = 0;
			double sumaEdades = 0;
			double mediaEdades = 0;
			for (Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				llaves.addElement(key);
			}
			for (int i = 0; i < llaves.size(); i++) {
				JSONObject jsonObject2 = (JSONObject) jsonObject.get(llaves.elementAt(i));
				sumaAlturas += Double.parseDouble((String) jsonObject2.get("Altura(cm)"));
				sumaAmenazas += Double.parseDouble((String) jsonObject2.get("Nivel_de_amenaza"));
				sumaEdades += (YEAR - ((getTheDate((String) jsonObject2.get("Fecha_de_nacimiento")))[2]));
			}
			mediaAlturas = sumaAlturas / llaves.size();
			mediaAmenazas = sumaAmenazas / llaves.size();
			mediaEdades = sumaEdades / llaves.size();
			System.out.println("Media de alturas de los presos: " + numberFormat.format(mediaAlturas) + " cm");
			System.out.println("Media de niveles de amenaza de los presos: " + numberFormat.format(mediaAmenazas));
			System.out.println("Media de edades de los presos: " + numberFormat.format(mediaEdades) + " años");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static int[] getTheDate(String s) {
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
