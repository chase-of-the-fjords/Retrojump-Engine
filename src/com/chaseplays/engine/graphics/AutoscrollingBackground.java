package com.chaseplays.engine.graphics;

import com.chaseplays.engine.Engine;
import com.chaseplays.engine.action.Action;

public class AutoscrollingBackground extends Background {
	
	public int speed = 1;
	
	public Action scroll = new Action(1, 0);
	
	public int position;
	
	public AutoscrollingBackground (int speed) {
		
		this.speed = speed;
		
		scroll = new Action(speed, 0);
		
		scroll.start();
		
	}
	
	public void update (Engine e) {
		
		while (scroll.able()) {
			
			position++;
			
			scroll.gather();
			
		}
		
		if (position >= largestBackground) position %= largestBackground;
		
	}
	
	public void render (Engine e) {
		
		for (int back = 0; back < backgrounds.size(); back++) {
			
			for (int instance = 0; instance <= Math.ceil((double) e.screen.width / (double) backgrounds.get(back).sprite.width); instance++) {
				if (backgrounds.get(back).pixelDistance != 0) e.screen.on.render(((position / backgrounds.get(back).pixelDistance) % backgrounds.get(back).sprite.width) - backgrounds.get(back).sprite.width + (instance * backgrounds.get(back).sprite.width), 0, backgrounds.get(back).sprite);
				else e.screen.on.render(((backgrounds.get(back).pixelDistance) % backgrounds.get(back).sprite.width) - backgrounds.get(back).sprite.width + (instance * backgrounds.get(back).sprite.width), 0, backgrounds.get(back).sprite);
			}
			
		}
		
		// Screen Width: 100
		// Sprite Width: 10 (11 Needed)
		
	}
	
}
