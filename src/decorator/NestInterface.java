package decorator;
import java.awt.Graphics2D;

import tree.Nest;

public interface NestInterface {

	public Nest getBaseNest(); 
	public void drawNest(Graphics2D g2);
	
}
