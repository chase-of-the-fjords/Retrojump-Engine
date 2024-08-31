package com.chaseplays.engine;

import com.chaseplays.engine.Game;
import com.chaseplays.engine.action.Action;
import com.chaseplays.engine.shapes.Circle;

public class Default extends Game {
	
	private static final long serialVersionUID = 1L;

	public static Default game = new Default();
	
	public static Circle circle = new Circle(100, 100, 50);
	
	public static Action action = new Action(5, 0);
	
	public static void main (String[] args) {
		
		game.setDimensions(200, 200, 3);
		
		game.start();
		
	}
	
	public void setupGame () {
		
		action.start();
		
		circle.shade(true);
		circle.outlineColor(0xFFFFFFFF);
		circle.fillColor(0xFF888888);
		
		game.setFullscreen();
		
	}
	
	public void update () {
		
		if (action.able()) {
			
			action.gather();
			
			if (key.down.pressed) circle.r -= 0.1;
			if (key.up.pressed) circle.r += 0.1;
			
		}
		
	}
	
	public void render () {
		
		circle.render(this);
		
	}
	
}
