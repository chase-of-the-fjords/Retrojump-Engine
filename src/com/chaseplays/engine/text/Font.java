package com.chaseplays.engine.text;

import com.chaseplays.engine.screen.Sprite;

public class Font {
	
	public Figure[] figures = new Figure[94];
	
	public int space, gap, size;
	
	public Font (String path, int space, int gap, int size) {
		
		this.space = space;
		this.gap = gap;
		this.size = size;
		
	}
	
	public Figure getFigure (char c) {
		
		if (c == ' ') return new Figure(new Sprite(0xFFFF00FF, space, 1), ' ');
		if (c == '\n') return new Figure(new Sprite(0xFFFF00FF, space, 1), '\n');
		
		for (int f = 0; f < figures.length; f++) {
			
			if (figures[f].c == c) return new Figure(figures[f]);
			
		}
		
		return null;
		
	}
	
}
