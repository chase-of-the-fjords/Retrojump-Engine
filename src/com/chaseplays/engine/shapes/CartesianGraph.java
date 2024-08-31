package com.chaseplays.engine.shapes;

import com.chaseplays.engine.Engine;
import com.chaseplays.engine.action.Action;
import com.chaseplays.engine.screen.Sprite;

public class CartesianGraph extends Graph {
	
	public int x, y, gx, gy;
	
	public double t = 0;
	
	public Action xt = new Action(0, 0);
	
	public double increase = 1;
	
	public boolean parametric = false;
	
	public CartesianGraph (int x, int y, int updateEvery, double increase) {
		
		this.x = x;
		this.y = y;
		
		this.increase = increase;
		
		xt = new Action(updateEvery, 0);
		
		xt.start();
		
	}
	
	public int getX () {
		
		return x + gx;
		
	}
	
	public int getY () {
		
		return y + gy;
		
	}
	
	public void update () {
		
		if (xt.able()) {
			
			xt.gather();
			
			if (!parametric) this.gx += increase;
			else if (parametric) this.t += increase;
			
		}
		
	}
	
	public void setParametric (boolean parametric) {
		
		this.parametric = parametric;
		
	}
	
	public void render (Engine e) {
		
		e.screen.on.render(x + gx - 1, y + gy - 1, new Sprite(0xFFFFFFFF, 3, 3));
		
	}
	
}
