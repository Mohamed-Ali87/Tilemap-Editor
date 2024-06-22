package Code;

import java.awt.Graphics;

public class Camera {
	
	static int x;
	static int y;
	static int w;
	static int h;
	
	
	public static void setup(int x, int y, int w, int h) {
		
		setLocation(x, y);
		setSize(w, h);
	}
	
	public static void setLocation(int x, int y) {
		
		Camera.x = x;
		Camera.y = y;
	}
	
	public static void setSize(int w, int h) {
		
		Camera.w = w;
		Camera.h = h;
	}
	
	static public void moveUp(int dy) {
		y -= dy;
	}
	
	static public void moveDown(int dy) {
		y += dy;
	}
	
	static public void moveRight(int dx) {
		x += dx;
	}
	
	static public void moveLeft(int dx) {
		x -= dx;
	}
	
	public static void draw(Graphics g) {
		
		  g.drawRect(x, y, w, h);
	}
	
	
	
	
}


