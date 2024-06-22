package Code;
import java.awt.Color;
import java.awt.Graphics;

public class Rect {
	
	int x;
	int y;
	int w;
	int h;
	
	
	public Rect(int x, int y, int w, int h) {
		
		setLocation(x, y);
		setSize(w, h);
	}
	
	public void setLocation(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
	public void setSize(int w, int h) {
		
		this.w = w;
		this.h = h;
	}
	
	public void draw(Graphics g) {
		
		  g.drawRect(x, y, w, h);
	}
	
	
}

