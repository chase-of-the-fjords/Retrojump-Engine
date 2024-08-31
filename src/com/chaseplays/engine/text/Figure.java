package com.chaseplays.engine.text;

import java.util.ArrayList;

import com.chaseplays.engine.screen.Sprite;

public class Figure {
	
	public Sprite sprite;
	
	public int width, height;
	
	public char c;
	
	public Font font;
	
	public int color = -1;
	
	public ArrayList<TextAction> actions = new ArrayList<TextAction>();
	
	public static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_-+={[}]|\"\':;?/>.<,\\~`";
	
	public Figure (Sprite sprite, char c) {
		
		this.width = sprite.width;
		this.height = sprite.height;
		
		this.sprite = sprite;
		
		this.c = c;
		
	}
	
	public Figure (String path, int width, int height, char c) {
		
		Sprite sprite = new Sprite(path);
		
		this.height = height;
		this.width = width;
		
		int size = sprite.height / 10;
		
		int x = 0;
		int y = 0;
		
		for (int a = 0; a < chars.length(); a++) {
			
			if (c == chars.charAt(a)) {
				
				x = ((a % 10) * size) * 2;
				y = (a / 10) * size;
				
			}
			
		}
		
		this.sprite = new Sprite(sprite, x, y, height * 2, height);
		
		this.c = c;
		
	}
	
	public Figure (Figure figure) {
		
		this.sprite = figure.sprite;
		
		this.width = figure.width;
		this.height = figure.height;
		
		this.c = figure.c;
		
	}
	
	public void setAction(TextAction action) {
		
		this.actions.add(action);
		
	}
	
	public void update () {
		
		for (int a = 0; a < actions.size(); a++) {
			
			actions.get(a).update();
			
		}
		
	}
	
}
