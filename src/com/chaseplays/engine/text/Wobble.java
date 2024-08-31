package com.chaseplays.engine.text;

import com.chaseplays.engine.action.Action;

public class Wobble implements TextAction {
	
	public int change;
	
	public Action wobble;
	
	public int time = 0;
	
	public double separation = 0.25;
	
	public Wobble (int change, int time) {
		
		this.change = change;
		this.wobble = new Action(time, 0);
		
		this.wobble.start();
		
	}
	
	public Wobble (int change, int time, int separation) {
		
		this.change = change;
		this.wobble = new Action(time, 0);
		
		this.separation = separation / 100.00;
		
		this.wobble.start();
		
	}
	
	public void update () {
		
		if (wobble.able()) {
			
			time++;
			
			wobble.gather();
			
		}
		
	}
	
	public boolean show () {
		
		return true;
		
	}
	
	public int xchange(int position) {
		
		return 0;
		
	}
	
	public int ychange(int position) {
		
		int ychange = (int) ((double) change * (double) Math.sin(separation * ((double) (position) + (double) time)));
		
		return ychange;
		
	}

}
