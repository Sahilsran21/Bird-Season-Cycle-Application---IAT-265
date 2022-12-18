package bird;



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;

import javax.swing.Timer;

import processing.core.*;


public class BlueJay extends Bird implements ActionListener {
//Fields
	
	
	//Declaration for blue jay shape features
	//Head Features
	private Ellipse2D.Double head;
	private Ellipse2D.Double eye;
	private QuadCurve2D.Double headStripe;
	private QuadCurve2D.Double beak;
	

	//Body Features
	//Flying 
	private Ellipse2D.Double body;
	
	private Ellipse2D.Double flyingWing;
	
	private Rectangle2D.Double leg;
	private Rectangle2D.Double foot;
	
	private Ellipse2D.Double tailFeather1;
	private Ellipse2D.Double tailFeather2;
	private Ellipse2D.Double tailFeather3;
	
	
	
	//Sat down
	private Ellipse2D.Double satBody;
	
	private Ellipse2D.Double satFeather1;
	private Ellipse2D.Double satFeather2;
	private Ellipse2D.Double satFeather3;
	
	private Rectangle2D.Double satLeg;
	private Rectangle2D.Double satFoot1;
	private Rectangle2D.Double satFoot2;

	private Ellipse2D.Double satTailFeather1;
	private Ellipse2D.Double satTailFeather2;
	private Ellipse2D.Double satTailFeather3;
	
	

	//Estimates of Blue Jay's width and height for hit detection
	public final int HEAD_WIDTH = 15;
	public final int HEAD_HEIGHT = 15;
	public final int BODY_WIDTH = 20;
	public final int BODY_HEIGHT = 45;
	
	protected int colorCode1 = 128; 
	protected int colorCode2 = 191;
	protected int colorCode3 = 255;

	protected int colorCodeStroke1 = 0; 
	protected int colorCodeStroke2 = 51;
	protected int colorCodeStroke3 = 102;
	
	
//Methods
	
	//Set up body component location and size, assuming (0,0) is center of the body
	//with other elements drawn around it 
	private void setBodyAttributes() {
		
		
	//Flying
	body.setFrame(-10, -20, 20, 50);
	
	flyingWing.setFrame(-5, -10, 10, 30);
	
	leg.setFrame(20, 5, 6, 2);
	foot.setFrame(28, 1, 6, 0.5);
	
	tailFeather1.setFrame(2, 23, 6, 25);
	tailFeather2.setFrame(0, 25, 6, 25);
	tailFeather3.setFrame(-1, 26, 6, 25);
	
	
	
	//Sat Down
	satBody.setFrame(7, -15, 20, 40);
	
	satFeather1.setFrame(-16, -20, 6, 25);
	satFeather2.setFrame(-19, -20, 6, 25);
	satFeather3.setFrame(-23, -20, 6, 25);
	
	satLeg.setFrame(25, -17, 10, 1);
	satFoot1.setFrame(-2, -39, 4, 0.5);
	satFoot2.setFrame(-25, -34, 4, 0.5);
	
	satTailFeather1.setFrame(-22, -30, 5, 20);
	satTailFeather2.setFrame(-22, -34, 5, 20);
	satTailFeather3.setFrame(-22, -38, 5, 20);
	}
	
	
	
	
	//Set up head components with reference to the center of the body (0,0)
	private void setHeadAttributes() {
		
	head.setFrame(-7.5, -30, 15, 15);
	headStripe.setCurve(-1.5, -29, -1.5, -20, -5, -17);
	eye.setFrame(-5, -29, 3.8, 3.8);
	beak.setCurve(-2, -30, 0, -50, 2, -30);
	
	}
	

	
	
	
	//Public method for drawing the blue jay
	public void draw(Graphics2D g2) {
		
		//get the direction the blue jay is moving from PVector vel
		angle = vel.heading();
		
	
		
		//Set up initial location for Blue Jay and rotate the drawing space before drawing
		AffineTransform transform = g2.getTransform();
		g2.translate(pos.x, pos.y);  
		g2.rotate(angle - 300);
		g2.scale(scale,scale);	
		
		//Mirrors the drawing 
		if (vel.x < 0)
		{
			g2.scale(-1, 1);
		}
		
		

		//Draw Legs
		g2.rotate(Math.toRadians(50));
		g2.setColor(new Color(0,0,0));
		g2.setStroke(new BasicStroke(3));
		g2.draw(leg);
		g2.setColor(new Color(22,22,22));
		g2.fill(leg);
		g2.rotate(Math.toRadians(-50));
		
		
		g2.rotate(Math.toRadians(60));
		g2.setColor(new Color(0,0,0));
		g2.setStroke(new BasicStroke(3));
		g2.draw(foot);
		g2.setColor(new Color(22,22,22));
		g2.fill(foot);
		g2.rotate(Math.toRadians(-60));

		
		
		
		//Draw Body
		g2.setColor(new Color(colorCode1, colorCode2, colorCode3));
		g2.fill(body);
		
		g2.setColor(new Color(colorCodeStroke1, colorCodeStroke2, colorCodeStroke3));
		g2.setStroke(new BasicStroke(2));
		g2.draw(body);
		
		
		
		//Draw Tail Feathers
		g2.rotate(Math.toRadians(20));
		g2.setColor(new Color(colorCodeStroke1, colorCodeStroke2, colorCodeStroke3));
		g2.draw(tailFeather1);
		g2.setColor(new Color(colorCode1, colorCode2, colorCode3));
		g2.fill(tailFeather1);
		g2.rotate(Math.toRadians(-20));
		
		g2.rotate(Math.toRadians(10));
		g2.setColor(new Color(colorCodeStroke1, colorCodeStroke2, colorCodeStroke3));
		g2.draw(tailFeather2);
		g2.setColor(new Color(colorCode1, colorCode2, colorCode3));
		g2.fill(tailFeather2);
		g2.rotate(Math.toRadians(-10));
		
		g2.setColor(new Color(colorCodeStroke1, colorCodeStroke2, colorCodeStroke3)); 
		g2.draw(tailFeather3);
		g2.setColor(new Color(colorCode1, colorCode2, colorCode3));
		g2.fill(tailFeather3);
		
		
		
		//Draw Wing	
		g2.setColor(new Color(colorCodeStroke1, colorCodeStroke2, colorCodeStroke3));
		g2.setStroke(new BasicStroke(3));
		g2.draw(flyingWing);
		g2.setColor(new Color(colorCode1, colorCode2, colorCode3));
		g2.fill(flyingWing);
		
		
		
		
		
		
		
		//Draw Head 
		g2.setColor(new Color(colorCode1, colorCode2, colorCode3));
		g2.fill(head);

		g2.setColor(new Color(colorCodeStroke1, colorCodeStroke2, colorCodeStroke3));
		g2.setStroke(new BasicStroke(1));
		g2.draw(headStripe);
		
		g2.setStroke(new BasicStroke(2));
		g2.setColor(new Color(0));
		g2.draw(beak);
		g2.setColor(new Color(50,50,50));
		g2.fill(beak);
		
		g2.setColor(new Color(colorCodeStroke1, colorCodeStroke2, colorCodeStroke3));
		g2.setStroke(new BasicStroke(2));
		g2.draw(head);

		g2.setColor(new Color(22,22,22));
		g2.fill(eye);
		
		
		g2.setTransform(transform);		
	}
	
	

	
	
	
	
	//Public method for drawing the blue jay
		public void drawSat(Graphics2D g2) {
			//get the direction the blue jay is moving from PVector vel
			angle = vel.heading();
			
			//Set up initial location for Blue Jay and rotate the drawing space before drawing
			AffineTransform transform = g2.getTransform();
			g2.translate(pos.x, pos.y);  
			g2.rotate(angle - 300);
			g2.scale(scale,scale);		
			
			
			if (vel.x < 0)
			{
			g2.scale(-1, 1);
			}
			
			
			
			
			//Draw Body
			g2.rotate(Math.toRadians(-55));
			g2.setColor(new Color(colorCode1, colorCode2, colorCode3));
			g2.fill(satBody);
			
			g2.setColor(new Color(colorCodeStroke1, colorCodeStroke2, colorCodeStroke3));
			g2.setStroke(new BasicStroke(2));
			g2.draw(satBody);
			g2.rotate(Math.toRadians(55));
			
			
			//Draw Feathers
			g2.rotate(Math.toRadians(130));
			g2.setColor(new Color(colorCodeStroke1, colorCodeStroke2, colorCodeStroke3));
			g2.setStroke(new BasicStroke(3));
			g2.draw(satFeather1);
			g2.setColor(new Color(colorCode1, colorCode2, colorCode3));
			g2.fill(satFeather1);
			g2.rotate(Math.toRadians(-130));
			
			g2.rotate(Math.toRadians(125));
			g2.setColor(new Color(colorCodeStroke1, colorCodeStroke2, colorCodeStroke3));
			g2.draw(satFeather2);
			g2.setColor(new Color(colorCode1, colorCode2, colorCode3));
			g2.fill(satFeather2);
			g2.rotate(Math.toRadians(-125));
			
			g2.rotate(Math.toRadians(120));
			g2.setColor(new Color(colorCodeStroke1, colorCodeStroke2, colorCodeStroke3));
			g2.draw(satFeather3);
			g2.setColor(new Color(colorCode1, colorCode2, colorCode3));
			g2.fill(satFeather3);
			g2.rotate(Math.toRadians(-120));
			
		
			
			//Draw Tail Feathers
			g2.rotate(Math.toRadians(150));
			g2.setColor(new Color(colorCodeStroke1, colorCodeStroke2, colorCodeStroke3));
			g2.draw(satTailFeather1);
			g2.setColor(new Color(colorCode1, colorCode2, colorCode3));
			g2.fill(satTailFeather1);
			g2.rotate(Math.toRadians(-150));
			
			g2.rotate(Math.toRadians(140));
			g2.setColor(new Color(colorCodeStroke1, colorCodeStroke2, colorCodeStroke3));
			g2.draw(satTailFeather2);
			g2.setColor(new Color(colorCode1, colorCode2, colorCode3));
			g2.fill(satTailFeather2);
			g2.rotate(Math.toRadians(-140));
			
			g2.rotate(Math.toRadians(130));
			g2.setColor(new Color(colorCodeStroke1, colorCodeStroke2, colorCodeStroke3));
			g2.draw(satTailFeather3);
			g2.setColor(new Color(colorCode1, colorCode2, colorCode3));
			g2.fill(satTailFeather3);
			g2.rotate(Math.toRadians(-130));

			
			
			
			
			//Draw Legs
			g2.rotate(Math.toRadians(15));
			g2.setColor(new Color(0,0,0));
			g2.setStroke(new BasicStroke(3));
			g2.draw(satLeg);
			g2.setColor(new Color(22,22,22));
			g2.fill(satLeg);
			g2.rotate(Math.toRadians(-15));
			
			
			g2.rotate(Math.toRadians(85));
			g2.setColor(new Color(0,0,0));
			g2.setStroke(new BasicStroke(3));
			g2.draw(satFoot1);
			g2.setColor(new Color(22,22,22));
			g2.fill(satFoot1);
			g2.rotate(Math.toRadians(-85));

			
			g2.rotate(Math.toRadians(110));
			g2.setColor(new Color(0,0,0));
			g2.setStroke(new BasicStroke(3));
			g2.draw(satFoot2);
			g2.setColor(new Color(22,22,22));
			g2.fill(satFoot2);
			g2.rotate(Math.toRadians(-110));
			
			
			
			
			//Draw Head 
			g2.setColor(new Color(colorCode1, colorCode2, colorCode3));
			g2.fill(head);
			
			g2.setColor(new Color(colorCodeStroke1, colorCodeStroke2, colorCodeStroke3));
			g2.setStroke(new BasicStroke(1));
			g2.draw(headStripe);
		
			
			g2.setStroke(new BasicStroke(2));
			g2.setColor(new Color(0));
			g2.draw(beak);
			g2.setColor(new Color(50,50,50));
			g2.fill(beak);
			
			
			g2.setColor(new Color(colorCodeStroke1, colorCodeStroke2, colorCodeStroke3));
			g2.setStroke(new BasicStroke(2));
			g2.draw(head);

			g2.setColor(new Color(22,22,22));
			g2.fill(eye);
		
			g2.setTransform(transform);
		}
	

		

		
	
//Constructor
 public BlueJay(double x, double y, double velX, double velY, double s) {
		
		//Instantiate Blue Jay's attributes
		super(x,y,velX,velY,s);   //Explicitly invokes the superclass constructor
		
		//Instantiate Head Features
		head = new Ellipse2D.Double();
		eye = new Ellipse2D.Double();
		headStripe = new QuadCurve2D.Double();
		beak = new QuadCurve2D.Double();
		
		//Instantiate Body Features
		
		
		//Flying
		body = new Ellipse2D.Double();
		
		leg = new Rectangle2D.Double();
		foot = new Rectangle2D.Double();        
		
		flyingWing = new Ellipse2D.Double();
		
		tailFeather1 = new Ellipse2D.Double();
		tailFeather2 = new Ellipse2D.Double();
		tailFeather3 = new Ellipse2D.Double();
		
		
		
		//Sat Down
		satBody = new Ellipse2D.Double();
		satFeather1 = new Ellipse2D.Double();
		satFeather2 = new Ellipse2D.Double();
		satFeather3 = new Ellipse2D.Double();
		
		satLeg = new Rectangle2D.Double();
		satFoot1 = new Rectangle2D.Double();        
		satFoot2 = new Rectangle2D.Double();
		
		satTailFeather1 = new Ellipse2D.Double();
		satTailFeather2 = new Ellipse2D.Double();
		satTailFeather3 = new Ellipse2D.Double();
	
		
		
		
		//Method calls to properly position and draw the Blue Jay's features
		setHeadAttributes();
		setBodyAttributes();		
	}


}

