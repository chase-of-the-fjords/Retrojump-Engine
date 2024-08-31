package com.chaseplays.engine.shapes;

import com.chaseplays.engine.Engine;
import com.chaseplays.engine.action.Action;
import com.chaseplays.engine.screen.Sprite;

public class PolarGraph extends Graph {
	
	public int x, y;
	
	public double gAngle, gRad;
	
	public double increase;
	
	public Action xt = new Action(0, 0);
	
	public PolarGraph (int x, int y, int updateEvery, double increase) {
		
		this.x = x;
		this.y = y;
		
		this.increase = increase;
		
		xt = new Action(updateEvery, 0);
		
		xt.start();
		
	}
	
	public int getX () {
		
		return x + (int) (gRad * Math.cos(gAngle));
		
	}
	
	public int getY () {
		
		return y + (int) (gRad * Math.sin(gAngle));
		
	}
	
	public void update () {
		
		if (xt.able()) {
			
			xt.gather();
			
			gAngle += increase;
			
		}
		
	}
	
	public void render (Engine e) {
		
		e.screen.on.render(getX() - 1, getY() - 1, new Sprite(0xFFFFFFFF, 3, 3));
		
	}
	
}
