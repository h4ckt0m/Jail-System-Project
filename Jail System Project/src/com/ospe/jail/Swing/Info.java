package com.ospe.jail.Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class Info {

	JFrame frame;

	public Info() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setSize(532, 439);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOW TO PLAY");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(118, 23, 266, 56);
		frame.getContentPane().add(lblNewLabel);
		
		JTextArea txtrPlayer = new JTextArea();
		txtrPlayer.setEditable(false);
		txtrPlayer.setBackground(SystemColor.menu);
		txtrPlayer.setText(" - Player 1 controls:\r\n\tup: W\r\n\tdown: S\r\n\r\n - Player 2 controls:\r\n\tup: O\r\n\tdown: L\r\n\r\n - Start/Restart game: click on the middle white bar\r\n\r\n - Exit: click on the red cross in the upper left corner\r\n\r\n - Once the game has started, it will finish when one of the players \r\n    reaches five points\r\n\r\n - Good luck!");
		txtrPlayer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrPlayer.setBounds(48, 90, 419, 277);
		frame.getContentPane().add(txtrPlayer);
	}
}
