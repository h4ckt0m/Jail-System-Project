package com.ospe.jail.Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.SwingConstants;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.ospe.jail.*;
import com.ospe.jail.Swing.IOS.*;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.SystemColor;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends Thread {
	public static final String mainPath = "src/com/ospe/jail/";
	int count = 0;
	MessageWindow w;
	private JFrame frame = new JFrame();
	JPanel MainPanel = new JPanel();
	private JTextField textField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private final Action loginAction = new SwingAction();
	JList list = new JList();
	JComboBox comboBox = new JComboBox();
	JLabel lblNewLabel_12 = new JLabel("Example direction");
	JLabel lblNewLabel_15 = new JLabel("Example direction");
	JComboBox comboBox_1 = new JComboBox();
	JComboBox comboBox_2 = new JComboBox();
	JComboBox comboBox_csv;
	JCheckBox chckbxNewCheckBox = new JCheckBox("Save changes");
	JCheckBox chckbxNewCheckBox2 = new JCheckBox("Update backup copy");
	JButton question;
	JLabel JSPImage;
	private String fileName2 = "";
	boolean cl = false;
	JLabel lblNewLabel_csv;
	// visible and not
	JTree powerTree = new JTree();
	JPanel powerMenu = new JPanel();
	JPanel login = new JPanel();
	JPanel RegManagement = new JPanel();
	JPanel loadBase = new JPanel();
	JPanel AboutUs = new JPanel();
	JPanel pavMenu = new JPanel();
	JPanel cellMenu = new JPanel();
	JPanel vMenu = new JPanel();
	JPanel cvMenu = new JPanel();
	JPanel prisonersMenu = new JPanel();
	JPanel impJson = new JPanel();
	JPanel email = new JPanel();
	JPanel saveChanges = new JPanel();
	JPanel exCSV = new JPanel();
	// visible and not

	private final Action dataSelect = new SwingAction_1();
	Timer t = new Timer(0, textField, passwordField);
	Gestor m = new Gestor();
	private final Action LDBase = new SwingAction_2();
	private final Action LDBackup = new SwingAction_3();
	private final Action aboutusAction = new SwingAction_4();
	private final Action browseImport = new SwingAction_5();
	private final Action importar = new SwingAction_6();
	private JTextField textField_1;
	private JTextField textField_2;
	private final Action browseEmail = new SwingAction_7();
	private final Action sendEmail = new SwingAction_8();
	private final Action savechanges = new SwingAction_9();
	private final Action browseExport = new SwingAction_10();
	private final Action exportar = new SwingAction_11();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MainWindow temp = new MainWindow();
		temp.start();
		try {
			// SimpleAudioPlayer audioPlayer = new SimpleAudioPlayer("resources\\a.wav");
			// audioPlayer.play();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				SaveWindow s = new SaveWindow(m.getPavilions(), m.getCivilServants(), m.getVisitors());
				s.frame.setVisible(true);
			}
		});
		frame.setTitle("Jail System Project - Login");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\minilogo.png"));
		frame.setSize(852, 550);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(MainPanel, BorderLayout.CENTER);
		MainPanel.setLayout(null);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() == '\n') {
					loginAction.actionPerformed(null);
				}
			}
		});
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() == '\n') {
					loginAction.actionPerformed(null);
				}
			}
		});

		powerTree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					if (arg0.getClickCount() == 2) {
						if (powerTree.getSelectionPath().toString().equals("[Main Menu]")) {
							goTo("powermenu");
							frame.setTitle("Jail System Project - Login/Main Menu");
						} else if (powerTree.getSelectionPath().toString().equals("[Main Menu, Register Management]")) {
							goTo("regmanagement");
							frame.setTitle("Jail System Project - Login/Main Menu/Register Management");
						} else if (powerTree.getSelectionPath().toString()
								.equals("[Main Menu, Register Management, Prisoners]")) {
							goTo("prisonersmenu");
							frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Prisoners");
						} else if (powerTree.getSelectionPath().toString()
								.equals("[Main Menu, Register Management, CivilServants]")) {
							goTo("cvmenu");
							frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Civil Servants");
						} else if (powerTree.getSelectionPath().toString()
								.equals("[Main Menu, Register Management, Visitors]")) {
							goTo("vmenu");
							frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Visitors");
						} else if (powerTree.getSelectionPath().toString()
								.equals("[Main Menu, Register Management, Cells]")) {
							goTo("cellmenu");
							frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Cells");
						} else if (powerTree.getSelectionPath().toString()
								.equals("[Main Menu, Register Management, Pavilions]")) {
							goTo("pavmenu");
							frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Pavilions");
						} else if (powerTree.getSelectionPath().toString().equals("[Main Menu, Import JSON]")) {
							goTo("importjson");
							frame.setTitle("Jail System Project - Login/Main Menu/Import JSON");
						} else if (powerTree.getSelectionPath().toString().equals("[Main Menu, Send files by email]")) {
							goTo("email");
							frame.setTitle("Jail System Project - Login/Main Menu/Send Email");
						} else if (powerTree.getSelectionPath().toString().equals("[Main Menu, Save changes]")) {
							goTo("save");
							frame.setTitle("Jail System Project - Login/Main Menu/Save changes");
						} else if (powerTree.getSelectionPath().toString().equals("[Main Menu, Export CSV]")) {
							goTo("exportCSV");
							frame.setTitle("Jail System Project - Login/Main Menu/Export CSV");
						}
					}
				} catch (Exception ee) {
				}
			}
		});
		
				powerTree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Main Menu") {
					{
						DefaultMutableTreeNode node_1;
						node_1 = new DefaultMutableTreeNode("Register Management");
						node_1.add(new DefaultMutableTreeNode("Prisoners"));
						node_1.add(new DefaultMutableTreeNode("CivilServants"));
						node_1.add(new DefaultMutableTreeNode("Visitors"));
						node_1.add(new DefaultMutableTreeNode("Cells"));
						node_1.add(new DefaultMutableTreeNode("Pavilions"));
						add(node_1);
						add(new DefaultMutableTreeNode("Import JSON"));
						add(new DefaultMutableTreeNode("Export CSV"));
						add(new DefaultMutableTreeNode("Send files by email"));
						add(new DefaultMutableTreeNode("Save changes"));
					}
				}));
				powerTree.setForeground(SystemColor.menu);
				powerTree.setBorder(new LineBorder(new Color(0, 0, 0)));
				powerTree.setFont(new Font("Tahoma", Font.PLAIN, 11));
				powerTree.setBackground(Color.WHITE);
				powerTree.setBounds(0, 0, 157, 511);
				MainPanel.add(powerTree);
		
				prisonersMenu.setBounds(0, 0, 836, 511);
				MainPanel.add(prisonersMenu);
				prisonersMenu.setLayout(null);
				
						JLabel JSPImage3 = new JLabel("");
						JSPImage3.setIcon(new ImageIcon("resources\\JSP300.png"));
						JSPImage3.setBounds(345, 51, 318, 168);
						prisonersMenu.add(JSPImage3);
						
								JList list_1 = new JList();
								list_1.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent arg0) {
										if (arg0.getClickCount() == 2) {
											Prisoner_IOS pIOS = new Prisoner_IOS(frame);
											if (list_1.getSelectedValue().equals("2)  Read one prisoner")) {
												prisonersMenu.setVisible(false);
												MainPanel.add(pIOS.leer(m.getPrisoners()));
												frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Prisoners/Read");
											} else if (list_1.getSelectedValue().equals("1)  Show list of all prisoners")) {
												prisonersMenu.setVisible(false);
												MainPanel.add(pIOS.leerListado(m.getPrisoners()));
												frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Prisoners/Read list");
											} else if (list_1.getSelectedValue().equals("3)  Create a new prisoner")) {
												prisonersMenu.setVisible(false);
												MainPanel.add(pIOS.crear(m.getPrisoners(), m.getCells()));
												frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Prisoners/Create");
											} else if (list_1.getSelectedValue().equals("4)  Edit an existing prisoner")) {
												prisonersMenu.setVisible(false);
												MainPanel.add(pIOS.editar(m.getPrisoners(), m.getCells()));
												frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Prisoners/Edit");
											} else if (list_1.getSelectedValue().equals("5)  Delete an existing prisoner")) {
												prisonersMenu.setVisible(false);
												MainPanel.add(pIOS.borrar(m.getPrisoners(), m.getCells()));
												frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Prisoners/Delete");
											} else if (list_1.getSelectedValue().equals("6)  Make a query")) {
												prisonersMenu.setVisible(false);
												MainPanel.add(pIOS.realizarConsulta(m.getPrisoners()));
												frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Prisoners/Query");
												frame.repaint();
											} else if (list_1.getSelectedValue().equals("7)  Statistics")) {
												prisonersMenu.setVisible(false);
												MainPanel.add(pIOS.stats(m.getPrisoners()));
												frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Prisoners/Stats");
											}
										}
									}
								});
								list_1.setBackground(SystemColor.menu);
								list_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
								list_1.setBorder(new LineBorder(new Color(0, 0, 0)));
								list_1.setModel(new AbstractListModel() {
									String[] values = new String[] { "1)  Show list of all prisoners", "2)  Read one prisoner",
											"3)  Create a new prisoner", "4)  Edit an existing prisoner", "5)  Delete an existing prisoner",
											"6)  Make a query", "7)  Statistics" };

									public int getSize() {
										return values.length;
									}

									public Object getElementAt(int index) {
										return values[index];
									}
								});
								list_1.setBounds(352, 278, 281, 161);
								prisonersMenu.add(list_1);
								
										JLabel lblNewLabel_4 = new JLabel("PRISONERS");
										lblNewLabel_4.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
										lblNewLabel_4.setBounds(355, 215, 189, 37);
										prisonersMenu.add(lblNewLabel_4);

		saveChanges.setBounds(0, 0, 836, 511);
		MainPanel.add(saveChanges);
		saveChanges.setLayout(null);

		JLabel JSPImageA = new JLabel("");
		JSPImageA.setIcon(new ImageIcon("resources\\JSP300.png"));
		JSPImageA.setBounds(345, 51, 318, 168);
		saveChanges.add(JSPImageA);

		JLabel lblNewLabel_A = new JLabel("SAVE CHANGES");
		lblNewLabel_A.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_A.setBounds(355, 215, 189, 37);
		saveChanges.add(lblNewLabel_A);
		MainPanel.add(saveChanges);

		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox.setBounds(413, 322, 159, 23);
		saveChanges.add(chckbxNewCheckBox);

		chckbxNewCheckBox2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox2.setBounds(413, 342, 159, 23);
		saveChanges.add(chckbxNewCheckBox2);

		JLabel lblNewLabel_21 = new JLabel("Are you sure you want to save changes?");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_21.setBounds(355, 282, 271, 23);
		saveChanges.add(lblNewLabel_21);

		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setAction(savechanges);
		btnNewButton_5.setBounds(442, 388, 89, 23);
		saveChanges.add(btnNewButton_5);

		RegManagement.setBounds(0, 0, 836, 511);
		MainPanel.add(RegManagement);
		RegManagement.setLayout(null);
		JLabel JSPImage2 = new JLabel("");
		JSPImage2.setIcon(new ImageIcon("resources\\JSP300.png"));
		JSPImage2.setBounds(345, 51, 318, 168);
		RegManagement.add(JSPImage2);

		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Prisoners", "CivilServants", "Visitors", "Cells", "Pavilions" }));
		comboBox.setBounds(420, 267, 152, 23);
		RegManagement.add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("Select the data type you want to work with:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(355, 216, 281, 20);
		RegManagement.add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setAction(dataSelect);
		btnNewButton_1.setBounds(453, 342, 89, 23);
		RegManagement.add(btnNewButton_1);
		RegManagement.setVisible(false);

		email.setBounds(0, 0, 836, 511);
		MainPanel.add(email);
		email.setLayout(null);

		JLabel JSPImage9 = new JLabel("");
		JSPImage9.setIcon(new ImageIcon("resources\\JSP300.png"));
		JSPImage9.setBounds(345, 51, 318, 168);
		email.add(JSPImage9);

		JLabel lblNewLabel_13 = new JLabel("SEND FILES VIA EMAIL");
		lblNewLabel_13.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_13.setBounds(355, 215, 239, 37);
		email.add(lblNewLabel_13);

		textField_1 = new JTextField();
		textField_1.setBounds(458, 281, 205, 20);
		email.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(458, 323, 205, 20);
		email.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("Email Adress:");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_16.setBounds(355, 284, 93, 14);
		email.add(lblNewLabel_16);

		JLabel lblNewLabel_14 = new JLabel("Subject:");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_14.setBounds(355, 326, 93, 14);
		email.add(lblNewLabel_14);
		lblNewLabel_15.setBorder(new LineBorder(new Color(0, 0, 0)));

		lblNewLabel_15.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_15.setBounds(244, 382, 419, 20);
		email.add(lblNewLabel_15);

		JLabel lblNewLabel_17 = new JLabel("Select the file you want to send:");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_17.setBounds(269, 357, 179, 14);
		email.add(lblNewLabel_17);

		JButton btnNewButton_8 = new JButton("New button");
		btnNewButton_8.setAction(sendEmail);
		btnNewButton_8.setBounds(458, 439, 89, 23);
		email.add(btnNewButton_8);

		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				browseEmail.actionPerformed(null);
			}
		});
		lblNewLabel_19
				.setIcon(new ImageIcon("resources\\carpeta.png"));
		lblNewLabel_19.setBounds(673, 371, 39, 37);
		email.add(lblNewLabel_19);

		impJson.setBounds(0, 0, 836, 511);
		MainPanel.add(impJson);
		impJson.setLayout(null);

		JLabel JSPImage8 = new JLabel("");
		JSPImage8.setIcon(new ImageIcon("resources\\JSP300.png"));
		JSPImage8.setBounds(345, 51, 318, 168);
		impJson.add(JSPImage8);

		JLabel lblNewLabel_9 = new JLabel("IMPORT JSON");
		lblNewLabel_9.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_9.setBounds(355, 215, 189, 37);
		impJson.add(lblNewLabel_9);

		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "merge data", "import new data" }));
		comboBox_1.setBounds(458, 263, 143, 20);
		impJson.add(comboBox_1);

		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "Pavilion", "CivilServant", "Visitor" }));
		comboBox_2.setBounds(458, 311, 143, 20);
		impJson.add(comboBox_2);

		JLabel lblNewLabel_10 = new JLabel("Select import mode:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setBounds(336, 267, 112, 14);
		impJson.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Select filetype:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setBounds(345, 314, 103, 14);
		impJson.add(lblNewLabel_11);
		lblNewLabel_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);

		lblNewLabel_12.setBackground(Color.WHITE);
		lblNewLabel_12.setBounds(245, 381, 357, 20);
		impJson.add(lblNewLabel_12);

		JLabel lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				browseImport.actionPerformed(null);
			}
		});
		lblNewLabel_20
				.setIcon(new ImageIcon("resources\\carpeta.png"));
		lblNewLabel_20.setBounds(612, 369, 39, 37);
		impJson.add(lblNewLabel_20);

		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setAction(importar);
		btnNewButton_6.setBounds(455, 427, 89, 23);
		impJson.add(btnNewButton_6);

		JLabel lblNewLabel_18 = new JLabel("Select the file you want to import:");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_18.setBounds(245, 350, 203, 20);
		impJson.add(lblNewLabel_18);

		powerMenu.setBounds(0, 0, 836, 511);
		MainPanel.add(powerMenu);
		powerMenu.setLayout(null);

		JSPImage = new JLabel("");
		JSPImage.setIcon(new ImageIcon("resources\\JSP300.png"));
		JSPImage.setBounds(345, 51, 318, 168);
		JSPImage.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					if (arg0.getClickCount() == 5) {
						Blink blk = new Blink(frame, powerMenu, JSPImage);
						blk.start();
					}
				} catch (Exception ee) {
				}
			}
		});
		powerMenu.add(JSPImage);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));

		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					if (list.getSelectedValue().equals("1)  Register Management")) {
						goTo("regmanagement");
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management");
					} else if (list.getSelectedValue().equals("2)  Import database files in JSON")) {
						goTo("importjson");
						frame.setTitle("Jail System Project - Login/Main Menu/Import JSON");
					} else if (list.getSelectedValue().equals("3)  Export database files in CSV")) {
						goTo("exportCSV");
						frame.setTitle("Jail System Project - Login/Main Menu/Export CSV");
					} else if (list.getSelectedValue().equals("4)  Send files by email")) {
						goTo("email");
						frame.setTitle("Jail System Project - Login/Main Menu/Send Email");
					} else if (list.getSelectedValue().equals("5)  Save changes")) {
						goTo("save");
						frame.setTitle("Jail System Project - Login/Main Menu/Save changes");
					}
				}
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(SystemColor.menu);
		list.setFont(new Font("Tahoma", Font.PLAIN, 17));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "1)  Register Management", "2)  Import database files in JSON",
					"3)  Export database files in CSV", "4)  Send files by email", "5)  Save changes" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(369, 230, 256, 122);
		powerMenu.add(list);

		question = new JButton("");
		question.setAction(aboutusAction);
		question.setBorder(null);
		question.setForeground(SystemColor.menu);
		question.setBackground(SystemColor.menu);
		question.setIcon(new ImageIcon("resources\\about_us.png"));
		question.setBounds(781, 461, 45, 39);
		powerMenu.add(question);

		loadBase.setBounds(0, 0, 836, 511);
		MainPanel.add(loadBase);
		loadBase.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Choose the files you want to load:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(161, 213, 215, 31);
		loadBase.add(lblNewLabel_2);

		JLabel label = new JLabel("Welcome to the Jail System Project Application");
		label.setFont(new Font("Sitka Display", Font.BOLD | Font.ITALIC, 27));
		label.setBounds(161, 65, 536, 67);
		loadBase.add(label);

		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() == '\n') {
					LDBase.actionPerformed(null);
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setAction(LDBase);
		btnNewButton_3.setBounds(161, 300, 200, 37);
		loadBase.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '\n') {
					LDBackup.actionPerformed(null);
				}
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setAction(LDBackup);
		btnNewButton_4.setBounds(455, 300, 200, 37);
		loadBase.add(btnNewButton_4);
		loadBase.setVisible(false);

		pavMenu.setBounds(0, 0, 836, 511);
		MainPanel.add(pavMenu);
		pavMenu.setLayout(null);

		JLabel JSPImage7 = new JLabel("");
		JSPImage7.setIcon(new ImageIcon("resources\\JSP300.png"));
		JSPImage7.setBounds(345, 51, 318, 168);
		pavMenu.add(JSPImage7);

		JList list_5 = new JList();
		list_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					Pavilion_IOS paIOS = new Pavilion_IOS(frame);
					if (list_5.getSelectedValue().equals("2)  Read one pavilion")) {
						pavMenu.setVisible(false);
						MainPanel.add(paIOS.leer(m.getPavilions()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Pavilions/Read");
					} else if (list_5.getSelectedValue().equals("1)  Show list of all pavilions")) {
						pavMenu.setVisible(false);
						MainPanel.add(paIOS.leerListado(m.getPavilions()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Pavilions/Read list");
					} else if (list_5.getSelectedValue().equals("3)  Create a new pavilion")) {
						pavMenu.setVisible(false);
						MainPanel.add(paIOS.crear(m.getPavilions()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Pavilions/Create");
					} else if (list_5.getSelectedValue().equals("4)  Edit an existing pavilion")) {
						pavMenu.setVisible(false);
						MainPanel.add(paIOS.editar(m.getPavilions()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Pavilions/Edit");
					} else if (list_5.getSelectedValue().equals("5)  Delete an existing pavilion")) {
						pavMenu.setVisible(false);
						MainPanel.add(paIOS.borrar(m.getPavilions()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Pavilions/Delete");
					} else if (list_5.getSelectedValue().equals("6)  Statistics")) {
						pavMenu.setVisible(false);
						MainPanel.add(paIOS.stats(m.getPavilions()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Pavilions/Stats");
					}
				}
			}
		});
		list_5.setBackground(SystemColor.menu);
		list_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_5.setModel(new AbstractListModel() {
			String[] values = new String[] { "1)  Show list of all pavilions", "2)  Read one pavilion",
					"3)  Create a new pavilion", "4)  Edit an existing pavilion", "5)  Delete an existing pavilion",
					"6)  Statistics" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_5.setBounds(352, 278, 254, 135);
		pavMenu.add(list_5);

		JLabel lblNewLabel_8 = new JLabel("PAVILIONS");
		lblNewLabel_8.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_8.setBounds(355, 215, 189, 37);
		pavMenu.add(lblNewLabel_8);

		login.setBounds(0, 0, 836, 511);
		MainPanel.add(login);
		login.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome to the Jail System Project Application");
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel.setBounds(161, 65, 536, 67);
		login.add(lblNewLabel);

		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setBounds(282, 190, 46, 14);
		login.add(lblUser);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(238, 227, 90, 17);
		login.add(lblPassword);

		textField.setBounds(350, 188, 158, 20);
		login.add(textField);
		textField.setColumns(10);

		passwordField.setBounds(350, 227, 158, 20);
		login.add(passwordField);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setAction(loginAction);
		btnNewButton.setBounds(389, 289, 89, 23);
		login.add(btnNewButton);

		login.setVisible(true);

		cellMenu.setBounds(0, 0, 836, 511);
		MainPanel.add(cellMenu);
		cellMenu.setLayout(null);

		JLabel JSPImage6 = new JLabel("");
		JSPImage6.setIcon(new ImageIcon("resources\\JSP300.png"));
		JSPImage6.setBounds(345, 51, 318, 168);
		cellMenu.add(JSPImage6);

		JList list_4 = new JList();
		list_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					Cell_IOS cIOS = new Cell_IOS(frame);
					if (list_4.getSelectedValue().equals("2)  Read one cell")) {
						cellMenu.setVisible(false);
						MainPanel.add(cIOS.leer(m.getCells()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Cells/Read");
					} else if (list_4.getSelectedValue().equals("1)  Show list of all cells")) {
						cellMenu.setVisible(false);
						MainPanel.add(cIOS.leerListado(m.getCells()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Cells/Read list");
					} else if (list_4.getSelectedValue().equals("3)  Create a new cell")) {
						cellMenu.setVisible(false);
						MainPanel.add(cIOS.crear(m.getCells(), m.getPavilions()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Cells/Create");
					} else if (list_4.getSelectedValue().equals("4)  Edit an existing cell")) {
						cellMenu.setVisible(false);
						MainPanel.add(cIOS.editar(m.getCells(), m.getPavilions()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Cells/Edit");
					} else if (list_4.getSelectedValue().equals("5)  Delete an existing cell")) {
						cellMenu.setVisible(false);
						MainPanel.add(cIOS.borrar(m.getCells(), m.getPavilions()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Cells/Delete");
					} else if (list_4.getSelectedValue().equals("6)  Make a query")) {
						cellMenu.setVisible(false);
						MainPanel.add(cIOS.realizarConsulta(m.getCells()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Cells/Query");
						frame.repaint();
					} else if (list_4.getSelectedValue().equals("7)  Statistics")) {
						cellMenu.setVisible(false);
						MainPanel.add(cIOS.stats(m.getCells()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Cells/Stats");
					}
				}
			}
		});
		list_4.setBackground(SystemColor.menu);
		list_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_4.setModel(new AbstractListModel() {
			String[] values = new String[] { "1)  Show list of all cells", "2)  Read one cell", "3)  Create a new cell",
					"4)  Edit an existing cell", "5)  Delete an existing cell", "6)  Make a query", "7)  Statistics" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_4.setBounds(352, 278, 254, 161);
		cellMenu.add(list_4);

		JLabel lblNewLabel_7 = new JLabel("CELLS");
		lblNewLabel_7.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_7.setBounds(355, 215, 189, 37);
		cellMenu.add(lblNewLabel_7);

		vMenu.setBounds(0, 0, 836, 511);
		MainPanel.add(vMenu);
		vMenu.setLayout(null);

		JLabel JSPImage5 = new JLabel("");
		JSPImage5.setIcon(new ImageIcon("resources\\JSP300.png"));
		JSPImage5.setBounds(345, 51, 318, 168);
		vMenu.add(JSPImage5);

		JList list_3 = new JList();
		list_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					Visitor_IOS vIOS = new Visitor_IOS(frame);
					if (list_3.getSelectedValue().equals("2)  Read one visitor")) {
						vMenu.setVisible(false);
						MainPanel.add(vIOS.leer(m.getVisitors()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Visitors/Read");
					} else if (list_3.getSelectedValue().equals("1)  Show list of all visitors")) {
						vMenu.setVisible(false);
						MainPanel.add(vIOS.leerListado(m.getVisitors()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Visitors/Read list");
					} else if (list_3.getSelectedValue().equals("3)  Create a new visitor")) {
						vMenu.setVisible(false);
						MainPanel.add(vIOS.crear(m.getVisitors()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Visitors/Create");
					} else if (list_3.getSelectedValue().equals("4)  Edit an existing visitor")) {
						vMenu.setVisible(false);
						MainPanel.add(vIOS.editar(m.getVisitors()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Visitors/Edit");
					} else if (list_3.getSelectedValue().equals("5)  Delete an existing visitor")) {
						vMenu.setVisible(false);
						MainPanel.add(vIOS.borrar(m.getVisitors()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Visitors/Delete");
					} else if (list_3.getSelectedValue().equals("6)  Make a query")) {
						vMenu.setVisible(false);
						MainPanel.add(vIOS.realizarConsulta(m.getVisitors()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Visitors/Query");
						frame.repaint();
					} else if (list_3.getSelectedValue().equals("7)  Statistics")) {
						vMenu.setVisible(false);
						MainPanel.add(vIOS.stats(m.getVisitors()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Visitors/Stats");
					}
				}
			}
		});
		list_3.setBackground(SystemColor.menu);
		list_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_3.setModel(new AbstractListModel() {
			String[] values = new String[] { "1)  Show list of all visitors", "2)  Read one visitor",
					"3)  Create a new visitor", "4)  Edit an existing visitor", "5)  Delete an existing visitor",
					"6)  Make a query", "7)  Statistics" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_3.setBounds(352, 278, 254, 161);
		vMenu.add(list_3);

		JLabel lblNewLabel_6 = new JLabel("VISITORS");
		lblNewLabel_6.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_6.setBounds(355, 215, 189, 37);
		vMenu.add(lblNewLabel_6);

		cvMenu.setBounds(0, 0, 836, 511);
		MainPanel.add(cvMenu);
		cvMenu.setLayout(null);

		JLabel JSPImage4 = new JLabel("");
		JSPImage4.setIcon(new ImageIcon("resources\\JSP300.png"));
		JSPImage4.setBounds(345, 51, 318, 168);
		cvMenu.add(JSPImage4);

		JList list_2 = new JList();
		list_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					CivilServant_IOS cvIOS = new CivilServant_IOS(frame);
					if (list_2.getSelectedValue().equals("2)  Read one civil servant")) {
						cvMenu.setVisible(false);
						MainPanel.add(cvIOS.leer(m.getCivilServants()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/CivilServants/Read");
					} else if (list_2.getSelectedValue().equals("1)  Show list of all civil servants")) {
						cvMenu.setVisible(false);
						MainPanel.add(cvIOS.leerListado(m.getCivilServants()));
						frame.setTitle(
								"Jail System Project - Login/Main Menu/Register Management/CivilServants/Read list");
					} else if (list_2.getSelectedValue().equals("3)  Create a new civil servant")) {
						cvMenu.setVisible(false);
						MainPanel.add(cvIOS.crear(m.getCivilServants()));
						frame.setTitle(
								"Jail System Project - Login/Main Menu/Register Management/CivilServants/Create");
					} else if (list_2.getSelectedValue().equals("4)  Edit an existing civil servant")) {
						cvMenu.setVisible(false);
						MainPanel.add(cvIOS.editar(m.getCivilServants()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/CivilServants/Edit");
					} else if (list_2.getSelectedValue().equals("5)  Delete an existing civil servant")) {
						cvMenu.setVisible(false);
						MainPanel.add(cvIOS.borrar(m.getCivilServants()));
						frame.setTitle(
								"Jail System Project - Login/Main Menu/Register Management/CivilServants/Delete");
					} else if (list_2.getSelectedValue().equals("6)  Make a query")) {
						cvMenu.setVisible(false);
						MainPanel.add(cvIOS.realizarConsulta(m.getCivilServants()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/CivilServants/Query");
						frame.repaint();
					} else if (list_2.getSelectedValue().equals("7)  Statistics")) {
						cvMenu.setVisible(false);
						MainPanel.add(cvIOS.stats(m.getCivilServants()));
						frame.setTitle("Jail System Project - Login/Main Menu/Register Management/CivilServants/Stats");
					}
				}
			}
		});
		list_2.setBackground(SystemColor.menu);
		list_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_2.setModel(new AbstractListModel() {
			String[] values = new String[] { "1)  Show list of all civil servants", "2)  Read one civil servant",
					"3)  Create a new civil servant", "4)  Edit an existing civil servant",
					"5)  Delete an existing civil servant", "6)  Make a query", "7)  Statistics" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_2.setBounds(352, 278, 296, 161);
		cvMenu.add(list_2);

		JLabel lblNewLabel_5 = new JLabel("CIVIL SERVANTS");
		lblNewLabel_5.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_5.setBounds(355, 215, 189, 37);
		cvMenu.add(lblNewLabel_5);

		AboutUs.setBounds(0, 0, 836, 511);
		MainPanel.add(AboutUs);
		AboutUs.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("resources\\JSP300.png"));
		label_1.setBounds(345, 51, 318, 168);
		AboutUs.add(label_1);

		JLabel lblNewLabel_3 = new JLabel("About Us");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(299, 213, 108, 49);

		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 5) {
					WindowPong window = new WindowPong(frame, MainPanel);
					window.getFrame().setVisible(true);
					MainPanel.setVisible(false);
					frame.repaint();
					Info i = new Info();
					i.frame.setVisible(true);
				}
			}
		});

		AboutUs.add(lblNewLabel_3);

		JTextArea txtrJspIsGreat = new JTextArea();
		txtrJspIsGreat.setDragEnabled(true);
		txtrJspIsGreat.setBackground(SystemColor.menu);
		txtrJspIsGreat.setWrapStyleWord(true);
		txtrJspIsGreat.setLineWrap(true);
		txtrJspIsGreat.setText(
				"Description\r\nGroup Project of Computer Engineering students from Universidad Europea. Our project is based on a security system of a prision.\r\n\r\n\u2B50\uFE0F Star us on GitHub \u2014 it helps!\r\n\r\nMembers of the project\r\nFrancisco Af\u00E1n Rodriguez -> Project Boss\r\nH\u00E9ctor Palencia S\u00E1nchez -> Coder\r\nGonzalo Alcaide Agundez -> Coder\r\nArturo Alba S\u00E1nchez-Mayoral -> Administrator\r\nAlberto Gonz\u00E1lez Fern\u00E1ndez -> Administrator\r\n                    \r\n\r\nPrerequisites\r\nYou will only need Eclipse IDE and Java JDK on their last version.\r\n\r\nHow To Use\r\nTo clone and run this application, you'll need Git and Eclipse. From your command line:\r\n\r\n# Clone this repository\r\n$ git clone https://github.com/HectorSkm/ProyectoIngenieria.git\r\n\r\n# Go into the repository\r\n$ cd ProyectoIngenieria\r\n\r\n# Run the exe\r\n$ ./jsp.exe\r\nVersioning\r\nWe will improve new versions for our project since we achieve version 1.0.\r\n\r\nContact with us\r\nWe hope you like our code. Meaning, if you liked using this app or has helped you in anyway, I'd like you send me an email on jailsystemproject@gmail.com about anything you'd want to say about this software. We'd really appreciate it!\r\n\r\nOur accounts wiht personal repositories\r\nFrancisco Af\u00E1n Rodriguez\r\nH\u00E9ctor Palencia S\u00E1nchez\r\nArturo Alba S\u00E1nchez-Mayoral\r\nAlberto Gonz\u00E1lez Fern\u00E1ndez\r\nGonzalo Alcaide Agundez");
		txtrJspIsGreat.setEditable(false);
		txtrJspIsGreat.setFont(new Font("Monospaced", Font.PLAIN, 13));

		JScrollPane sp = new JScrollPane(txtrJspIsGreat);
		sp.setBounds(299, 278, 448, 203);
		sp.setBackground(SystemColor.menu);
		AboutUs.add(sp);

		exCSV.setBounds(0, 0, 846, 521);
		exCSV.setLayout(null);
		MainPanel.add(exCSV);

		JLabel JSPImagecsv = new JLabel("");
		JSPImagecsv.setIcon(new ImageIcon("resources\\JSP300.png"));
		JSPImagecsv.setBounds(345, 51, 318, 168);
		exCSV.add(JSPImagecsv);

		JLabel lblNewLabelcsv = new JLabel("EXPORT CSV");
		lblNewLabelcsv.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabelcsv.setBounds(355, 215, 189, 37);
		exCSV.add(lblNewLabelcsv);

		comboBox_csv = new JComboBox();
		comboBox_csv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_csv.setModel(new DefaultComboBoxModel(
				new String[] { "Prisoners", "CivilServants", "Visitors", "Cells", "Pavilions" }));
		comboBox_csv.setBounds(336, 303, 143, 20);
		exCSV.add(comboBox_csv);

		JLabel lblNewLabelCSV2 = new JLabel("Select data type to export:");
		lblNewLabelCSV2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabelCSV2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabelCSV2.setBounds(336, 267, 300, 14);
		exCSV.add(lblNewLabelCSV2);

		lblNewLabel_csv = new JLabel("Example direction");
		lblNewLabel_csv.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_csv.setHorizontalAlignment(SwingConstants.RIGHT);

		lblNewLabel_csv.setBackground(Color.WHITE);
		lblNewLabel_csv.setBounds(245, 381, 357, 20);
		exCSV.add(lblNewLabel_csv);

		JLabel lblNewLabel_csvcarp = new JLabel("");
		lblNewLabel_csvcarp.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_csvcarp.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_csvcarp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				browseExport.actionPerformed(null);
			}
		});
		lblNewLabel_csvcarp
				.setIcon(new ImageIcon("resources\\carpeta.png"));
		lblNewLabel_csvcarp.setBounds(612, 369, 39, 37);
		exCSV.add(lblNewLabel_csvcarp);

		JButton btnNewButton_ex = new JButton("New button");
		btnNewButton_ex.setAction(exportar);
		btnNewButton_ex.setBounds(455, 427, 89, 23);
		exCSV.add(btnNewButton_ex);

		JLabel lblNewLabel_exp = new JLabel("Select the file you want to export:");
		lblNewLabel_exp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_exp.setBounds(245, 350, 203, 20);
		exCSV.add(lblNewLabel_exp);

		goTo("login");
	}

	public void reset() {
		MainPanel.removeAll();
		JSPImage.setBounds(345, 51, 318, 168);
		JSPImage.setIcon(new ImageIcon("resources\\JSP300.png"));
		MainPanel.add(powerTree);
		MainPanel.add(powerMenu);
		MainPanel.add(login);
		MainPanel.add(RegManagement);
		MainPanel.add(loadBase);
		MainPanel.add(AboutUs);
		MainPanel.add(cellMenu);
		MainPanel.add(vMenu);
		MainPanel.add(cvMenu);
		MainPanel.add(prisonersMenu);
		MainPanel.add(pavMenu);
		MainPanel.add(impJson);
		MainPanel.add(email);
		MainPanel.add(saveChanges);
		MainPanel.add(exCSV);
	}

	public void goTo(String s) {
		reset();
		switch (s) {
		case "aboutus":
			powerTree.setVisible(true);
			powerMenu.setVisible(false);
			login.setVisible(false);
			RegManagement.setVisible(false);
			loadBase.setVisible(false);
			AboutUs.setVisible(true);
			cellMenu.setVisible(false);
			vMenu.setVisible(false);
			cvMenu.setVisible(false);
			prisonersMenu.setVisible(false);
			pavMenu.setVisible(false);
			impJson.setVisible(false);
			email.setVisible(false);
			saveChanges.setVisible(false);
			exCSV.setVisible(false);
			break;
		case "pavmenu":
			powerTree.setVisible(true);
			powerMenu.setVisible(false);
			login.setVisible(false);
			RegManagement.setVisible(false);
			loadBase.setVisible(false);
			AboutUs.setVisible(false);
			cellMenu.setVisible(false);
			vMenu.setVisible(false);
			cvMenu.setVisible(false);
			prisonersMenu.setVisible(false);
			pavMenu.setVisible(true);
			impJson.setVisible(false);
			email.setVisible(false);
			saveChanges.setVisible(false);
			exCSV.setVisible(false);
			break;
		case "cellmenu":
			powerTree.setVisible(true);
			powerMenu.setVisible(false);
			login.setVisible(false);
			RegManagement.setVisible(false);
			loadBase.setVisible(false);
			AboutUs.setVisible(false);
			cellMenu.setVisible(true);
			vMenu.setVisible(false);
			cvMenu.setVisible(false);
			prisonersMenu.setVisible(false);
			pavMenu.setVisible(false);
			impJson.setVisible(false);
			email.setVisible(false);
			saveChanges.setVisible(false);
			exCSV.setVisible(false);
			break;
		case "vmenu":
			powerTree.setVisible(true);
			powerMenu.setVisible(false);
			login.setVisible(false);
			RegManagement.setVisible(false);
			loadBase.setVisible(false);
			AboutUs.setVisible(false);
			cellMenu.setVisible(false);
			vMenu.setVisible(true);
			cvMenu.setVisible(false);
			prisonersMenu.setVisible(false);
			pavMenu.setVisible(false);
			impJson.setVisible(false);
			email.setVisible(false);
			saveChanges.setVisible(false);
			exCSV.setVisible(false);
			break;
		case "cvmenu":
			powerTree.setVisible(true);
			powerMenu.setVisible(false);
			login.setVisible(false);
			RegManagement.setVisible(false);
			loadBase.setVisible(false);
			AboutUs.setVisible(false);
			cellMenu.setVisible(false);
			vMenu.setVisible(false);
			cvMenu.setVisible(true);
			prisonersMenu.setVisible(false);
			pavMenu.setVisible(false);
			impJson.setVisible(false);
			email.setVisible(false);
			saveChanges.setVisible(false);
			exCSV.setVisible(false);
			break;
		case "prisonersmenu":
			powerTree.setVisible(true);
			powerMenu.setVisible(false);
			login.setVisible(false);
			RegManagement.setVisible(false);
			loadBase.setVisible(false);
			AboutUs.setVisible(false);
			cellMenu.setVisible(false);
			vMenu.setVisible(false);
			cvMenu.setVisible(false);
			prisonersMenu.setVisible(true);
			pavMenu.setVisible(false);
			impJson.setVisible(false);
			email.setVisible(false);
			saveChanges.setVisible(false);
			exCSV.setVisible(false);
			break;
		case "regmanagement":
			powerTree.setVisible(true);
			powerMenu.setVisible(false);
			login.setVisible(false);
			RegManagement.setVisible(true);
			loadBase.setVisible(false);
			AboutUs.setVisible(false);
			cellMenu.setVisible(false);
			vMenu.setVisible(false);
			cvMenu.setVisible(false);
			prisonersMenu.setVisible(false);
			pavMenu.setVisible(false);
			impJson.setVisible(false);
			email.setVisible(false);
			saveChanges.setVisible(false);
			exCSV.setVisible(false);
			break;
		case "loadbase":
			powerTree.setVisible(false);
			powerMenu.setVisible(false);
			login.setVisible(false);
			RegManagement.setVisible(false);
			loadBase.setVisible(true);
			AboutUs.setVisible(false);
			cellMenu.setVisible(false);
			vMenu.setVisible(false);
			cvMenu.setVisible(false);
			prisonersMenu.setVisible(false);
			pavMenu.setVisible(false);
			impJson.setVisible(false);
			email.setVisible(false);
			saveChanges.setVisible(false);
			exCSV.setVisible(false);
			break;
		case "login":
			powerTree.setVisible(false);
			powerMenu.setVisible(false);
			login.setVisible(true);
			RegManagement.setVisible(false);
			loadBase.setVisible(false);
			AboutUs.setVisible(false);
			cellMenu.setVisible(false);
			vMenu.setVisible(false);
			cvMenu.setVisible(false);
			prisonersMenu.setVisible(false);
			pavMenu.setVisible(false);
			impJson.setVisible(false);
			email.setVisible(false);
			saveChanges.setVisible(false);
			exCSV.setVisible(false);
			break;
		case "powermenu":
			powerTree.setVisible(true);
			powerMenu.setVisible(true);
			login.setVisible(false);
			RegManagement.setVisible(false);
			loadBase.setVisible(false);
			AboutUs.setVisible(false);
			cellMenu.setVisible(false);
			vMenu.setVisible(false);
			cvMenu.setVisible(false);
			prisonersMenu.setVisible(false);
			pavMenu.setVisible(false);
			impJson.setVisible(false);
			email.setVisible(false);
			saveChanges.setVisible(false);
			exCSV.setVisible(false);
			break;
		case "importjson":
			powerTree.setVisible(true);
			powerMenu.setVisible(false);
			login.setVisible(false);
			RegManagement.setVisible(false);
			loadBase.setVisible(false);
			AboutUs.setVisible(false);
			cellMenu.setVisible(false);
			vMenu.setVisible(false);
			cvMenu.setVisible(false);
			prisonersMenu.setVisible(false);
			pavMenu.setVisible(false);
			impJson.setVisible(true);
			email.setVisible(false);
			saveChanges.setVisible(false);
			exCSV.setVisible(false);
			break;
		case "exportCSV":
			powerTree.setVisible(true);
			powerMenu.setVisible(false);
			login.setVisible(false);
			RegManagement.setVisible(false);
			loadBase.setVisible(false);
			AboutUs.setVisible(false);
			cellMenu.setVisible(false);
			vMenu.setVisible(false);
			cvMenu.setVisible(false);
			prisonersMenu.setVisible(false);
			pavMenu.setVisible(false);
			impJson.setVisible(false);
			email.setVisible(false);
			saveChanges.setVisible(false);
			exCSV.setVisible(true);
			break;
		case "email":
			powerTree.setVisible(true);
			powerMenu.setVisible(false);
			login.setVisible(false);
			RegManagement.setVisible(false);
			loadBase.setVisible(false);
			AboutUs.setVisible(false);
			cellMenu.setVisible(false);
			vMenu.setVisible(false);
			cvMenu.setVisible(false);
			prisonersMenu.setVisible(false);
			pavMenu.setVisible(false);
			impJson.setVisible(false);
			email.setVisible(true);
			saveChanges.setVisible(false);
			exCSV.setVisible(false);
			break;
		case "save":
			powerTree.setVisible(true);
			powerMenu.setVisible(false);
			login.setVisible(false);
			RegManagement.setVisible(false);
			loadBase.setVisible(false);
			AboutUs.setVisible(false);
			cellMenu.setVisible(false);
			vMenu.setVisible(false);
			cvMenu.setVisible(false);
			prisonersMenu.setVisible(false);
			pavMenu.setVisible(false);
			impJson.setVisible(false);
			email.setVisible(false);
			saveChanges.setVisible(true);
			exCSV.setVisible(false);
			break;
		case "All":
			powerTree.setVisible(true);
			powerMenu.setVisible(false);
			login.setVisible(false);
			RegManagement.setVisible(false);
			loadBase.setVisible(false);
			AboutUs.setVisible(false);
			cellMenu.setVisible(false);
			vMenu.setVisible(false);
			cvMenu.setVisible(false);
			prisonersMenu.setVisible(false);
			pavMenu.setVisible(false);
			impJson.setVisible(false);
			email.setVisible(false);
			saveChanges.setVisible(false);
			exCSV.setVisible(false);
			break;
		}
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Log In");
			putValue(SHORT_DESCRIPTION, "Introduce your user and password to log in");
		}

		public void actionPerformed(ActionEvent e) {
			JSONParser parser = new JSONParser();
			final String text;
			final String text2;
			try {
				if ((count < 2) && (!t.isAlive())) {
					Object obj = parser.parse(new FileReader(mainPath + "database/users.json"));
					JSONObject jsonObject = (JSONObject) obj;
					if (jsonObject.containsKey(textField.getText())) {
						JSONObject obj2 = (JSONObject) jsonObject.get(textField.getText());
						String passtest = (String) obj2.get("Password");
						String power = (String) obj2.get("PowerUser");
						if (passtest.equals(passwordField.getText()) && power.equals("True")) {
							text = "Correct Login";
							text2 = "";
							goTo("loadbase");
							frame.setTitle("Jail System Project - Login/Main Menu");
						} else if (passtest.equals(passwordField.getText()) && power.equals("False")) {
							text = "Correct Login";
							text2 = "";
							goTo("loadbase");
							frame.setTitle("Jail System Project - Login/Main Menu");
							list.setModel(new AbstractListModel() {
								String[] values = new String[] { "1)  Register Management", "2)  Save changes" };

								public int getSize() {
									return values.length;
								}

								public Object getElementAt(int index) {
									return values[index];
								}
							});
							powerTree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Main Menu") {
								{
									DefaultMutableTreeNode node_1;
									node_1 = new DefaultMutableTreeNode("Register Management");
									node_1.add(new DefaultMutableTreeNode("Prisoners"));
									node_1.add(new DefaultMutableTreeNode("CivilServants"));
									node_1.add(new DefaultMutableTreeNode("Visitors"));
									node_1.add(new DefaultMutableTreeNode("Cells"));
									node_1.add(new DefaultMutableTreeNode("Pavilions"));
									add(node_1);
									add(new DefaultMutableTreeNode("Save changes"));
								}
							}));
							// go to user menu
						} else {
							text = "Incorrect Password";
							text2 = "";
							passwordField.setText("");
							count = count + 1;
						}
					} else {
						text = "Invalid User";
						text2 = "";
						textField.setText("");
						passwordField.setText("");
						count = count + 1;
					}
					w = new MessageWindow(text, text2);
					w.frame.setVisible(true);
				} else if ((!t.isAlive())) {
					t = new Timer(5000, textField, passwordField);
					count = 0;
					t.start();
				}
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Accept");
			putValue(SHORT_DESCRIPTION, "Go to data type");
		}

		public void actionPerformed(ActionEvent e) {
			if (comboBox.getSelectedItem().equals("Prisoners")) {
				goTo("prisonersmenu");
				frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Prisoners");
			} else if (comboBox.getSelectedItem().equals("CivilServants")) {
				goTo("cvmenu");
				frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Civil Servants");
			} else if (comboBox.getSelectedItem().equals("Visitors")) {
				goTo("vmenu");
				frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Visitors");
			} else if (comboBox.getSelectedItem().equals("Cells")) {
				goTo("cellmenu");
				frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Cells");
			} else if (comboBox.getSelectedItem().equals("Pavilions")) {
				goTo("pavmenu");
				frame.setTitle("Jail System Project - Login/Main Menu/Register Management/Pavilions");
			}
		}
	}

	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Load Main Database");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			m.JsonToHashPab(mainPath + "database/" + "prisondb" + ".json");
			m.JsonToHashCS(mainPath + "database/" + "civilservants" + ".json");
			m.JsonToHashV(mainPath + "database/" + "visitors" + ".json");
			goTo("powermenu");

		}
	}

	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Load Backup Files");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			m.JsonToHashPab(mainPath + "database/backup/" + "prisondbBackup" + ".json");
			m.JsonToHashCS(mainPath + "database/backup/" + "civilservantsBackup" + ".json");
			m.JsonToHashV(mainPath + "database/backup/" + "visitorsBackup" + ".json");
			goTo("powermenu");

		}
	}

	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "About us action");
			putValue(SHORT_DESCRIPTION, "About Us");
		}

		public void actionPerformed(ActionEvent e) {
			goTo("aboutus");
		}
	}

	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "Browse");
			putValue(SHORT_DESCRIPTION, "Choose your directory file");
		}

		public void actionPerformed(ActionEvent e) {
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			int returnValue = jfc.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				String path = jfc.getSelectedFile().getAbsolutePath();
				lblNewLabel_12.setText(path);
			}

		}
	}

	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "Import");
			putValue(SHORT_DESCRIPTION, "Import json");
		}

		public void actionPerformed(ActionEvent e) {
			if (lblNewLabel_12.getText().equals("Example direction")) {
				MessageWindow w2 = new MessageWindow("Select imported file", "");
				w2.frame.setVisible(true);
			} else {
				int type = -1;
				if (comboBox_1.getSelectedItem().equals("merge data")) {
					type = 0;
				} else if (comboBox_1.getSelectedItem().equals("import new data")) {
					type = 1;
				}
				int filetype = -1;
				if (comboBox_2.getSelectedItem().equals("Pavilion")) {
					filetype = 0;
				} else if (comboBox_2.getSelectedItem().equals("CivilServant")) {
					filetype = 1;
				} else if (comboBox_2.getSelectedItem().equals("Visitor")) {
					filetype = 2;
				}
				String path = lblNewLabel_12.getText();
				m.importJson(type, filetype, path);
				if (!m.importError) {
					MessageWindow mg = new MessageWindow("Data imported succesfully", "");
					mg.frame.setVisible(true);
					goTo("powermenu");
				}else {
					m.importError=false;
				}
			}
		}
	}

	private class SwingAction_11 extends AbstractAction {
		public SwingAction_11() {
			putValue(NAME, "Export");
			putValue(SHORT_DESCRIPTION, "Export CSV");
		}

		public void actionPerformed(ActionEvent e) {
			if (comboBox_csv.getSelectedItem().equals("Prisoners")) {
				try {
					FileWriter writer = new FileWriter(lblNewLabel_csv.getText());
					writer.write(
							"DNI;NOMBRE;APELLIDOS;F_NAC;NACIONALIDAD;SEXO;ALTURA(cm);PESO(kg);NUM_PRESO;NIV_AMENAZA;NUM_CELDA;CRIMEN;CONDENA(aa,mm,dd);INGRESO;VISITAS;LLAMADAS\n");
					for (Prisoner p : m.getPrisoners().values()) {
						writer.write(p.toCSV(';'));
					}
					writer.flush();
					writer.close();
				} catch (Exception exce) {
					exce.printStackTrace();
				}

			} else if (comboBox_csv.getSelectedItem().equals("CivilServants")) {
				try {
					FileWriter writer = new FileWriter(lblNewLabel_csv.getText());
					writer.write(
							"DNI;NOMBRE;APELLIDOS;F_NAC;NACIONALIDAD;SEXO;ALTURA(cm);PESO(kg);CARGO;ID_FUNC;SUELDO;PABELLON;TURNO\n");
					for (CivilServant cs : m.getCivilServants().values()) {
						writer.write(cs.toCSV(';'));
					}
					writer.flush();
					writer.close();
				} catch (Exception exce) {
					exce.printStackTrace();
				}

			} else if (comboBox_csv.getSelectedItem().equals("Visitors")) {
				try {
					FileWriter writer = new FileWriter(lblNewLabel_csv.getText());
					writer.write(
							"DNI;NOMBRE;APELLIDOS;F_NAC;NACIONALIDAD;SEXO;ALTURA(cm);PESO(kg);ID_VISIT;PRESO_VISIT;FECHA_VISIT(dd,mm,aaa);HORA_VISIT(hh,mm,ss);RELACION_PRESO;NUM_VISIT;SOLICITANTE_VISITA\n");
					for (Visitor v : m.getVisitors().values()) {
						writer.write(v.toCSV(';'));
					}
					writer.flush();
					writer.close();
				} catch (Exception exce) {
					exce.printStackTrace();
				}

			} else if (comboBox_csv.getSelectedItem().equals("Cells")) {
				try {
					FileWriter writer = new FileWriter(lblNewLabel_csv.getText());
					writer.write(
							"CAPACIDAD ACTUAL;TIPO DE CELDA;LLENA;ESTADO DE PUERTA;NUM_CELDA;NIV_SEGURIDAD;PISO;NUM_PABELLON;PRESOS CONTENIDOS\n");
					for (Cell c : m.getCells().values()) {
						writer.write(c.toCSV(';'));
					}
					writer.flush();
					writer.close();
				} catch (Exception exce) {
					exce.printStackTrace();
				}

			} else if (comboBox_csv.getSelectedItem().equals("Pavilions")) {
				try {
					FileWriter writer = new FileWriter(lblNewLabel_csv.getText());
					writer.write(
							"NUM_PABELLON;NUM_CELDAS;NUM_PRESOS;NUM_GUARDIAS;NUM_SALAS_COMUNES;CELDAS CONTENIDAS\n");
					for (Pavilion p : m.getPavilions().values()) {
						writer.write(p.toCSV(';'));
					}
					writer.flush();
					writer.close();
				} catch (Exception exce) {
					exce.printStackTrace();
				}
			}
			MessageWindow w = new MessageWindow("CSV saved", "");
			w.frame.setVisible(true);
			goTo("powermenu");

		}
	}

	private class SwingAction_10 extends AbstractAction {
		public SwingAction_10() {
			putValue(NAME, "Browse");
			putValue(SHORT_DESCRIPTION, "Browse files to export");
		}

		public void actionPerformed(ActionEvent e) {
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			int returnValue = jfc.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				String path = jfc.getSelectedFile().getAbsolutePath();
				lblNewLabel_csv.setText(path + ".csv");
			}
		}
	}

	private class SwingAction_7 extends AbstractAction {
		public SwingAction_7() {
			putValue(NAME, "Browse");
			putValue(SHORT_DESCRIPTION, "Browse files to email");
		}

		public void actionPerformed(ActionEvent e) {
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			int returnValue = jfc.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				String path = jfc.getSelectedFile().getAbsolutePath();
				lblNewLabel_15.setText(path);
				fileName2 = jfc.getSelectedFile().getName();
			}
		}
	}

	private class SwingAction_8 extends AbstractAction {
		public SwingAction_8() {
			putValue(NAME, "Send");
			putValue(SHORT_DESCRIPTION, "Send email");
		}

		public void actionPerformed(ActionEvent e) {
			if((textField_1.getText().equals(""))||(lblNewLabel_15.getText().equals("Example direction"))) {
				MessageWindow s = new MessageWindow("Introduce email and file to send", "");
				s.frame.setVisible(true);	
			}else {
			final String username = "jailsystemproject@gmail.com";
			final String password = "averchavales";

			Properties props = new Properties();
			props.put("mail.smtp.auth", true);
			props.put("mail.smtp.starttls.enable", true);
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("jailsystemproject@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(textField_1.getText()));
				message.setSubject(textField_2.getText());
				message.setText("");

				MimeBodyPart messageBodyPart = new MimeBodyPart();

				Multipart multipart = new MimeMultipart();

				messageBodyPart = new MimeBodyPart();
				String file = lblNewLabel_15.getText();
				String fileName = fileName2;
				DataSource source = new FileDataSource(file);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(fileName);
				multipart.addBodyPart(messageBodyPart);

				message.setContent(multipart);
				Transport.send(message);
				MessageWindow s = new MessageWindow("Email sent", "");
				s.frame.setVisible(true);
				goTo("powermenu");

			} catch (MessagingException exc) {
				MessageWindow s = new MessageWindow("Invalid email or file", "");
				s.frame.setVisible(true);	
			}
		}}
	}

	private class SwingAction_9 extends AbstractAction {
		public SwingAction_9() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Save changes");
		}

		public void actionPerformed(ActionEvent e) {
			if ((chckbxNewCheckBox.isSelected()) && (chckbxNewCheckBox2.isSelected())) {
				m.HashToJson(0, "prisondb", "database/");
				m.HashToJson(1, "civilservants", "database/");
				m.HashToJson(2, "visitors", "database/");

				m.HashToJson(0, "prisondbBackup", "database/backup/");
				m.HashToJson(1, "civilservantsBackup", "database/backup/");
				m.HashToJson(2, "visitorsBackup", "database/backup/");

				MessageWindow s = new MessageWindow("Changes saved", "Backup files updated");
				s.frame.setVisible(true);
				goTo("powermenu");
			} else if ((chckbxNewCheckBox.isSelected()) && (!chckbxNewCheckBox2.isSelected())) {
				m.HashToJson(0, "prisondb", "database/");
				m.HashToJson(1, "civilservants", "database/");
				m.HashToJson(2, "visitors", "database/");

				MessageWindow s = new MessageWindow("Changes saved", "Backup files not updated");
				s.frame.setVisible(true);
				goTo("powermenu");
			} else if ((!chckbxNewCheckBox.isSelected()) && (chckbxNewCheckBox2.isSelected())) {
				m.HashToJson(0, "prisondbBackup", "database/backup/");
				m.HashToJson(1, "civilservantsBackup", "database/backup/");
				m.HashToJson(2, "visitorsBackup", "database/backup/");

				MessageWindow s = new MessageWindow("Changes not saved", "Backup files updated");
				s.frame.setVisible(true);
				goTo("powermenu");
			} else if ((!chckbxNewCheckBox.isSelected()) && (!chckbxNewCheckBox2.isSelected())) {
				MessageWindow s = new MessageWindow("Changes not saved", "Backup files not updated");
				s.frame.setVisible(true);
				goTo("powermenu");
			}
		}
	}
}
