package com.chaseplays.engine.graphics;

import com.chaseplays.engine.screen.Sprite;

public class Frame {
	
	public Sprite sprite;
	public int duration;
	
	public Frame (Sprite sprite, int duration) {
		
		this.sprite = sprite;
		this.duration = duration;
		
	}
	
	public Frame (String sprite, int duration) {
		
		this.sprite = new Sprite(sprite);
		this.duration = duration;
		
	}
	
}
