package tree;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import bird.Util;

import java.awt.BasicStroke;

public class Branch{
	
	
//Fields
	public static final double angleLeft = -0.45;
	public static final double angleRight = 0.45;
	public static final double centerCoef = 0.8;
	public static final double sideCoef = 0.6;
	
		
	private double length;
	private double width;
	private double angle;
	private int depth;
	
	
	private Branch left = null;
	private Branch center = null;
	private Branch right = null;
	
	private Rectangle2D.Double branch;
	//private Ellipse2D.Double developingLeaf;
	//private Ellipse2D.Double leaf;
	//private Ellipse2D.Double fallLeaf;
	
	
	
	
	
//Methods
	public void drawBranch(Graphics2D g2) {
		AffineTransform tr = g2.getTransform();
		g2.rotate(angle);

		g2.setColor(Color.black);
		g2.fill(branch);

		g2.translate(0, -length);
		if (left != null) left.drawBranch(g2);
		if (right != null) right.drawBranch(g2);
		if (center != null) center.drawBranch(g2);	
		g2.setTransform(tr);
	}
	
	
	
	//Spring
	public void addDevelopingLeaf(Graphics2D g2, double absoluteAngle) {
		   AffineTransform tr = g2.getTransform();
		   g2.rotate(angle);

		   if (depth == 0) {
		      absoluteAngle += angle;
		      if (Math.abs(absoluteAngle) > 0.25) {
		         g2.setColor(new Color(115, 230, 0));
		         int offset = (int) -width;
		         if (absoluteAngle > 0)
		            offset *= -1;
		         int leafSize = 8;
		         g2.fillOval(offset - leafSize/2, (int)(-length - leafSize/2), leafSize, leafSize + 4);
		      }
		   }
		   g2.translate(0, -length);
		   if (left != null)
		      left.addDevelopingLeaf(g2, absoluteAngle);
		   if (right != null)
		      right.addDevelopingLeaf(g2, absoluteAngle);
		   if (center != null)
		      center.addDevelopingLeaf(g2, absoluteAngle);
		   g2.setTransform(tr);
		}
	
	
	
	
	//Summer
	public void addLeaf(Graphics2D g2, double absoluteAngle) {
		   AffineTransform tr = g2.getTransform();
		   g2.rotate(angle);

		   if (depth == 0) {
		      absoluteAngle += angle;
		      if (Math.abs(absoluteAngle) > 0.25) {
		         g2.setColor(new Color(153, 255, 51));
		         int offset = (int) -width;
		         if (absoluteAngle > 0)
		            offset *= -1;
		         int leafSize = 8;
		         g2.fillOval(offset - leafSize/2, (int)(-length - leafSize/2), leafSize, leafSize + 4);
		      }
		   }
		   g2.translate(0, -length);
		   if (left != null)
		      left.addLeaf(g2, absoluteAngle);
		   if (right != null)
		      right.addLeaf(g2, absoluteAngle);
		   if (center != null)
		      center.addLeaf(g2, absoluteAngle);
		   g2.setTransform(tr);
		}

	
	
	//Fall
	public void addFallLeaf(Graphics2D g2, double absoluteAngle) {
		   AffineTransform tr = g2.getTransform();
		   g2.rotate(angle);

		   if (depth == 0) {
		      absoluteAngle += angle;
		      if (Math.abs(absoluteAngle) > 0.25) {
		         g2.setColor(new Color(255, 102, 0));
		         int offset = (int) -width;
		         if (absoluteAngle > 0)
		            offset *= -1;
		         int leafSize = 8;
		         g2.fillOval(offset - leafSize/2, (int)(-length - leafSize/2), leafSize, leafSize + 4);
		      }
		   }
		   g2.translate(0, -length);
		   if (left != null)
		      left.addFallLeaf(g2, absoluteAngle);
		   if (right != null)
		      right.addFallLeaf(g2, absoluteAngle);
		   if (center != null)
		      center.addFallLeaf(g2, absoluteAngle);
		   g2.setTransform(tr);
		}
	

	
	
	//Winter
	public void addSnow(Graphics2D g2, double absoluteAngle) {
		AffineTransform tr = g2.getTransform();
		g2.rotate(angle);
		
		absoluteAngle += angle;
		if (Math.abs(absoluteAngle) > 0.5) {
			g2.setColor(new Color(0, 230, 230));
			g2.setStroke(new BasicStroke(5)); 
			int offset = (int) -width/2;
			if (absoluteAngle < 0 ) offset *=-1;
			g2.drawLine(offset,0,offset,(int)-length);
		}
		g2.translate(0, -length);
		if (left != null) left.addSnow(g2, absoluteAngle);
		if (right != null) right.addSnow(g2, absoluteAngle);
		if (center != null) center.addSnow(g2, absoluteAngle);
		g2.setTransform(tr);
		
	}
	
	
	
	
	//Constructor
		public Branch(double len, double wid, double ang, int dep) {
			length = len;
			width = wid;
			angle = ang;
			depth = dep;
			branch = new Rectangle2D.Double(-width/2,-length,width,length);
			//developingLeaf = new Ellipse2D.Double(-width/2,-length,width,length);
			//leaf = new Ellipse2D.Double(-width/2,-length,width,length);
			//fallLeaf = new Ellipse2D.Double(-width/2,-length,width,length);
			
			//For Primary Branches
			if (depth >= 1) {
				if (Util.random(0,1) > 0.03) //if limb is not broken
					//then randomly adjust sub-branch angle
					left = new Branch(length*sideCoef, width*sideCoef, angleLeft+Util.random(-angleLeft*0.1, angleLeft*0.1), depth-1);
				if (Util.random(0,1) > 0.03)
					right = new Branch(length*sideCoef, width*sideCoef, angleRight+Util.random(-angleRight*0.1, angleRight*0.1), depth-1);
				if (Util.random(0,1) > 0.03)
					center = new Branch(length*centerCoef, width*sideCoef, Util.random(-0.2, 0.3), depth-1);
				
			}	
		}

	

}
