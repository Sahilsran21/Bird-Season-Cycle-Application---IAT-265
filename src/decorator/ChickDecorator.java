package decorator;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class ChickDecorator extends NestDecorator {

	
	
	
//Fields	
	private Ellipse2D.Double chickHead;
	private Ellipse2D.Double chickBody;
	private Polygon chickBeak;
	private Ellipse2D.Double chickEye;
			
		
	
			
//Methods		
	private void setAttributes() {

		chickHead.setFrame(580,313,13,13);
		chickBody.setFrame(435,500,15,25);
		chickEye.setFrame(583, 314, 2, 2);
			
		chickBeak.addPoint(579,318);
		chickBeak.addPoint(580,314);
		chickBeak.addPoint(574,314);	
	}
			
		
		
				

	@Override
	public void drawNest(Graphics2D g2) {
				
			//Draw the nest
			super.drawNest(g2);
						
			//Draw the third chick decorator
			AffineTransform transform = g2.getTransform();		
			g2.translate(pos.x, pos.y);  
			g2.rotate(angle);
			g2.scale(scale,scale);	
				
			g2.setStroke(new BasicStroke(3)); 
					
			g2.rotate(Math.toRadians(-20));
			g2.setColor(new Color(0,0,0));
			g2.draw(chickBody);
			g2.setColor(new Color(128,191,255));
			g2.fill(chickBody);
			g2.rotate(Math.toRadians(20));
			
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
		public ChickDecorator(NestInterface NestDecorator) {
			//calls NestDecorator constructors which keeps parentDecorator
			super(NestDecorator,nestPosX,nestPosY,nestAngle,nestScale);
				
			chickHead = new Ellipse2D.Double();
			chickBody = new Ellipse2D.Double();
			chickBeak = new Polygon();
			chickEye = new Ellipse2D.Double();
			
			setAttributes();
		}
				

}


