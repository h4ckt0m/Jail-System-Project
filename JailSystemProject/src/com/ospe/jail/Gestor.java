package com.ospe.jail;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;

public class Gestor {

	
	static HashMap<Integer, Prisoner> Prisoners = new HashMap<Integer, Prisoner>();
	static HashMap<String, CivilServant> CivilServants = new HashMap<String, CivilServant>();
	static HashMap<String, Visitor> Visitors = new HashMap<String, Visitor>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrisonerStats ps = new PrisonerStats();
		Prisoner_IO pIO = new Prisoner_IO();
		JsonToHash();
		//System.out.println(Prisoners);
		System.out.println(ps.Stats(Prisoners));
		//pIO.editar(Prisoners);
		pIO.leerListado(Prisoners);
		pIO.realizarConsulta(Prisoners);
		importJson("preso","presos",1);
        pIO.leerListado(Prisoners);
		//HashToJson();
		
		//menu.runMenu();
	}
	
	public static void JsonToHash() {
		JSONParser parser = new JSONParser();
		Vector<String> llaves = new Vector();
		Gson gson = new Gson();
		Prisoner pr = new Prisoner();
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("src/com/ospe/jail/prisoners.json"));
			for (Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				llaves.addElement(key);
			}
			for (int i = 0; i < llaves.size(); i++) {
				JSONObject jsonObject2 = (JSONObject) jsonObject.get(llaves.elementAt(i));
				pr = (Prisoner) gson.fromJson(jsonObject2.toString(), Prisoner.class);
				Prisoners.put(pr.getNum_preso(), pr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void HashToJson() {
        try (FileWriter file = new FileWriter("src/com/ospe/jail/prisoners.json")) {
            Gson gson = new Gson();
            file.write(gson.toJson(Prisoners));
            file.flush();
            System.out.println("Changes saved.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void importJson(String s, String filename, int type) {// type=0 merge, type=1 new
		JSONParser parser = new JSONParser();
		Vector<String> llaves = new Vector();
		Gson gson = new Gson();
		Prisoner pr = new Prisoner();
		Object o = new Object();// el resto, una para cada tipo de objeto
		// MERGE:
		if (type == 1) {
			if (s == "preso") {
				Prisoners.clear();
			} // un else if para cada tipo de objeto
		}
		try {
			JSONObject jsonObject = (JSONObject) parser
					.parse(new FileReader("src/com/ospe/jail/" + filename + ".json"));
			for (Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				llaves.addElement(key);
			}
			for (int i = 0; i < llaves.size(); i++) {
				JSONObject jsonObject2 = (JSONObject) jsonObject.get(llaves.elementAt(i));
				if (s == "preso") {
					pr = (Prisoner) gson.fromJson(jsonObject2.toString(), Prisoner.class);
					Prisoners.put(pr.getNum_preso(), pr);
				} // un else if para cada tipo de objeto
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
