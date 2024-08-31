package com.chaseplays.engine.dialoguebox;

import java.util.ArrayList;

import com.chaseplays.engine.Engine;
import com.chaseplays.engine.action.Action;
import com.chaseplays.engine.screen.Sprite;
import com.chaseplays.engine.text.Text;

public class DialogueBox {
	
	public int width, height;
	public int bordersize;
	public int x, iconx, y, icony;
	
	public Sprite sprite, icon;
	
	public boolean showIcon = false;
	
	public Dialogue dialogue;
	
	public ArrayList<Text> text = new ArrayList<Text>();
	
	public Action showText = new Action(100, 0);
	
	public int textPosition = 0;
	
	public void setup (Engine e) {
		
		showText.start();
		
		dialogue.text.x = this.x + bordersize + 1;
		dialogue.text.y = this.y + bordersize + 1;
		
		dialogue.text.direction = "center";
		
	}
	
	public void update (Engine e) {
		
		dialogue.text.update(e);
		
		if (showText.able()) {
			
			if (textPosition < dialogue.text.text.size() - 1) textPosition++;
			
			if (textPosition < dialogue.text.text.size() - 1) showText.gather();
			else showText.stop();
			
		}
		
		if (e.key.enter.typed && textPosition == dialogue.text.text.size() - 1) {
			
			if (dialogue.doNext) {
				
				this.dialogue = this.dialogue.next;
				this.textPosition = 0;
				
				dialogue.text.x = this.x + bordersize + 1;
				dialogue.text.y = this.y + bordersize + 1;
				
				showText.start();
				
			}
			
		}
		
	}
	
	public void render (Engine e) {
		
		Text rendertext = dialogue.text.substring(0, textPosition);
		
		e.screen.on.render(x, y, sprite);
		
		e.screen.on.renderText(rendertext);
		
		if (showIcon) e.screen.on.render(x + iconx, y + icony, icon);
		
	}
	
	public void setIcon (int x, int y, Sprite icon) {
		
		this.showIcon = true;
		
		this.iconx = x;
		this.icony = y;
		
		this.icon = icon;
		
	}
	
	public DialogueBox (int width, int height, int bordersize, int x, int y, Sprite sprite, Text... textList) {
		
		this.sprite = sprite;
		this.width = width;
		this.height = height;
		this.bordersize = bordersize;
		
		this.x = x;
		this.y = y;
		
		for (int t = 0; t < textList.length; t++) this.text.add(textList[t]);
		
		dialogue = new Dialogue(textList[0]);
		
		if (textList.length > 1) dialogue.next = new Dialogue(textList[1]);
		
	}
	
}
