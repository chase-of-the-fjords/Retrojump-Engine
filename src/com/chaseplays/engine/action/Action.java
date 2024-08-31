package com.chaseplays.engine.action;

/**
 * 
 * the general class for an "action". a variable
 * that repeats every "x" milliseconds for "y"
 * milliseconds in total.
 * 
 * @author Chase "Bown" Peterson
 *
 */

public class Action {
	
	public boolean active; // whether or not the "action" is active
	
	public long lastUpdated; // when the action last updated
	
	public long updateEvery; // how often the action should update
	
	public long updateFor; // how long the action should update for
	
	public long beganAt; // the time that the action began "acting"
	
	/**
	 * 
	 * a general action
	 * 
	 * @param update how often the action should update
	 * @param time how long the action should update for
	 */
	
	public Action (long update, long time) {
		
		this.updateEvery = update; // sets how often the action should update
		this.updateFor = time; // sets how long the action should update for
		
	}
	
	/**
	 * 
	 * 
	 * 
	 */
	
	public void gather () {
		
		lastUpdated += updateEvery;
		
		if (System.currentTimeMillis() - beganAt >= updateFor && updateFor != 0) stop();
		
	}
	
	public boolean able () {
		
		return active && System.currentTimeMillis() - lastUpdated >= updateEvery;
		
	}
	
	public void start () {
		
		active = true;
		
		lastUpdated = System.currentTimeMillis();
		
		beganAt = System.currentTimeMillis();
		
	}
	
	public void stop () {
		
		active = false;
		
	}
	
}
