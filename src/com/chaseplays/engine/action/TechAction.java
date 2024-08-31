package com.chaseplays.engine.action;

/**
 * 
 * An action measured in terms of techs. Every time "able" is used, it adds 1 tech to the timer.
 * Once the timer reaches the limit of techs, "able" will return true and the action will be
 * carried out. A tech equals 10 milliseconds, or 1/100 of a second.
 * 
 * @author Chase Peterson
 *
 */

public class TechAction {
	
	/**
	 * 
	 * The amount of techs since the last "gather".
	 * 
	 */
	
	public int timeSinceLast;
	
	/**
	 * 
	 * The amount of techs until "able" returns true.
	 * 
	 */
	
	public int limit;
	
	/**
	 * 
	 * An action measured in number of "techs". "Techs" constitute 1/100 of a second, or 10 milliseconds.
	 * 
	 * @param limit Sets the amount of techs until "able" returns true.
	 */
	
	public TechAction (int limit) {
		
		this.limit = limit; // sets the limit
		
	}
	
	/**
	 * 
	 * Checks if the action is ready to be fulfilled. Adds 1 tech to the timer.
	 * 
	 * @return If the action is ready to be fulfilled.
	 * 
	 */
	
	public boolean able () {
		
		timeSinceLast++; // adds 1 to the timer
		
		if (timeSinceLast >= limit) return true; // if the time limit is reached, returns true
		
		return false; // otherwise, returns false
		
	}
	
	/**
	 * 
	 * If the action is ready to be fulfilled, brings the timer down by its limit, usually resetting it to zero.
	 * 
	 */
	
	public void gather () {
		
		timeSinceLast -= limit;
		
	}
	
}