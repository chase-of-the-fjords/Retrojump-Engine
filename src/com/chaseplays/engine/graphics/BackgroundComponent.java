package com.chaseplays.engine.graphics;

import com.chaseplays.engine.screen.Sprite;

public class BackgroundComponent {
	
	public Sprite sprite;
	public int pixelDistance;
	
	public BackgroundComponent (Sprite sprite, int pixelDistance) {
		
		this.sprite = sprite;
		this.pixelDistance = pixelDistance;
		
	}
	
	public BackgroundComponent (String sprite, int pixelDistance) {
		
		this.sprite = new Sprite(sprite);
		this.pixelDistance = pixelDistance;
		
	}
	
}
