package com.chaseplays.engine.button;

import com.chaseplays.engine.Engine;
import com.chaseplays.engine.screen.Sprite;

public class ClickButton implements Button {
	
	public int x, y;
	
	public boolean active;
	
	public Sprite sprite;
	
	public boolean clicked;
	
	public boolean pressed;
	
	public ClickButton (int x, int y, Sprite sprite) {
		
		this.x = x;
		this.y = y;
		
		this.sprite = sprite;
		
	}
	
	public boolean interacting (Engine e) {
		
		if (!active) return false;
		
		if (e.getMouseX(true) >= this.x && e.getMouseX(true) <= this.x + this.sprite.width) {
			
			if (e.getMouseY(true) >= this.y && e.getMouseY(true) <= this.y + this.sprite.height) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public boolean clicked () {
		
		if (!active) return false;
		
		return clicked;
		
	}
	
	public void update (Engine e) {
		
		if (e.mouse.left.clicked && interacting(e)) {
			
			if (!pressed) clicked = true;
			else clicked = false;
			
			pressed = true;
			
		}
		
		else {
			
			clicked = false;
			pressed = false;
			
		}
		
	}
	
	public void activate () {
		
		active = true;
		
	}
	
	public void deactivate () {
		
		active = false;
		
	}

	public void toggle () {
		
		if (active) active = false;
		else if (!active) active = true;
	
	}
	
	public void render (Engine e) {
		
		if (!active) return;
		
		boolean hover = interacting(e);
		
		if (hover) e.screen.on.render(x, y, sprite.darkened(0.5));
		else e.screen.on.render(x, y, sprite);
		
	}
	
	public int x (Engine e) {
		
		return x;
		
	}
	
	public int y (Engine e) {
		
		return y;
		
	}
	
	public boolean pressed () {
		
		if (!active) return false;
		
		return pressed;
		
	}
	
}
