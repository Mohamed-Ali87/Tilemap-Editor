package Code;

import java.applet.Applet;
import java.awt.Graphics;

public class TileMapApplet extends Applet {
	
	private TileMap tileMap;
	
	public void init() {
		tileMap = new TileMap("C:\\Users\\M A\\Desktop\\map1.txt", 32);
		
	}
	
	public void paint (Graphics g) {
		tileMap.draw(g);
	}
	
}
