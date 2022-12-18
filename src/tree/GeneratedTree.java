package tree;


import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class GeneratedTree {
	

	
//Fields
	private Branch tree;
	private int locx, locy;

	public static final int TYPE1 = 1;
	public static final int TYPE2 = 2;
	public static final int TYPE3 = 3;
	public static final int TYPE4 = 4;
	public static final int TYPE5 = 5;

	
	
	
//Methods
	public void drawTree(Graphics2D g2) {
		AffineTransform tr = g2.getTransform();
		g2.translate(locx, locy);
		tree.drawBranch(g2);
		g2.setTransform(tr);
	}

	
	//Spring
	public void drawDevelopingLeaves(Graphics2D g2) {
		AffineTransform tr = g2.getTransform();
		g2.translate(locx, locy);
		((Branch) tree).addDevelopingLeaf(g2, 0);
		g2.setTransform(tr);
	}
	
	
	//Summer
	public void drawLeaves(Graphics2D g2) {
		AffineTransform tr = g2.getTransform();
		g2.translate(locx, locy);
		((Branch) tree).addLeaf(g2, 0);
		g2.setTransform(tr);
	}
	
	
	//Fall
	public void drawFallLeaves(Graphics2D g2) {
		AffineTransform tr = g2.getTransform();
		g2.translate(locx, locy);
		((Branch) tree).addFallLeaf(g2, 0);
		g2.setTransform(tr);
	}
	
	
	//Winter
	public void drawSnow(Graphics2D g2) {
		AffineTransform tr = g2.getTransform();
		g2.translate(locx, locy);
		tree.addSnow(g2, 0);
		g2.setTransform(tr);
	}
	
	
	
	
	

//Constructor
	public GeneratedTree(int x, int y, double len, double wid, double ang, int depth) {
		locx = x;
		locy = y;
		tree = new Branch(len, wid, ang, depth);
	}


}
