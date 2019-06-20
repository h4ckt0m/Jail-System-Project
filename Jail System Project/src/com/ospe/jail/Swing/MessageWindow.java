package com.ospe.jail.Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;


import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class MessageWindow {
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	public JFrame frame;
	private final Action close = new SwingAction();
	/**
	 * Create the application.
	 */
	public MessageWindow(String txt,String txt2) {
		initialize(txt,txt2);
	}

	public JLabel getBigLabel() {
		return lblNewLabel;
	}

	public void setBigLabel(String txt) {
		lblNewLabel.setText(txt);
	}

	public JLabel getLittleLabel() {
		return lblNewLabel_1;
	}

	public void setLittleLabel(String txt) {
		lblNewLabel_1.setText(txt);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String text,String text2) {
		frame = new JFrame();
		frame.setTitle("Jail System Project - Message");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\minilogo.png"));
		frame.setSize(380, 211);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblNewLabel = new JLabel(text);
		if ((text.equals("Correct Login"))||(text.equals("Data imported succesfully"))) {
			lblNewLabel.setForeground(Color.GREEN);
		}
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 364, 116);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() == '\n') {
					close.actionPerformed(null);
				}
			}
		});
		btnNewButton.setAction(close);
		btnNewButton.setBounds(139, 127, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_1 = new JLabel(text2);
		lblNewLabel_1.setForeground(Color.RED);
		if((text.equals("Query finished"))||(text2.equals("Backup files updated"))) {
		lblNewLabel_1.setForeground(Color.BLACK);
		}
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 95, 364, 23);
		frame.getContentPane().add(lblNewLabel_1);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Accept");
			putValue(SHORT_DESCRIPTION, "Accept and close window");
		}

		public void actionPerformed(ActionEvent e) {
			frame.hide();
		}
	}
}
