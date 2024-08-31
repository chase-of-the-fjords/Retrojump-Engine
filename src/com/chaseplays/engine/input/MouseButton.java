package com.chaseplays.engine.input;

public class MouseButton {

	public boolean pressed = false;
	public boolean clicked = false;
	public boolean alreadyPressed = false;
	
	public void update() {
		
		if (this.alreadyPressed && this.pressed) {
			
			this.clicked = false;
			
		} else if (!this.pressed) {
			
			this.clicked = false;
			this.alreadyPressed = false;
			
		} else {
			
			this.clicked = true;
			this.alreadyPressed = true;
			
		}
		
	}
	
	public boolean pressed() {

		return pressed;

	}

	public boolean clicked() {

		return clicked;

	}

}
