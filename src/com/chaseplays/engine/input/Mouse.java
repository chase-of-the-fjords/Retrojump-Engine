package com.chaseplays.engine.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener {
	
	public int x, y;
	
	public MouseButton left = new MouseButton(), middle = new MouseButton(), right = new MouseButton();
	
	public MouseButton[] clicks = new MouseButton[500];
	
	public void setup () {
		
		for (int x = 0; x < clicks.length; x++) clicks[x] = new MouseButton();
		
	}
	
	public void update() {
		
		this.left.update();
		this.middle.update();
		this.right.update();
		
		this.left = clicks[MouseEvent.BUTTON1];
		this.middle = clicks[MouseEvent.BUTTON2];
		this.right = clicks[MouseEvent.BUTTON3];
		
	}
	
	public void mouseDragged(MouseEvent event) {
		
		x = event.getX();
		y = event.getY();
		
	}
	
	public void mouseMoved(MouseEvent event) {
		
		x = event.getX();
		y = event.getY();
		
	}
	
	public void mouseClicked(MouseEvent event) {
		
	}
	
	public void mouseEntered(MouseEvent event) {
		
	}
	
	public void mouseExited(MouseEvent event) {
		
	}
	
	public void mousePressed(MouseEvent event) {
		
		clicks[event.getButton()].pressed = true;
		clicks[event.getButton()].clicked = true;
		
		
	}
	
	public void mouseReleased(MouseEvent event) {
		
		clicks[event.getButton()].pressed = false;
		clicks[event.getButton()].clicked = false;
		clicks[event.getButton()].alreadyPressed = false;
		
	}
	
}
