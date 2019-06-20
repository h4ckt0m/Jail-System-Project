package com.ospe.jail.Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class pong extends Thread {

	private JFrame frame;
	private JLabel ball;
	JLabel p1points;
	JLabel p2points;
	JLabel player1;
	JLabel player2;

	
	public pong(JFrame frame, JLabel ball, JLabel p1points, JLabel p2points, JLabel player1, JLabel player2) {
		super();
		this.frame = frame;
		this.ball = ball;
		this.p1points = p1points;
		this.p2points = p2points;
		this.player1 = player1;
		this.player2 = player2;
	}

	public pong() {
	}

	public void run() {
		double vx = 3;
		double vy = 3;
		double ax = 0.01;
		double ay = 0.01;
		double x = ball.getX();
		double y = ball.getY();
		int maxX = 820;
		int minX = -10;
		int maxY = 450;
		int minY = -50;
		int count = 0;
		int puntosP1 = 1;
		int puntosP2 = 1;
		int lastchoque=0;
		boolean game = true;
		boolean point = true;
		while (game) {
			if ((puntosP1 > 5)||(puntosP2 > 5)) {
				game=false;
			} else {
				//reseteo del siguiente punto-------------------------------
				point = true;
				vx=3;
				vy=3;
				ax = 0.01;
				ay = 0.01;
				x=350;
				Random r = new Random();
				y=r.nextInt((420 - 0) + 1) + 0;
				lastchoque=0;
				ball.setLocation((int) x, (int) y);
				while (point) {
					//colisión con player 2---------------------------------
					if(((x+5>=player1.getX())&&(x+5<=player1.getX()+30))&&((y+55>=player1.getY()+19)&&(y+55<=player1.getY()+103))) {
						if(lastchoque==1) {}else {
						//System.out.println("choque con 1");
						lastchoque=1;
						vx = vx * (-1); 
						ax = ax * (-1);}
					}
					//colisión con player 2---------------------------------
					if(((x+5>=player2.getX()-30)&&(x+5<=player2.getX()))&&((y+55>=player2.getY()+19)&&(y+55<=player2.getY()+103))) {
						if(lastchoque==2) {}else {
						//System.out.println("choque con 2");
						lastchoque=2;
						vx = vx * (-1); 
						ax = ax * (-1);}
					}
					
					//Puntos-------------------------------------------
					if ((x >= maxX) || (x <= minX)) {
						if (x > 400) {
							p1points.setText(puntosP1++ + "");
							point = false;
						} else {
							p2points.setText(puntosP2++ + "");
							point = false;
						}
					}
					//Rebotes con las paredes---------------------------
					if ((y >= maxY) || (y <= minY)) {
						vy = vy * (-1);
						ay = ay * (-1);
					}
					//Calcular siguiente posicion---------------------
					x = ball.getX() + vx;
					y = ball.getY() + vy;
					vx = vx + ax;
					vy = vy + ay;
					ball.setLocation((int) x, (int) y);
					frame.repaint();
					//Delay de fps-----------------------------------
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		String text;
		if(puntosP1>=5) {
			text="Player 1 wins";
		}else {
			text="Player 2 wins";
		}
		MessageWindow w=new MessageWindow(text,"");
		w.frame.setVisible(true);
		}
	}

