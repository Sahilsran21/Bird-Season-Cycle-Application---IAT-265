package decorator;
import java.awt.Graphics2D;

import processing.core.PVector;
import tree.Nest;

public class NestDecorator implements NestInterface {

	
	
//Fields
		//keeps reference to the decorator it draws on top off for NestDecorator 
	    //this objects is Nest, which implements NestInterface	
		protected NestInterface parentNestDecorator;
		protected PVector pos;
		protected int angle;
		protected double scale;
		
		protected static int nestPosX = 200;
		protected static int nestPosY = -60;
		protected static int nestAngle = 0;
		protected static double nestScale = 1.2;
		
		
		
		
		
//Methods
		public void drawNest(Graphics2D g2) {
			parentNestDecorator.drawNest(g2);
			//no other decoration beyond what Nest object draws
		}
		
		
		
		@Override
		public Nest getBaseNest() {
			//return the nest object
			return parentNestDecorator.getBaseNest();
		}
		

	

		
//Constructor
		public NestDecorator(NestInterface nestDecorator, int x, int y, int a, double s) {
			//NestDecorator must be called with Nest object as a parameter
			pos = new PVector (x, y);
			this.angle = a;
			this.scale = s;
			
			parentNestDecorator = nestDecorator;
		}
	
}
