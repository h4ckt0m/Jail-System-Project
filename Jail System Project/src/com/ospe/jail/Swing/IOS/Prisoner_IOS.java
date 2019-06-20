package com.ospe.jail.Swing.IOS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.ospe.jail.Cell;
import com.ospe.jail.Gestor;
import com.ospe.jail.Prisoner;
import com.ospe.jail.IO.Prisoner_IO;
import com.ospe.jail.Swing.MessageWindow;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.event.ChangeEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

public class Prisoner_IOS {
	HashMap<Integer, Prisoner> Prisoners;
	HashMap<Integer, Cell> Cells;
	HashMap<Integer, Prisoner> Query;
	ArrayList<Integer> deleteos = new ArrayList<Integer>();
	private JFrame frame;
	private DecimalFormat numberFormat2 = new DecimalFormat("#");
	public static final int YEAR = 2019;
	private JTextField textField;
	private Prisoner edp;
	JTextArea textArea = new JTextArea();
	private final Action search = new SwingAction();
	private JTextField dnitxt;
	private JTextField nametxt;
	private JTextField lastnametxt;
	private JTextField birthtxt;
	private JTextField nationtext;
	private JTextField cmtxt;
	private JTextField kgtxt;
	private JTextField numbertxt;
	private JTextField celltxt;
	private JTextField crimetxt;
	private JTextField timetxt;
	private JTextField timetxt_2;
	private JTextField timetxt_3;
	private JTextField entrancetxt;
	private JTextField entrancetxt_2;
	private JTextField entrancetxt_3;
	private JTextField birthtxt_2;
	private JTextField birthtxt_3;
	JButton btnNewButton_1 = new JButton();
	JCheckBox checkBoxMale = new JCheckBox("Male");
	JCheckBox checkBoxFemale = new JCheckBox("Female");
	JCheckBox checkBoxVisits = new JCheckBox("");
	JCheckBox checkBoxCalls = new JCheckBox("");
	JCheckBox checkBox1 = new JCheckBox("1");
	JCheckBox checkBox2 = new JCheckBox("2");
	JCheckBox checkBox3 = new JCheckBox("3");
	JCheckBox ovCheckbox;
	String optRestriction;
	JCheckBox chckbxNewCheckBox_1;
	private final Action saveNew = new SwingAction_1();
	private final Action editSearch = new SwingAction_2();
	private final Action saveEdit = new SwingAction_3();
	private JTextField textField_1;
	private final Action delete = new SwingAction_4();
	private JTextField restxt1 = new JTextField();
	private final Action applyR = new SwingAction_5();
	private JTextField restxt2 = new JTextField();
	JPanel opt=new JPanel();
	JPanel restMenu = new JPanel();
	JPanel realizarConsulta = new JPanel();
	private final Action endQ = new SwingAction_6();
	JCheckBox chckbxNewCheckBox = new JCheckBox("Export query to CSV");
	JLabel lblNewLabel_10 = new JLabel("Example direction");
	JLabel lblNewLabel = new JLabel("MAKE A QUERY");
	private final Action back = new SwingAction_8();
	JTextArea consultastxt;
	JList list = new JList();
	boolean volver=false;
	
	public HashMap<Integer, Prisoner> getPrisoners() {
		return Prisoners;
	}

	public void setPrisoners(HashMap<Integer, Prisoner> prisoners) {
		Prisoners = prisoners;
	}

	public HashMap<Integer, Cell> getCells() {
		return Cells;
	}

	public void setCells(HashMap<Integer, Cell> cells) {
		Cells = cells;
	}
	public Prisoner_IOS(JFrame frame) {
		this.frame=frame;
	}
	public JPanel leer(HashMap<Integer, Prisoner> prisoners) {
		setPrisoners(prisoners);
		JPanel leer = new JPanel();
		leer.setBounds(0, 0, 836, 511);
		leer.setVisible(true);
		leer.setLayout(null);

		JLabel lblNewLabel = new JLabel("READ ONE PRISONER");
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

		JLabel lblNewLabel_1 = new JLabel("Insert prisoner number:");
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

		textArea.setBounds(257, 148, 429, 336);
		leer.add(textArea);
		return leer;
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Search");
			putValue(SHORT_DESCRIPTION, "Search one prisoner");
		}

		public void actionPerformed(ActionEvent e) {
			try {
			int id = Integer.parseInt(textField.getText());
			if (Prisoners.containsKey(id)) {
				textArea.setText(Prisoners.get(id).toString());
			} else {
				textArea.setText("There is no prisoner registered with that number.");
			}
		}catch(Exception exc) {
			MessageWindow m = new MessageWindow("Format error", "Introduce a valid prisoner number");
			m.frame.setVisible(true);	
		}
		}
	}

	public JPanel crear(HashMap<Integer, Prisoner> prisoners, HashMap<Integer, Cell> cells) {
		setPrisoners(prisoners);
		setCells(cells);
		entrancetxt_2 = new JTextField();
		entrancetxt_3 = new JTextField();
		timetxt_2 = new JTextField();
		timetxt_3 = new JTextField();
		JPanel crear = new JPanel();
		crear.setBounds(0, 0, 836, 511);
		crear.setVisible(true);
		crear.setLayout(null);

		JLabel lblNewLabel = new JLabel("CREATE A NEW PRISONER");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 335, 37);
		crear.add(lblNewLabel);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni.setBounds(378, 108, 46, 14);
		crear.add(lblDni);

		dnitxt = new JTextField();
		dnitxt.setBounds(434, 108, 192, 20);
		crear.add(dnitxt);
		dnitxt.setColumns(10);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(378, 133, 46, 14);
		crear.add(lblName);

		nametxt = new JTextField();
		nametxt.setBounds(434, 133, 192, 20);
		crear.add(nametxt);
		nametxt.setColumns(10);

		JLabel lblLastNames = new JLabel("Last Names:");
		lblLastNames.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLastNames.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastNames.setBounds(338, 158, 86, 14);
		crear.add(lblLastNames);

		lastnametxt = new JTextField();
		lastnametxt.setBounds(434, 158, 192, 20);
		crear.add(lastnametxt);
		lastnametxt.setColumns(10);

		JLabel lblBirthDateddmmaaaa = new JLabel("Birth date(dd/mm/yyyy):");
		lblBirthDateddmmaaaa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBirthDateddmmaaaa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBirthDateddmmaaaa.setBounds(279, 183, 145, 14);
		crear.add(lblBirthDateddmmaaaa);

		birthtxt = new JTextField();
		birthtxt.setBounds(434, 183, 46, 20);
		crear.add(birthtxt);
		birthtxt.setColumns(10);

		JLabel lblNationality = new JLabel("Nationality:");
		lblNationality.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNationality.setBounds(350, 214, 74, 14);
		crear.add(lblNationality);

		nationtext = new JTextField();
		nationtext.setBounds(434, 212, 86, 20);
		crear.add(nationtext);
		nationtext.setColumns(10);

		JLabel lblSex = new JLabel("Sex:");
		lblSex.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSex.setBounds(378, 238, 46, 14);
		crear.add(lblSex);

		checkBoxFemale.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (checkBoxFemale.isSelected()) {
					checkBoxMale.setSelected(false);
				}
			}
		});
		checkBoxMale.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (checkBoxMale.isSelected()) {
					checkBoxFemale.setSelected(false);
				}
			}
		});
		checkBoxMale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		checkBoxMale.setBounds(434, 235, 61, 23);
		crear.add(checkBoxMale);

		checkBoxFemale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		checkBoxFemale.setBounds(497, 235, 97, 23);
		crear.add(checkBoxFemale);

		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHeight.setBounds(378, 263, 46, 20);
		crear.add(lblHeight);

		cmtxt = new JTextField();
		cmtxt.setBounds(434, 265, 86, 20);
		crear.add(cmtxt);
		cmtxt.setColumns(10);

		JLabel lblCm = new JLabel("cm");
		lblCm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCm.setBounds(530, 268, 46, 14);
		crear.add(lblCm);

		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWeight.setBounds(378, 294, 46, 20);
		crear.add(lblWeight);

		kgtxt = new JTextField();
		kgtxt.setBounds(434, 297, 86, 20);
		crear.add(kgtxt);
		kgtxt.setColumns(10);

		JLabel lblKg = new JLabel("kg");
		lblKg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKg.setBounds(530, 296, 52, 18);
		crear.add(lblKg);

		JLabel lblPrisonerNumber = new JLabel("Prisoner Number:");
		lblPrisonerNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrisonerNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrisonerNumber.setBounds(308, 83, 116, 14);
		crear.add(lblPrisonerNumber);

		numbertxt = new JTextField();
		numbertxt.setBounds(434, 83, 86, 20);
		crear.add(numbertxt);
		numbertxt.setColumns(10);

		JLabel lblThreatLevel = new JLabel("Threat Level:");
		lblThreatLevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblThreatLevel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThreatLevel.setBounds(330, 325, 94, 14);
		crear.add(lblThreatLevel);

		checkBox1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (checkBox1.isSelected()) {
					checkBox2.setSelected(false);
					checkBox3.setSelected(false);
				}
			}
		});
		checkBox1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		checkBox1.setBounds(434, 324, 39, 23);
		crear.add(checkBox1);

		checkBox2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (checkBox2.isSelected()) {
					checkBox1.setSelected(false);
					checkBox3.setSelected(false);
				}
			}
		});
		checkBox2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		checkBox2.setBounds(475, 324, 39, 23);
		crear.add(checkBox2);

		checkBox3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (checkBox3.isSelected()) {
					checkBox2.setSelected(false);
					checkBox1.setSelected(false);
				}
			}
		});
		checkBox3.setBounds(516, 324, 39, 23);
		crear.add(checkBox3);

		JLabel lblNewLabel_2 = new JLabel("Cell Number:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(338, 350, 86, 14);
		crear.add(lblNewLabel_2);

		celltxt = new JTextField();
		celltxt.setBounds(434, 348, 86, 20);
		crear.add(celltxt);
		celltxt.setColumns(10);

		JLabel lblCrimeDescription = new JLabel("Crime Description:");
		lblCrimeDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrimeDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCrimeDescription.setBounds(318, 375, 106, 14);
		crear.add(lblCrimeDescription);

		crimetxt = new JTextField();
		crimetxt.setBounds(434, 373, 335, 20);
		crear.add(crimetxt);
		crimetxt.setColumns(10);

		JLabel lblTimeOfCondemnationddmmaaaa = new JLabel("Time of condemnation(yyy/mm/dd):");
		lblTimeOfCondemnationddmmaaaa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTimeOfCondemnationddmmaaaa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTimeOfCondemnationddmmaaaa.setBounds(207, 400, 217, 14);
		crear.add(lblTimeOfCondemnationddmmaaaa);

		timetxt = new JTextField();
		timetxt.setBounds(434, 398, 46, 20);
		crear.add(timetxt);
		timetxt.setColumns(10);

		JLabel lblEntranceDate = new JLabel("Entrance Date(dd/mm/yyyy):");
		lblEntranceDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntranceDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEntranceDate.setBounds(246, 425, 178, 14);
		crear.add(lblEntranceDate);

		entrancetxt = new JTextField();
		entrancetxt.setBounds(434, 423, 46, 20);
		crear.add(entrancetxt);
		entrancetxt.setColumns(10);

		JLabel lblVisitsPermission = new JLabel("Visits Permission:");
		lblVisitsPermission.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVisitsPermission.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVisitsPermission.setBounds(308, 450, 116, 14);
		crear.add(lblVisitsPermission);

		JLabel lblCalls = new JLabel("Calls Permission:");
		lblCalls.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalls.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCalls.setBounds(318, 475, 106, 14);
		crear.add(lblCalls);

		checkBoxVisits.setBounds(434, 447, 97, 23);
		crear.add(checkBoxVisits);

		checkBoxCalls.setBounds(434, 472, 97, 23);
		crear.add(checkBoxCalls);

		birthtxt_2 = new JTextField();
		birthtxt_2.setBounds(510, 183, 46, 20);
		crear.add(birthtxt_2);
		birthtxt_2.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("/");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(485, 183, 20, 20);
		crear.add(lblNewLabel_3);

		JLabel label = new JLabel("/");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(558, 183, 20, 20);
		crear.add(label);

		birthtxt_3 = new JTextField();
		birthtxt_3.setBounds(580, 183, 46, 20);
		crear.add(birthtxt_3);
		birthtxt_3.setColumns(10);

		timetxt_2.setBounds(510, 398, 46, 20);
		crear.add(timetxt_2);
		timetxt_2.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("/");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(485, 398, 20, 20);
		crear.add(lblNewLabel_4);

		JLabel label2 = new JLabel("/");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label2.setBounds(558, 398, 20, 20);
		crear.add(label2);

		timetxt_3.setBounds(580, 398, 46, 20);
		crear.add(timetxt_3);
		timetxt_3.setColumns(10);

		entrancetxt_2.setBounds(510, 423, 46, 20);
		crear.add(entrancetxt_2);
		entrancetxt_2.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("/");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(485, 423, 20, 20);
		crear.add(lblNewLabel_5);

		JLabel label3 = new JLabel("/");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label3.setBounds(558, 423, 20, 20);
		crear.add(label3);

		entrancetxt_3.setBounds(580, 423, 46, 20);
		crear.add(entrancetxt_3);
		entrancetxt_3.setColumns(10);

		btnNewButton_1.setAction(saveNew);
		btnNewButton_1.setBounds(658, 472, 89, 23);
		crear.add(btnNewButton_1);
		setEditar(true);
		return crear;
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Save new prisoner");
		}

		public void actionPerformed(ActionEvent e) {
			Prisoner pr = new Prisoner();
			savePrisoner(pr, "new");
		}
	}

	public void savePrisoner(Prisoner p, String mode) {
		try {
			int cellId = 0;
			int oldId=0;
			boolean ov = true;
			boolean error = false;
			if (mode.equals("new")) {
				p.setCelda(new Cell());
				p.getCelda().setNum_celda(0);
			}

			p.setDNI(dnitxt.getText());

			p.setNombre(nametxt.getText());

			p.setApellidos(lastnametxt.getText());

			p.setF_nac(birthtxt.getText() + "/" + birthtxt_2.getText() + "/" + birthtxt_3.getText());

			p.setNacionalidad(nationtext.getText());

			if (checkBoxMale.isSelected()) {
				p.setSexo("h");
			} else if (checkBoxFemale.isSelected()) {
				p.setSexo("m");
			} else {
				error = true;
				MessageWindow full = new MessageWindow("Select one gender", "");
				full.frame.setVisible(true);
			}

			p.setAltura(Integer.parseInt(cmtxt.getText()));

			p.setPeso(Double.parseDouble(kgtxt.getText()));

			if (checkBox1.isSelected()) {
				p.setNiv_amenaza(1);
			} else if (checkBox2.isSelected()) {
				p.setNiv_amenaza(2);
			} else if (checkBox3.isSelected()) {
				p.setNiv_amenaza(3);
			} else {
				error = true;
				MessageWindow level = new MessageWindow("Select one threat level", "");
				level.frame.setVisible(true);
			}
			cellId = Integer.parseInt(celltxt.getText());
			if (Cells.containsKey(cellId)) {
				if (Cells.get(cellId).isLlena()) {
					if (p.getCelda().getNum_celda() == Cells.get(cellId).getNum_celda()) {
						oldId=p.getCelda().getNum_celda();
					} else {
						error = true;
						MessageWindow llena = new MessageWindow("Selected cell is full", "");
						llena.frame.setVisible(true);
					}
				} else {
					oldId=p.getCelda().getNum_celda();
					p.setCelda(Cells.get(cellId));
				}
			} else {
				error = true;
				MessageWindow cell = new MessageWindow("Selected cell does not exist", "");
				cell.frame.setVisible(true);
			}

			p.setCrimen(crimetxt.getText());

			if (mode.equals("new")) {
				p.setCondena(timetxt.getText() + ", " + timetxt_2.getText() + ", " + timetxt_3.getText());
			} else if (mode.equals("edit")) {
				p.setCondena(timetxt.getText());
			}

			p.setIngreso(entrancetxt.getText() + "/" + entrancetxt_2.getText() + "/" + entrancetxt_3.getText());

			if (checkBoxVisits.isSelected()) {
				p.setVisitas(true);
			} else {
				p.setVisitas(false);
			}
			if (checkBoxCalls.isSelected()) {
				p.setLlamadas(true);
			} else {
				p.setLlamadas(false);
			}
			if (!error) {
				if (mode.equals("edit")) {
					if (!(Prisoners.containsKey(Integer.parseInt(numbertxt.getText())))) {//si el nuevo nº no esta en presos
						Prisoners.remove(p.getNum_preso());// aunque de normal se reescribe, si cambia el nÂº preso
															// quedarian los dos, asi
						// que hay que borrar el antiguo
						p.setNum_preso(Integer.parseInt(numbertxt.getText()));
					} else {//si el nuevo nº existe ya
						if (!(Integer.parseInt(numbertxt.getText()) == p.getNum_preso())) {//si el nuevo nº no es igual al antiguo(overwrite)
							if (!(ovCheckbox.isSelected())) {
								ov = false;
								MessageWindow over = new MessageWindow("Save cancelled",
										"Overwrite existing prisoner option not selected");
								over.frame.setVisible(true);
							} else {
								Prisoners.remove(p.getNum_preso());// aunque de normal se reescribe, si cambia el nÂº
																	// preso quedarian los dos, asi
								// que hay que borrar el antiguo
								p.setNum_preso(Integer.parseInt(numbertxt.getText()));
							}
						}
					}
				} else {
					if (Prisoners.containsKey(Integer.parseInt(numbertxt.getText()))) {
						ov = false;
						MessageWindow over = new MessageWindow("Prisoner number in use",
								"Delete existing prisoner to use that number");
						over.frame.setVisible(true);
					}
				}
				if (ov) {
					if(mode.equals("edit")) {
						Cells.get(oldId).getPresos().remove(p);
						Cells.get(oldId).setCap_actual();
						Cells.get(oldId).setLlena();
						Cells.get(oldId).getPabellon().setNum_presos();
					}
					p.setNum_preso(Integer.parseInt(numbertxt.getText()));
					Cells.get(cellId).getPresos().add(p);
					Cells.get(cellId).setCap_actual();
					Cells.get(cellId).setLlena();
					Cells.get(cellId).getPabellon().setNum_presos();
					Prisoners.put(p.getNum_preso(), p);
					MessageWindow saved = new MessageWindow("Prisoner saved", "");
					saved.frame.setVisible(true);
				}
			} else {
				error = false;
			}
		} catch (Exception ex) {
			MessageWindow err = new MessageWindow("Format error ocurred", "");
			err.frame.setVisible(true);
		}
	}

	public JPanel editar(HashMap<Integer, Prisoner> prisoners, HashMap<Integer, Cell> cells) {
		setPrisoners(prisoners);
		setCells(cells);
		entrancetxt_2 = new JTextField();
		entrancetxt_3 = new JTextField();
		JPanel crear = new JPanel();
		crear.setBounds(0, 0, 836, 511);
		crear.setVisible(true);
		crear.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel(" already exists");
		lblNewLabel_6.setBounds(670, 100, 89, 14);
		crear.add(lblNewLabel_6);

		JLabel lblNewLabel = new JLabel("EDIT AN EXISTING PRISONER");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 335, 37);
		crear.add(lblNewLabel);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni.setBounds(378, 108, 46, 14);
		crear.add(lblDni);

		dnitxt = new JTextField();
		dnitxt.setBounds(434, 108, 192, 20);
		crear.add(dnitxt);
		dnitxt.setColumns(10);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(378, 133, 46, 14);
		crear.add(lblName);

		nametxt = new JTextField();
		nametxt.setBounds(434, 133, 192, 20);
		crear.add(nametxt);
		nametxt.setColumns(10);

		JLabel lblLastNames = new JLabel("Last Names:");
		lblLastNames.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLastNames.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastNames.setBounds(338, 158, 86, 14);
		crear.add(lblLastNames);

		lastnametxt = new JTextField();
		lastnametxt.setBounds(434, 158, 192, 20);
		crear.add(lastnametxt);
		lastnametxt.setColumns(10);

		JLabel lblBirthDateddmmaaaa = new JLabel("Birth date(dd/mm/yyyy):");
		lblBirthDateddmmaaaa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBirthDateddmmaaaa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBirthDateddmmaaaa.setBounds(279, 183, 145, 14);
		crear.add(lblBirthDateddmmaaaa);

		birthtxt = new JTextField();
		birthtxt.setBounds(434, 183, 46, 20);
		crear.add(birthtxt);
		birthtxt.setColumns(10);

		JLabel lblNationality = new JLabel("Nationality:");
		lblNationality.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNationality.setBounds(350, 214, 74, 14);
		crear.add(lblNationality);

		nationtext = new JTextField();
		nationtext.setBounds(434, 212, 86, 20);
		crear.add(nationtext);
		nationtext.setColumns(10);

		JLabel lblSex = new JLabel("Sex:");
		lblSex.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSex.setBounds(378, 238, 46, 14);
		crear.add(lblSex);

		checkBoxFemale.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (checkBoxFemale.isSelected()) {
					checkBoxMale.setSelected(false);
				}
			}
		});
		checkBoxMale.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (checkBoxMale.isSelected()) {
					checkBoxFemale.setSelected(false);
				}
			}
		});
		checkBoxMale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		checkBoxMale.setBounds(434, 235, 61, 23);
		crear.add(checkBoxMale);

		checkBoxFemale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		checkBoxFemale.setBounds(497, 235, 97, 23);
		crear.add(checkBoxFemale);

		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHeight.setBounds(378, 263, 46, 20);
		crear.add(lblHeight);

		cmtxt = new JTextField();
		cmtxt.setBounds(434, 265, 86, 20);
		crear.add(cmtxt);
		cmtxt.setColumns(10);

		JLabel lblCm = new JLabel("cm");
		lblCm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCm.setBounds(530, 268, 46, 14);
		crear.add(lblCm);

		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWeight.setBounds(378, 294, 46, 20);
		crear.add(lblWeight);

		kgtxt = new JTextField();
		kgtxt.setBounds(434, 297, 86, 20);
		crear.add(kgtxt);
		kgtxt.setColumns(10);

		JLabel lblKg = new JLabel("kg");
		lblKg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKg.setBounds(530, 296, 52, 18);
		crear.add(lblKg);

		JLabel lblPrisonerNumber = new JLabel("Prisoner Number:");
		lblPrisonerNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrisonerNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrisonerNumber.setBounds(308, 83, 116, 14);
		crear.add(lblPrisonerNumber);

		numbertxt = new JTextField();
		numbertxt.setBounds(434, 83, 86, 20);
		crear.add(numbertxt);
		numbertxt.setColumns(10);

		JLabel lblThreatLevel = new JLabel("Threat Level:");
		lblThreatLevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblThreatLevel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThreatLevel.setBounds(330, 325, 94, 14);
		crear.add(lblThreatLevel);

		checkBox1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (checkBox1.isSelected()) {
					checkBox2.setSelected(false);
					checkBox3.setSelected(false);
				}
			}
		});
		checkBox1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		checkBox1.setBounds(434, 324, 39, 23);
		crear.add(checkBox1);

		checkBox2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (checkBox2.isSelected()) {
					checkBox1.setSelected(false);
					checkBox3.setSelected(false);
				}
			}
		});
		checkBox2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		checkBox2.setBounds(475, 324, 39, 23);
		crear.add(checkBox2);

		checkBox3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (checkBox3.isSelected()) {
					checkBox2.setSelected(false);
					checkBox1.setSelected(false);
				}
			}
		});
		checkBox3.setBounds(516, 324, 39, 23);
		crear.add(checkBox3);

		JLabel lblNewLabel_2 = new JLabel("Cell Number:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(338, 350, 86, 14);
		crear.add(lblNewLabel_2);

		celltxt = new JTextField();
		celltxt.setBounds(434, 348, 86, 20);
		crear.add(celltxt);
		celltxt.setColumns(10);

		JLabel lblCrimeDescription = new JLabel("Crime Description:");
		lblCrimeDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrimeDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCrimeDescription.setBounds(318, 375, 106, 14);
		crear.add(lblCrimeDescription);

		crimetxt = new JTextField();
		crimetxt.setBounds(434, 373, 335, 20);
		crear.add(crimetxt);
		crimetxt.setColumns(10);

		JLabel lblTimeOfCondemnationddmmaaaa = new JLabel("Time of condemnation(yyy, mm, dd):");
		lblTimeOfCondemnationddmmaaaa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTimeOfCondemnationddmmaaaa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTimeOfCondemnationddmmaaaa.setBounds(207, 400, 217, 14);
		crear.add(lblTimeOfCondemnationddmmaaaa);

		timetxt = new JTextField();
		timetxt.setBounds(434, 398, 121, 20);
		crear.add(timetxt);
		timetxt.setColumns(10);

		JLabel lblEntranceDate = new JLabel("Entrance Date(dd/mm/yyyy):");
		lblEntranceDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntranceDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEntranceDate.setBounds(246, 425, 178, 14);
		crear.add(lblEntranceDate);

		entrancetxt = new JTextField();
		entrancetxt.setBounds(434, 423, 46, 20);
		crear.add(entrancetxt);
		entrancetxt.setColumns(10);

		JLabel lblVisitsPermission = new JLabel("Visits Permission:");
		lblVisitsPermission.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVisitsPermission.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVisitsPermission.setBounds(308, 450, 116, 14);
		crear.add(lblVisitsPermission);

		JLabel lblCalls = new JLabel("Calls Permission:");
		lblCalls.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalls.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCalls.setBounds(318, 475, 106, 14);
		crear.add(lblCalls);

		checkBoxVisits.setBounds(434, 447, 97, 23);
		crear.add(checkBoxVisits);

		checkBoxCalls.setBounds(434, 472, 97, 23);
		crear.add(checkBoxCalls);

		birthtxt_2 = new JTextField();
		birthtxt_2.setBounds(510, 183, 46, 20);
		crear.add(birthtxt_2);
		birthtxt_2.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("/");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(485, 183, 20, 20);
		crear.add(lblNewLabel_3);

		JLabel label = new JLabel("/");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(558, 183, 20, 20);
		crear.add(label);

		birthtxt_3 = new JTextField();
		birthtxt_3.setBounds(580, 183, 46, 20);
		crear.add(birthtxt_3);
		birthtxt_3.setColumns(10);

		entrancetxt_2.setBounds(510, 423, 46, 20);
		crear.add(entrancetxt_2);
		entrancetxt_2.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("/");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(485, 423, 20, 20);
		crear.add(lblNewLabel_5);

		JLabel label3 = new JLabel("/");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label3.setBounds(558, 423, 20, 20);
		crear.add(label3);

		entrancetxt_3.setBounds(580, 423, 46, 20);
		crear.add(entrancetxt_3);
		entrancetxt_3.setColumns(10);

		btnNewButton_1.setAction(saveEdit);
		btnNewButton_1.setBounds(658, 472, 89, 23);
		crear.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setAction(editSearch);
		btnNewButton_2.setBounds(537, 80, 89, 23);
		crear.add(btnNewButton_2);
		numbertxt.setEditable(true);

		ovCheckbox = new JCheckBox("Overwrite if number");
		ovCheckbox.setBounds(650, 80, 169, 23);
		crear.add(ovCheckbox);
		setEditar(false);

		return crear;
	}

	public void setEditar(boolean a) {

		dnitxt.setEditable(a);
		dnitxt.setText("");

		nametxt.setEditable(a);
		nametxt.setText("");

		lastnametxt.setEditable(a);
		lastnametxt.setText("");

		birthtxt.setEditable(a);
		birthtxt.setText("");

		birthtxt_2.setEditable(a);
		birthtxt_2.setText("");

		birthtxt_3.setEditable(a);
		birthtxt_3.setText("");

		nationtext.setEditable(a);
		nationtext.setText("");

		checkBoxMale.setEnabled(a);
		checkBoxMale.setSelected(false);

		checkBoxFemale.setEnabled(a);
		checkBoxFemale.setSelected(false);

		cmtxt.setEditable(a);
		cmtxt.setText("");

		kgtxt.setEditable(a);
		kgtxt.setText("");

		checkBox1.setEnabled(a);
		checkBox1.setSelected(false);

		checkBox2.setEnabled(a);
		checkBox2.setSelected(false);

		checkBox3.setEnabled(a);
		checkBox3.setSelected(false);

		celltxt.setEditable(a);
		celltxt.setText("");

		crimetxt.setEditable(a);
		crimetxt.setText("");

		timetxt.setEditable(a);
		timetxt.setText("");

		entrancetxt.setEditable(a);
		entrancetxt.setText("");

		entrancetxt_2.setEditable(a);
		entrancetxt_2.setText("");

		entrancetxt_3.setEditable(a);
		entrancetxt_3.setText("");

		checkBoxCalls.setEnabled(a);
		checkBoxCalls.setSelected(false);

		checkBoxVisits.setEnabled(a);
		checkBoxVisits.setSelected(false);

		btnNewButton_1.setEnabled(a);

	}

	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Search");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {

			numberFormat2.setMinimumIntegerDigits(2);
			int id = Integer.parseInt(numbertxt.getText());
			Prisoner_IO pio = new Prisoner_IO();
			if (Prisoners.containsKey(id)) {
				setEditar(true);
				edp = Prisoners.get(id);

				dnitxt.setText(edp.getDNI());

				nametxt.setText(edp.getNombre());

				lastnametxt.setText(edp.getApellidos());

				int date[] = pio.getTheDate(edp.getF_nac());
				birthtxt.setText(numberFormat2.format(date[0]) + "");
				birthtxt_2.setText(numberFormat2.format(date[1]) + "");
				birthtxt_3.setText(numberFormat2.format(date[2]) + "");

				nationtext.setText(edp.getNacionalidad());

				if (edp.getSexo().equals("h")) {
					checkBoxMale.setSelected(true);
				} else if (edp.getSexo().equals("m")) {
					checkBoxFemale.setSelected(true);
				}
				cmtxt.setText(edp.getAltura() + "");

				kgtxt.setText(edp.getPeso() + "");

				numbertxt.setText(edp.getNum_preso() + "");

				if (edp.getNiv_amenaza() == 1) {
					checkBox1.setSelected(true);
				} else if (edp.getNiv_amenaza() == 2) {
					checkBox2.setSelected(true);
				} else if (edp.getNiv_amenaza() == 3) {
					checkBox3.setSelected(true);
				}

				celltxt.setText(edp.getCelda().getNum_celda() + "");

				crimetxt.setText(edp.getCrimen());

				timetxt.setText(edp.getCondena());

				int date2[] = pio.getTheDate(edp.getIngreso());
				entrancetxt.setText(numberFormat2.format(date2[0]) + "");
				entrancetxt_2.setText(numberFormat2.format(date2[1]) + "");
				entrancetxt_3.setText(numberFormat2.format(date2[2]) + "");

				if (edp.isLlamadas()) {
					checkBoxCalls.setSelected(true);
				}
				if (edp.isVisitas()) {
					checkBoxVisits.setSelected(true);
				}
			} else {
				setEditar(false);
				MessageWindow m = new MessageWindow("Invalid prisoner number", "There is no prisoner with that number");
				numbertxt.setText("");
				m.frame.setVisible(true);
			}
		}
	}

	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Save edited prisoner");
		}

		public void actionPerformed(ActionEvent e) {
			savePrisoner(edp, "edit");
		}
	}

	public JPanel borrar(HashMap<Integer, Prisoner> prisoners, HashMap<Integer, Cell> cells) {

		setPrisoners(prisoners);
		setCells(cells);

		JPanel borrar = new JPanel();
		borrar.setBounds(0, 0, 836, 511);
		borrar.setVisible(true);
		borrar.setLayout(null);

		JLabel lblNewLabel = new JLabel("DELETE AN EXISTING PRISONER");
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

		JLabel lblNewLabel_7 = new JLabel("Insert the number of the prisoner you want to delete:");
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
			putValue(SHORT_DESCRIPTION, "Delete prisoner");
		}

		public void actionPerformed(ActionEvent e) {
			try {
			int id = Integer.parseInt(textField_1.getText());
			if (Prisoners.containsKey(id)) {
				Cells.get(Prisoners.get(id).getCelda().getNum_celda()).getPresos().remove(Prisoners.get(id));
				Cells.get(Prisoners.get(id).getCelda().getNum_celda()).setCap_actual();
				Cells.get(Prisoners.get(id).getCelda().getNum_celda()).setLlena();
				Cells.get(Prisoners.get(id).getCelda().getNum_celda()).getPabellon().setNum_presos();
				Prisoners.remove(id);
				MessageWindow m = new MessageWindow("Prisoner deleted", "");
				m.frame.setVisible(true);
				textField_1.setText("");
			} else {
				MessageWindow m = new MessageWindow("Invalid prisoner", "There is no prisoner with that number");
				m.frame.setVisible(true);
				textField_1.setText("");
			}
		}catch(Exception es){
			MessageWindow m = new MessageWindow("Format error ocurred", "Introduce a number");
			m.frame.setVisible(true);
		}	
		}
	}

	public JPanel leerListado(HashMap<Integer, Prisoner> prisoners) {

		setPrisoners(prisoners);

		JPanel leerListado = new JPanel();
		leerListado.setBounds(0, 0, 836, 511);
		leerListado.setVisible(true);
		leerListado.setLayout(null);

		JLabel lblNewLabel = new JLabel("READ LIST OF ALL PRISONERS");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 335, 37);
		leerListado.add(lblNewLabel);
		
		JTextArea txtrSafdSdfSdfds = new JTextArea();
		txtrSafdSdfSdfds.setFont(new Font("Monospaced", Font.PLAIN, 14));
		String s="";
		ArrayList<Integer> orderedP = new ArrayList<Integer>();
		for (int i : Prisoners.keySet()) {
			orderedP.add(i);
		}
		Collections.sort(orderedP);
		for(int a=0;a<Prisoners.size();a++) {
			Prisoner p=Prisoners.get(orderedP.get(a));
			s=s+p.getNum_preso() + ", " + p.getNombre() + " " + p.getApellidos() + "\r\n";
		}
		txtrSafdSdfSdfds.setText(s);
		txtrSafdSdfSdfds.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtrSafdSdfSdfds.setBounds(268, 110, 455, 391);
		
		JScrollPane sp = new JScrollPane(txtrSafdSdfSdfds);
		sp.setBounds(268, 110, 455, 370);
		sp.setBackground(SystemColor.menu);
		leerListado.add(sp);
		
		JLabel lblNewLabel_8 = new JLabel("Current number of prisoners in the database: "+Prisoners.size());
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(268, 73, 324, 26);
		leerListado.add(lblNewLabel_8);
		
		return leerListado;
	}
	public JPanel realizarConsulta(HashMap<Integer, Prisoner> prisoners) {

		setPrisoners(prisoners);
		Query = new HashMap<Integer, Prisoner>(Prisoners);

		realizarConsulta.removeAll();
		realizarConsulta.setBounds(0, 0, 836, 511);
		realizarConsulta.setVisible(true);
		realizarConsulta.setLayout(null);

		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 335, 37);
		realizarConsulta.add(lblNewLabel);

		restMenu.setBounds(0, 0, 836, 511);
		restMenu.setVisible(true);
		restMenu.setLayout(null);
		realizarConsulta.add(restMenu);
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					restMenu.setVisible(false);
					opt.setBounds(0, 0, 836, 511);
					opt.setVisible(true);
					opt.setLayout(null);
					
					JButton btnNewButton_7 = new JButton("New button");
					btnNewButton_7.setAction(back);
					btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
					btnNewButton_7.setBounds(330, 412, 95, 23);
					opt.add(btnNewButton_7);
					
					realizarConsulta.add(opt);
					JButton btnNewButton_5 = new JButton("New button");
					btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
					btnNewButton_5.setAction(applyR);
					if (list.getSelectedValue().equals("Search by DNI")) {
						optRestriction="DNI";
						
						restxt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
						restxt1.setBounds(274, 180, 202, 28);
						restxt1.setColumns(10);
						opt.add(restxt1);
						
						JLabel lblNewLabel_11 = new JLabel("Insert DNI:");
						lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblNewLabel_11.setBounds(274, 144, 147, 25);
						opt.add(lblNewLabel_11);
						
						btnNewButton_5.setBounds(533, 180, 140, 28);
						opt.add(btnNewButton_5);
						
					}else if (list.getSelectedValue().equals("Search by name")) {
						optRestriction="name";
						restxt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
						restxt1.setBounds(274, 180, 202, 28);
						restxt1.setColumns(10);
						opt.add(restxt1);
						
						JLabel lblNewLabel_11 = new JLabel("Insert name:");
						lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblNewLabel_11.setBounds(274, 144, 147, 25);
						opt.add(lblNewLabel_11);
						
						btnNewButton_5.setBounds(533, 180, 140, 28);
						opt.add(btnNewButton_5);
						
					}else if (list.getSelectedValue().equals("Search by age")) {
                        optRestriction="age";

                        restxt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		restxt1.setBounds(274, 180, 202, 28);
                		restxt1.setColumns(10);
                		opt.add(restxt1);
                		
                		JLabel lblNewLabel_11 = new JLabel("Insert maximum age(years):");
                		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		lblNewLabel_11.setBounds(274, 144, 202, 25);
                		opt.add(lblNewLabel_11);
                		
                		btnNewButton_5.setBounds(520, 274, 140, 28);
                		opt.add(btnNewButton_5);
                		
                		JLabel lblNewLabel_12 = new JLabel("Insert minimum age(years):");
                		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		lblNewLabel_12.setBounds(274, 240, 202, 25);
                		opt.add(lblNewLabel_12);
                		
                		restxt2.setBounds(274, 276, 202, 28);
                		opt.add(restxt2);
                		restxt2.setColumns(10);
                        
                    }else if (list.getSelectedValue().equals("Search by nationality")) {
                        optRestriction="nationality";
                		restxt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		restxt1.setBounds(274, 180, 202, 28);
                		restxt1.setColumns(10);
                		opt.add(restxt1);
                		
                		JLabel lblNewLabel_11 = new JLabel("Insert nationality:");
                		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		lblNewLabel_11.setBounds(274, 144, 147, 25);
                		opt.add(lblNewLabel_11);
                		
                		btnNewButton_5.setBounds(533, 180, 140, 28);
                		opt.add(btnNewButton_5);
                		
                    }else if (list.getSelectedValue().equals("Search by height")) {
                        optRestriction="height";
                        restxt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		restxt1.setBounds(274, 180, 202, 28);
                		restxt1.setColumns(10);
                		opt.add(restxt1);
                		
                		JLabel lblNewLabel_11 = new JLabel("Insert maximum height(cm):");
                		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		lblNewLabel_11.setBounds(274, 144, 202, 25);
                		opt.add(lblNewLabel_11);
                		
                		btnNewButton_5.setBounds(520, 274, 140, 28);
                		opt.add(btnNewButton_5);
                		
                		JLabel lblNewLabel_12 = new JLabel("Insert minimum height(cm):");
                		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		lblNewLabel_12.setBounds(274, 240, 202, 25);
                		opt.add(lblNewLabel_12);
                		
                		restxt2.setBounds(274, 276, 202, 28);
                		opt.add(restxt2);
                		restxt2.setColumns(10);
                        
                    }else if (list.getSelectedValue().equals("Search by weight")) {
                        optRestriction="weight";
                        restxt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		restxt1.setBounds(274, 180, 202, 28);
                		restxt1.setColumns(10);
                		opt.add(restxt1);
                		
                		JLabel lblNewLabel_11 = new JLabel("Insert maximum weight(kg):");
                		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		lblNewLabel_11.setBounds(274, 144, 202, 25);
                		opt.add(lblNewLabel_11);
                		
                		btnNewButton_5.setBounds(520, 274, 140, 28);
                		opt.add(btnNewButton_5);
                		
                		JLabel lblNewLabel_12 = new JLabel("Insert minimum weight(kg):");
                		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		lblNewLabel_12.setBounds(274, 240, 202, 25);
                		opt.add(lblNewLabel_12);
                		
                		restxt2.setBounds(274, 276, 202, 28);
                		opt.add(restxt2);
                		restxt2.setColumns(10);
                        
                    }else if (list.getSelectedValue().equals("Search by threat level")) {
                        optRestriction="threat level";
                        restxt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		restxt1.setBounds(274, 180, 202, 28);
                		restxt1.setColumns(10);
                		opt.add(restxt1);
                		
                		JLabel lblNewLabel_11 = new JLabel("Insert maximum threat level:");
                		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		lblNewLabel_11.setBounds(274, 144, 202, 25);
                		opt.add(lblNewLabel_11);
                		
                		btnNewButton_5.setBounds(520, 274, 140, 28);
                		opt.add(btnNewButton_5);
                		
                		JLabel lblNewLabel_12 = new JLabel("Insert minimum threat level:");
                		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		lblNewLabel_12.setBounds(274, 240, 202, 25);
                		opt.add(lblNewLabel_12);
                		
                		restxt2.setBounds(274, 276, 202, 28);
                		opt.add(restxt2);
                		restxt2.setColumns(10);
                    }else if (list.getSelectedValue().equals("Search by cell number")) {
                        optRestriction="cell number";
                		restxt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		restxt1.setBounds(274, 180, 202, 28);
                		restxt1.setColumns(10);
                		opt.add(restxt1);
                		
                		JLabel lblNewLabel_11 = new JLabel("Insert cell number:");
                		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		lblNewLabel_11.setBounds(274, 144, 147, 25);
                		opt.add(lblNewLabel_11);
                		
                		btnNewButton_5.setBounds(533, 180, 140, 28);
                		opt.add(btnNewButton_5);
                    }else if (list.getSelectedValue().equals("Search by time of condemnation")) {
                    	optRestriction="time of condemnation";
                        restxt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		restxt1.setBounds(274, 180, 202, 28);
                		restxt1.setColumns(10);
                		opt.add(restxt1);
                		
                		JLabel lblNewLabel_11 = new JLabel("Insert maximum time of condemnation(years):");
                		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		lblNewLabel_11.setBounds(274, 144, 386, 25);
                		opt.add(lblNewLabel_11);
                		
                		btnNewButton_5.setBounds(520, 274, 140, 28);
                		opt.add(btnNewButton_5);
                		
                		JLabel lblNewLabel_12 = new JLabel("Insert minimum time of condemnation(years):");
                		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		lblNewLabel_12.setBounds(274, 240, 382, 25);
                		opt.add(lblNewLabel_12);
                		
                		restxt2.setBounds(274, 276, 202, 28);
                		opt.add(restxt2);
                		restxt2.setColumns(10);
                       
                    }else if (list.getSelectedValue().equals("Search by entrance date")) {
                        optRestriction="entrance date";
                        restxt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		restxt1.setBounds(274, 180, 202, 28);
                		restxt1.setColumns(10);
                		opt.add(restxt1);
                		
                		JLabel lblNewLabel_11 = new JLabel("Insert maximum entrance date(years):");
                		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		lblNewLabel_11.setBounds(274, 144, 386, 25);
                		opt.add(lblNewLabel_11);
                		
                		btnNewButton_5.setBounds(520, 274, 140, 28);
                		opt.add(btnNewButton_5);
                		
                		JLabel lblNewLabel_12 = new JLabel("Insert minimum entrance date(years):");
                		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		lblNewLabel_12.setBounds(274, 240, 382, 25);
                		opt.add(lblNewLabel_12);
                		
                		restxt2.setBounds(274, 276, 202, 28);
                		opt.add(restxt2);
                		restxt2.setColumns(10);
                    }else if (list.getSelectedValue().equals("Search by visits")) {
                        optRestriction="visits";
                        JLabel lblNewLabel_11 = new JLabel("Do you want prisoners with or without visits permission?");
                		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		lblNewLabel_11.setBounds(274, 144, 399, 25);
                		opt.add(lblNewLabel_11);
                		
                		btnNewButton_5.setBounds(471, 194, 140, 28);
                		opt.add(btnNewButton_5);
                		
                		chckbxNewCheckBox_1 = new JCheckBox("Visits");
                		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		chckbxNewCheckBox_1.setBounds(319, 197, 129, 23);
                		opt.add(chckbxNewCheckBox_1);
                        
                    }else if (list.getSelectedValue().equals("Search by calls")) {
                        optRestriction="calls";
                        JLabel lblNewLabel_11 = new JLabel("Do you want prisoners with or without calls permission?");
                		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		lblNewLabel_11.setBounds(274, 144, 399, 25);
                		opt.add(lblNewLabel_11);
                		
                		btnNewButton_5.setBounds(471, 194, 140, 28);
                		opt.add(btnNewButton_5);
                		
                		chckbxNewCheckBox_1 = new JCheckBox("Calls");
                		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		chckbxNewCheckBox_1.setBounds(319, 197, 129, 23);
                		opt.add(chckbxNewCheckBox_1);
					}
					frame.repaint();
				}
			}
		});
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Search by DNI", "Search by name", "Search by age", "Search by nationality", "Search by height", "Search by weight", "Search by threat level", "Search by cell number", "Search by time of condemnation", "Search by entrance date", "Search by visits", "Search by calls"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(259, 125, 248, 271);
		restMenu.add(list);
		
		JLabel lblNewLabel_9 = new JLabel("Select the field in which you want to put the restriction:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(259, 78, 385, 24);
		restMenu.add(lblNewLabel_9);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_4.setAction(endQ);
		btnNewButton_4.setBounds(581, 365, 112, 31);
		restMenu.add(btnNewButton_4);
		
		JLabel lblNewLabel_20 = new JLabel("");
		chckbxNewCheckBox.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(chckbxNewCheckBox.isSelected()) {
					lblNewLabel_20.setEnabled(true);
					lblNewLabel_10.setEnabled(true);
				}else {
					lblNewLabel_20.setEnabled(false);
					lblNewLabel_10.setEnabled(false);
					lblNewLabel_10.setText("");
				}
			}
		});
		chckbxNewCheckBox.setBounds(259, 414, 166, 23);
		restMenu.add(chckbxNewCheckBox);
		
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_10.setBounds(259, 444, 366, 18);
		restMenu.add(lblNewLabel_10);
		
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(lblNewLabel_20.isEnabled()) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnValue = jfc.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					String path = jfc.getSelectedFile().getAbsolutePath();
					lblNewLabel_10.setText(path+".csv");
			}}}
		});
		lblNewLabel_20
				.setIcon(new ImageIcon("resources\\carpeta.png"));
		lblNewLabel_20.setBounds(635, 433, 39, 37);
		restMenu.add(lblNewLabel_20);
		lblNewLabel_20.setEnabled(false);
		lblNewLabel_10.setEnabled(false);
		
		consultastxt = new JTextArea();
		consultastxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane sp = new JScrollPane(consultastxt);
		sp.setBounds(538, 127, 211, 224);
		sp.setBackground(SystemColor.menu);
		restMenu.add(sp);
		
		frame.repaint();
		return realizarConsulta;
	}
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "Apply restriction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			switch(optRestriction) {
			case "DNI":
				for (Prisoner p : Query.values()) {
					if (!p.getDNI().equals(restxt1.getText())) {
						deleteos.add(p.getNum_preso());
					}
				}
				consultastxt.setText(consultastxt.getText()+"DNI = "+restxt1.getText()+"\r\n");
				break;
			case "name":
				for (Prisoner p : Query.values()) {
					if (!p.getNombre().equals(restxt1.getText())) {
						deleteos.add(p.getNum_preso());
					}
				}
				consultastxt.setText(consultastxt.getText()+"Name = "+restxt1.getText()+"\r\n");
				break;
			case "age":
				Prisoner_IO a = new Prisoner_IO();
				for (Prisoner p : Query.values()) {
					int age = (YEAR - ((a.getTheDate(p.getF_nac()))[2]));
					if ((age < Integer.parseInt(restxt2.getText())) || (age > Integer.parseInt(restxt1.getText()))) {
						deleteos.add(p.getNum_preso());
					}
				}
				consultastxt.setText(consultastxt.getText()+"MaxAge = "+restxt1.getText()+" years\r\nMinAge = "+restxt2.getText()+" years\r\n");
				break;
			case "nationality":
				for (Prisoner p : Query.values()) {
					if (!p.getNacionalidad().equals(restxt1.getText())) {
						deleteos.add(p.getNum_preso());
					}
				}
				consultastxt.setText(consultastxt.getText()+"Nationality = "+restxt1.getText()+"\r\n");
				break;
			case "height":
				for (Prisoner p : Query.values()) {
					if ((p.getAltura() < Integer.parseInt(restxt2.getText())) || (p.getAltura() > Integer.parseInt(restxt1.getText()))) {
						deleteos.add(p.getNum_preso());
					}
				}
				consultastxt.setText(consultastxt.getText()+"MaxHeight = "+restxt1.getText()+" cm\r\nMinHeight = "+restxt2.getText()+" cm\r\n");
				break;
			case "weight":
				double minWeight = Double.parseDouble(restxt2.getText());
				double maxWeight = Double.parseDouble(restxt1.getText());
				for (Prisoner p : Query.values()) {
					if ((p.getPeso() < minWeight) || (p.getPeso() > maxWeight)) {
						deleteos.add(p.getNum_preso());
					}
				}
				consultastxt.setText(consultastxt.getText()+"MaxWeight = "+restxt1.getText()+" kg\r\nMinWeight = "+restxt2.getText()+" kg\r\n");
				break;
			case "threat level":
				for (Prisoner p : Query.values()) {
					if ((p.getNiv_amenaza() < Integer.parseInt(restxt2.getText())) || (p.getNiv_amenaza() > Integer.parseInt(restxt1.getText()))) {
						deleteos.add(p.getNum_preso());
					}
				}
				consultastxt.setText(consultastxt.getText()+"MaxThreat = "+restxt1.getText()+"\r\nMinThreat = "+restxt2.getText()+"\r\n");
				break;
			case "cell number":
				for (Prisoner p : Query.values()) {
					if ((p.getCelda().getNum_celda()) != Integer.parseInt(restxt1.getText())) {
						deleteos.add(p.getNum_preso());
					}
				}
				consultastxt.setText(consultastxt.getText()+"Cell = "+restxt1.getText()+"\r\n");
				break;
			case "time of condemnation":
				for (Prisoner p : Query.values()) {
					String s = p.getCondena();
					int c = Integer.parseInt(Character.toString(s.charAt(0)) + Character.toString(s.charAt(1))
							+ Character.toString(s.charAt(2)));
					if ((c >= Integer.parseInt(restxt1.getText())) || (c < Integer.parseInt(restxt2.getText()))) {
						deleteos.add(p.getNum_preso());
					}
				}
				consultastxt.setText(consultastxt.getText()+"MaxCondemnation = "+restxt1.getText()+" years\r\nMinCondemnation = "+restxt2.getText()+" years\r\n");
				break;
			case "entrance date":
				for (Prisoner p : Query.values()) {
					String s = p.getIngreso();
					int y = Integer.parseInt(Character.toString(s.charAt(6)) + Character.toString(s.charAt(7))
							+ Character.toString(s.charAt(8)) + Character.toString(s.charAt(9)));
					if ((y < Integer.parseInt(restxt2.getText())) || (y > Integer.parseInt(restxt1.getText()))) {
						deleteos.add(p.getNum_preso());
					}
				}
				consultastxt.setText(consultastxt.getText()+"MaxEntrance = "+restxt1.getText()+" years\r\nMinEntrance = "+restxt2.getText()+" years\r\n");
				break;
			case "visits":
				for (Prisoner p : Query.values()) {
					if (((!(chckbxNewCheckBox_1.isSelected())) && (p.isVisitas())) || ((chckbxNewCheckBox_1.isSelected()) && (!p.isVisitas()))) {
						deleteos.add(p.getNum_preso());
					}
				}
				if(chckbxNewCheckBox_1.isSelected()) {
					consultastxt.setText(consultastxt.getText()+"Visits = permitted\r\n");
				}else {
					consultastxt.setText(consultastxt.getText()+"Visits = not permitted\r\n");
				}
				break;
			case "calls":
				boolean calls;
				if(chckbxNewCheckBox_1.isSelected()) {calls=true;}else {calls=false;}
				for (Prisoner p : Query.values()) {
					if ((!calls) && (p.isLlamadas()) || ((calls) && (!p.isLlamadas()))) {
						deleteos.add(p.getNum_preso());
					}
				}
				if(chckbxNewCheckBox_1.isSelected()) {
					consultastxt.setText(consultastxt.getText()+"Calls = permitted\r\n");
				}else {
					consultastxt.setText(consultastxt.getText()+"Calls = not permitted\r\n");
				}
				break;
			default:
				break;
			}
				for (int i : deleteos) {
					Query.remove(i);
				}
				deleteos.clear();
				
				realizarConsulta.remove(opt);
				opt.removeAll();
				restxt1.setText("");
				restxt2.setText("");
				restMenu.setVisible(true);
				frame.repaint();
			}
		}
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "End Query");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if((chckbxNewCheckBox.isSelected())&&(lblNewLabel_10.getText().equals(""))) {
				MessageWindow m=new MessageWindow("Select save destination","");
				m.frame.setVisible(true);
			}
			else {
			JPanel readQ = new JPanel();
			readQ.setBounds(0, 0, 836, 511);
			readQ.setVisible(true);
			readQ.setLayout(null);

			JLabel lblNewLabelr = new JLabel("QUERY RESULTS");
			lblNewLabelr.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
			lblNewLabelr.setBounds(257, 25, 335, 37);
			readQ.add(lblNewLabelr);
			
			JTextArea txtrSafdSdfSdfds = new JTextArea();
			txtrSafdSdfSdfds.setFont(new Font("Monospaced", Font.PLAIN, 14));
			String s="";
			ArrayList<Integer> orderedP = new ArrayList<Integer>();
			for (int i : Query.keySet()) {
				orderedP.add(i);
			}
			Collections.sort(orderedP);
			for(int a=0;a<Query.size();a++) {
				Prisoner p=Query.get(orderedP.get(a));
				s=s+p.getNum_preso() + ", " + p.getNombre() + " " + p.getApellidos() + "\r\n";
			}
			txtrSafdSdfSdfds.setText(s);
			txtrSafdSdfSdfds.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtrSafdSdfSdfds.setBounds(200, 110, 455, 391);
			
			JScrollPane sp = new JScrollPane(txtrSafdSdfSdfds);
			sp.setBounds(268, 110, 455, 370);
			sp.setBackground(SystemColor.menu);
			readQ.add(sp);
			
			JLabel lblNewLabel_8 = new JLabel("Total number of prisoners in the query: "+Query.size());
			lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_8.setBounds(268, 73, 324, 26);
			readQ.add(lblNewLabel_8);
			
			restMenu.setVisible(false);
			lblNewLabel.setVisible(false);
			realizarConsulta.add(readQ);
			frame.repaint();
			
			if(chckbxNewCheckBox.isSelected()) {
				try {
					FileWriter writer = new FileWriter(lblNewLabel_10.getText());
					writer.write(
							"DNI;NOMBRE;APELLIDOS;F_NAC;NACIONALIDAD;SEXO;ALTURA(cm);PESO(kg);NUM_PRESO;NIV_AMENAZA;NUM_CELDA;CRIMEN;CONDENA(aa,mm,dd);INGRESO;VISITAS;LLAMADAS\n");
					for (Prisoner p : Query.values()) {
						writer.write(p.toCSV(';'));
					}
					writer.flush();
					writer.close();
					MessageWindow w=new MessageWindow("CSV saved","");
					w.frame.setVisible(true);
				} catch (Exception exce) {
					exce.printStackTrace();
				}
			}
		}
		}
	}
	private class SwingAction_8 extends AbstractAction {
		public SwingAction_8() {
			putValue(NAME, "Go back");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			optRestriction="a";
			applyR.actionPerformed(null);
		}
	}
	public JPanel stats(HashMap<Integer, Prisoner> prisoners) {

		setPrisoners(prisoners);

		JPanel stats = new JPanel();
		stats.setBounds(0, 0, 836, 511);
		stats.setVisible(true);
		stats.setLayout(null);

		JLabel lblNewLabel = new JLabel("PRISONER STATISTICS");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 335, 37);
		stats.add(lblNewLabel);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Prisoner_IO pio=new Prisoner_IO();
		textArea_1.setText(pio.stats(prisoners));
		JScrollPane sp = new JScrollPane(textArea_1);
		sp.setBounds(257, 168, 505, 223);
		sp.setBackground(SystemColor.menu);
		stats.add(sp);

		return stats;
	}
}
