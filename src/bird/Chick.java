package bird;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import decorator.NestDecorator;
import decorator.NestInterface;

public class Chick extends Bird{

	
	
	
//Fields	
	private Ellipse2D.Double chickHead;
	private Ellipse2D.Double chickBody;
	private Polygon chickBeak;
	private Ellipse2D.Double chickEye;
	private Ellipse2D.Double flyingWing;
	private Rectangle2D.Double leg;
	
			
//Methods		
	private void setAttributes() {

		chickHead.setFrame(0,313,13,13);
		chickBody.setFrame(-22,312.5,30,15);
		chickEye.setFrame(10, 315, 2, 2);
		flyingWing.setFrame(-17,315.5,20,8);
		leg.setFrame(-185,273,6,1);
			
		chickBeak.addPoint(14,321);
		chickBeak.addPoint(19,319);
		chickBeak.addPoint(14,317);	
	}
			
		
		
				

	@Override
	public void draw(Graphics2D g2) {
				
			//get the direction the blue jay is moving from PVector vel
			angle = vel.heading();
						
			//Draw the third chick decorator
			AffineTransform transform = g2.getTransform();		
			g2.translate(pos.x, pos.y);  
			g2.rotate(angle);
			g2.scale(scale,scale);	
				
			//Mirrors the drawing 
			if (vel.x < 0)
			{
				g2.scale(-1, 1);
			}
			
			
			
			g2.setStroke(new BasicStroke(3)); 
			
			
			g2.rotate(Math.toRadians(-30));
			g2.setColor(new Color(0,0,0));
			g2.draw(leg);
			g2.setColor(new Color(22,22,22));
			g2.fill(leg);
			g2.rotate(Math.toRadians(30));
					
			//g2.rotate(Math.toRadians(-20));
			g2.setColor(new Color(0,0,0));
			g2.draw(chickBody);
			g2.setColor(new Color(128,191,255));
			g2.fill(chickBody);
			//g2.rotate(Math.toRadians(20));
		
			g2.setColor(new Color(0,0,0));
			g2.draw(flyingWing);
			g2.setColor(new Color(128,191,255));
			g2.fill(flyingWing);
			
			g2.setColor(new Color(0,0,0));
			g2.draw(chickHead);
			g2.setColor(new Color(128,191,255));
			g2.fill(chickHead);
			
			//g2.rotate(Math.toRadians(-50));
			g2.setColor(new Color(0,0,0));
			g2.draw(chickBeak);
			g2.setColor(new Color(50,50,50));
			g2.fill(chickBeak);
			//g2.rotate(Math.toRadians(-50));
			
			g2.setColor(new Color(0,0,0));
			g2.draw(chickEye);
			g2.setColor(new Color(22, 22, 22));
			g2.fill(chickEye);
			
			
			
			
			
			
			g2.setTransform(transform);		
	}
	
	
	
	@Override
	public void drawSat(Graphics2D g2) {
		
		//get the direction the blue jay is moving from PVector vel
		angle = vel.heading();
					
		//Draw the third chick decorator
		AffineTransform transform = g2.getTransform();		
		g2.translate(pos.x, pos.y);  
		g2.rotate(angle);
		g2.scale(scale,scale);	
			
		//Mirrors the drawing 
		if (vel.x < 0)
		{
			g2.scale(-1, 1);
		}
		
		
		
		g2.setStroke(new BasicStroke(3)); 
		
		
		g2.rotate(Math.toRadians(-30));
		g2.setColor(new Color(0,0,0));
		g2.draw(leg);
		g2.setColor(new Color(22,22,22));
		g2.fill(leg);
		g2.rotate(Math.toRadians(30));
				
		//g2.rotate(Math.toRadians(-20));
		g2.setColor(new Color(0,0,0));
		g2.draw(chickBody);
		g2.setColor(new Color(128,191,255));
		g2.fill(chickBody);
		//g2.rotate(Math.toRadians(20));
	
		g2.setColor(new Color(0,0,0));
		g2.draw(flyingWing);
		g2.setColor(new Color(128,191,255));
		g2.fill(flyingWing);
		
		g2.setColor(new Color(0,0,0));
		g2.draw(chickHead);
		g2.setColor(new Color(128,191,255));
		g2.fill(chickHead);
		
		//g2.rotate(Math.toRadians(-50));
		g2.setColor(new Color(0,0,0));
		g2.draw(chickBeak);
		g2.setColor(new Color(50,50,50));
		g2.fill(chickBeak);
		//g2.rotate(Math.toRadians(-50));
		
		g2.setColor(new Color(0,0,0));
		g2.draw(chickEye);
		g2.setColor(new Color(22, 22, 22));
		g2.fill(chickEye);
		
		
		
		
		
		
		g2.setTransform(transform);	
	}
		
		
		

	
	

			
				
//Constructor
		public Chick(double x, double y, double velX, double velY, double s) {
			
			super(x,y,velX,velY,s);
				
			chickHead = new Ellipse2D.Double();
			chickBody = new Ellipse2D.Double();
			chickBeak = new Polygon();
			chickEye = new Ellipse2D.Double();
			flyingWing = new Ellipse2D.Double();
			leg = new Rectangle2D.Double();
	
			
			
			setAttributes();
		}





		





	
				

}

