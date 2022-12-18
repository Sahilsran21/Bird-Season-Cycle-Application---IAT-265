package tree;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import processing.core.PVector;

public class Season {

	
	
//Fields
	private PVector pos;
	private double angle;
	private double scale = 1.5;
	private int seasonTracker = 1;
	
	private Rectangle2D.Double springSky;
	private Rectangle2D.Double springGround;
	
	private Rectangle2D.Double summerSky;
	private Rectangle2D.Double summerGround;
	
	private Rectangle2D.Double fallSky;
	private Rectangle2D.Double fallGround;
	
	private Rectangle2D.Double winterSky;
	private Rectangle2D.Double winterGround;
	
	
	
	
	
//Methods
	private void setAttributes() {
		springSky.setFrame(0, 0, 1200, 600);
		springGround.setFrame(0, 600, 1200, 100);
		
		summerSky.setFrame(0, 0, 1200, 600);
		summerGround.setFrame(0, 600, 1200, 100);
		
		fallSky.setFrame(0, 0, 1200, 600);
		fallGround.setFrame(0, 600, 1200, 100);
		
		winterSky.setFrame(0, 0, 1200, 600);
		winterGround.setFrame(0, 600, 1200, 100);
	}
	
	
	
	
	
	
	public void drawSpring(Graphics2D g2)
	{
		AffineTransform tr = g2.getTransform();
		g2.rotate(angle);
		g2.translate(pos.x, pos.y);	
		g2.scale(scale,scale);	
		
		g2.setColor(new Color(102, 217, 255));
		g2.fill(springSky);
		
		g2.setColor(new Color(119, 255, 51));
		g2.fill(springGround);

		g2.setTransform(tr);
	}





	public void drawSummer(Graphics2D g2)
	{
		AffineTransform tr = g2.getTransform();
		g2.rotate(angle);
		g2.translate(pos.x, pos.y);	
		g2.scale(scale,scale);	
		
		g2.setColor(new Color(51, 214, 255));
		g2.fill(summerSky);
		
		g2.setColor(new Color(204, 255, 51));
		g2.fill(summerGround);

		g2.setTransform(tr);
	}




	public void drawFall(Graphics2D g2)
	{
		AffineTransform tr = g2.getTransform();
		g2.rotate(angle);
		g2.translate(pos.x, pos.y);	
		g2.scale(scale,scale);	
		
		g2.setColor(new Color(0, 153, 255));
		g2.fill(fallSky);
		
		g2.setColor(new Color(255, 153, 51));
		g2.fill(fallGround);

		g2.setTransform(tr);
	}	

	
	


	public void drawWinter(Graphics2D g2)
	{
		AffineTransform tr = g2.getTransform();
		g2.rotate(angle);
		g2.translate(pos.x, pos.y);	
		g2.scale(scale,scale);	
		
		g2.setColor(new Color(230, 250, 255));
		g2.fill(winterSky);
		
		g2.setColor(new Color(179, 240, 255));
		g2.fill(winterGround);

		g2.setTransform(tr);	
	}


	
	




//Constructor
	public Season(double x, double y, double s, int st)
	{
	
		pos = new PVector((float) x, (float) y);
		scale = s;	
		seasonTracker = st;
		
		
		springSky = new Rectangle2D.Double();
		springGround = new Rectangle2D.Double();        
		
		summerSky = new Rectangle2D.Double();
		summerGround = new Rectangle2D.Double();

		fallSky = new Rectangle2D.Double();
		fallGround = new Rectangle2D.Double();        
		
		winterSky = new Rectangle2D.Double();
		winterGround = new Rectangle2D.Double();


		setAttributes();
	}

}
	
