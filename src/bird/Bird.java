package bird;



import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Timer;

import processing.core.PVector;

public abstract class Bird implements ActionListener {
	
	//Fields	
		//Declaration for all bird attributes
		protected PVector pos;
		protected PVector vel;
		protected double angle;
		protected double scale = 1.5;
		
		//Estimates of all bird width and height for hit detection
		public final int HEAD_WIDTH = 15;
		public final int HEAD_HEIGHT = 15;
		public final int BODY_WIDTH = 20;
		public final int BODY_HEIGHT = 45;
		
		
		public boolean isMoving = true;
		protected Timer timer;
		protected int waitTime = 1500; //2700
		
		public float maxSpeed;
		private boolean selected;
		
		protected boolean alive;
		
		
		
	//Methods
			
		public abstract void draw(Graphics2D g2);
		
		public abstract void drawSat(Graphics2D g2);
		
		
		
		//Private method for park edge detection
		public void edgeDetection() {
			//Check collision against left or right edge of the park
			
			if (pos.x + (BODY_WIDTH / 2 + HEAD_WIDTH) * scale > (Panel.PARK_X + Panel.PANEL_W )) {
				pos.x = (float) (Panel.PARK_X + Panel.PANEL_W  - (BODY_WIDTH / 2 + HEAD_WIDTH) * scale);
				vel.x *= -1;
				}

			if (pos.x - (BODY_WIDTH / 2 + HEAD_WIDTH) * scale < Panel.PARK_X) {
				pos.x = (float) (Panel.PARK_X +(BODY_WIDTH / 2 + HEAD_WIDTH)* scale);
				vel.x *= -1;
				}
			
			// Collision against bottom or top edge of garden
			if (pos.y + BODY_HEIGHT / 2 * scale > (Panel.PARK_Y + Panel.PANEL_H )) {
				pos.y = (float) (Panel.PARK_Y + Panel.PANEL_H  - BODY_HEIGHT / 2 * scale);
				vel.y *= -1;
				}
					
			if (pos.y - BODY_HEIGHT / 2 * scale < Panel.PARK_Y) {
				pos.y = (float) (Panel.PARK_Y + BODY_HEIGHT / 2 * scale); 
				vel.y *= -1;
				}				
		}
	
		
		
		
		
		//Public method for moving any bird
		public void move() {
				if(!isMoving)return;
				vel.limit(maxSpeed);
				pos.add(vel);
				edgeDetection();	
			}
		
		
		

		//Public method to make blueJay stop and land
		public void stopAndLand()
		{
			isMoving = false;		
			
			if (isMoving == false)
			{
				timer = new Timer(waitTime, this);
				timer.start();
			}
		}
		
		
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{	
			isMoving = true;
			vel.x = (float) Util.random(-5, 5);
			vel.y = (float) Util.random(-5, 5);
			timer.stop();
		}
		
		
		
		
		
		
		public Food findBestFood(ArrayList<Food> food)
		{
		Food bestFood = null;

		if (food.size() > 0) {
			bestFood = food.get(0);
			float bestScore = bestFood.getFoodSize() / PVector.dist(pos, bestFood.getFoodPos());
			for (Food f : food) {
				float currentScore = f.getFoodSize() / PVector.dist(pos, f.pos);
				if (currentScore > bestScore) {
					bestFood = f;
					bestScore = currentScore;
				}
			}
			for (Food f : food) {
				if (f == bestFood) {
					f.setFoodColor(Color.GREEN);
				}
				else {
					f.setFoodColor(new Color(194, 158, 100));
				}
			}
		}
		return bestFood;
		}
			

		
		

		public void attractedBy(Food target)
		{
			float coefficient = .2f;
			PVector direction = PVector.sub(target.pos, pos).normalize();
			PVector acc = PVector.mult(direction, maxSpeed * coefficient);
			vel.add(acc);
		}
		
		
		
		public void setPos(int x, int y) {
			pos = new PVector(x, y);		
		}

		
		
		

		public int getBirdSize() {
			
			return (int) scale;
		}		

		
		public PVector getBirdPos() {
			
			return pos;
		}
		
		
		

		
		
	//Constructor 
		 public Bird(double x, double y, double velX, double velY, double s) {
				
			 	while (maxSpeed == 0)
			 		this.maxSpeed = (float) Util.random(3,5);
			 
				//Instantiate Blue Jay's attributes
				pos = new PVector((float) x, (float) y);
				vel = new PVector((float) velX, (float) velY);
				scale = s;	
				
		
			}
	}
