package com.chaseplays.engine.text;

public class Fontext extends Font {
	
	public Fontext (String path, int space, int gap, int size) {
		
		super(path, space, gap, size);
		
		for (int f = 0; f < figures.length; f++) {
			
			if (f == 0) figures[f] = new Figure(path, 3, 12, 'A');
			if (f == 1) figures[f] = new Figure(path, 3, 12, 'B');
			if (f == 2) figures[f] = new Figure(path, 3, 12, 'C');
			if (f == 3) figures[f] = new Figure(path, 3, 12, 'D');
			if (f == 4) figures[f] = new Figure(path, 3, 12, 'E');
			if (f == 5) figures[f] = new Figure(path, 3, 12, 'F');
			if (f == 6) figures[f] = new Figure(path, 3, 12, 'G');
			if (f == 7) figures[f] = new Figure(path, 3, 12, 'H');
			if (f == 8) figures[f] = new Figure(path, 3, 12, 'I');
			if (f == 9) figures[f] = new Figure(path, 3, 12, 'J');
			
			if (f == 10) figures[f] = new Figure(path, 3, 12, 'K');
			if (f == 11) figures[f] = new Figure(path, 3, 12, 'L');
			if (f == 12) figures[f] = new Figure(path, 5, 12, 'M');
			if (f == 13) figures[f] = new Figure(path, 4, 12, 'N');
			if (f == 14) figures[f] = new Figure(path, 3, 12, 'O');
			if (f == 15) figures[f] = new Figure(path, 3, 12, 'P');
			if (f == 16) figures[f] = new Figure(path, 3, 12, 'Q');
			if (f == 17) figures[f] = new Figure(path, 3, 12, 'R');
			if (f == 18) figures[f] = new Figure(path, 3, 12, 'S');
			if (f == 19) figures[f] = new Figure(path, 3, 12, 'T');
			
			if (f == 20) figures[f] = new Figure(path, 3, 12, 'U');
			if (f == 21) figures[f] = new Figure(path, 3, 12, 'V');
			if (f == 22) figures[f] = new Figure(path, 5, 12, 'W');
			if (f == 23) figures[f] = new Figure(path, 3, 12, 'X');
			if (f == 24) figures[f] = new Figure(path, 3, 12, 'Y');
			if (f == 25) figures[f] = new Figure(path, 3, 12, 'Z');
			
			
			
			if (f == 26) figures[f] = new Figure(path, 3, 12, 'a');
			if (f == 27) figures[f] = new Figure(path, 3, 12, 'b');
			if (f == 28) figures[f] = new Figure(path, 3, 12, 'c');
			if (f == 29) figures[f] = new Figure(path, 3, 12, 'd');
			
			if (f == 30) figures[f] = new Figure(path, 3, 12, 'e');
			if (f == 31) figures[f] = new Figure(path, 3, 12, 'f');
			if (f == 32) figures[f] = new Figure(path, 3, 12, 'g');
			if (f == 33) figures[f] = new Figure(path, 3, 12, 'h');
			if (f == 34) figures[f] = new Figure(path, 1, 12, 'i');
			if (f == 35) figures[f] = new Figure(path, 1, 12, 'j');
			if (f == 36) figures[f] = new Figure(path, 3, 12, 'k');
			if (f == 37) figures[f] = new Figure(path, 1, 12, 'l');
			if (f == 38) figures[f] = new Figure(path, 5, 12, 'm');
			if (f == 39) figures[f] = new Figure(path, 3, 12, 'n');
			
			if (f == 40) figures[f] = new Figure(path, 3, 12, 'o');
			if (f == 41) figures[f] = new Figure(path, 3, 12, 'p');
			if (f == 42) figures[f] = new Figure(path, 3, 12, 'q');
			if (f == 43) figures[f] = new Figure(path, 3, 12, 'r');
			if (f == 44) figures[f] = new Figure(path, 3, 12, 's');
			if (f == 45) figures[f] = new Figure(path, 3, 12, 't');
			if (f == 46) figures[f] = new Figure(path, 3, 12, 'u');
			if (f == 47) figures[f] = new Figure(path, 3, 12, 'v');
			if (f == 48) figures[f] = new Figure(path, 5, 12, 'w');
			if (f == 49) figures[f] = new Figure(path, 3, 12, 'x');
			
			if (f == 50) figures[f] = new Figure(path, 3, 12, 'y');
			if (f == 51) figures[f] = new Figure(path, 3, 12, 'z');
			
			
			
			if (f == 52) figures[f] = new Figure(path, 3, 12, '1');
			if (f == 53) figures[f] = new Figure(path, 3, 12, '2');
			if (f == 54) figures[f] = new Figure(path, 3, 12, '3');
			if (f == 55) figures[f] = new Figure(path, 3, 12, '4');
			if (f == 56) figures[f] = new Figure(path, 3, 12, '5');
			if (f == 57) figures[f] = new Figure(path, 3, 12, '6');
			if (f == 58) figures[f] = new Figure(path, 3, 12, '7');
			if (f == 59) figures[f] = new Figure(path, 3, 12, '8');
			
			if (f == 60) figures[f] = new Figure(path, 3, 12, '9');
			if (f == 61) figures[f] = new Figure(path, 3, 12, '0');
			
			
			
			if (f == 62) figures[f] = new Figure(path, 1, 12, '!');
			if (f == 63) figures[f] = new Figure(path, 5, 12, '@');
			if (f == 64) figures[f] = new Figure(path, 5, 12, '#');
			if (f == 65) figures[f] = new Figure(path, 3, 12, '$');
			if (f == 66) figures[f] = new Figure(path, 3, 12, '%');
			if (f == 67) figures[f] = new Figure(path, 3, 12, '^');
			if (f == 68) figures[f] = new Figure(path, 4, 12, '&');
			if (f == 69) figures[f] = new Figure(path, 3, 12, '*');
			
			if (f == 70) figures[f] = new Figure(path, 2, 12, '(');
			if (f == 71) figures[f] = new Figure(path, 2, 12, ')');
			if (f == 72) figures[f] = new Figure(path, 3, 12, '_');
			if (f == 73) figures[f] = new Figure(path, 3, 12, '-');
			if (f == 74) figures[f] = new Figure(path, 5, 12, '+');
			if (f == 75) figures[f] = new Figure(path, 3, 12, '=');
			if (f == 76) figures[f] = new Figure(path, 3, 12, '{');
			if (f == 77) figures[f] = new Figure(path, 2, 12, '[');
			if (f == 78) figures[f] = new Figure(path, 3, 12, '}');
			if (f == 79) figures[f] = new Figure(path, 2, 12, ']');
			
			if (f == 80) figures[f] = new Figure(path, 1, 12, '|');
			if (f == 81) figures[f] = new Figure(path, 3, 12, '"');
			if (f == 82) figures[f] = new Figure(path, 1, 12, '\'');
			if (f == 83) figures[f] = new Figure(path, 1, 12, ':');
			if (f == 84) figures[f] = new Figure(path, 2, 12, ';');
			if (f == 85) figures[f] = new Figure(path, 3, 12, '?');
			if (f == 86) figures[f] = new Figure(path, 3, 12, '/');
			if (f == 87) figures[f] = new Figure(path, 4, 12, '>');
			if (f == 88) figures[f] = new Figure(path, 1, 12, '.');
			if (f == 89) figures[f] = new Figure(path, 4, 12, '<');
			
			if (f == 90) figures[f] = new Figure(path, 2, 12, ',');
			if (f == 91) figures[f] = new Figure(path, 3, 12, '\\');
			if (f == 92) figures[f] = new Figure(path, 6, 12, '~');
			if (f == 93) figures[f] = new Figure(path, 3, 12, '`');
			
		}
	
	}
	
}
