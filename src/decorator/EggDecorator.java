package decorator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class EggDecorator extends NestDecorator {


	
//Fields	
	private Ellipse2D.Double egg;
	
	
	
	
	
//Methods	
	private void setAttributes() {
		egg.setFrame(580,325,13,17);
	}
	
	

	@Override
	public void drawNest(Graphics2D g2) {
		
		    //Draw the nest
			super.drawNest(g2);
				
			//Draw the first egg decorator
			AffineTransform transform = g2.getTransform();
		
			g2.translate(pos.x, pos.y);  
			g2.rotate(angle);
			g2.scale(scale,scale);	
	
			g2.setStroke(new BasicStroke(3)); 
	
			g2.setColor(new Color(0,0,0));
			g2.draw(egg);
			g2.setColor(new Color(242, 242, 242));
			g2.fill(egg);
		
			g2.setTransform(transform);		
	}
		
		
	
		
//Constructor
		public EggDecorator(NestInterface NestDecorator) {
			//calls NestDecorator constructors which keeps parentDecorator
			super(NestDecorator,nestPosX,nestPosY,nestAngle,nestScale);
			
			egg = new Ellipse2D.Double();
			
			setAttributes();
		}
		
	
}
