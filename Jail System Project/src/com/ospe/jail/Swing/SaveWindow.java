package com.ospe.jail.Swing;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.ospe.jail.CivilServant;
import com.ospe.jail.Gestor;
import com.ospe.jail.Pavilion;
import com.ospe.jail.Visitor;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.HashMap;

import javax.swing.Action;

public class SaveWindow {
	private HashMap<Integer, Pavilion> Pavilions;
	private HashMap<String, CivilServant> CivilServants;
	private HashMap<String, Visitor> Visitors;
	JFrame frame;
	private final Action saveExit = new SwingAction();
	private final Action notExit = new SwingAction_1();

	public HashMap<Integer, Pavilion> getPavilions() {
		return Pavilions;
	}

	public void setPavilions(HashMap<Integer, Pavilion> pavilions) {
		Pavilions = pavilions;
	}

	public HashMap<String, CivilServant> getCivilServants() {
		return CivilServants;
	}

	public void setCivilServants(HashMap<String, CivilServant> civilServants) {
		CivilServants = civilServants;
	}

	public HashMap<String, Visitor> getVisitors() {
		return Visitors;
	}

	public void setVisitors(HashMap<String, Visitor> visitors) {
		Visitors = visitors;
	}

	public SaveWindow(HashMap<Integer, Pavilion> pavilions,HashMap<String, CivilServant> civilServants,HashMap<String, Visitor> visitors) {
		initialize(pavilions,civilServants,visitors);
	}
	
	private void initialize(HashMap<Integer, Pavilion> Pavs,HashMap<String, CivilServant> Civils,HashMap<String, Visitor> Visits) {
		setCivilServants(Civils);
		setPavilions(Pavs);
		setVisitors(Visits);
		frame = new JFrame();
		frame.setTitle("Jail System Project - Confirm exit");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\minilogo.png"));
		frame.setSize(380, 211);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Do you want to save changes?");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(36, 11, 283, 77);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setAction(saveExit);
		btnNewButton.setBounds(62, 113, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setAction(notExit);
		btnNewButton_1.setBounds(195, 113, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Yes");
			putValue(SHORT_DESCRIPTION, "Save and exit");
		}
		public void actionPerformed(ActionEvent e) {
			Gestor ge = new Gestor();
			ge.setCivilServants(CivilServants);
			ge.setPavilions(Pavilions);
			ge.setVisitors(Visitors);
			ge.HashToJson(0, "prisondb", "database/");
			ge.HashToJson(1, "civilservants", "database/");
			ge.HashToJson(2, "visitors", "database/");
			System.exit(0);
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "No");
			putValue(SHORT_DESCRIPTION, "Not save and exit");
		}
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
