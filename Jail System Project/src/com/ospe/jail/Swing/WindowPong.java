package com.ospe.jail.Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class WindowPong {

	private JFrame frame;
	private JPanel mainp;
	JLabel ball;
	JLabel player1;
	JLabel player2;
	pong p;
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowPong window = new WindowPong();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public WindowPong(JFrame frame, JPanel mainp) {
		this.frame=frame;
		this.mainp=mainp;
		initialize();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getMainp() {
		return mainp;
	}

	public void setMainp(JPanel mainp) {
		this.mainp = mainp;
	}

	private void initialize() {
		
//comment-----------------------------------------------------------------
		/*frame = new JFrame();
		frame.setBounds(250, 100, 852, 550);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
//comment-----------------------------------------------------------------
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setVisible(true);

		JLabel p1points = new JLabel("0");
		p1points.setFont(new Font("Tahoma", Font.PLAIN, 20));
		p1points.setHorizontalAlignment(SwingConstants.CENTER);
		p1points.setForeground(Color.WHITE);
		p1points.setBounds(336, 37, 46, 34);
		panel.add(p1points);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(410, 0, 4, 522);
		panel.add(textArea);

		JLabel p2points = new JLabel("0");
		p2points.setHorizontalAlignment(SwingConstants.CENTER);
		p2points.setForeground(Color.WHITE);
		p2points.setFont(new Font("Tahoma", Font.PLAIN, 20));
		p2points.setBounds(443, 37, 46, 34);
		panel.add(p2points);

		player1 = new JLabel("|");
		player1.setFont(new Font("Tahoma", Font.PLAIN, 90));
		player1.setHorizontalAlignment(SwingConstants.CENTER);
		player1.setForeground(Color.WHITE);
		player1.setBackground(SystemColor.text);
		player1.setBounds(40, 228, 34, 104);
		panel.add(player1);

		player2 = new JLabel("|");
		player2.setHorizontalAlignment(SwingConstants.CENTER);
		player2.setForeground(Color.WHITE);
		player2.setFont(new Font("Tahoma", Font.PLAIN, 90));
		player2.setBackground(Color.WHITE);
		player2.setBounds(754, 228, 34, 104);
		panel.add(player2);

		ball = new JLabel(".");
		ball.setHorizontalAlignment(SwingConstants.CENTER);
		ball.setFont(new Font("Tahoma", Font.PLAIN, 80));
		ball.setForeground(Color.WHITE);
		ball.setBounds(333, 228, 24, 61);
		panel.add(ball);
		
		JLabel lblNewLabel = new JLabel("Player 1");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(336, 23, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblPlayer = new JLabel("Player 2");
		lblPlayer.setForeground(Color.WHITE);
		lblPlayer.setBounds(443, 23, 46, 14);
		panel.add(lblPlayer);
		
		JLabel cross = new JLabel("");
		cross.setHorizontalAlignment(SwingConstants.CENTER);
		cross.setIcon(new ImageIcon("resources\\x20.png"));
		cross.setBounds(10, 0, 46, 41);
		panel.add(cross);
		cross.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				panel.setVisible(false);
				getMainp().setVisible(true);
				frame.repaint();
				p.currentThread().stop();
				}
		});
		textArea.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				p1points.setText(0+"");
				p2points.setText(0+"");
				p = new pong(frame, ball, p1points, p2points, player1, player2);
				p.start();
				frame.repaint();
				}
		});
		textArea.addKeyListener(new KeyAdapter() {
			int barSpeed=40;
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() == 's') {
					if (player1.getY() + barSpeed <= 450) {
						player1.setLocation(player1.getX(), player1.getY() + barSpeed);
					} else {
					}

					frame.repaint();
				} else if (arg0.getKeyChar() == 'w') {
					if (player1.getY() - barSpeed >= -45) {
						player1.setLocation(player1.getX(), player1.getY() - barSpeed);
					} else {
					}

					frame.repaint();
				} else if (arg0.getKeyChar() == 'l') {
					if (player2.getY() + barSpeed <= 450) {
						player2.setLocation(player2.getX(), player2.getY() + barSpeed);
					} else {
					}

					frame.repaint();
				} else if (arg0.getKeyChar() == 'o') {
					if (player2.getY() - barSpeed >= -45) {
						player2.setLocation(player2.getX(), player2.getY() - barSpeed);
					} else {
					}
					frame.repaint();
				}
			}
		});
	}
}
