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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

import com.ospe.jail.Cell;
import com.ospe.jail.Gestor;
import com.ospe.jail.Pavilion;
import com.ospe.jail.Prisoner;
import com.ospe.jail.IO.Cell_IO;
import com.ospe.jail.IO.Prisoner_IO;
import com.ospe.jail.Swing.MessageWindow;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Cell_IOS {
	HashMap<Integer, Pavilion> Pavilions;
	HashMap<Integer, Cell> Cells;
	HashMap<Integer, Cell> Query;
	ArrayList<Integer> deleteos = new ArrayList<Integer>();
	private JFrame frame;
	public static final int YEAR = 2019;
	private JTextField textField;
	private Cell edc;
	JTextArea textArea = new JTextArea();
	private final Action search = new SwingAction();
	private JTextField Sec;
	private JTextField floor;
	private JTextField pav;
	private JTextField numbertxt;
	private JTextField restxt1 = new JTextField();
	private JTextField restxt2 = new JTextField();
	JButton btnNewButton_1 = new JButton();
	JComboBox comboBox = new JComboBox();
	JCheckBox ovCheckbox;
	String optRestriction;
	JCheckBox chckbxNewCheckBox_1;
	private JTextField textField_1;
	private final Action saveNew = new SwingAction_1();
	JCheckBox checkO = new JCheckBox("Open");
	JCheckBox checkC = new JCheckBox("Closed");
	private final Action editSearch = new SwingAction_2();
	private final Action saveEdit = new SwingAction_3();
	private final Action delete = new SwingAction_4();
	private final Action applyR = new SwingAction_5();
	private final Action endQ = new SwingAction_6();
	private final Action back = new SwingAction_8();
	JPanel opt = new JPanel();
	JPanel restMenu = new JPanel();
	JPanel realizarConsulta = new JPanel();
	JCheckBox chckbxNewCheckBox = new JCheckBox("Export query to CSV");
	JLabel lblNewLabel_10 = new JLabel("Example direction");
	JLabel lblNewLabel = new JLabel("MAKE A QUERY");
	JTextArea consultastxt;
	JList list = new JList();
	JComboBox comboBox_1 = new JComboBox();
	JComboBox comboBox_2 = new JComboBox();
	JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Individual");
	JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Doble");
	boolean volver = false;

	public Cell getEdc() {
		return edc;
	}

	public void setEdc(Cell edc) {
		this.edc = edc;
	}

	public HashMap<Integer, Pavilion> getPavilions() {
		return Pavilions;
	}

	public void setPavilions(HashMap<Integer, Pavilion> pavilions) {
		Pavilions = pavilions;
	}

	public HashMap<Integer, Cell> getCells() {
		return Cells;
	}

	public void setCells(HashMap<Integer, Cell> cells) {
		Cells = cells;
	}

//-------------------------------------------------------------------------------------------------------//
//----------------------------------------------COMMENT--------------------------------------------------//	
//-------------------------------------------------------------------------------------------------------//	
	public Cell_IOS(JFrame frame) {
		this.frame = frame;
		// initialize();
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
		// MainPanel.add(leer(m.getPrisoners()));
		// MainPanel.add(crear(m.getCells(),m.getPavilions()));
		// MainPanel.add(editar(m.getCells(),m.getPavilions()));
		// MainPanel.add(borrar(m.getCells(),m.getPavilions()));
		// MainPanel.add(leerListado(m.getPrisoners()));
		// MainPanel.add(realizarConsulta(m.getCells()));
		MainPanel.add(stats(m.getCells()));

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
		 * 
		 * 
		 * //---------PANELES-----------------------------------------------------------
		 * ----
		 * 
		 * optRestriction="security level"; restxt1.setFont(new Font("Tahoma",
		 * Font.PLAIN, 14)); restxt1.setBounds(274, 180, 202, 28);
		 * restxt1.setColumns(10); opt.add(restxt1);
		 * 
		 * JLabel lblNewLabel_11 = new JLabel("Insert maximum security level:");
		 * lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 * lblNewLabel_11.setBounds(274, 144, 228, 25); opt.add(lblNewLabel_11);
		 * 
		 * btnNewButton_5.setBounds(520, 274, 140, 28); opt.add(btnNewButton_5);
		 * 
		 * JLabel lblNewLabel_12 = new JLabel("Insert minimum security level:");
		 * lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 * lblNewLabel_12.setBounds(274, 240, 228, 25); opt.add(lblNewLabel_12);
		 * 
		 * restxt2.setBounds(274, 276, 202, 28); opt.add(restxt2);
		 * restxt2.setColumns(10);
		 */
	}

//-------------------------------------------------------------------------------------------------------//
//----------------------------------------------COMMENT--------------------------------------------------//	
//-------------------------------------------------------------------------------------------------------//

	public JPanel leer(HashMap<Integer, Cell> cells) {
		setCells(cells);
		JPanel leer = new JPanel();
		leer.setBounds(0, 0, 836, 511);
		leer.setVisible(true);
		leer.setLayout(null);

		JLabel lblNewLabel = new JLabel("READ ONE CELL");
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

		JLabel lblNewLabel_1 = new JLabel("Insert cell number:");
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
			putValue(SHORT_DESCRIPTION, "Search one cell");
		}

		public void actionPerformed(ActionEvent e) {
			try {
			int id = Integer.parseInt(textField.getText());
			if (Cells.containsKey(id)) {
				textArea.setText(Cells.get(id).toString());
			} else {
				textArea.setText("There is no cell registered with that number.");
			}
		}catch(Exception exc) {
			MessageWindow m = new MessageWindow("Format error", "Introduce a valid cell number");
			m.frame.setVisible(true);	
		}
		}
	}

	public JPanel crear(HashMap<Integer, Cell> cells, HashMap<Integer, Pavilion> pavilions) {

		setCells(cells);
		setPavilions(pavilions);
		JPanel crear = new JPanel();
		crear.setBounds(0, 0, 836, 511);
		crear.setVisible(true);
		crear.setLayout(null);

		JLabel lblNewLabel = new JLabel("CREATE A NEW CELL");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 335, 37);
		crear.add(lblNewLabel);

		JLabel cellT = new JLabel("Cell Type:");
		cellT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cellT.setHorizontalAlignment(SwingConstants.RIGHT);
		cellT.setBounds(350, 124, 74, 14);
		crear.add(cellT);

		JLabel door = new JLabel("Door State:");
		door.setFont(new Font("Tahoma", Font.PLAIN, 13));
		door.setHorizontalAlignment(SwingConstants.RIGHT);
		door.setBounds(350, 163, 74, 14);
		crear.add(door);

		JLabel seclb = new JLabel("Security Level:");
		seclb.setFont(new Font("Tahoma", Font.PLAIN, 13));
		seclb.setHorizontalAlignment(SwingConstants.RIGHT);
		seclb.setBounds(330, 202, 94, 14);
		crear.add(seclb);

		Sec = new JTextField();
		Sec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Sec.setBounds(434, 200, 94, 20);
		crear.add(Sec);
		Sec.setColumns(10);

		JLabel floorlb = new JLabel("Cell Floor:");
		floorlb.setHorizontalAlignment(SwingConstants.RIGHT);
		floorlb.setFont(new Font("Tahoma", Font.PLAIN, 13));
		floorlb.setBounds(318, 241, 106, 14);
		crear.add(floorlb);

		floor = new JTextField();
		floor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		floor.setBounds(434, 239, 94, 20);
		crear.add(floor);
		floor.setColumns(10);

		JLabel pavlb = new JLabel("Pavilion number:");
		pavlb.setHorizontalAlignment(SwingConstants.RIGHT);
		pavlb.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pavlb.setBounds(308, 285, 116, 14);
		crear.add(pavlb);

		pav = new JTextField();
		pav.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pav.setBounds(434, 283, 94, 20);
		crear.add(pav);
		pav.setColumns(10);

		JLabel cellN = new JLabel("Cell Number:");
		cellN.setHorizontalAlignment(SwingConstants.RIGHT);
		cellN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cellN.setBounds(308, 83, 116, 14);
		crear.add(cellN);

		numbertxt = new JTextField();
		numbertxt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		numbertxt.setBounds(434, 83, 93, 20);
		crear.add(numbertxt);
		numbertxt.setColumns(10);

		btnNewButton_1.setAction(saveNew);
		btnNewButton_1.setBounds(655, 417, 89, 23);
		crear.add(btnNewButton_1);

		checkO.setFont(new Font("Tahoma", Font.PLAIN, 13));
		checkO.setBounds(430, 160, 97, 23);
		crear.add(checkO);

		checkC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		checkC.setBounds(529, 160, 97, 23);
		crear.add(checkC);

		checkO.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (checkO.isSelected()) {
					checkC.setSelected(false);
				}
			}
		});
		checkC.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (checkC.isSelected()) {
					checkO.setSelected(false);
				}
			}
		});

		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Individual", "Doble" }));
		comboBox.setBounds(434, 121, 94, 20);
		crear.add(comboBox);
		setEditar(true);
		return crear;
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Save new cell");
		}

		public void actionPerformed(ActionEvent e) {
			Cell c = new Cell();
			saveCell(c, "new");
		}
	}

	public void saveCell(Cell c, String mode) {
		try {
			int pavId = 0;
			int oldId = 0;
			boolean ov = true;
			boolean error = false;
			if (mode.equals("new")) {
				c.setPabellon(new Pavilion());
				c.getPabellon().setNum_pabellon(0);
			}
			if (comboBox.getSelectedItem().equals("Individual") && (c.getPresos().size() == 2)) {
				error = true;
				MessageWindow tam = new MessageWindow("Size does not match",
						"Cannot be individual with 2 prisoners inside");
				tam.frame.setVisible(true);
			} else {
				c.setTipo_celda(comboBox.getSelectedItem().toString());
			}

			if (checkO.isSelected()) {
				c.setEstado_puerta(true);
			} else if (checkC.isSelected()) {
				c.setEstado_puerta(false);
			} else {
				error = true;
				MessageWindow door = new MessageWindow("Select one door state", "");
				door.frame.setVisible(true);
			}
			c.setNivel_seguridad(Integer.parseInt(Sec.getText()));

			c.setPiso(Integer.parseInt(floor.getText()));

			pavId = Integer.parseInt(pav.getText());
			if (Pavilions.containsKey(pavId)) {
				oldId = c.getPabellon().getNum_pabellon();
				c.setPabellon(Pavilions.get(pavId));
			} else {
				error = true;
				MessageWindow pav = new MessageWindow("Invalid pavilion", "");
				pav.frame.setVisible(true);
			}

			if (!error) {
				if (mode.equals("edit")) {
					if (!(Cells.containsKey(Integer.parseInt(numbertxt.getText())))) {// si el nuevo nº no esta en cells
						Cells.remove(c.getNum_celda());// aunque de normal se reescribe, si cambia el nÂº preso
														// quedarian los dos, asi
						// que hay que borrar el antiguo
						c.setNum_celda(Integer.parseInt(numbertxt.getText()));
					} else {// si el nuevo nº existe ya
						if (!(Integer.parseInt(numbertxt.getText()) == c.getNum_celda())) {// si el nuevo nº no es igual
																							// al antiguo(overwrite)
							if (!(ovCheckbox.isSelected())) {
								ov = false;
								MessageWindow over = new MessageWindow("Save cancelled",
										"Overwrite existing cell option not selected");
								over.frame.setVisible(true);
							} else {
								Cells.remove(c.getNum_celda());// aunque de normal se reescribe, si cambia el nÂº
																// preso quedarian los dos, asi
								// que hay que borrar el antiguo
								c.setNum_celda(Integer.parseInt(numbertxt.getText()));
							}
						}
					}
				} else {
					if (Cells.containsKey(Integer.parseInt(numbertxt.getText()))) {
						ov = false;
						MessageWindow over = new MessageWindow("Cell number in use",
								"Delete existing cell to use that number");
						over.frame.setVisible(true);
					}
				}
				if (ov) {
					if (mode.equals("edit")) {
						Pavilions.get(oldId).getCeldas().remove(c);
						Pavilions.get(oldId).setNum_presos();
						Pavilions.get(oldId).setNum_celdas();
					}
					c.setNum_celda(Integer.parseInt(numbertxt.getText()));
					c.setCap_actual();
					c.setLlena();
					Pavilions.get(pavId).getCeldas().add(c);
					Pavilions.get(pavId).setNum_celdas();
					Pavilions.get(pavId).setNum_presos();
					Cells.put(c.getNum_celda(), c);
					MessageWindow saved = new MessageWindow("Cell saved", "");
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

	public JPanel editar(HashMap<Integer, Cell> cells, HashMap<Integer, Pavilion> pavilions) {
		setCells(cells);
		setPavilions(pavilions);

		JPanel crear = new JPanel();
		crear.setBounds(0, 0, 836, 511);
		crear.setVisible(true);
		crear.setLayout(null);

		JLabel lblNewLabel = new JLabel("EDIT AN EXISTING CELL");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 335, 37);
		crear.add(lblNewLabel);

		JLabel cellT = new JLabel("Cell Type:");
		cellT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cellT.setHorizontalAlignment(SwingConstants.RIGHT);
		cellT.setBounds(350, 124, 74, 14);
		crear.add(cellT);

		JLabel door = new JLabel("Door State:");
		door.setFont(new Font("Tahoma", Font.PLAIN, 13));
		door.setHorizontalAlignment(SwingConstants.RIGHT);
		door.setBounds(350, 163, 74, 14);
		crear.add(door);

		JLabel seclb = new JLabel("Security Level:");
		seclb.setFont(new Font("Tahoma", Font.PLAIN, 13));
		seclb.setHorizontalAlignment(SwingConstants.RIGHT);
		seclb.setBounds(330, 202, 94, 14);
		crear.add(seclb);

		Sec = new JTextField();
		Sec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Sec.setBounds(434, 200, 94, 20);
		crear.add(Sec);
		Sec.setColumns(10);

		JLabel floorlb = new JLabel("Cell Floor:");
		floorlb.setHorizontalAlignment(SwingConstants.RIGHT);
		floorlb.setFont(new Font("Tahoma", Font.PLAIN, 13));
		floorlb.setBounds(318, 241, 106, 14);
		crear.add(floorlb);

		floor = new JTextField();
		floor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		floor.setBounds(434, 239, 94, 20);
		crear.add(floor);
		floor.setColumns(10);

		JLabel pavlb = new JLabel("Pavilion number:");
		pavlb.setHorizontalAlignment(SwingConstants.RIGHT);
		pavlb.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pavlb.setBounds(308, 285, 116, 14);
		crear.add(pavlb);

		pav = new JTextField();
		pav.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pav.setBounds(434, 283, 94, 20);
		crear.add(pav);
		pav.setColumns(10);

		JLabel cellN = new JLabel("Cell Number:");
		cellN.setHorizontalAlignment(SwingConstants.RIGHT);
		cellN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cellN.setBounds(308, 83, 116, 14);
		crear.add(cellN);

		numbertxt = new JTextField();
		numbertxt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		numbertxt.setBounds(434, 83, 93, 20);
		crear.add(numbertxt);
		numbertxt.setColumns(10);

		btnNewButton_1.setAction(saveEdit);
		btnNewButton_1.setBounds(655, 417, 89, 23);
		crear.add(btnNewButton_1);

		checkO.setFont(new Font("Tahoma", Font.PLAIN, 13));
		checkO.setBounds(430, 160, 97, 23);
		crear.add(checkO);

		checkC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		checkC.setBounds(529, 160, 97, 23);
		crear.add(checkC);

		checkO.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (checkO.isSelected()) {
					checkC.setSelected(false);
				}
			}
		});
		checkC.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (checkC.isSelected()) {
					checkO.setSelected(false);
				}
			}
		});

		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Individual", "Doble" }));
		comboBox.setBounds(434, 121, 94, 20);
		crear.add(comboBox);
		setEditar(true);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setAction(editSearch);
		btnNewButton_2.setBounds(537, 80, 89, 23);
		crear.add(btnNewButton_2);
		numbertxt.setEditable(true);

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

		comboBox.setEnabled(a);

		checkO.setEnabled(a);
		checkO.setSelected(false);

		checkC.setEnabled(a);
		checkC.setSelected(false);

		Sec.setEditable(a);
		Sec.setText("");

		floor.setEditable(a);
		floor.setText("");

		pav.setEditable(a);
		pav.setText("");

		btnNewButton_1.setEnabled(a);

	}

	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Search");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {

			int id = Integer.parseInt(numbertxt.getText());

			if (Cells.containsKey(id)) {
				setEditar(true);
				setEdc(Cells.get(id));
				numbertxt.setText(edc.getNum_celda() + "");

				comboBox.setSelectedItem(edc.getTipo_celda());

				if (edc.isEstado_puerta()) {
					checkO.setSelected(true);
				} else {
					checkC.setSelected(true);
				}

				Sec.setText(edc.getNivel_seguridad() + "");

				floor.setText(edc.getPiso() + "");

				pav.setText(edc.getPabellon().getNum_pabellon() + "");

			} else {
				setEditar(false);
				MessageWindow m = new MessageWindow("Invalid cell number", "There is no cell with that number");
				numbertxt.setText("");
				m.frame.setVisible(true);
			}
		}
	}

	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Save edited cell");
		}

		public void actionPerformed(ActionEvent e) {
			saveCell(edc, "edit");
		}
	}

	public JPanel borrar(HashMap<Integer, Cell> cells, HashMap<Integer, Pavilion> pavilions) {

		setCells(cells);
		setPavilions(pavilions);

		JPanel borrar = new JPanel();
		borrar.setBounds(0, 0, 836, 511);
		borrar.setVisible(true);
		borrar.setLayout(null);

		JLabel lblNewLabel = new JLabel("DELETE AN EXISTING CELL");
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

		JLabel lblNewLabel_7 = new JLabel("Insert the number of the cell you want to delete:");
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
			putValue(SHORT_DESCRIPTION, "Delete cell");
		}

		public void actionPerformed(ActionEvent e) {
			try {
				int id = Integer.parseInt(textField_1.getText());
				if (Cells.containsKey(id)) {
					if (Cells.get(id).getCap_actual() == 0) {
						Pavilions.get(Cells.get(id).getPabellon().getNum_pabellon()).getCeldas().remove(Cells.get(id));
						Pavilions.get(Cells.get(id).getPabellon().getNum_pabellon()).setNum_celdas();
						Cells.remove(id);
						MessageWindow m = new MessageWindow("Cell deleted", "");
						m.frame.setVisible(true);
						textField_1.setText("");
					} else {
						MessageWindow m = new MessageWindow("Error",
								"Cell selected is not empty and will not be deleted");
						m.frame.setVisible(true);
						textField_1.setText("");
					}

				} else {
					MessageWindow m = new MessageWindow("Invalid cell", "There is no cell with that number");
					m.frame.setVisible(true);
					textField_1.setText("");
				}
			} catch (Exception es) {
				MessageWindow m = new MessageWindow("Format error ocurred", "Introduce a number");
				m.frame.setVisible(true);
			}
		}
	}

	public JPanel leerListado(HashMap<Integer, Cell> cells) {

		setCells(cells);

		JPanel leerListado = new JPanel();
		leerListado.setBounds(0, 0, 836, 511);
		leerListado.setVisible(true);
		leerListado.setLayout(null);

		JLabel lblNewLabel = new JLabel("READ LIST OF ALL CELLS");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 335, 37);
		leerListado.add(lblNewLabel);

		JTextArea txtrSafdSdfSdfds = new JTextArea();
		txtrSafdSdfSdfds.setFont(new Font("Monospaced", Font.PLAIN, 14));
		String s = "";
		ArrayList<Integer> orderedC = new ArrayList<Integer>();
		for (int i : Cells.keySet()) {
			orderedC.add(i);
		}
		Collections.sort(orderedC);
		for (int a = 0; a < Cells.size(); a++) {
			Cell c = Cells.get(orderedC.get(a));
			String door;
			if (c.isEstado_puerta()) {
				door = "puerta abierta";
			} else {
				door = "puerta cerrada";
			}
			s = s + c.getNum_celda() + ", " + c.getTipo_celda() + ", " + door + "\r\n";
		}
		txtrSafdSdfSdfds.setText(s);
		txtrSafdSdfSdfds.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtrSafdSdfSdfds.setBounds(268, 110, 455, 391);

		JScrollPane sp = new JScrollPane(txtrSafdSdfSdfds);
		sp.setBounds(268, 110, 455, 370);
		sp.setBackground(SystemColor.menu);
		leerListado.add(sp);

		JLabel lblNewLabel_8 = new JLabel("Current number of cells in the database: " + Cells.size());
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(268, 73, 324, 26);
		leerListado.add(lblNewLabel_8);

		return leerListado;
	}

	public JPanel stats(HashMap<Integer, Cell> cells) {

		setCells(cells);

		JPanel stats = new JPanel();
		stats.setBounds(0, 0, 836, 511);
		stats.setVisible(true);
		stats.setLayout(null);

		JLabel lblNewLabel = new JLabel("CELL STATISTICS");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(257, 25, 335, 37);
		stats.add(lblNewLabel);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Cell_IO cio = new Cell_IO();
		textArea_1.setText(cio.stats(cells));
		JScrollPane sp = new JScrollPane(textArea_1);
		sp.setBounds(257, 168, 505, 223);
		sp.setBackground(SystemColor.menu);
		stats.add(sp);

		return stats;
	}

	public JPanel realizarConsulta(HashMap<Integer, Cell> cells) {

		setCells(cells);
		Query = new HashMap<Integer, Cell>(Cells);

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
					if (list.getSelectedValue().equals("Search by current capacity")) {

						optRestriction = "current capacity";

						JLabel lblNewLabel_11 = new JLabel("Insert maximum current capacity:");
						lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblNewLabel_11.setBounds(274, 144, 290, 25);
						opt.add(lblNewLabel_11);

						btnNewButton_5.setBounds(520, 274, 140, 28);
						opt.add(btnNewButton_5);

						JLabel lblNewLabel_12 = new JLabel("Insert minimum current capacity:");
						lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblNewLabel_12.setBounds(274, 240, 272, 25);
						opt.add(lblNewLabel_12);

						comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
						comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "0", "1", "2" }));
						comboBox_1.setBounds(274, 190, 114, 23);
						opt.add(comboBox_1);

						comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "0", "1", "2" }));
						comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
						comboBox_2.setBounds(274, 296, 114, 23);
						opt.add(comboBox_2);

					} else if (list.getSelectedValue().equals("Search by cell type")) {
						optRestriction = "cell type";

						JLabel lblNewLabel_11 = new JLabel("Insert cell type:");
						lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblNewLabel_11.setBounds(274, 144, 147, 25);
						opt.add(lblNewLabel_11);

						btnNewButton_5.setBounds(533, 180, 140, 28);
						opt.add(btnNewButton_5);

						chckbxNewCheckBox_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
						chckbxNewCheckBox_2.setBounds(274, 185, 97, 23);
						opt.add(chckbxNewCheckBox_2);

						chckbxNewCheckBox_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
						chckbxNewCheckBox_3.setBounds(274, 219, 97, 23);
						opt.add(chckbxNewCheckBox_3);

						chckbxNewCheckBox_2.addChangeListener(new ChangeListener() {
							public void stateChanged(ChangeEvent e) {
								if (chckbxNewCheckBox_2.isSelected()) {
									chckbxNewCheckBox_3.setSelected(false);
								}
							}
						});
						chckbxNewCheckBox_3.addChangeListener(new ChangeListener() {
							public void stateChanged(ChangeEvent e) {
								if (chckbxNewCheckBox_3.isSelected()) {
									chckbxNewCheckBox_2.setSelected(false);
								}
							}
						});

					} else if (list.getSelectedValue().equals("Search by fill")) {
						optRestriction = "fill";
						JLabel lblNewLabel_11 = new JLabel("Do you want full or not full cells?");
						lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblNewLabel_11.setBounds(274, 144, 399, 25);
						opt.add(lblNewLabel_11);

						btnNewButton_5.setBounds(471, 194, 140, 28);
						opt.add(btnNewButton_5);

						chckbxNewCheckBox_1 = new JCheckBox("Full Cells");
						chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
						chckbxNewCheckBox_1.setBounds(319, 197, 129, 23);
						opt.add(chckbxNewCheckBox_1);

					} else if (list.getSelectedValue().equals("Search by door status")) {
						optRestriction = "door status";
						JLabel lblNewLabel_11 = new JLabel("Do you want opened or closed cells?");
						lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblNewLabel_11.setBounds(274, 144, 399, 25);
						opt.add(lblNewLabel_11);

						btnNewButton_5.setBounds(471, 194, 140, 28);
						opt.add(btnNewButton_5);

						chckbxNewCheckBox_1 = new JCheckBox("Opened Cells");
						chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
						chckbxNewCheckBox_1.setBounds(319, 197, 129, 23);
						opt.add(chckbxNewCheckBox_1);

					} else if (list.getSelectedValue().equals("Search by security level")) {
						optRestriction = "security level";
						restxt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
						restxt1.setBounds(274, 180, 202, 28);
						restxt1.setColumns(10);
						opt.add(restxt1);

						JLabel lblNewLabel_11 = new JLabel("Insert maximum security level:");
						lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblNewLabel_11.setBounds(274, 144, 228, 25);
						opt.add(lblNewLabel_11);

						btnNewButton_5.setBounds(520, 274, 140, 28);
						opt.add(btnNewButton_5);

						JLabel lblNewLabel_12 = new JLabel("Insert minimum security level:");
						lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblNewLabel_12.setBounds(274, 240, 228, 25);
						opt.add(lblNewLabel_12);

						restxt2.setBounds(274, 276, 202, 28);
						opt.add(restxt2);
						restxt2.setColumns(10);

					} else if (list.getSelectedValue().equals("Search by floor")) {
						optRestriction = "floor";
						restxt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
						restxt1.setBounds(274, 180, 202, 28);
						restxt1.setColumns(10);
						opt.add(restxt1);

						JLabel lblNewLabel_11 = new JLabel("Insert maximum floor:");
						lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblNewLabel_11.setBounds(274, 144, 202, 25);
						opt.add(lblNewLabel_11);

						btnNewButton_5.setBounds(520, 274, 140, 28);
						opt.add(btnNewButton_5);

						JLabel lblNewLabel_12 = new JLabel("Insert minimum floor:");
						lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblNewLabel_12.setBounds(274, 240, 202, 25);
						opt.add(lblNewLabel_12);

						restxt2.setBounds(274, 276, 202, 28);
						opt.add(restxt2);
						restxt2.setColumns(10);

					} else if (list.getSelectedValue().equals("Search by pavilion")) {
						optRestriction = "pavilion";
						restxt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
						restxt1.setBounds(274, 180, 202, 28);
						restxt1.setColumns(10);
						opt.add(restxt1);

						JLabel lblNewLabel_11 = new JLabel("Insert pavilion number:");
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
			String[] values = new String[] { "Search by current capacity", "Search by cell type", "Search by fill",
					"Search by door status", "Search by security level", "Search by floor", "Search by pavilion" };

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
		lblNewLabel_20.setIcon(new ImageIcon("resources/carpeta.png"));
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
			switch (optRestriction) {
			case "current capacity":

				for (Cell c : Query.values()) {
					if ((c.getCap_actual() < Integer.parseInt(comboBox_2.getSelectedItem().toString()))
							|| (c.getCap_actual() > Integer.parseInt(comboBox_1.getSelectedItem().toString()))) {
						deleteos.add(c.getNum_celda());
					}
				}
				consultastxt
						.setText(consultastxt.getText() + "Max capacity = " + comboBox_1.getSelectedItem().toString()
								+ "\r\nMin capacity = " + comboBox_2.getSelectedItem().toString() + "\r\n");
				break;
			case "cell type":
				if ((!chckbxNewCheckBox_3.isSelected()) && (!chckbxNewCheckBox_2.isSelected())) {
					MessageWindow w = new MessageWindow("No option selected", "No restriction has been applied");
					w.frame.setVisible(true);
				} else {
					for (Cell c : Query.values()) {
						if (((chckbxNewCheckBox_3.isSelected()) && (c.getTipo_celda().equals("Individual")))
								|| ((chckbxNewCheckBox_2.isSelected()) && (c.getTipo_celda().equals("Doble")))) {
							deleteos.add(c.getNum_celda());
						}
					}
					if (chckbxNewCheckBox_2.isSelected()) {
						consultastxt.setText(consultastxt.getText() + "Cell Type = Individual\r\n");
					} else {
						consultastxt.setText(consultastxt.getText() + "Cell Type = Doble\r\n");
					}
				}
				break;
			case "fill":
				boolean full;
				if (chckbxNewCheckBox_1.isSelected()) {
					full = true;
				} else {
					full = false;
				}
				for (Cell c : Query.values()) {
					if (((!full) && (c.isLlena())) || ((full) && (!c.isLlena()))) {
						deleteos.add(c.getNum_celda());
					}
				}
				if (chckbxNewCheckBox_1.isSelected()) {
					consultastxt.setText(consultastxt.getText() + "Fill = full cells\r\n");
				} else {
					consultastxt.setText(consultastxt.getText() + "Fill = not full cells\r\n");
				}
				break;
			case "door status":
				boolean door;
				if (chckbxNewCheckBox_1.isSelected()) {
					door = true;
				} else {
					door = false;
				}
				for (Cell c : Query.values()) {
					if (((!door) && (c.isEstado_puerta())) || ((door) && (!c.isEstado_puerta()))) {
						deleteos.add(c.getNum_celda());
					}
				}
				if (chckbxNewCheckBox_1.isSelected()) {
					consultastxt.setText(consultastxt.getText() + "Door status = open\r\n");
				} else {
					consultastxt.setText(consultastxt.getText() + "Door status = not open\r\n");
				}
				break;
			case "security level":
				for (Cell c : Query.values()) {
					if ((c.getNivel_seguridad() < Integer.parseInt(restxt2.getText()))
							|| (c.getNivel_seguridad() > Integer.parseInt(restxt1.getText()))) {
						deleteos.add(c.getNum_celda());
					}
				}
				consultastxt.setText(consultastxt.getText() + "MaxSecLevel = " + restxt1.getText()
						+ "\r\nMinSecLevel = " + restxt2.getText() + "\r\n");
				break;
			case "floor":
				for (Cell c : Query.values()) {
					if ((c.getPiso() < Integer.parseInt(restxt2.getText()))
							|| (c.getPiso() > Integer.parseInt(restxt1.getText()))) {
						deleteos.add(c.getNum_celda());
					}
				}
				consultastxt.setText(consultastxt.getText() + "MaxFloor = " + restxt1.getText() + "\r\nMinFloor = "
						+ restxt2.getText() + "\r\n");
				break;
			case "pavilion":
				for (Cell c : Query.values()) {
					if ((c.getPabellon().getNum_pabellon()) != Integer.parseInt(restxt1.getText())) {
						deleteos.add(c.getNum_celda());
					}
				}
				consultastxt.setText(consultastxt.getText() + "Pav number = " + restxt1.getText() + "\r\n");
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
				ArrayList<Integer> orderedC = new ArrayList<Integer>();
				for (int i : Query.keySet()) {
					orderedC.add(i);
				}
				Collections.sort(orderedC);
				for (int a = 0; a < Query.size(); a++) {
					Cell c = Query.get(orderedC.get(a));
					String door;
					if (c.isEstado_puerta()) {
						door = "puerta abierta";
					} else {
						door = "puerta cerrada";
					}
					s = s + c.getNum_celda() + ", " + c.getTipo_celda() + ", " + door + "\r\n";
				}
				txtrSafdSdfSdfds.setText(s);
				txtrSafdSdfSdfds.setBorder(new LineBorder(new Color(0, 0, 0)));
				txtrSafdSdfSdfds.setBounds(200, 110, 455, 391);

				JScrollPane sp = new JScrollPane(txtrSafdSdfSdfds);
				sp.setBounds(268, 110, 455, 370);
				sp.setBackground(SystemColor.menu);
				readQ.add(sp);

				JLabel lblNewLabel_8 = new JLabel("Total number of cells in the query: " + Query.size());
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
								"CAPACIDAD ACTUAL;TIPO DE CELDA;LLENA;ESTADO DE PUERTA;NUM_CELDA;NIV_SEGURIDAD;PISO;NUM_PABELLON;PRESOS CONTENIDOS\n");
						for (Cell c : Query.values()) {
							writer.write(c.toCSV(';'));
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
}