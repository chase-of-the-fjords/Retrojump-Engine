package com.chaseplays.engine.text;

import java.util.Random;

public class Shake implements TextAction {
	
	public int distance;
	
	public static Random rand = new Random();
	
	public Shake (int distance) {
		
		this.distance = distance;
		
	}
	
	public void update () { }
	
	public int xchange(int position) {
		
		return rand.nextInt(distance * 2) - distance;
		
	}
	
	public int ychange(int position) {
		
		return rand.nextInt(distance * 2) - distance;
		
	}
	
	public boolean show () {
		
		return true;
		
	}
	
}
