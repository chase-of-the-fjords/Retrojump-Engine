package com.chaseplays.engine.text;

import java.util.ArrayList;

import com.chaseplays.engine.Engine;

public class Text {
	
	public int x, y;
	
	public ArrayList<Figure> text = new ArrayList<Figure>();
	
	public String direction = "right";
	
	public Text (int x, int y, String text, Font font) {
		
		this.x = x;
		this.y = y;
		
		for (int t = 0; t < text.length(); t++) {
			
			Figure figure = font.getFigure(text.charAt(t));
			
			figure.font = font;
			
			this.text.add(figure);
			
		}
		
	}
	
	public Text () {
		
	}
	
	public Text (int x, int y, String text, Font font, int color) {
		
		this.x = x;
		this.y = y;
		
		for (int t = 0; t < text.length(); t++) {
			
			Figure figure = font.getFigure(text.charAt(t));
			
			figure.font = font;
			
			figure.color = color;
			
			this.text.add(figure);
			
		}
		
	}
	
	public Text (int x, int y, Font font, Object... objects) {
		
		this.x = x;
		this.y = y;
		
		boolean bold = false;
		boolean italics = false;
		boolean sine = false;
		boolean shake = false;
		
		int color = 0xFFFF0000;
		
		for (Object o : objects) {
			
			if (o instanceof rTyping) {
				
				if (o.equals(rTyping.BOLD)) bold = true;
				if (o.equals(rTyping.NO_BOLD)) bold = false;
				if (o.equals(rTyping.ITALICS)) italics = true;
				if (o.equals(rTyping.NO_ITALICS)) italics = false;
				if (o.equals(rTyping.SINE)) sine = true;
				if (o.equals(rTyping.NO_SINE)) sine = false;
				if (o.equals(rTyping.SHAKE)) shake = true;
				if (o.equals(rTyping.NO_SHAKE)) shake = false;
				
			} else if (o instanceof rColor) {
				
				color = ((rColor) o).color;
				
			} else if (o instanceof String) {
				
				for (int t = 0; t < ((String) o).length(); t++) {
					
					Figure textFigure = font.getFigure(((String) o).charAt(t));
					
					textFigure.font = font;
					
					if (bold) textFigure.setAction(rTyping.BOLD.getAction());
					if (italics) textFigure.setAction(rTyping.ITALICS.getAction());
					if (sine) textFigure.setAction(rTyping.SINE.getAction());
					if (shake) textFigure.setAction(rTyping.SHAKE.getAction());
					
					textFigure.color = color;
					
					this.text.add(textFigure);
					
				}
				
			}
			
		}
		
	}
	
	public void addText (String text, Font font) {
		
		for (int t = 0; t < text.length(); t++) {
			
			Figure figure = font.getFigure(text.charAt(t));
			
			figure.font = font;
			
			figure.color = 0xFF000000;
			
			this.text.add(figure);
			
		}
		
	}
	
	public void setText (String text, Font font) {
		
		this.text.clear();
		
		this.addText(text, font);
		
	}
	
	public void addText (String text, Font font, int color) {
		
		for (int t = 0; t < text.length(); t++) {
			
			Figure figure = font.getFigure(text.charAt(t));
			
			figure.font = font;
			
			figure.color = color;
			
			this.text.add(figure);
			
		}
		
	}
	
	public void setText (String text, Font font, int color) {
		
		this.text.clear();
		
		this.addText(text, font, color);
		
	}
	
	public void update (Engine e) {
		
		for (int t = 0; t < text.size(); t++) text.get(t).update();
		
	}
	
	public void render (Engine e) {
		
		e.screen.on.renderText(this);
		
	}
	
	public int getLength (int line) {
		
		int length = 0;
		
		int tLine = 0;
		
		for (int t = 0; t < text.size(); t++) {
			
			if (text.get(t).c == '\n') {
				
				tLine++;
				
			} else if (tLine == line)  {
				
				Figure figure = this.text.get(t);
				
				if (figure.c == ' ') {
					
					length += this.text.get(t).font.space;
					
				} else  {
					
					length += figure.width;
					
					if (t + 1 < this.text.size()) if (this.text.get(t + 1).c != '\n' || this.text.get(t + 1).c != ' ') length += figure.font.gap;
					
				}
				
			}
			
		}
		
		return length;
		
	}
	
	public void setDirection (String direction) {
		
		this.direction = direction;
		
	}
	
	public void color (int color) {
		
		for (int t = 0; t < text.size(); t++) {
			
			text.get(t).color = color;
			
		}
		
	}
	
	public void color (int start, int end, int color) {
		
		for (int t = start; t < end; t++) {
			
			text.get(t).color = color;
			
		}
		
	}
	
	public void clearColor () {
		
		for (int t = 0; t < text.size(); t++) {
			
			text.get(t).color = -1;
			
		}
		
	}
	
	public void setAction (TextAction action) {
		
		for (int t = 0; t < text.size(); t++) {
			
			text.get(t).actions.add(action);
			
		}
		
	}
	
	public void setAction (int start, int end, TextAction action) {
		
		for (int t = start; t < end; t++) {
			
			text.get(t).actions.add(action);
			
		}
		
	}
	
	public void clearAction () {
		
		for (int t = 0; t < text.size(); t++) {
			
			text.get(t).actions.clear();
			
		}
		
	}
	
	public Text substring (int start, int end) {
		
		Text subtext = new Text();
		
		for (int value = start; value <= end; value++) {
			
			subtext.text.add(this.text.get(value));
			subtext.text.get(value - start).actions = this.text.get(value).actions;
			subtext.text.get(value - start).color = this.text.get(value).color;
			
		}
		
		subtext.x = this.x;
		subtext.y = this.y;
		
		return subtext;
		
	}

	
}
