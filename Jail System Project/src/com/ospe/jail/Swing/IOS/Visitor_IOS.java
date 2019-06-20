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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.AbstractListModel;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileSystemView;

import com.ospe.jail.Gestor;
import com.ospe.jail.Visitor;
import com.ospe.jail.IO.CivilServant_IO;
import com.ospe.jail.IO.Visitor_IO;
import com.ospe.jail.Swing.MessageWindow;

public class Visitor_IOS {
	HashMap<String, Visitor> Visitors;
	HashMap<String, Visitor> Query;
	ArrayList<String> deleteos = new ArrayList<String>();
	private JFrame frame;
	private DecimalFormat numberFormat2 = new DecimalFormat("#");
	public static final int YEAR = 2019;
	private JTextField textField;
	private Visitor edv;
	JTextArea textArea = new JTextArea();
	private final Action search = new SwingAction();
	private JTextField dnitxt;
	private JTextField nametxt;
	private JTextField lastnametxt;
	private JTextField birthtxt;
	private JTextField nationtext;
	private JTextField cmtxt;
	private JTextField kgtxt;
	private JTextField idtxt;
	private JTextField pvisitedtxt;
	private JTextField hourtxt;
	private JTextField birthtxt_2;
	private JTextField birthtxt_3;
	JButton btnNewButton_1 = new JButton();
	JCheckBox checkBoxMale = new JCheckBox("Male");
	JCheckBox checkBoxFemale = new JCheckBox("Female");
	JCheckBox ovCheckbox;
	String optRestriction;
	JCheckBox chckbxNewCheckBox_1;
	JComboBox comboBoxR;
	JComboBox comboBoxRC;
	private final Action saveNew = new SwingAction_1();
	private final Action editSearch = new SwingAction_2();
	private final Action saveEdit = new SwingAction_3();
	private JTextField textField_1;
	private final Action delete = new SwingAction_4();
	private JTextField restxt1 = new JTextField();
	private final Action applyR = new SwingAction_5();
	private JTextField restxt2 = new JTextField();
	JPanel opt = new JPanel();
	JPanel restMenu = new JPanel();
	JPanel realizarConsulta = new JPanel();
	private final Action endQ = new SwingAction_6();
	JCheckBox chckbxNewCheckBox = new JCheckBox("Export query to CSV");
	JLabel lblNewLabel_10 = new JLabel("Example direction");
	JLabel lblNewLabel = new JLabel("MAKE A QUERY");
	private final Action back = new SwingAction_8();
	JTextArea consultastxt;
	JList list = new JList();
	boolean volver = false;
	private JTextField vdate1;
	private JTextField vdate2;
	private JTextField vdate3;
	private JTextField numberVtxt;
	private JTextField aptxt;

	public HashMap<String, Visitor> getVisitors() {
		return Visitors;
	}

	public void setVisitors(HashMap<String, Visitor> visitors) {
		Visitors = visitors;
	}

	public Visitor_IOS(JFrame frame) {
		this.frame = frame;
		//initialize();
	}

	private void initialize() {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
		// MainPanel.add(crear(m.getVisitors()));
		MainPanel.add(realizarConsulta(m.getVisitors()));
		// MainPanel.add(editar(m.getCells(),m.getPavilions()));
		// MainPanel.add(borrar(m.getCells(),m.getPavilions()));
		// MainPanel.add(leerListado(m.getPrisoners()));
		// MainPanel.add(realizarConsulta(m.getCells()));
		// MainPanel.add(stats(m.getCells()));

		/*
		 * restMenu.setVisible(false); opt.setBounds(0, 0, 836, 511);
		 * opt.setVisible(true); opt.setLayout(null);
		 * 
		 * JButton btnNewButton_7 = new JButton("New button");
		 * btnNewButton_7.setAction(back); btnNewButton_7.setFont(new Font("Tahoma",
		 * Font.PLAIN, 14)); btnNewButton_7.setBounds(330, 412, 95, 23);
		 * opt.add(btnNewButton_7);
		 * 
		 * MainPanel.add(opt); JButton btnNewButton_5 = new JButton("New button");
		 * btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 * btnNewButton_5.setAction(applyR);
		 */

//---------PANELES---------------------------------------------------------------

		/*
		 * optRestriction="position";
		 * 
		 * JLabel lblNewLabel_11 = new JLabel("Insert position:");
		 * lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 * lblNewLabel_11.setBounds(274, 144, 147, 25); opt.add(lblNewLabel_11);
		 * 
		 * comboBoxPC = new JComboBox(); comboBoxPC.setFont(new Font("Tahoma",
		 * Font.PLAIN, 14)); comboBoxPC.setModel(new DefaultComboBoxModel(new String[]
		 * {"mantenimiento", "doctor", "psicologo", "cura", "tecnico informatico",
		 * "vigilante", "cocinero", "limpieza", "alcaide", "administrativo", "jurista",
		 * "sociologo"})); comboBoxPC.setBounds(274, 180, 184, 28); opt.add(comboBoxPC);
		 * 
		 * btnNewButton_5.setBounds(533, 180, 140, 28); opt.add(btnNewButton_5);
		 */
	}

	public JPanel leer(HashMap<String, Visitor> visitors) {
		setVisitors(visitors);
		JPanel leer = new JPanel();
		leer.setBounds(0, 0, 836, 511);
		leer.setVisible(true);
		leer.setLayout(null);

		JLabel lblNewLabel = new JLabel("READ ONE VISITOR");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 316, 37);
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

		JLabel lblNewLabel_1 = new JLabel("Insert visitor id:");
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
			putValue(SHORT_DESCRIPTION, "Search one visitor");
		}

		public void actionPerformed(ActionEvent e) {
			String id = textField.getText();
			if (Visitors.containsKey(id)) {
				textArea.setText(Visitors.get(id).toString());
			} else {
				textArea.setText("There is no visitor registered with that id.");
			}
		}
	}

	public JPanel crear(HashMap<String, Visitor> visitors) {
		setVisitors(visitors);
		JPanel crear = new JPanel();
		crear.setBounds(0, 0, 836, 511);
		crear.setVisible(true);
		crear.setLayout(null);

		JLabel lblNewLabel = new JLabel("CREATE A NEW VISITOR");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 369, 37);
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
		kgtxt.setBounds(434, 294, 86, 20);
		crear.add(kgtxt);
		kgtxt.setColumns(10);

		JLabel lblKg = new JLabel("kg");
		lblKg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKg.setBounds(530, 296, 52, 18);
		crear.add(lblKg);

		JLabel lblVisitorID = new JLabel("Visitor Id:");
		lblVisitorID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVisitorID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVisitorID.setBounds(308, 83, 116, 14);
		crear.add(lblVisitorID);

		idtxt = new JTextField();
		idtxt.setBounds(434, 83, 86, 20);
		crear.add(idtxt);
		idtxt.setColumns(10);

		JLabel lblSalary = new JLabel("Number of the prisoner visited:");
		lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSalary.setBounds(193, 325, 231, 14);
		crear.add(lblSalary);

		JLabel lblVisitorDate = new JLabel("Visitor date(dd/mm/yyyy):");
		lblVisitorDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVisitorDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVisitorDate.setBounds(232, 350, 192, 14);
		crear.add(lblVisitorDate);

		pvisitedtxt = new JTextField();
		pvisitedtxt.setBounds(434, 323, 86, 20);
		crear.add(pvisitedtxt);
		pvisitedtxt.setColumns(10);

		JLabel lblvHour = new JLabel("Visit hour(hh:mm):");
		lblvHour.setHorizontalAlignment(SwingConstants.RIGHT);
		lblvHour.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblvHour.setBounds(279, 375, 145, 14);
		crear.add(lblvHour);

		hourtxt = new JTextField();
		hourtxt.setBounds(434, 376, 87, 20);
		crear.add(hourtxt);
		hourtxt.setColumns(10);

		JLabel lblRelation = new JLabel("Relation with prisoner:");
		lblRelation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRelation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRelation.setBounds(207, 404, 217, 14);
		crear.add(lblRelation);

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

		btnNewButton_1.setAction(saveNew);
		btnNewButton_1.setBounds(737, 477, 89, 23);
		crear.add(btnNewButton_1);

		comboBoxR = new JComboBox();
		comboBoxR.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBoxR.setModel(
				new DefaultComboBoxModel(new String[] { "familiar", "pareja", "amigo", "abogado", "agente policial" }));
		comboBoxR.setBounds(434, 404, 142, 20);
		crear.add(comboBoxR);

		vdate1 = new JTextField();
		vdate1.setColumns(10);
		vdate1.setBounds(434, 350, 46, 20);
		crear.add(vdate1);

		JLabel label_1 = new JLabel("/");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(485, 350, 20, 20);
		crear.add(label_1);

		vdate2 = new JTextField();
		vdate2.setColumns(10);
		vdate2.setBounds(510, 350, 46, 20);
		crear.add(vdate2);

		JLabel label_2 = new JLabel("/");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(558, 350, 20, 20);
		crear.add(label_2);

		vdate3 = new JTextField();
		vdate3.setColumns(10);
		vdate3.setBounds(580, 350, 46, 20);
		crear.add(vdate3);

		JLabel lblNumberOfVisitors = new JLabel("Number of visitors:");
		lblNumberOfVisitors.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumberOfVisitors.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumberOfVisitors.setBounds(308, 430, 116, 14);
		crear.add(lblNumberOfVisitors);

		numberVtxt = new JTextField();
		numberVtxt.setBounds(434, 430, 86, 20);
		crear.add(numberVtxt);
		numberVtxt.setColumns(10);

		JLabel lblApplicantNames = new JLabel("Applicant name:");
		lblApplicantNames.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApplicantNames.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApplicantNames.setBounds(279, 460, 145, 14);
		crear.add(lblApplicantNames);

		aptxt = new JTextField();
		aptxt.setBounds(434, 458, 293, 20);
		crear.add(aptxt);
		aptxt.setColumns(10);
		setEditar(true);
		return crear;
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Save new visitor");
		}

		public void actionPerformed(ActionEvent e) {
			Visitor v = new Visitor();
			saveVisitor(v, "new");
		}
	}

	public void saveVisitor(Visitor v, String mode) {
		try {
			String vId = "";
			String oldId = "";
			boolean ov = true;
			boolean error = false;
			if (mode.equals("new")) {
				v.setId_visitor("");
			}

			v.setDNI(dnitxt.getText());

			v.setNombre(nametxt.getText());

			v.setApellidos(lastnametxt.getText());

			v.setF_nac(birthtxt.getText() + "/" + birthtxt_2.getText() + "/" + birthtxt_3.getText());

			v.setNacionalidad(nationtext.getText());

			if (checkBoxMale.isSelected()) {
				v.setSexo("h");
			} else if (checkBoxFemale.isSelected()) {
				v.setSexo("m");
			} else {
				error = true;
				MessageWindow full = new MessageWindow("Select one gender", "");
				full.frame.setVisible(true);
			}

			v.setAltura(Integer.parseInt(cmtxt.getText()));

			v.setPeso(Double.parseDouble(kgtxt.getText()));

			v.setPreso_visitado(Integer.parseInt(pvisitedtxt.getText()));

			v.setFecha_visita(vdate1.getText() + "/" + vdate2.getText() + "/" + vdate3.getText());

			v.setHora_visita(hourtxt.getText());

			v.setRelacion_preso(comboBoxR.getSelectedItem().toString());

			v.setNumero_visitantes(Integer.parseInt(numberVtxt.getText()));

			v.setSolicitante_visita(aptxt.getText());

			if (!error) {
				if (mode.equals("edit")) {
					if (!(Visitors.containsKey(idtxt.getText()))) {// si el nuevo nº no esta en presos
						Visitors.remove(v.getId_visitor());// aunque de normal se reescribe, si cambia el nÂº preso
															// quedarian los dos, asi
						// que hay que borrar el antiguo
						v.setId_visitor(idtxt.getText());
					} else {// si el nuevo nº existe ya
						if (!(idtxt.getText().equals(v.getId_visitor()))) {// si el nuevo nº no es igual al
																			// antiguo(overwrite)
							if (!(ovCheckbox.isSelected())) {
								ov = false;
								MessageWindow over = new MessageWindow("Save cancelled",
										"Overwrite existing visitor option not selected");
								over.frame.setVisible(true);
							} else {
								Visitors.remove(v.getId_visitor());// aunque de normal se reescribe, si cambia el nÂº
																	// preso quedarian los dos, asi
								// que hay que borrar el antiguo
								v.setId_visitor(idtxt.getText());
							}
						}
					}
				} else {
					if (Visitors.containsKey(idtxt.getText())) {
						ov = false;
						MessageWindow over = new MessageWindow("Visitor id in use",
								"Delete existing visitor to use that id");
						over.frame.setVisible(true);
					}
				}
				if (ov) {
					v.setId_visitor(idtxt.getText());
					Visitors.put(v.getId_visitor(), v);
					MessageWindow saved = new MessageWindow("Visitor saved", "");
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

	public JPanel editar(HashMap<String, Visitor> visitors) {
		setVisitors(visitors);
		JPanel crear = new JPanel();
		crear.setBounds(0, 0, 836, 511);
		crear.setVisible(true);
		crear.setLayout(null);

		JLabel lblNewLabel = new JLabel("EDIT A NEW VISITOR");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 369, 37);
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
		kgtxt.setBounds(434, 294, 86, 20);
		crear.add(kgtxt);
		kgtxt.setColumns(10);

		JLabel lblKg = new JLabel("kg");
		lblKg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKg.setBounds(530, 296, 52, 18);
		crear.add(lblKg);

		JLabel lblVisitorID = new JLabel("Visitor Id:");
		lblVisitorID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVisitorID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVisitorID.setBounds(308, 83, 116, 14);
		crear.add(lblVisitorID);

		idtxt = new JTextField();
		idtxt.setBounds(434, 83, 86, 20);
		crear.add(idtxt);
		idtxt.setColumns(10);

		JLabel lblSalary = new JLabel("Number of the prisoner visited:");
		lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSalary.setBounds(193, 325, 231, 14);
		crear.add(lblSalary);

		JLabel lblVisitorDate = new JLabel("Visitor date(yyyy/mm/dd):");
		lblVisitorDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVisitorDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVisitorDate.setBounds(232, 350, 192, 14);
		crear.add(lblVisitorDate);

		pvisitedtxt = new JTextField();
		pvisitedtxt.setBounds(434, 323, 86, 20);
		crear.add(pvisitedtxt);
		pvisitedtxt.setColumns(10);

		JLabel lblvHour = new JLabel("Visit hour(hh:mm):");
		lblvHour.setHorizontalAlignment(SwingConstants.RIGHT);
		lblvHour.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblvHour.setBounds(279, 375, 145, 14);
		crear.add(lblvHour);

		hourtxt = new JTextField();
		hourtxt.setBounds(434, 376, 87, 20);
		crear.add(hourtxt);
		hourtxt.setColumns(10);

		JLabel lblRelation = new JLabel("Relation with prisoner:");
		lblRelation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRelation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRelation.setBounds(207, 404, 217, 14);
		crear.add(lblRelation);

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

		btnNewButton_1.setAction(saveEdit);
		btnNewButton_1.setBounds(737, 477, 89, 23);
		crear.add(btnNewButton_1);

		comboBoxR = new JComboBox();
		comboBoxR.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBoxR.setModel(
				new DefaultComboBoxModel(new String[] { "familiar", "pareja", "amigo", "abogado", "agente policial" }));
		comboBoxR.setBounds(434, 404, 142, 20);
		crear.add(comboBoxR);

		vdate1 = new JTextField();
		vdate1.setColumns(10);
		vdate1.setBounds(434, 350, 46, 20);
		crear.add(vdate1);

		JLabel label_1 = new JLabel("/");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(485, 350, 20, 20);
		crear.add(label_1);

		vdate2 = new JTextField();
		vdate2.setColumns(10);
		vdate2.setBounds(510, 350, 46, 20);
		crear.add(vdate2);

		JLabel label_2 = new JLabel("/");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(558, 350, 20, 20);
		crear.add(label_2);

		vdate3 = new JTextField();
		vdate3.setColumns(10);
		vdate3.setBounds(580, 350, 46, 20);
		crear.add(vdate3);

		JLabel lblNumberOfVisitors = new JLabel("Number of visitors:");
		lblNumberOfVisitors.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumberOfVisitors.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumberOfVisitors.setBounds(308, 430, 116, 14);
		crear.add(lblNumberOfVisitors);

		numberVtxt = new JTextField();
		numberVtxt.setBounds(434, 430, 86, 20);
		crear.add(numberVtxt);
		numberVtxt.setColumns(10);

		JLabel lblApplicantNames = new JLabel("Applicant name:");
		lblApplicantNames.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApplicantNames.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApplicantNames.setBounds(279, 460, 145, 14);
		crear.add(lblApplicantNames);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setAction(editSearch);
		btnNewButton_2.setBounds(537, 80, 89, 23);
		crear.add(btnNewButton_2);
		idtxt.setEditable(true);
		
		aptxt = new JTextField();
		aptxt.setBounds(434, 458, 293, 20);
		crear.add(aptxt);
		aptxt.setColumns(10);
		
		ovCheckbox = new JCheckBox("Overwrite if number");
		ovCheckbox.setBounds(650, 80, 169, 23);
		crear.add(ovCheckbox);
		
		JLabel lblNewLabel_6 = new JLabel(" already exists");
		lblNewLabel_6.setBounds(670, 100, 89, 14);
		crear.add(lblNewLabel_6);
		
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

		pvisitedtxt.setEditable(a);
		pvisitedtxt.setText("");

		vdate1.setEditable(a);
		vdate1.setText("");

		vdate2.setEditable(a);
		vdate2.setText("");

		vdate3.setEditable(a);
		vdate3.setText("");

		hourtxt.setEditable(a);
		hourtxt.setText("");

		comboBoxR.setEnabled(a);

		numberVtxt.setEditable(a);
		numberVtxt.setText("");

		aptxt.setEditable(a);
		aptxt.setText("");

		btnNewButton_1.setEnabled(a);

	}

	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Search");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {

			numberFormat2.setMinimumIntegerDigits(2);
			String id = idtxt.getText();
			Visitor_IO vio = new Visitor_IO();
			if (Visitors.containsKey(id)) {
				setEditar(true);
				edv = Visitors.get(id);

				dnitxt.setText(edv.getDNI());

				nametxt.setText(edv.getNombre());

				lastnametxt.setText(edv.getApellidos());

				int date[] = vio.getTheDate(edv.getF_nac());
				birthtxt.setText(numberFormat2.format(date[0]) + "");
				birthtxt_2.setText(numberFormat2.format(date[1]) + "");
				birthtxt_3.setText(numberFormat2.format(date[2]) + "");

				nationtext.setText(edv.getNacionalidad());

				if (edv.getSexo().equals("h")) {
					checkBoxMale.setSelected(true);
				} else if (edv.getSexo().equals("m")) {
					checkBoxFemale.setSelected(true);
				}
				cmtxt.setText(edv.getAltura() + "");

				kgtxt.setText(edv.getPeso() + "");

				pvisitedtxt.setText(edv.getPreso_visitado() + "");

				int date2[] = vio.getTheDate(edv.getFecha_visita());
				vdate1.setText(numberFormat2.format(date[0]) + "");
				vdate2.setText(numberFormat2.format(date[1]) + "");
				vdate3.setText(numberFormat2.format(date[2]) + "");

				hourtxt.setText(edv.getHora_visita() + "");

				comboBoxR.setSelectedItem(edv.getRelacion_preso());

				numberVtxt.setText(edv.getNumero_visitantes() + "");

				aptxt.setText(edv.getSolicitante_visita() + "");

			} else {
				setEditar(false);
				MessageWindow m = new MessageWindow("Invalid visitor id", "There is no visitor with that id");
				idtxt.setText("");
				m.frame.setVisible(true);
			}
		}
	}

	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Save edited visitor");
		}

		public void actionPerformed(ActionEvent e) {
			saveVisitor(edv, "edit");
		}
	}

	public JPanel borrar(HashMap<String, Visitor> visitors) {

		setVisitors(visitors);

		JPanel borrar = new JPanel();
		borrar.setBounds(0, 0, 836, 511);
		borrar.setVisible(true);
		borrar.setLayout(null);

		JLabel lblNewLabel = new JLabel("DELETE AN EXISTING VISITOR");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 478, 37);
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

		JLabel lblNewLabel_7 = new JLabel("Insert the id of the visitor you want to delete:");
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
			putValue(SHORT_DESCRIPTION, "Delete visitor");
		}

		public void actionPerformed(ActionEvent e) {
			try {
				String id = textField_1.getText();
				if (Visitors.containsKey(id)) {
					Visitors.remove(id);
					MessageWindow m = new MessageWindow("Visitor deleted", "");
					m.frame.setVisible(true);
					textField_1.setText("");
				} else {
					MessageWindow m = new MessageWindow("Invalid visitor", "There is no visitor with that id");
					m.frame.setVisible(true);
					textField_1.setText("");
				}
			} catch (Exception es) {
				MessageWindow m = new MessageWindow("Format error ocurred", "Introduce an id");
				m.frame.setVisible(true);
			}
		}
	}

	public JPanel leerListado(HashMap<String, Visitor> visitors) {

		setVisitors(visitors);

		JPanel leerListado = new JPanel();
		leerListado.setBounds(0, 0, 836, 511);
		leerListado.setVisible(true);
		leerListado.setLayout(null);

		JLabel lblNewLabel = new JLabel("READ LIST OF ALL VISITORS");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 440, 37);
		leerListado.add(lblNewLabel);

		JTextArea txtrSafdSdfSdfds = new JTextArea();
		txtrSafdSdfSdfds.setFont(new Font("Monospaced", Font.PLAIN, 14));
		String s = "";
		ArrayList<String> orderedP = new ArrayList<String>();
		for (String i : Visitors.keySet()) {
			orderedP.add(i);
		}
		Collections.sort(orderedP);
		for (int a = 0; a < Visitors.size(); a++) {
			Visitor v = Visitors.get(orderedP.get(a));
			s = s + v.getId_visitor() + ", " + v.getNombre() + " " + v.getApellidos() + "\r\n";
		}
		txtrSafdSdfSdfds.setText(s);
		txtrSafdSdfSdfds.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtrSafdSdfSdfds.setBounds(268, 110, 455, 391);

		JScrollPane sp = new JScrollPane(txtrSafdSdfSdfds);
		sp.setBounds(268, 110, 455, 370);
		sp.setBackground(SystemColor.menu);
		leerListado.add(sp);

		JLabel lblNewLabel_8 = new JLabel("Current number of visitors in the database: " + Visitors.size());
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(268, 73, 324, 26);
		leerListado.add(lblNewLabel_8);

		return leerListado;
	}

	public JPanel realizarConsulta(HashMap<String, Visitor> visitors) {

		setVisitors(visitors);
		Query = new HashMap<String, Visitor>(Visitors);

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
						optRestriction = "DNI";

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

					} else if (list.getSelectedValue().equals("Search by name")) {
						optRestriction = "name";
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

					} else if (list.getSelectedValue().equals("Search by age")) {
						optRestriction = "age";

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

					} else if (list.getSelectedValue().equals("Search by nationality")) {
						optRestriction = "nationality";
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

					} else if (list.getSelectedValue().equals("Search by height")) {
						optRestriction = "height";
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

					} else if (list.getSelectedValue().equals("Search by weight")) {
						optRestriction = "weight";
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

					} else if (list.getSelectedValue().equals("Search by visitor Id")) {
						optRestriction = "id";
						restxt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
						restxt1.setBounds(274, 180, 202, 28);
						restxt1.setColumns(10);
						opt.add(restxt1);

						JLabel lblNewLabel_11 = new JLabel("Insert Id:");
						lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblNewLabel_11.setBounds(274, 144, 147, 25);
						opt.add(lblNewLabel_11);

						btnNewButton_5.setBounds(533, 180, 140, 28);
						opt.add(btnNewButton_5);

					}else if (list.getSelectedValue().equals("Search by prisoner visited")) {
						optRestriction = "pvisit";
						restxt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
						restxt1.setBounds(274, 180, 202, 28);
						restxt1.setColumns(10);
						opt.add(restxt1);

						JLabel lblNewLabel_11 = new JLabel("Insert number of the visited prisoner:");
						lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblNewLabel_11.setBounds(274, 144, 300, 25);
						opt.add(lblNewLabel_11);

						btnNewButton_5.setBounds(533, 180, 140, 28);
						opt.add(btnNewButton_5);

					}else if (list.getSelectedValue().equals("Search by visit date")) {
						optRestriction = "vdate";

						restxt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
						restxt1.setBounds(274, 180, 202, 28);
						restxt1.setColumns(10);
						opt.add(restxt1);

						JLabel lblNewLabel_11 = new JLabel("Insert maximum visit month(mm):");
						lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblNewLabel_11.setBounds(274, 144, 300, 25);
						opt.add(lblNewLabel_11);

						btnNewButton_5.setBounds(520, 274, 140, 28);
						opt.add(btnNewButton_5);

						JLabel lblNewLabel_12 = new JLabel("Insert minimum visit month(mm):");
						lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblNewLabel_12.setBounds(274, 240, 300, 25);
						opt.add(lblNewLabel_12);

						restxt2.setBounds(274, 276, 202, 28);
						opt.add(restxt2);
						restxt2.setColumns(10);

					} else if (list.getSelectedValue().equals("Search by visit hour")) {
						optRestriction = "hour";

						restxt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
						restxt1.setBounds(274, 180, 202, 28);
						restxt1.setColumns(10);
						opt.add(restxt1);

						JLabel lblNewLabel_11 = new JLabel("Insert maximum visit hour(hh):");
						lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblNewLabel_11.setBounds(274, 144, 202, 25);
						opt.add(lblNewLabel_11);

						btnNewButton_5.setBounds(520, 274, 140, 28);
						opt.add(btnNewButton_5);

						JLabel lblNewLabel_12 = new JLabel("Insert minimum visit hour(hh):");
						lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblNewLabel_12.setBounds(274, 240, 202, 25);
						opt.add(lblNewLabel_12);

						restxt2.setBounds(274, 276, 202, 28);
						opt.add(restxt2);
						restxt2.setColumns(10);

					}else if (list.getSelectedValue().equals("Search by relation with the prisoner")) {
						optRestriction = "relation";

						JLabel lblNewLabel_11 = new JLabel("Select relation with the prisoner:");
						lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblNewLabel_11.setBounds(274, 144, 300, 25);
						opt.add(lblNewLabel_11);

						comboBoxRC = new JComboBox();
						comboBoxRC.setModel(
								new DefaultComboBoxModel(new String[] { "familiar", "pareja", "amigo", "abogado", "agente policial" }));
						
						comboBoxRC.setBounds(274, 180, 184, 28);
						opt.add(comboBoxRC);

						btnNewButton_5.setBounds(533, 180, 140, 28);
						opt.add(btnNewButton_5);
					} else if (list.getSelectedValue().equals("Search by number of visitors")) {
						optRestriction = "nvisit";
						restxt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
						restxt1.setBounds(274, 180, 202, 28);
						restxt1.setColumns(10);
						opt.add(restxt1);

						JLabel lblNewLabel_11 = new JLabel("Insert number of visitors:");
						lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblNewLabel_11.setBounds(274, 144, 300, 25);
						opt.add(lblNewLabel_11);

						btnNewButton_5.setBounds(533, 180, 140, 28);
						opt.add(btnNewButton_5);

					} else if (list.getSelectedValue().equals("Search by visit applicant")) {
						optRestriction = "vapp";
						restxt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
						restxt1.setBounds(274, 180, 202, 28);
						restxt1.setColumns(10);
						opt.add(restxt1);

						JLabel lblNewLabel_11 = new JLabel("Insert visitor applicant:");
						lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblNewLabel_11.setBounds(274, 144, 147, 25);
						opt.add(lblNewLabel_11);

						btnNewButton_5.setBounds(533, 180, 140, 28);
						opt.add(btnNewButton_5);

					}
					frame.repaint();
				}
			}
		});
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Search by DNI", "Search by name", "Search by age",
					"Search by nationality", "Search by height", "Search by weight", "Search by visitor Id",
					"Search by prisoner visited", "Search by visit date", "Search by visit hour",
					"Search by relation with the prisoner", "Search by number of visitors",
					"Search by visit applicant" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(259, 125, 269, 294);
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
				if (chckbxNewCheckBox.isSelected()) {
					lblNewLabel_20.setEnabled(true);
					lblNewLabel_10.setEnabled(true);
				} else {
					lblNewLabel_20.setEnabled(false);
					lblNewLabel_10.setEnabled(false);
					lblNewLabel_10.setText("");
				}
			}
		});
		chckbxNewCheckBox.setBounds(259, 430, 166, 23);
		restMenu.add(chckbxNewCheckBox);

		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_10.setBounds(259, 460, 366, 18);
		restMenu.add(lblNewLabel_10);

		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (lblNewLabel_20.isEnabled()) {
					JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
					int returnValue = jfc.showSaveDialog(null);
					if (returnValue == JFileChooser.APPROVE_OPTION) {
						String path = jfc.getSelectedFile().getAbsolutePath();
						lblNewLabel_10.setText(path + ".csv");
					}
				}
			}
		});
		lblNewLabel_20
				.setIcon(new ImageIcon("resources\\carpeta.png"));
		lblNewLabel_20.setBounds(635, 449, 39, 37);
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
			switch (optRestriction) {
			case "DNI":
				for (Visitor v : Query.values()) {
					if (!v.getDNI().equals(restxt1.getText())) {
						deleteos.add(v.getId_visitor());
					}
				}
				consultastxt.setText(consultastxt.getText() + "DNI = " + restxt1.getText() + "\r\n");
				break;
			case "name":
				for (Visitor v : Query.values()) {
					if (!v.getNombre().equals(restxt1.getText())) {
						deleteos.add(v.getId_visitor());
					}
				}
				consultastxt.setText(consultastxt.getText() + "Name = " + restxt1.getText() + "\r\n");
				break;
			case "age":
				Visitor_IO a = new Visitor_IO();
				for (Visitor v : Query.values()) {
					int age = (YEAR - ((a.getTheDate(v.getF_nac()))[2]));
					if ((age < Integer.parseInt(restxt2.getText())) || (age > Integer.parseInt(restxt1.getText()))) {
						deleteos.add(v.getId_visitor());
					}
				}
				consultastxt.setText(consultastxt.getText() + "MaxAge = " + restxt1.getText() + " years\r\nMinAge = "
						+ restxt2.getText() + " years\r\n");
				break;
			case "nationality":
				for (Visitor v : Query.values()) {
					if (!v.getNacionalidad().equals(restxt1.getText())) {
						deleteos.add(v.getId_visitor());
					}
				}
				consultastxt.setText(consultastxt.getText() + "Nationality = " + restxt1.getText() + "\r\n");
				break;
			case "height":
				for (Visitor v : Query.values()) {
					if ((v.getAltura() < Integer.parseInt(restxt2.getText()))
							|| (v.getAltura() > Integer.parseInt(restxt1.getText()))) {
						deleteos.add(v.getId_visitor());
					}
				}
				consultastxt.setText(consultastxt.getText() + "MaxHeight = " + restxt1.getText() + " cm\r\nMinHeight = "
						+ restxt2.getText() + " cm\r\n");
				break;
			case "weight":
				double minWeight = Double.parseDouble(restxt2.getText());
				double maxWeight = Double.parseDouble(restxt1.getText());
				for (Visitor v : Query.values()) {
					if ((v.getPeso() < minWeight) || (v.getPeso() > maxWeight)) {
						deleteos.add(v.getId_visitor());
					}
				}
				consultastxt.setText(consultastxt.getText() + "MaxWeight = " + restxt1.getText() + " kg\r\nMinWeight = "
						+ restxt2.getText() + " kg\r\n");
				break;
			case "id":
				for (Visitor v : Query.values()) {
					if (!v.getId_visitor().equals(restxt1.getText())) {
						deleteos.add(v.getId_visitor());
					}
				}
				consultastxt.setText(consultastxt.getText() + "Id = " + restxt1.getText()+ "\r\n");
				break;
			case "pvisit":
				for (Visitor v : Query.values()) {
					if (v.getPreso_visitado() != (Integer.parseInt(restxt1.getText()))) {
						deleteos.add(v.getId_visitor());
					}
				}
				consultastxt.setText(consultastxt.getText() + "Prisoner visited = " + restxt1.getText() + "\r\n");
				break;
			case "vdate":
				int minMonth = Integer.parseInt(restxt2.getText());
				int maxMonth = Integer.parseInt(restxt1.getText());
				for (Visitor v : Query.values()) {
					String s = v.getFecha_visita();
					int month = Integer.parseInt(Character.toString(s.charAt(3)) + Character.toString(s.charAt(4)));
					if ((month < minMonth) || (month >= maxMonth)) {
						deleteos.add(v.getId_visitor());
					}
				}
				consultastxt.setText(consultastxt.getText() + "MaxMonth = " + restxt1.getText() + "\r\nMinMonth = "+ restxt2.getText() + "\r\n");
				break;
			case "hour":
				int minHour = Integer.parseInt(restxt2.getText());
				int maxHour = Integer.parseInt(restxt1.getText());
				for (Visitor v : Query.values()) {
					String s = v.getHora_visita();
					int hour = Integer.parseInt(Character.toString(s.charAt(0)) + Character.toString(s.charAt(1)));
					if ((hour < minHour) || (hour >= maxHour)) {
						deleteos.add(v.getId_visitor());
					}
				}
				consultastxt.setText(consultastxt.getText() + "MaxHour = " + restxt1.getText() + "\r\nMinHour = "+ restxt2.getText() + "\r\n");
				break;
			case "relation":
				for (Visitor v : Query.values()) {
					if (!comboBoxRC.getSelectedItem().toString().equals(v.getRelacion_preso())) {
						deleteos.add(v.getId_visitor());
					}
				}
				consultastxt.setText(consultastxt.getText() + "Relation = " + comboBoxRC.getSelectedItem().toString() + "\r\n");
				break;
			case "nvisit":
				for (Visitor v : Query.values()) {
					if (v.getNumero_visitantes() != Integer.parseInt(restxt1.getText())) {
						deleteos.add(v.getId_visitor());
					}
				}
				consultastxt.setText(consultastxt.getText() + "Number of visitors = " + restxt1.getText() + "\r\n");
				break;
			case "vapp":
				for (Visitor v : Query.values()) {
					if (!v.getSolicitante_visita().equals(restxt1.getText())) {
						deleteos.add(v.getId_visitor());
					}
				}
				consultastxt.setText(consultastxt.getText() + "Visitor applicant = " + restxt1.getText() + "\r\n");
				break;
			default:
				break;
			}
			for (String i : deleteos) {
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
			if ((chckbxNewCheckBox.isSelected()) && (lblNewLabel_10.getText().equals(""))) {
				MessageWindow m = new MessageWindow("Select save destination", "");
				m.frame.setVisible(true);
			} else {
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
				String s = "";
				ArrayList<String> orderedP = new ArrayList<String>();
				for (String i : Query.keySet()) {
					orderedP.add(i);
				}
				Collections.sort(orderedP);
				for (int a = 0; a < Query.size(); a++) {
					Visitor v = Query.get(orderedP.get(a));
					s = s + v.getId_visitor() + ", " + v.getNombre() + " " + v.getApellidos() + "\r\n";
				}
				txtrSafdSdfSdfds.setText(s);
				txtrSafdSdfSdfds.setBorder(new LineBorder(new Color(0, 0, 0)));
				txtrSafdSdfSdfds.setBounds(200, 110, 455, 391);

				JScrollPane sp = new JScrollPane(txtrSafdSdfSdfds);
				sp.setBounds(268, 110, 455, 370);
				sp.setBackground(SystemColor.menu);
				readQ.add(sp);

				JLabel lblNewLabel_8 = new JLabel("Total number of visitors in the query: " + Query.size());
				lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_8.setBounds(268, 73, 324, 26);
				readQ.add(lblNewLabel_8);

				restMenu.setVisible(false);
				lblNewLabel.setVisible(false);
				realizarConsulta.add(readQ);
				frame.repaint();

				if (chckbxNewCheckBox.isSelected()) {
					try {
						FileWriter writer = new FileWriter(lblNewLabel_10.getText());
						writer.write(
								"DNI;NOMBRE;APELLIDOS;F_NAC;NACIONALIDAD;SEXO;ALTURA(cm);PESO(kg);ID_VISIT;PRESO_VISIT;FECHA_VISIT(dd,mm,aaa);HORA_VISIT(hh,mm,ss);RELACION_PRESO;NUM_VISIT;SOLICITANTE_VISITA\n");
						for (Visitor v : Query.values()) {
							writer.write(v.toCSV(';'));
						}
						writer.flush();
						writer.close();
						MessageWindow w = new MessageWindow("CSV saved", "");
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
			optRestriction = "a";
			applyR.actionPerformed(null);
		}
	}
	
	public JPanel stats(HashMap<String, Visitor> visitors) {

		setVisitors(visitors);

		JPanel stats = new JPanel();
		stats.setBounds(0, 0, 836, 511);
		stats.setVisible(true);
		stats.setLayout(null);

		JLabel lblNewLabel = new JLabel("VISITOR STATISTICS");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 390, 37);
		stats.add(lblNewLabel);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Visitor_IO vio=new Visitor_IO();
		textArea_1.setText(vio.stats(Visitors));
		JScrollPane sp = new JScrollPane(textArea_1);
		sp.setBounds(257, 168, 505, 223);
		sp.setBackground(SystemColor.menu);
		stats.add(sp);

		return stats;
	}
	

}