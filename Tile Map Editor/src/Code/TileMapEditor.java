package Code;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class TileMapEditor extends Applet implements ActionListener {
	
	Image offscreen;
	Graphics offscreen_g;
	
	MapPanel mapPN;
	TilePanel tilePN;
	
	Button saveBN;
	
	TileMap tilemap = new TileMap("C:\\Users\\M A\\Desktop\\map1.txt", 32);
	
	public void init() {
		
		offscreen = createImage(1920, 1080);
		offscreen_g = offscreen.getGraphics();
		
		setLayout(null);
		
		mapPN = new MapPanel(this);
		tilePN = new TilePanel(this);
		
		saveBN = new Button("save");
		
		add(mapPN);
		add(tilePN);
		add(saveBN);
		
		
		
		saveBN.setBounds(10,500, 100, 20);
		
		saveBN.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent e) {
		
		tilemap.saveMap("C:\\Users\\M A\\Desktop\\map1.txt");
		
	}
	
	
}
