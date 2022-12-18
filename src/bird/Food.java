package bird;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.QuadCurve2D;
import java.awt.*;
import java.awt.geom.*;
import processing.core.*;

public class Food {

	//Fields
		private Ellipse2D.Double head;
		private Ellipse2D.Double bodyBall1;
		private Ellipse2D.Double bodyBall2;
		private Ellipse2D.Double bodyBall3;
		private Ellipse2D.Double bodyBall4;
		
		private Ellipse2D.Double bodyDetail1;
		private Ellipse2D.Double bodyDetail2;
		private Ellipse2D.Double bodyDetail3;
		private Ellipse2D.Double bodyDetail4;
		
		private QuadCurve2D.Double bodyLineDetail1;
		private QuadCurve2D.Double bodyLineDetail2;
		private QuadCurve2D.Double Antenna1;
		private QuadCurve2D.Double Antenna2;	
		

		public PVector pos;
		private double angle;
		public double scale;
		
		protected boolean alive;
		protected boolean selected;
		
		
		//Estimates of Caterpillar's width and height for hit detection ((Changed from final int to int for detect collision))
		//public int HEAD_WIDTH = 5;
		//public int HEAD_HEIGHT = 5;
		public int BODY_WIDTH = 10;
		public int BODY_HEIGHT = 15;
		
		

	//Methods
		private void setBodyAttributes() {
		head.setFrame(0, 0, 5, 5);
		bodyBall1.setFrame(0, 4, 5, 5);
		bodyBall2.setFrame(0, 8, 5, 5);
		bodyBall3.setFrame(0, 12, 5, 5);
		bodyBall4.setFrame(0, 16, 5, 5);
		
		bodyDetail1.setFrame(0, 4, 5, 3);
		bodyDetail2.setFrame(0, 8, 5, 3);
		bodyDetail3.setFrame(0, 12, 5, 3);
		bodyDetail4.setFrame(0, 16, 5, 3);

		bodyLineDetail1.setCurve(1.5,2,1.5,10,1.5,19);
		bodyLineDetail2.setCurve(3.3,2,3.3,10,3.3,19);
		Antenna1.setCurve(1.5,2,1,0,-1,-1);
		Antenna2.setCurve(3.3,2,3.5,0,5.7,-1);
		}
		
		
		
		
		public void draw(Graphics2D g2) {
		
		//Set up initial location for Blue Jay and rotate the drawing space before drawing
		AffineTransform transform = g2.getTransform();
		g2.translate(pos.x, pos.y);  
		g2.rotate(angle);
		g2.scale(scale,scale);	
		
		if (alive) 
		{	
		g2.setColor(new Color(100,100,100));
		g2.fill(head);
		g2.fill(bodyBall1);
		g2.setColor(new Color(255, 163, 26));
		g2.fill(bodyDetail1);
		
		g2.setColor(new Color(100,100,100));
		g2.fill(bodyBall2);
		g2.setColor(new Color(255, 163, 26));
		g2.fill(bodyDetail2);
		
		g2.setColor(new Color(100,100,100));
		g2.fill(bodyBall3);
		g2.setColor(new Color(255, 163, 26));
		g2.fill(bodyDetail3);
		
		g2.setColor(new Color(100,100,100));
		g2.fill(bodyBall4);
		g2.setColor(new Color(255, 163, 26));
		g2.fill(bodyDetail4);
		
		
		g2.setColor(new Color(50,50,50,200));
		g2.setStroke(new BasicStroke(1));
		g2.draw(bodyLineDetail1);
		g2.draw(bodyLineDetail2);
		
		g2.setColor(new Color(50,50,50));
		g2.draw(Antenna1);
		g2.draw(Antenna2);
		}
		
		g2.setTransform(transform);	
		}
		
		
		
		//Detect collision between the caterpillar and the Blue Jay's head
		public boolean detectCollision(BlueJay blueJay){
				boolean bump = false;
				if (alive) {
					if (Math.abs((pos.x) - blueJay.pos.x) < ((BODY_WIDTH / 2 + (BODY_WIDTH/2) - 2) * scale + 
										(blueJay.HEAD_WIDTH / 2 + (BODY_WIDTH/2) / 2) * blueJay.scale)
								&& Math.abs((pos.y + 10) - blueJay.pos.y) < (BODY_HEIGHT / 2 * scale + 
										blueJay.HEAD_HEIGHT / 2 * blueJay.scale)) {
						bump = true;
					}
				}
				return bump;
			}
		
		
		
		
		
		
		public void setFoodColor(Color green) {
			// TODO Auto-generated method stub
			
		}


		public int getFoodSize() {
			
			return (int) scale;
		}



		public PVector getFoodPos() {
			
			return pos;
		}
		

		public void setPos(int x, int y) {
			pos = new PVector(x, y);		
		}

		
		

		
		
		
	//Constructor
		public Food(double x, double y, double a, double s)
		{
			
			//Instantiate Caterpillar's attributes
			pos = new PVector((float) x, (float) y);
			angle = a;
			scale = s;
			alive = true;	
			
			
			//Instantiate Body Features
			head = new Ellipse2D.Double();
			bodyBall1 = new Ellipse2D.Double();
			bodyBall2 = new Ellipse2D.Double();
			bodyBall3 = new Ellipse2D.Double();
			bodyBall4 = new Ellipse2D.Double();
			
			bodyDetail1 = new Ellipse2D.Double();
			bodyDetail2 = new Ellipse2D.Double();
			bodyDetail3 = new Ellipse2D.Double();
			bodyDetail4 = new Ellipse2D.Double();
			
			bodyLineDetail1 = new QuadCurve2D.Double();
			bodyLineDetail2 = new QuadCurve2D.Double();
			Antenna1 = new QuadCurve2D.Double();
			Antenna2 = new QuadCurve2D.Double();
		
			
			
			setBodyAttributes();
		}
			
	
}
