package com.chaseplays.engine.screen;

public class Screen {
	
	public int[] pixels;
	
	public int width, height, scale;
	
	public int x, y;
	
	public Cam cam;
	
	public Renderer on = new Renderer("on", this);
	public Renderer in = new Renderer("in", this);
	
	public Screen (int width, int height, Cam cam) {
		
		this.width = width;
		this.height = height;
		this.cam = cam;
		
		this.pixels = new int[width * height];
		
	}
	
	public void clear () {
		
		for (int pixel = 0; pixel < pixels.length; pixel++) pixels[pixel] = 0;
		
	}
	
	public void color (int color) {
		
		for (int pixel = 0; pixel < pixels.length; pixel++) pixels[pixel] = color;
		
	}
		
}
