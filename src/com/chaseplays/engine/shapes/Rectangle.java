package com.chaseplays.engine.shapes;

import com.chaseplays.engine.Engine;
import com.chaseplays.engine.screen.Sprite;

public class Rectangle {
	
	public int x1, y1, x2, y2;
	
	public int fillColor = 0xFFFFFFFF, outlineColor = 0xFFFFFFFF;
	
	public boolean shaded = false;
	
	public Rectangle (int x1, int y1, int x2, int y2) {
		
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		
	}
	
	public Rectangle (int x1, int y1, int x2, int y2, int color) {

		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		
		this.fillColor = color;
		this.outlineColor = color;
		
	}
	
	public void color (int color) {
		
		this.fillColor = color;
		this.outlineColor = color;
		
	}
	
	public void shade (boolean shaded) {
		
		this.shaded = shaded;
		
	}
	
	public void outlineColor (int color) {
		
		this.outlineColor = color;
		
	}
	
	public void fillColor (int color) {
		
		this.fillColor = color;
		
	}
	
	public void render (Engine e) {
		
		for (int x = 0; x < Math.abs(x2 - x1); x++) {
			
			if (x2 > x1) {
				
				if (y1 >= y2) for (int y = 0; y > y2 - y1; y--) {
					
					if (x == 0 || x == Math.abs(x2 - x1) - 1 || y == 0 || y == y2 - y1 + 1) e.screen.on.render(x1 + x, y1 + y, new Sprite(outlineColor, 1, 1));
					else if (shaded) e.screen.on.render(x1 + x, y1 + y, new Sprite(fillColor, 1, 1));
					
				}
				else for (int y = 0; y < y2 - y1; y++) {
					
					if (x == 0 || x == Math.abs(x2 - x1) - 1|| y == 0 || y == y2 - y1 - 1) e.screen.on.render(x1 + x, y1 + y, new Sprite(outlineColor, 1, 1));
					else if (shaded) e.screen.on.render(x1 + x, y1 + y, new Sprite(fillColor, 1, 1));
					
				}
				
			} else {
				
				if (y1 >= y2) for (int y = 0; y > y2 - y1; y--) {
					
					if (x == 0 || x == Math.abs(x2 - x1) - 1 || y == 0 || y == y2 - y1 + 1) e.screen.on.render(x1 - x, y1 + y, new Sprite(outlineColor, 1, 1));
					else if (shaded) e.screen.on.render(x1 - x, y1 + y, new Sprite(fillColor, 1, 1));
					
				}
				else for (int y = 0; y < y2 - y1; y++) {
					
					if (x == 0 || x == Math.abs(x2 - x1) - 1 || y == 0 || y == y2 - y1 - 1) e.screen.on.render(x1 - x, y1 + y, new Sprite(outlineColor, 1, 1));
					else if (shaded) e.screen.on.render(x1 - x, y1 + y, new Sprite(fillColor, 1, 1));
				
				}
				
			}
			
		}
		
	}
	
}
