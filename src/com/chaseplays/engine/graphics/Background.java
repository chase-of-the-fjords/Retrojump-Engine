package com.chaseplays.engine.graphics;

import java.util.ArrayList;

import com.chaseplays.engine.Engine;
import com.chaseplays.engine.screen.Sprite;

public class Background {
	
	public ArrayList<BackgroundComponent> backgrounds = new ArrayList<BackgroundComponent>();
	
	public int largestBackground = 0;
	
	public void addLayer (String dir, int pixelDistance) {
		
		Sprite sprite = new Sprite(dir);
		
		backgrounds.add(new BackgroundComponent(sprite, pixelDistance));
		
		if (largestBackground != 0) largestBackground = LCM(sprite.width * pixelDistance, largestBackground);
		else largestBackground = sprite.width * pixelDistance;
		
	}
	
	public void render (Engine e) {
		
		for (int back = 0; back < backgrounds.size(); back++) {
			
			for (int instance = 0; instance <= Math.ceil((double) e.screen.width / (double) backgrounds.get(back).sprite.width); instance++) {
				if (backgrounds.get(back).pixelDistance != 0) e.screen.on.render(((e.screen.cam.x / backgrounds.get(back).pixelDistance) % backgrounds.get(back).sprite.width) - backgrounds.get(back).sprite.width + (instance * backgrounds.get(back).sprite.width), 0, backgrounds.get(back).sprite);
				else e.screen.on.render(((backgrounds.get(back).pixelDistance) % backgrounds.get(back).sprite.width) - backgrounds.get(back).sprite.width + (instance * backgrounds.get(back).sprite.width), 0, backgrounds.get(back).sprite);
			}
			
		}
		
		// Screen Width: 100
		// Sprite Width: 10 (11 Needed)
		
	}
	
	public int GCF(int a, int b) {
		
		if (b == 0) return a;
		else return (GCF (b, a % b));
		
	}
	
	public int LCM(int a, int b) {
		
	    return a * (b / GCF(a, b));
	    
	}
	
}
