package com.chaseplays.engine.button;

import com.chaseplays.engine.Engine;

public interface Button {
	
	boolean interacting (Engine e);
	
	void update (Engine e);
	
	void render (Engine e);
	
	int x (Engine e);
	
	int y (Engine e);
	
}
