package com.chaseplays.engine.single;

import com.chaseplays.engine.Engine;
import com.chaseplays.engine.action.TechAction;
import com.chaseplays.engine.screen.Sprite;

public class PhysicalObject {

	public double y = 10;
	public double x = 10;
	
	public int pWidth;
	public int pHeight;
	
	// Jump Variables
	
	/**
	 * 
	 * When jumping, determines the upwards velocity at the start.
	 * 
	 */
	
	public double thrust;
	
	/**
	 * 
	 * While in the air, determines the maximum velocity downwards.
	 * 
	 */
	
	public double maximum_downwards_velocity;
	
	/**
	 * 
	 * The speed at which the velocity decreases, in pixels per tech.
	 * 
	 */
	
	public double v_decay;
	
	/**
	 * 
	 * The vertical velocity at any given time.
	 * 
	 */
	
	public double v_velocity = 0;
	
		// ^ ^ ^
	
	
	
	// Movement Variables
	
	/**
	 * 
	 * The speed at which the horizontal velocity decreases, in pixels per tech.
	 * 
	 */
	
	public double h_decay;
	
	/**
	 * 
	 * The speed at which pressing left or right increases the horizontal velocity.
	 * 
	 */
	
	public double h_acceleration;
	
	/**
	 * 
	 * The maximum horizontal velocity in either direction.
	 * 
	 */
	
	public double maximum_h_velocity;
	
	/**
	 * 
	 * The horizontal velocity at any given time.
	 * 
	 */
	
	public double h_velocity = 0;
	
		// ^ ^ ^
	
	/**
	 * 
	 * A tech-action that will update the jumping physics every tech.
	 * 
	 */
	
	public TechAction jump = new TechAction(1);
	
	/**
	 * 
	 * A tech-action that will update the moving physics every tech.
	 * 
	 */
	
	public TechAction move = new TechAction(1);
	
	/**
	 * 
	 * Deals with the amount of ending lag after landing.
	 * 
	 */
	
	public int landTech = 0;
	
	public void updatePhysics (Engine e) {
		
		/*
		 * 
		 * Deals with vertical velocity calculations
		 * 
		 */
		
		if (jump.able()) {
			
			jump.gather();
			
			if (v_velocity > maximum_downwards_velocity && !grounded()) {
				
				v_velocity -= v_decay;
				if (v_velocity < maximum_downwards_velocity) v_velocity = maximum_downwards_velocity;
				
			}
			
			boolean positive_v_velocity = v_velocity >= 0;
			
			for (double v = Math.abs(v_velocity); v > 0 && !v_blocked(); v--) {
				
				double y_change;
				
				if (v >= 1) {
					
					if (positive_v_velocity) y_change = -1;
					else y_change = 1;
					
				} else {
					
					if (positive_v_velocity) y_change = -1 * v;
					else y_change = v;
					
				}
				
				y += y_change;
				
				if (grounded()) landTech = 5;
				
			}
			
			if (v_blocked()) v_velocity = 0;
			
		}
		
		/*
		 * 
		 * Deals with horizontal velocity calculations
		 * 
		 */
		
		if (move.able()) {
			
			move.gather();
			
			for (double h = Math.abs(h_velocity); h > 0 && (!h_blocked(h) || ((!h_raised_blocked(h) || !h_lowered_blocked(h)) && grounded())); h--) {
				
				boolean lowered = false;
				
				if (grounded() && h_blocked(h)) {
					
					if (!h_raised_blocked(h)) y--;
					else y++;
					
				} else if (grounded() && !h_lowered_blocked(h)) {
					
					lowered = true;
					y++;
					
				}
				
				if (Math.abs(h) >= 1) {
					
					if (h_velocity < 0) x--;
					else x++;
					
				} else {
					
					if (h_velocity < 0) x -= h;
					else x += h;
					
				}
				
				if (lowered && !grounded()) y--;
				
			}
			
			if (h_velocity != 0) {
				
				if (h_velocity > 0) {
					
					if (h_velocity >= h_decay) h_velocity -= h_decay;
					else h_velocity = 0;
					
				}
				
				if (h_velocity < 0) {
					
					if (Math.abs(h_velocity) >= h_decay) h_velocity += h_decay;
					else h_velocity = 0;
					
				}
				
			}
			
			if (e.key.right.pressed()) {
				
				h_velocity += h_acceleration;
				
			}
			
			if (e.key.left.pressed()) {
				
				h_velocity -= h_acceleration;
				
			}
			
			if (Math.abs(h_velocity) > maximum_h_velocity) {
				
				if (h_velocity > 0) h_velocity = maximum_h_velocity;
				else h_velocity = -1 * maximum_h_velocity;
				
			}
			
			if (h_blocked(h_velocity) && (!grounded() || (h_raised_blocked(h_velocity) && h_lowered_blocked(h_velocity)))) h_velocity = 0;
			
		}
		
		if ((e.key.space.pressed() || e.key.up.pressed()) && grounded() && landTech == 0) {
			
			v_velocity = thrust;
			
		}
		
		if (v_velocity == 0 && grounded()) y = (int) y;
		if (h_velocity == 0) x = (int) x;
		
		if (landTech > 0) landTech--;
		if (!e.key.space.pressed && !e.key.up.pressed) landTech = 0;
		
	}
	
	public boolean grounded () {
		
		if (v_velocity > 0) return false;
		
		double stored_v_velocity = v_velocity;
		
		v_velocity = -1;
		
		boolean blocked = false;
		
		if (v_blocked()) blocked = true;
		
		v_velocity = stored_v_velocity;
		
		return blocked;
		
	}
	
	public boolean v_blocked () {
		
		if (v_velocity > 0) {
			
			if (level_blocked((int) x, (int) y - 1)) return true;
			
		}
		
		if (v_velocity < 0) {
			
			if (level_blocked((int) x, (int) y + 1)) return true;
			
		}
		
		return false;
		
	}
	
	public boolean h_raised_blocked (double h) {
		
		boolean return_statement = false;
		
		y--;
		
		if (h_blocked(h)) return_statement = true;
		
		y++;
		
		return return_statement;
		
	}
	
	public boolean h_lowered_blocked (double h) {
		
		boolean return_statement = false;
		
		y++;
		
		if (h_blocked(h)) return_statement = true;
		
		y--;
		
		return return_statement;
		
	}
	
	public boolean h_blocked (double h) {
		
		double x_change;
		
		if (Math.abs(h) >= 1) {
			
			if (h_velocity < 0) x_change = -1;
			else x_change = 1;
			
		} else {
			
			if (h_velocity < 0) x_change = -1 * h;
			else x_change = h;
			
		}
		
		if (level_blocked((int) (x + x_change), (int) y)) return true;
		
		return false;
		
	}
	
	public boolean level_blocked (int new_x, int new_y) {
		
		return false;
		
	}
	
}
