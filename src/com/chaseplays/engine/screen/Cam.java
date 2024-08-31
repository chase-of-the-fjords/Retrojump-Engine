package com.chaseplays.engine.screen;

import com.chaseplays.engine.Engine;
import com.chaseplays.engine.Game;

public class Cam {
	
	public int x = 0, y = 0;
	
	public int screenX = 0, screenY = 0;
	
	public int width, height;
	
	public int dX, dY;
	
	public int oX, oY;
	
	public int mX, mY;
	
	public boolean panning = false;
	
	public boolean dragging = false;
	
	public Cam (int width, int height) {
		
		this.width = width;
		this.height = height;
		
	}
	
	public void update (Engine e) {
		
		if (x == dX && y == dY) {
			
			panning = false;
			
		} else if (panning) {
			
			if (((x + dX) / 2) != x) {
				
				x = ((x + dX) / 2);
				oX = ((oX + dX) / 2);
				
			}
			else if (x == dX);
			else if (x > dX) {
				
				x = x - 1;
				oX = oX - 1;
				
			}
			else if (x < dX) {
				
				x = x + 1;
				oX = oX + 1;
				
			}
			
			if (((y + dY) / 2) != y) {
				
				y = ((y + dY) / 2);
				oY = ((oY + dY) / 2);
				
			}
			else if (y == dY);
			else if (y > dY) {
				
				y = y - 1;
				oY = oY - 1;
				
			}
			else if (y < dY) {
				
				y = y + 1;
				oY = oY + 1;
				
			}
			
		}
		
		if (dragging) {
			
			x = (oX + (mX - (e.mouse.x / e.scale)));
			y = (oY + (mY - (e.mouse.y / e.scale)));
			
		}
		
	}
	
	public void move (int x, int y) {
		
		this.x += x;
		this.y += y;
		
	}
	
	public void pan (int x, int y) {
		
		panning = true;
		
		dX = x;
		dY = y;
		
	}
	
	public void centerPan(int x, int y) {
		
		panning = true;
		
		dX = x - (width/2);
		dY = y - (height/2);
		
	}
	
	public void panTowards(int x, int y) {
		
		panning = true;
		
		dX = dX + x;
		dY = dY + y;
		
	}
	
	public void panToMouse(Game g) {
		
		centerPan(x + (g.mouse.x / g.scale), y + (g.mouse.y / g.scale));
		
	}
	
	public void dragWithMouse(Game g) {
		
		if (!dragging && g.mouse.left.pressed) {
			
			oY = y;
			oX = x;
			
			mX = (g.mouse.x / g.scale);
			mY = (g.mouse.y / g.scale);
			
			dragging = true;
			
		} else if (!g.mouse.left.pressed) {
			
			dragging = false;
			
		} else {
			
			dragging = true;
			
		}
		
	}
	
}