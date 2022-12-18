package tree;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import processing.core.PVector;

import decorator.NestInterface;

public class Nest implements NestInterface {

	
//Fields
	private PVector pos;
	private int angle;
	private double scale;
	
	
//Features
	private Rectangle2D.Double nestBranch1;
	private Rectangle2D.Double nestBranch2;
	private Rectangle2D.Double nestBranch3;
	private Rectangle2D.Double nestBranch4;
	private Rectangle2D.Double nestBranch5;	
	

	

	
	
//Methods
	public Nest getBaseNest() {
		return this;
	}
	
	
	
	public void prepareG2ForDrawing(Graphics2D g2) {
		g2.translate(pos.x, pos.y);
		g2.rotate(angle);
	}
	
	
	
	private void setAttributes() {

		nestBranch1.setFrame(50, 650, 2, 50);
		nestBranch2.setFrame(386, 532, 2, 50);
		nestBranch3.setFrame(590, 317, 2, 50);
		nestBranch4.setFrame(684, 33, 2, 50);
		nestBranch5.setFrame(626, -318, 2, 50);
	}
	
	
	
	
	
	
	public void drawNest(Graphics2D g2)
	{	
		AffineTransform transform = g2.getTransform();
		
		g2.translate(pos.x, pos.y);  
		g2.rotate(angle);
		g2.scale(scale,scale);	
		
		g2.setStroke(new BasicStroke(3)); 
		
		g2.rotate(Math.toRadians(-55));
		g2.setColor(new Color(0,0,0));
		g2.draw(nestBranch1);
		g2.setColor(new Color(77, 51, 25));
		g2.fill(nestBranch1);
		g2.rotate(Math.toRadians(55));
		
		g2.rotate(Math.toRadians(-25));
		g2.setColor(new Color(0,0,0));
		g2.draw(nestBranch2);
		g2.setColor(new Color(77, 51, 25));
		g2.fill(nestBranch2);
		g2.rotate(Math.toRadians(25));
		
		g2.rotate(Math.toRadians(0));
		g2.setColor(new Color(0,0,0));
		g2.draw(nestBranch3);
		g2.setColor(new Color(77, 51, 25));
		g2.fill(nestBranch3);
		g2.rotate(Math.toRadians(0));
		
		g2.rotate(Math.toRadians(25));
		g2.setColor(new Color(0,0,0));
		g2.draw(nestBranch4);
		g2.setColor(new Color(77, 51, 25));
		g2.fill(nestBranch4);
		g2.rotate(Math.toRadians(-25));
		
		g2.rotate(Math.toRadians(55));
		g2.setColor(new Color(0,0,0));
		g2.draw(nestBranch5);
		g2.setColor(new Color(77, 51, 25));
		g2.fill(nestBranch5);
		g2.rotate(Math.toRadians(-55));
		
		g2.setTransform(transform);	
	}
	
	
	
	
	
	
//Constructor
	public Nest(float x, float y, double s) {
		pos = new PVector (x, y);
		scale = s;
	
		//Instantiate Features
		nestBranch1 = new Rectangle2D.Double();
		nestBranch2 = new Rectangle2D.Double();    
		nestBranch3 = new Rectangle2D.Double();
		nestBranch4 = new Rectangle2D.Double();    
		nestBranch5 = new Rectangle2D.Double();	
		

		setAttributes();
	}
	
}
