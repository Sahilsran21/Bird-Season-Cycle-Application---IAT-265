package decorator;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;

public class BirdSittingChickDecorator extends NestDecorator {


	
//Fields		
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
	
	private Ellipse2D.Double head;
	private Ellipse2D.Double eye;
	private QuadCurve2D.Double headStripe;
	private QuadCurve2D.Double beak;	
	
		
		
		
		
//Methods	
	private void setAttributes() {
	head.setFrame(-7.5, -30, 15, 15);
	headStripe.setCurve(-1.5, -29, -1.5, -20, -5, -17);
	eye.setFrame(-5, -29, 3.8, 3.8);
	beak.setCurve(-2, -30, 0, -50, 2, -30);
			
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
		
		

	@Override
	public void drawNest(Graphics2D g2) {
			
		//Draw the nest
		super.drawNest(g2);
					
		//Draw the fourth bird sitting chick decorator
		AffineTransform transform = g2.getTransform();
		
		g2.translate(pos.x, pos.y);  
		g2.rotate(angle - 300);
		g2.scale(scale,scale);
					
		g2.translate(278, -562);
											
		//Draw Body
		g2.rotate(Math.toRadians(-55));
		g2.setColor(new Color(128,191,255));
		g2.fill(satBody);
					
		g2.setColor(new Color(0, 51, 102));
		g2.setStroke(new BasicStroke(2));
		g2.draw(satBody);
		g2.rotate(Math.toRadians(55));
					
					
		//Draw Feathers
		g2.rotate(Math.toRadians(130));
		g2.setColor(new Color(0, 51, 102));
		g2.setStroke(new BasicStroke(3));
		g2.draw(satFeather1);
		g2.setColor(new Color(128,191,255));
		g2.fill(satFeather1);
		g2.rotate(Math.toRadians(-130));
				
		g2.rotate(Math.toRadians(125));
		g2.setColor(new Color(0, 51, 102));
		g2.draw(satFeather2);
		g2.setColor(new Color(128,191,255));
		g2.fill(satFeather2);
		g2.rotate(Math.toRadians(-125));
					
		g2.rotate(Math.toRadians(120));
		g2.setColor(new Color(0, 51, 102));
		g2.draw(satFeather3);
		g2.setColor(new Color(128,191,255));
		g2.fill(satFeather3);
		g2.rotate(Math.toRadians(-120));

		
		//Draw Tail Feathers
		g2.rotate(Math.toRadians(150));
		g2.setColor(new Color(0, 51, 102));
		g2.draw(satTailFeather1);
		g2.setColor(new Color(128,191,255));
		g2.fill(satTailFeather1);
		g2.rotate(Math.toRadians(-150));
					
		g2.rotate(Math.toRadians(140));
		g2.setColor(new Color(0, 51, 102));
		g2.draw(satTailFeather2);
		g2.setColor(new Color(128,191,255));
		g2.fill(satTailFeather2);
		g2.rotate(Math.toRadians(-140));
					
		g2.rotate(Math.toRadians(130));
		g2.setColor(new Color(0, 51, 102));
		g2.draw(satTailFeather3);
		g2.setColor(new Color(128,191,255));
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
		g2.setColor(new Color(128,191,255));
		g2.fill(head);
					
		g2.setColor(new Color(0, 51, 102));
		g2.setStroke(new BasicStroke(1));
		g2.draw(headStripe);			
					
		g2.setStroke(new BasicStroke(2));
		g2.setColor(new Color(0));
		g2.draw(beak);
		g2.setColor(new Color(50,50,50));
		g2.fill(beak);
									
		g2.setColor(new Color(0, 51, 102));
		g2.setStroke(new BasicStroke(2));
		g2.draw(head);

		g2.setColor(new Color(22,22,22));
		g2.fill(eye);
				
		g2.setTransform(transform);			
	}
			
			
		
				
			
//Constructor
	public BirdSittingChickDecorator(NestInterface NestDecorator) {
		//calls NestDecorator constructors which keeps parentDecorator
		super(NestDecorator,nestPosX,nestPosY,nestAngle,nestScale);
				
		head = new Ellipse2D.Double();
		eye = new Ellipse2D.Double();
		headStripe = new QuadCurve2D.Double();
		beak = new QuadCurve2D.Double();
		
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
				
		setAttributes();
	}	
}
