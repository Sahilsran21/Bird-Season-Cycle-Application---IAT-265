package bird;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import processing.core.PVector;
import tree.*;
import decorator.BirdSittingChickDecorator;
import decorator.BirdSittingEggDecorator;
import decorator.ChickDecorator;
import decorator.ChickFlyingDecorator;
import decorator.EggDecorator;
import decorator.NestDecorator;
import decorator.NestInterface;

public class Panel extends JPanel implements ActionListener {
	
	
//Fields
	
	public ArrayList<Bird> bird;
	public ArrayList<Food> food;
	private GeneratedTree tree1;
	private Season season;
	private Nest nest;
	
	//Objects with decorators
	private NestInterface decorator;
	private NestInterface nestDecorator, eggDecorator, birdSittingEggDecorator, 
						  chickDecorator, birdSittingChickDecorator;
						  //chickFlyingDecorator;
	
	
	
	public final static int PANEL_W = 1200;
	public final static int PANEL_H = 700;


	private double length = 300;
	private double width = 24;
	private int depth = 5;
	
	//Setup Timer and Tracker for Seasons
	private int seasonTimer = 0;
	private int seasonWaitTime = 160; //80
	private int seasonTracker = 1;
	
	//Setup States for SeasonTracker FSM
	private int spring = 1;
	private int summer = 2;
	private int fall = 3;
	private int winter = 4;
	
	
	//Setup Timer and Tracker for Chick Raising Process
	private int chickTimer = 0;
	private int chickWaitTime = 160;  //80
	private int chickTracker = 1;
	
	
	//Setup States for birdTracker FSM
	private int layingEggs = 1;
	private int birdSittingEggs = 2;
	private int chickHatched = 3;
	private int birdFeedingChick = 4;
	private int chickFlyingAround = 5;
	
	
	
	public final static int PARK_X = 20;
	public final static int PARK_Y = 20;
	
	private final static int BLUEJAY_COUNT = 1;
	private Timer BlueJayTimer;
	
	private final static int CATERPILLAR_COUNT = 6;
	private final static int CHICK_COUNT = 1;
	
	
	private int nestPosX = 200;
	private int nestPosY = -60;
	private int nestAngle = 0;
	private double nestScale = 1.2;
	

	
	
//Methods
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		
		
		
			
	//Finite State Machine to keep track of seasons as time passes
		if (seasonTracker == spring) 	//1 - Spring
		{
		season.drawSpring(g2);
		tree1.drawDevelopingLeaves(g2);
		}
		
		
		if (seasonTracker == summer)	//2 - Summer
		{
		season.drawSummer(g2); 	
		tree1.drawLeaves(g2);	
		}
		
		
		if (seasonTracker == fall)		//3 - Fall 
		{
		season.drawFall(g2); 
		tree1.drawFallLeaves(g2);	
		}
		
		
		if (seasonTracker == winter) 	//4 - Winter
		{
		season.drawWinter(g2); 	
		tree1.drawSnow(g2);	
		}
		
		
		
		tree1.drawTree(g2);  
		decorator.drawNest(g2);
		
		
		
		
	//Finite State Machine For Raising Chicks Process
		if (chickTracker == layingEggs)   		 //1 - layingEggs
		{
		decorator = nestDecorator;		
		decorator = eggDecorator;	
		drawBlueJay(g2);
		}
		
		
		if (chickTracker == birdSittingEggs) 	 //2 - birdSittingEggs
		{		
		decorator = eggDecorator;
		decorator = birdSittingEggDecorator;
		}
		
		
		if (chickTracker == chickHatched)   	 //3 - chickHatched
		{		
		decorator = chickDecorator;
		drawBlueJay(g2);
		}
		
		
		if (chickTracker == birdFeedingChick)    //4 - birdFeedingChick
		{			
		decorator = chickDecorator;
		decorator = birdSittingChickDecorator;
		}
		
		
		if (chickTracker == chickFlyingAround)   //5 - chickFlyingAround
		{
		decorator = nestDecorator;
		drawBlueJay(g2);
		drawChick(g2);
		}
	
		
		
		

		
		
//Change the seasons using a counter 
				if (seasonTimer > seasonWaitTime)
				{
				seasonTimer = 0;
				seasonTracker++;
				}
				
				seasonTimer++;
				//System.out.println(seasonTimer);	
			
				
				

//Change the raising chicks stage using a counter
				if (chickTimer > chickWaitTime)
				{
				chickTimer = 0;
				chickTracker++;
				}
				
				chickTimer++;
				//System.out.println(chickTimer);	
				
				
	
				//After Winter, make tracker return back to spring
				if (seasonTracker > 4) 
				{
					seasonTracker = 1;
				}
				
				
				
				//After chick flying stage, make tracker return back to egg stage
				if (chickTracker > 5) 
				{
					chickTracker = 1;
				}					
	}
	
	
	
	
	
	//Put inside it's own methods to be called during specific stages in raising chick process
	public void drawBlueJay(Graphics g)
	{	
	Graphics2D g2 = (Graphics2D) g;
		
	//Draw the blue Jay
		for (int i = 0; i < bird.size(); i++) { 

			if (bird.get(i) instanceof BlueJay) {
				BlueJay birdi = (BlueJay) bird.get(i);

				if (birdi.isMoving == true) {
					birdi.draw(g2);	
				}

				if (birdi.isMoving == false) {
					birdi.drawSat(g2);
				}
						
				
				for (int j = 0; j < food.size(); j++) {
					if (food.get(j) instanceof Food) {
						Food foodk = (Food) food.get(j);

								
						if (foodk.detectCollision(birdi)) // Detect their collision
						{
							birdi.stopAndLand();// Timer to make blue jay stop and wait
							food.remove(j);
						}
						
						if (food.size() < CATERPILLAR_COUNT ) {
							food.add(new Food(Util.random(PARK_X + 20, PANEL_W),
									 Util.random(PARK_Y + 600, PANEL_H - 45),
									 Util.random(-30, 30), 1.3));
						}
						foodk.draw(g2); // Otherwise, the caterpillar lives
					}
				}
			}
		}
	}


	
	
	public void drawChick(Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	for (int j = 0; j < bird.size(); j++) { 

		if (bird.get(j) instanceof Chick) {
			Chick birdj = (Chick) bird.get(j);
				
			if (birdj.isMoving == true) {
				birdj.draw(g2);	
			}	
		}	
	}
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
		for (int i = 0; i < bird.size(); i++) {
			if (bird.get(i) instanceof BlueJay) {
				BlueJay birdi = (BlueJay) bird.get(i);
				birdi.move();
				
				for (int j = 0; j < food.size(); j++) {
					Food foodToChase = birdi.findBestFood(food);
					if (foodToChase != null) {
						birdi.attractedBy(foodToChase);
					}
				}			
			}
		
			else if (bird.get(i) instanceof Chick) {
					Chick birdj = (Chick) bird.get(i);
					birdj.move();
			}
		}
		
		repaint();
	}


	
	
	
		
	
	
//Constructor
	public Panel() {
		this.setBackground(Color.white);
		setPreferredSize(new Dimension(PANEL_W, PANEL_H));
		double scale = 1.5;
		bird = new ArrayList<Bird>();
		food = new ArrayList<Food>();
		BlueJayTimer = new Timer(30, this);
		BlueJayTimer.start();
		
		tree1 = new GeneratedTree(PANEL_W - 20, PANEL_H + 200, length, width, 0, depth);
		season = new Season(0, 0, 1, seasonTracker);
		nest = new Nest(nestPosX,nestPosY,nestScale);
		
		
		//basic decorator must have nest as parameter
		nestDecorator = new NestDecorator((NestInterface) nest,nestPosX,nestPosY,nestAngle,nestScale);
		
		//other decorators take a decorator as a parameter
		eggDecorator = new EggDecorator(nestDecorator);
		birdSittingEggDecorator = new BirdSittingEggDecorator(eggDecorator);
		chickDecorator = new ChickDecorator(nestDecorator);
		birdSittingChickDecorator = new BirdSittingChickDecorator(chickDecorator);
		//chickFlyingDecorator = new ChickFlyingDecorator(nestDecorator);
		
		//we set the basic as a starting decorator object
		decorator = nestDecorator;
		
		
	
		
		
		for (int i = 0; i < BLUEJAY_COUNT; i++) {
			bird.add(new BlueJay(Util.random(20, 1160), Util.random(20, 760),
					Util.random(-5, 5), Util.random(-5, 5), scale));
		}
		
		
		for (int i = 0; i < CATERPILLAR_COUNT; i++) {
			food.add(new Food(Util.random(PARK_X + 20, PANEL_W),
					 Util.random(PARK_Y + 600, PANEL_H - 45),
					 Util.random(-30, 30), 1.3));
		}
		
		
		//Had issues with chick not transforming to proper coordinates, and disappearing at random
		//points on the screen, may have something to do with hit detection.
		for (int i = 0; i < CHICK_COUNT; i++) {
			bird.add(new Chick(Util.random(0,0),Util.random(0,0), //60  //200
					Util.random(1,1), Util.random(0,0), scale));
		}
	
		
	
	}	
	
}
