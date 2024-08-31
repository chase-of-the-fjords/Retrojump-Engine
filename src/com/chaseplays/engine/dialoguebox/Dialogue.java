package com.chaseplays.engine.dialoguebox;

import com.chaseplays.engine.text.Text;

public class Dialogue {
	
	public Text text = new Text();
	
	public boolean doNext;
	
	public Dialogue next;
	
	public boolean buttons;
	
	public Dialogue (Text text) {
		
		doNext = false;
		
		this.text = text;
		
	}
	
	public void setNextText (Text text) {
		
		doNext = true;
		
		next = new Dialogue(text);
		
	}
	
}
