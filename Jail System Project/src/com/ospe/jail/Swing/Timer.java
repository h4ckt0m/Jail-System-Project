package com.ospe.jail.Swing;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Timer extends Thread {
	long time;
	private JTextField tf = new JTextField();
	private JPasswordField pf = new JPasswordField();

	public Timer(long time, JTextField tf, JPasswordField pf) {
		super();
		this.time = time;
		this.tf = tf;
		this.pf = pf;
	}

	public void run() {
		MessageWindow w = new MessageWindow("You wasted 3 attempts", "");
		w.frame.setVisible(true);
		long start = System.currentTimeMillis();
		tf.setForeground(Color.RED);
		while ((System.currentTimeMillis() - start) <= time) {
			w.setLittleLabel("Wait for "+((time/1000)-(System.currentTimeMillis() - start) / 1000) + " s");
			tf.setText("Wait for "+((time/1000)-(System.currentTimeMillis() - start) / 1000) + " s");
			pf.setText("");
		}
		tf.setForeground(Color.BLACK);
		tf.setText("");
		w.frame.hide();
	}
}
