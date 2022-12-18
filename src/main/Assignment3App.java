package main;


import javax.swing.JFrame;

import bird.Panel;

public class Assignment3App extends JFrame {

	public Assignment3App(String title) {
		super(title);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setLocation(100, 100);
		Panel p = new Panel();
		this.add(p);
		this.pack();
		this.setVisible(true);	
	}
	
	public static void main(String[] args) {
		new Assignment3App("Assignment 3.2: The Nesting Blue Jay");
	}

}
