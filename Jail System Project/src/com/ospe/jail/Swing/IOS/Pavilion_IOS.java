package com.ospe.jail.Swing.IOS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.ospe.jail.Cell;
import com.ospe.jail.Gestor;
import com.ospe.jail.Pavilion;
import com.ospe.jail.IO.Cell_IO;
import com.ospe.jail.IO.Pavilion_IO;
import com.ospe.jail.Swing.MessageWindow;

public class Pavilion_IOS {
	HashMap<Integer, Pavilion> Pavilions;
	HashMap<Integer, Cell> Query;
	private JFrame frame;
	private JTextField textField;
	JTextArea textArea = new JTextArea();
	private JTextField guardstxt;
	private JTextField comtxt;
	private JTextField numbertxt;
	JButton btnNewButton_1 = new JButton();
	JCheckBox ovCheckbox;
	private Pavilion edpa;
	private JTextField textField_1;
	private final Action search = new SwingAction();
	private final Action saveNew = new SwingAction_1();
	private final Action editSearch = new SwingAction_2();
	private final Action saveEdit = new SwingAction_3();
	private final Action delete = new SwingAction_4();
	public HashMap<Integer, Pavilion> getPavilions() {
		return Pavilions;
	}

	public void setPavilions(HashMap<Integer, Pavilion> pavilions) {
		Pavilions = pavilions;
	}

	public Pavilion getEdpa() {
		return edpa;
	}

	public void setEdpa(Pavilion edpa) {
		this.edpa = edpa;
	}

	public Pavilion_IOS(JFrame frame) {
		this.frame=frame;
		//initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Jail System Project - Login");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\minilogo.png"));
		frame.setBounds(250, 100, 852, 550);
		Gestor m = new Gestor();
		JPanel MainPanel = new JPanel();
		frame.getContentPane().add(MainPanel, BorderLayout.CENTER);
		MainPanel.setLayout(null);
		JTree powerTree = new JTree();
		powerTree.setForeground(SystemColor.menu);
		powerTree.setBorder(new LineBorder(new Color(0, 0, 0)));
		powerTree.setFont(new Font("Tahoma", Font.PLAIN, 11));
		powerTree.setBackground(Color.WHITE);
		powerTree.setBounds(0, 0, 157, 511);
		MainPanel.add(powerTree);
		MainPanel.add(editar(m.getPavilions()));
	}
	public JPanel leer(HashMap<Integer, Pavilion> pavilions) {
		setPavilions(pavilions);
		JPanel leer = new JPanel();
		leer.setBounds(0, 0, 836, 511);
		leer.setVisible(true);
		leer.setLayout(null);

		JLabel lblNewLabel = new JLabel("READ ONE PAVILION");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 239, 37);
		leer.add(lblNewLabel);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() == '\n') {
					search.actionPerformed(null);
				}
			}
		});
		textField.setBounds(257, 102, 180, 20);
		leer.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Insert pavilion number:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(257, 73, 132, 18);
		leer.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setAction(search);
		btnNewButton.setBounds(447, 101, 84, 23);
		leer.add(btnNewButton);
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JScrollPane sp = new JScrollPane(textArea);
		sp.setBounds(257, 148, 429, 336);
		sp.setBackground(SystemColor.menu);
		leer.add(sp);
		
		return leer;
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Search");
			putValue(SHORT_DESCRIPTION, "Search one cell");
		}

		public void actionPerformed(ActionEvent e) {
			try {
			int id = Integer.parseInt(textField.getText());
			if (Pavilions.containsKey(id)) {
				textArea.setText(Pavilions.get(id).toString());
			} else {
				textArea.setText("There is no pavilion registered with that number.");
			}
		}catch(Exception exc) {
			MessageWindow m = new MessageWindow("Format error", "Introduce a valid pavilion number");
			m.frame.setVisible(true);	
		}
		}
	}
public JPanel crear(HashMap<Integer, Pavilion> pavilions) {
		
		setPavilions(pavilions);
		JPanel crear = new JPanel();
		crear.setBounds(0, 0, 836, 511);
		crear.setVisible(true);
		crear.setLayout(null);

		JLabel lblNewLabel = new JLabel("CREATE A NEW PAVILION");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 335, 37);
		crear.add(lblNewLabel);

		JLabel guardN = new JLabel("Number of guards:");
		guardN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		guardN.setHorizontalAlignment(SwingConstants.RIGHT);
		guardN.setBounds(308, 177, 116, 28);
		crear.add(guardN);

		JLabel comR = new JLabel("Number of community rooms:");
		comR.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comR.setHorizontalAlignment(SwingConstants.RIGHT);
		comR.setBounds(234, 235, 190, 28);
		crear.add(comR);

		guardstxt = new JTextField();
		guardstxt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		guardstxt.setBounds(434, 181, 94, 20);
		crear.add(guardstxt);
		guardstxt.setColumns(10);

		comtxt = new JTextField();
		comtxt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comtxt.setBounds(434, 239, 94, 20);
		crear.add(comtxt);
		comtxt.setColumns(10);

		JLabel pavN = new JLabel("Pavilion Number:");
		pavN.setHorizontalAlignment(SwingConstants.RIGHT);
		pavN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pavN.setBounds(308, 130, 116, 14);
		crear.add(pavN);

		numbertxt = new JTextField();
		numbertxt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		numbertxt.setBounds(435, 127, 93, 20);
		crear.add(numbertxt);
		numbertxt.setColumns(10);

		btnNewButton_1.setAction(saveNew);
		btnNewButton_1.setBounds(655, 417, 89, 23);
		crear.add(btnNewButton_1);
		setEditar(true);
		return crear;
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Save new pavilion");
		}

		public void actionPerformed(ActionEvent e) {
			Pavilion pa=new Pavilion();
			savePavilion(pa, "new");
		}
	}

	public void savePavilion(Pavilion pa, String mode) {
		try {
			boolean ov = true;
			
			pa.setNum_guardias(Integer.parseInt(guardstxt.getText()));
			
			pa.setNum_salasComunes(Integer.parseInt(comtxt.getText()));
			
			if (mode.equals("edit")) {
					if (!(Pavilions.containsKey(Integer.parseInt(numbertxt.getText())))) {//si el nuevo nº no esta en cells
						Pavilions.remove(pa.getNum_pabellon());// aunque de normal se reescribe, si cambia el nÂº preso
															// quedarian los dos, asi
						// que hay que borrar el antiguo
						pa.setNum_pabellon(Integer.parseInt(numbertxt.getText()));
					} else {//si el nuevo nº existe ya
						if (!(Integer.parseInt(numbertxt.getText()) == pa.getNum_pabellon())) {//si el nuevo nº no es igual al antiguo(overwrite)
							if (!(ovCheckbox.isSelected())) {
								ov = false;
								MessageWindow over = new MessageWindow("Save cancelled",
										"Overwrite existing pavilion option not selected");
								over.frame.setVisible(true);
							} else {
								Pavilions.remove(pa.getNum_pabellon());// aunque de normal se reescribe, si cambia el nÂº
																	// preso quedarian los dos, asi
								// que hay que borrar el antiguo
								pa.setNum_pabellon(Integer.parseInt(numbertxt.getText()));
							}
						}
					}
				}
				else {
				if (Pavilions.containsKey(Integer.parseInt(numbertxt.getText()))) {
					ov = false;
					MessageWindow over = new MessageWindow("Pavilion number in use",
							"Delete existing pavilion to use that number");
					over.frame.setVisible(true);
				}}
				if(ov) {
				pa.setNum_pabellon(Integer.parseInt(numbertxt.getText()));
				pa.setNum_celdas();
				pa.setNum_presos();
				Pavilions.put(pa.getNum_pabellon(), pa);
				MessageWindow saved = new MessageWindow("Pavilion saved", "");
				saved.frame.setVisible(true);
				}
		} catch (Exception ex) {
			MessageWindow err = new MessageWindow("Format error ocurred", "");
			err.frame.setVisible(true);
		}
	}
	
	public JPanel editar(HashMap<Integer, Pavilion> pavilions) {
		setPavilions(pavilions);
		
		JPanel crear = new JPanel();
		crear.setBounds(0, 0, 836, 511);
		crear.setVisible(true);
		crear.setLayout(null);

		JLabel lblNewLabel = new JLabel("EDIT AN EXISTING PAVILION");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 335, 37);
		crear.add(lblNewLabel);

		JLabel guardN = new JLabel("Number of guards:");
		guardN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		guardN.setHorizontalAlignment(SwingConstants.RIGHT);
		guardN.setBounds(308, 177, 116, 28);
		crear.add(guardN);

		JLabel comR = new JLabel("Number of community rooms:");
		comR.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comR.setHorizontalAlignment(SwingConstants.RIGHT);
		comR.setBounds(234, 235, 190, 28);
		crear.add(comR);

		guardstxt = new JTextField();
		guardstxt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		guardstxt.setBounds(434, 181, 94, 20);
		crear.add(guardstxt);
		guardstxt.setColumns(10);

		comtxt = new JTextField();
		comtxt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comtxt.setBounds(434, 239, 94, 20);
		crear.add(comtxt);
		comtxt.setColumns(10);

		JLabel pavN = new JLabel("Pavilion Number:");
		pavN.setHorizontalAlignment(SwingConstants.RIGHT);
		pavN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pavN.setBounds(308, 130, 116, 14);
		crear.add(pavN);

		numbertxt = new JTextField();
		numbertxt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		numbertxt.setBounds(435, 127, 93, 20);
		crear.add(numbertxt);
		numbertxt.setColumns(10);

		btnNewButton_1.setAction(saveEdit);
		btnNewButton_1.setBounds(655, 417, 89, 23);
		crear.add(btnNewButton_1);
		setEditar(true);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setAction(editSearch);
		btnNewButton_2.setBounds(543, 127, 89, 23);
		crear.add(btnNewButton_2);
		numbertxt.setEditable(true);

		ovCheckbox = new JCheckBox("Overwrite if number");
		ovCheckbox.setBounds(638, 128, 169, 23);
		crear.add(ovCheckbox);
		
		JLabel lblNewLabel_6 = new JLabel(" already exists");
		lblNewLabel_6.setBounds(658, 148, 89, 14);
		crear.add(lblNewLabel_6);
		
		setEditar(false);
		
		return crear;
	}
	
	
public void setEditar(boolean a) {
		
		guardstxt.setEditable(a);
		guardstxt.setText("");

		comtxt.setEditable(a);
		guardstxt.setText("");

		btnNewButton_1.setEnabled(a);

	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Search");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {

			int id = Integer.parseInt(numbertxt.getText());
			
			if (Pavilions.containsKey(id)) {
				setEditar(true);
				setEdpa(Pavilions.get(id));
				numbertxt.setText(edpa.getNum_pabellon() + "");

				guardstxt.setText(edpa.getNum_guardias() + "");
				
				comtxt.setText(edpa.getNum_salasComunes() + "");
				
			} else {
				setEditar(false);
				MessageWindow m = new MessageWindow("Invalid pavilion number", "There is no pavilion with that number");
				numbertxt.setText("");
				m.frame.setVisible(true);
			}
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Save edited pavilion");
		}

		public void actionPerformed(ActionEvent e) {
			savePavilion(edpa, "edit");
		}
	}
	public JPanel borrar(HashMap<Integer, Pavilion> pavilions) {

		setPavilions(pavilions);

		JPanel borrar = new JPanel();
		borrar.setBounds(0, 0, 836, 511);
		borrar.setVisible(true);
		borrar.setLayout(null);

		JLabel lblNewLabel = new JLabel("DELETE AN EXISTING PAVILION");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 335, 37);
		borrar.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setBounds(285, 237, 223, 30);
		borrar.add(textField_1);
		textField_1.setColumns(10);
		
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() == '\n') {
					delete.actionPerformed(null);
				}
			}
		});

		JLabel lblNewLabel_7 = new JLabel("Insert the number of the pavilion you want to delete:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(285, 189, 367, 37);
		borrar.add(lblNewLabel_7);

		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setAction(delete);
		btnNewButton_3.setBounds(540, 237, 103, 28);
		borrar.add(btnNewButton_3);

		return borrar;
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Delete");
			putValue(SHORT_DESCRIPTION, "Delete pavilion");
		}

		public void actionPerformed(ActionEvent e) {
			try {
			int id = Integer.parseInt(textField_1.getText());
			if (Pavilions.containsKey(id)) {
				if (Pavilions.get(id).getNum_celdas() == 0) {
					Pavilions.remove(id);
					MessageWindow m = new MessageWindow("Pavilion deleted", "");
					m.frame.setVisible(true);
					textField_1.setText("");
				} else {
					MessageWindow m = new MessageWindow("Error", "Pavilion selected is not empty and will not be deleted");
					m.frame.setVisible(true);
					textField_1.setText("");
				}
				
			} else {
				MessageWindow m = new MessageWindow("Invalid pavilion", "There is no pavilion with that number");
				m.frame.setVisible(true);
				textField_1.setText("");
			}
		}catch(Exception es){
			MessageWindow m = new MessageWindow("Format error ocurred", "Introduce a number");
			m.frame.setVisible(true);
		}	
		}
	}
	public JPanel leerListado(HashMap<Integer, Pavilion> pavilions) {

		setPavilions(pavilions);

		JPanel leerListado = new JPanel();
		leerListado.setBounds(0, 0, 836, 511);
		leerListado.setVisible(true);
		leerListado.setLayout(null);

		JLabel lblNewLabel = new JLabel("READ LIST OF ALL PAVILIONS");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 335, 37);
		leerListado.add(lblNewLabel);
		
		JTextArea txtrSafdSdfSdfds = new JTextArea();
		txtrSafdSdfSdfds.setFont(new Font("Monospaced", Font.PLAIN, 14));
		String s="";
		ArrayList<Integer> orderedC = new ArrayList<Integer>();
		for (int i : Pavilions.keySet()) {
			orderedC.add(i);
		}
		Collections.sort(orderedC);
		for(int a=0;a<Pavilions.size();a++) {
			Pavilion pa=Pavilions.get(orderedC.get(a));
			s=s+pa.getNum_pabellon() + ", " + pa.getNum_celdas() + " celdas, " + pa.getNum_presos() + " presos\r\n";
		}
		txtrSafdSdfSdfds.setText(s);
		txtrSafdSdfSdfds.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtrSafdSdfSdfds.setBounds(268, 110, 455, 391);
		
		JScrollPane sp = new JScrollPane(txtrSafdSdfSdfds);
		sp.setBounds(268, 110, 455, 370);
		sp.setBackground(SystemColor.menu);
		leerListado.add(sp);
		
		JLabel lblNewLabel_8 = new JLabel("Current number of pavilions in the database: "+Pavilions.size());
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(268, 73, 324, 26);
		leerListado.add(lblNewLabel_8);
		
		return leerListado;
	}
	public JPanel stats(HashMap<Integer, Pavilion> pavilions) {

		setPavilions(pavilions);

		JPanel stats = new JPanel();
		stats.setBounds(0, 0, 836, 511);
		stats.setVisible(true);
		stats.setLayout(null);

		JLabel lblNewLabel = new JLabel("PAVILION STATISTICS");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 335, 37);
		stats.add(lblNewLabel);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Pavilion_IO paio=new Pavilion_IO();
		textArea_1.setText(paio.stats(Pavilions));
		JScrollPane sp = new JScrollPane(textArea_1);
		sp.setBounds(257, 168, 505, 223);
		sp.setBackground(SystemColor.menu);
		stats.add(sp);

		return stats;
	}
}
