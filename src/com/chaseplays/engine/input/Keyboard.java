package com.chaseplays.engine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	
	public Key a = new Key(), b = new Key(), c = new Key(), d = new Key(), e = new Key(), f = new Key(), g = new Key(), h = new Key(), i = new Key(), j = new Key(), k = new Key(), l = new Key(), m = new Key(), n = new Key(), o = new Key(), p = new Key(), q = new Key(), r = new Key(), s = new Key(), t = new Key(), u = new Key(), v = new Key(), w = new Key(), x = new Key(), y = new Key(), z = new Key();
	
	public Key one = new Key(), two = new Key(), three = new Key(), four = new Key(), five = new Key(), six = new Key(), seven = new Key(), eight = new Key(), nine = new Key(), zero = new Key();
	
	public Key numPadOne = new Key(), numPadTwo = new Key(), numPadThree = new Key(), numPadFour = new Key(), numPadFive = new Key(), numPadSix = new Key(), numPadSeven = new Key(), numPadEight = new Key(), numPadNine = new Key(), numPadZero = new Key(), numPadPlus = new Key(), numPadMinus = new Key();
	
	public Key space = new Key(), backspace = new Key(), shift = new Key(), enter = new Key(), escape = new Key(), tab = new Key(), alt = new Key(), ctrl = new Key();
	
	public Key left = new Key(), right = new Key(), up = new Key(), down = new Key();
	
	public Key dash = new Key(), equals = new Key(), apostrophe = new Key(), lBrac = new Key(), rBrac = new Key(), comma = new Key(), period = new Key(), accent = new Key(), semicolon = new Key(), slash = new Key(), backSlash = new Key();
	
	public Key f1 = new Key(), f2 = new Key(), f3 = new Key(), f4 = new Key(), f5 = new Key(), f6 = new Key(), f7 = new Key(), f8 = new Key(), f9 = new Key(), f10 = new Key(), f11 = new Key(), f12 = new Key();
	
	
	public Key[] keys = new Key[1000];
	
	public void setup () {
		
		for (int x = 0; x < keys.length; x++) keys[x] = new Key();
		
	}
	
	public void update () {
		
		a.pressed = keys[KeyEvent.VK_A].pressed;
		b.pressed = keys[KeyEvent.VK_B].pressed;
		c.pressed = keys[KeyEvent.VK_C].pressed;
		d.pressed = keys[KeyEvent.VK_D].pressed;
		e.pressed = keys[KeyEvent.VK_E].pressed;
		f.pressed = keys[KeyEvent.VK_F].pressed;
		g.pressed = keys[KeyEvent.VK_G].pressed;
		h.pressed = keys[KeyEvent.VK_H].pressed;
		i.pressed = keys[KeyEvent.VK_I].pressed;
		j.pressed = keys[KeyEvent.VK_J].pressed;
		k.pressed = keys[KeyEvent.VK_K].pressed;
		l.pressed = keys[KeyEvent.VK_L].pressed;
		m.pressed = keys[KeyEvent.VK_M].pressed;
		n.pressed = keys[KeyEvent.VK_N].pressed;
		o.pressed = keys[KeyEvent.VK_O].pressed;
		p.pressed = keys[KeyEvent.VK_P].pressed;
		q.pressed = keys[KeyEvent.VK_Q].pressed;
		r.pressed = keys[KeyEvent.VK_R].pressed;
		s.pressed = keys[KeyEvent.VK_S].pressed;
		t.pressed = keys[KeyEvent.VK_T].pressed;
		u.pressed = keys[KeyEvent.VK_U].pressed;
		v.pressed = keys[KeyEvent.VK_V].pressed;
		w.pressed = keys[KeyEvent.VK_W].pressed;
		x.pressed = keys[KeyEvent.VK_X].pressed;
		y.pressed = keys[KeyEvent.VK_Y].pressed;
		z.pressed = keys[KeyEvent.VK_Z].pressed;
		
		one.pressed = keys[KeyEvent.VK_1].pressed;
		two.pressed = keys[KeyEvent.VK_2].pressed;
		three.pressed = keys[KeyEvent.VK_3].pressed;
		four.pressed = keys[KeyEvent.VK_4].pressed;
		five.pressed = keys[KeyEvent.VK_5].pressed;
		six.pressed = keys[KeyEvent.VK_6].pressed;
		seven.pressed = keys[KeyEvent.VK_7].pressed;
		eight.pressed = keys[KeyEvent.VK_8].pressed;
		nine.pressed = keys[KeyEvent.VK_9].pressed;
		zero.pressed = keys[KeyEvent.VK_0].pressed;
		
		numPadOne.pressed = keys[KeyEvent.VK_NUMPAD1].pressed;
		numPadTwo.pressed = keys[KeyEvent.VK_NUMPAD2].pressed;
		numPadThree.pressed = keys[KeyEvent.VK_NUMPAD3].pressed;
		numPadFour.pressed = keys[KeyEvent.VK_NUMPAD4].pressed;
		numPadFive.pressed = keys[KeyEvent.VK_NUMPAD5].pressed;
		numPadSix.pressed = keys[KeyEvent.VK_NUMPAD6].pressed;
		numPadSeven.pressed = keys[KeyEvent.VK_NUMPAD7].pressed;
		numPadEight.pressed = keys[KeyEvent.VK_NUMPAD8].pressed;
		numPadNine.pressed = keys[KeyEvent.VK_NUMPAD9].pressed;
		numPadZero.pressed = keys[KeyEvent.VK_NUMPAD0].pressed;
		
		numPadMinus.pressed = keys[KeyEvent.VK_SUBTRACT].pressed;
		numPadPlus.pressed = keys[KeyEvent.VK_ADD].pressed;
		
		f1.pressed = keys[KeyEvent.VK_F1].pressed;
		f2.pressed = keys[KeyEvent.VK_F2].pressed;
		f3.pressed = keys[KeyEvent.VK_F3].pressed;
		f4.pressed = keys[KeyEvent.VK_F4].pressed;
		f5.pressed = keys[KeyEvent.VK_F5].pressed;
		f6.pressed = keys[KeyEvent.VK_F6].pressed;
		f7.pressed = keys[KeyEvent.VK_F7].pressed;
		f8.pressed = keys[KeyEvent.VK_F8].pressed;
		f9.pressed = keys[KeyEvent.VK_F9].pressed;
		f10.pressed = keys[KeyEvent.VK_F10].pressed;
		f11.pressed = keys[KeyEvent.VK_F11].pressed;
		f12.pressed = keys[KeyEvent.VK_F12].pressed;
		
		space.pressed = keys[KeyEvent.VK_SPACE].pressed;
		backspace.pressed = keys[KeyEvent.VK_BACK_SPACE].pressed;
		shift.pressed = keys[KeyEvent.VK_SHIFT].pressed;
		enter.pressed = keys[KeyEvent.VK_ENTER].pressed;
		escape.pressed = keys[KeyEvent.VK_ESCAPE].pressed;
		tab.pressed = keys[KeyEvent.VK_TAB].pressed;
		alt.pressed = keys[KeyEvent.VK_ALT].pressed;
		ctrl.pressed = keys[KeyEvent.VK_CONTROL].pressed;
		
		left.pressed = keys[KeyEvent.VK_LEFT].pressed;
		right.pressed = keys[KeyEvent.VK_RIGHT].pressed;
		up.pressed = keys[KeyEvent.VK_UP].pressed;
		down.pressed = keys[KeyEvent.VK_DOWN].pressed;
		
		
		dash.pressed = keys[KeyEvent.VK_MINUS].pressed;
		equals.pressed = keys[KeyEvent.VK_EQUALS].pressed;
		lBrac.pressed = keys[KeyEvent.VK_OPEN_BRACKET].pressed;
		rBrac.pressed = keys[KeyEvent.VK_CLOSE_BRACKET].pressed;
		apostrophe.pressed = keys[KeyEvent.VK_QUOTE].pressed;
		comma.pressed = keys[KeyEvent.VK_COMMA].pressed;
		period.pressed = keys[KeyEvent.VK_PERIOD].pressed;
		accent.pressed = keys[KeyEvent.VK_BACK_QUOTE].pressed;
		semicolon.pressed = keys[KeyEvent.VK_SEMICOLON].pressed;
		slash.pressed = keys[KeyEvent.VK_SLASH].pressed;
		backSlash.pressed = keys[KeyEvent.VK_BACK_SLASH].pressed;
		
		
		
		
		
		
		a.typed = keys[KeyEvent.VK_A].typed;
		b.typed = keys[KeyEvent.VK_B].typed;
		c.typed = keys[KeyEvent.VK_C].typed;
		d.typed = keys[KeyEvent.VK_D].typed;
		e.typed = keys[KeyEvent.VK_E].typed;
		f.typed = keys[KeyEvent.VK_F].typed;
		g.typed = keys[KeyEvent.VK_G].typed;
		h.typed = keys[KeyEvent.VK_H].typed;
		i.typed = keys[KeyEvent.VK_I].typed;
		j.typed = keys[KeyEvent.VK_J].typed;
		k.typed = keys[KeyEvent.VK_K].typed;
		l.typed = keys[KeyEvent.VK_L].typed;
		m.typed = keys[KeyEvent.VK_M].typed;
		n.typed = keys[KeyEvent.VK_N].typed;
		o.typed = keys[KeyEvent.VK_O].typed;
		p.typed = keys[KeyEvent.VK_P].typed;
		q.typed = keys[KeyEvent.VK_Q].typed;
		r.typed = keys[KeyEvent.VK_R].typed;
		s.typed = keys[KeyEvent.VK_S].typed;
		t.typed = keys[KeyEvent.VK_T].typed;
		u.typed = keys[KeyEvent.VK_U].typed;
		v.typed = keys[KeyEvent.VK_V].typed;
		w.typed = keys[KeyEvent.VK_W].typed;
		x.typed = keys[KeyEvent.VK_X].typed;
		y.typed = keys[KeyEvent.VK_Y].typed;
		z.typed = keys[KeyEvent.VK_Z].typed;
		
		one.typed = keys[KeyEvent.VK_1].typed;
		two.typed = keys[KeyEvent.VK_2].typed;
		three.typed = keys[KeyEvent.VK_3].typed;
		four.typed = keys[KeyEvent.VK_4].typed;
		five.typed = keys[KeyEvent.VK_5].typed;
		six.typed = keys[KeyEvent.VK_6].typed;
		seven.typed = keys[KeyEvent.VK_7].typed;
		eight.typed = keys[KeyEvent.VK_8].typed;
		nine.typed = keys[KeyEvent.VK_9].typed;
		zero.typed = keys[KeyEvent.VK_0].typed;
		
		numPadOne.typed = keys[KeyEvent.VK_NUMPAD1].typed;
		numPadTwo.typed = keys[KeyEvent.VK_NUMPAD2].typed;
		numPadThree.typed = keys[KeyEvent.VK_NUMPAD3].typed;
		numPadFour.typed = keys[KeyEvent.VK_NUMPAD4].typed;
		numPadFive.typed = keys[KeyEvent.VK_NUMPAD5].typed;
		numPadSix.typed = keys[KeyEvent.VK_NUMPAD6].typed;
		numPadSeven.typed = keys[KeyEvent.VK_NUMPAD7].typed;
		numPadEight.typed = keys[KeyEvent.VK_NUMPAD8].typed;
		numPadNine.typed = keys[KeyEvent.VK_NUMPAD9].typed;
		numPadZero.typed = keys[KeyEvent.VK_NUMPAD0].typed;
		
		numPadMinus.typed = keys[KeyEvent.VK_SUBTRACT].typed;
		numPadPlus.typed = keys[KeyEvent.VK_ADD].typed;
		
		f1.typed = keys[KeyEvent.VK_F1].typed;
		f2.typed = keys[KeyEvent.VK_F2].typed;
		f3.typed = keys[KeyEvent.VK_F3].typed;
		f4.typed = keys[KeyEvent.VK_F4].typed;
		f5.typed = keys[KeyEvent.VK_F5].typed;
		f6.typed = keys[KeyEvent.VK_F6].typed;
		f7.typed = keys[KeyEvent.VK_F7].typed;
		f8.typed = keys[KeyEvent.VK_F8].typed;
		f9.typed = keys[KeyEvent.VK_F9].typed;
		f10.typed = keys[KeyEvent.VK_F10].typed;
		f11.typed = keys[KeyEvent.VK_F11].typed;
		f12.typed = keys[KeyEvent.VK_F12].typed;
		
		space.typed = keys[KeyEvent.VK_SPACE].typed;
		backspace.typed = keys[KeyEvent.VK_BACK_SPACE].typed;
		shift.typed = keys[KeyEvent.VK_SHIFT].typed;
		enter.typed = keys[KeyEvent.VK_ENTER].typed;
		escape.typed = keys[KeyEvent.VK_ESCAPE].typed;
		tab.typed = keys[KeyEvent.VK_TAB].typed;
		alt.typed = keys[KeyEvent.VK_ALT].typed;
		ctrl.typed = keys[KeyEvent.VK_CONTROL].typed;
		
		left.typed = keys[KeyEvent.VK_LEFT].typed;
		right.typed = keys[KeyEvent.VK_RIGHT].typed;
		up.typed = keys[KeyEvent.VK_UP].typed;
		down.typed = keys[KeyEvent.VK_DOWN].typed;
		
		
		dash.typed = keys[KeyEvent.VK_MINUS].typed;
		equals.typed = keys[KeyEvent.VK_EQUALS].typed;
		lBrac.typed = keys[KeyEvent.VK_OPEN_BRACKET].typed;
		rBrac.typed = keys[KeyEvent.VK_CLOSE_BRACKET].typed;
		apostrophe.typed = keys[KeyEvent.VK_QUOTE].typed;
		comma.typed = keys[KeyEvent.VK_COMMA].typed;
		period.typed = keys[KeyEvent.VK_PERIOD].typed;
		accent.typed = keys[KeyEvent.VK_BACK_QUOTE].typed;
		semicolon.typed = keys[KeyEvent.VK_SEMICOLON].typed;
		slash.typed = keys[KeyEvent.VK_SLASH].typed;
		backSlash.typed = keys[KeyEvent.VK_BACK_SLASH].typed;
		
		for (int x = 0; x < keys.length; x++) keys[x].typed = false;
		
	}
	
	public void keyPressed (KeyEvent event) {
		
		keys[event.getKeyCode()].pressed = true;
		
		if (!keys[event.getKeyCode()].alreadyPressed) {
			
			keys[event.getKeyCode()].typed = true;
			
			keys[event.getKeyCode()].alreadyPressed = true;
			
		}
		
	}
	
	public void keyReleased (KeyEvent event) {
		
		keys[event.getKeyCode()].pressed = false;
		
		keys[event.getKeyCode()].alreadyPressed = false;
		
	}
	
	public void keyTyped (KeyEvent event) {
		
	}

}
