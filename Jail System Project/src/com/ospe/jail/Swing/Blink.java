package com.ospe.jail.Swing;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Blink extends Thread{
	JFrame frame;
	JPanel powermenu;
	JLabel label;
	public Blink(JFrame frame, JPanel powermenu, JLabel label) {
		this.powermenu=powermenu;
		this.label=label;
		this.frame=frame;
	}
	public void run() {
		int vx=3;
		int vy=3;
		int x=label.getX();
		int y=label.getY();
		int maxX=550;
		int minX=120;
		int maxY=380;
		int minY=0;
		int colorx=0;
		int colory=0;
		while(powermenu.isVisible()) {
			if((x>=maxX)||(x<=minX)) {
				vx=vx*(-1);
				if(colorx==0) {
					label.setIcon(new ImageIcon("resources\\JSP300.png"));
					colorx=1;
				}else {
					label.setIcon(new ImageIcon("resources\\JSP300b.png"));
					colorx=0;
				}
				
			}
			if((y>=maxY)||(y<=minY)) {
				vy=vy*(-1);
				if(colory==0) {
					label.setIcon(new ImageIcon("resources\\JSP300g.png"));
					colory=1;
				}else {
					label.setIcon(new ImageIcon("resources\\JSP300r.png"));
					colory=0;
				}
			}
			x=label.getX()+vx;
			y=label.getY()+vy;
			label.setLocation(x, y);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			frame.repaint();
		}
	}
}
