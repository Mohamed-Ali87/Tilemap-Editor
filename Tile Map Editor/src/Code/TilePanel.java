package Code;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class TilePanel extends GridPanel {

	TileMap tilemap;
	
	Rect selection;
	
	static char activeTile;
	
	String code = "ABCDEFGHIJKL";
	
	public TilePanel(TileMapEditor editor) {
		
		super(editor);
		
		scale = 2*scale +8;
		
		
		box = new Rect(-100, 100, scale, scale);
		
		selection = new Rect(-100, 100, scale, scale);
		
		tilemap = editor.tilemap;
		
		setBounds(820, 10, scale*8, scale*8);
		
		bgcolor = Color.black;
		setBackground(bgcolor);
		
		activeTile = '.';
		
	}
	
	public void mousePressed(MouseEvent e) {
		
		int row = my / scale;
		int col = mx / scale;
		
		selection.setLocation(col * scale, row *scale);
		
		int index = 8 * row + col;

		if(index < code.length()) activeTile = code.charAt(index);
		
		else {
		activeTile = '.';
		}
		
		System.out.print(activeTile);
		
		
	}
	
	public void paint(Graphics g){
		
		g.setColor(bgcolor);
		
		g.fillRect(0, 0, 1920, 1080);
		
		for(int row = 0; row < 8; row++) {
			for(int col = 0; col < 8; col++) {
				
				if(8 * row + col < tilemap.tile.length )
				g.drawImage(tilemap.tile[8 * row + col], 4+col * scale, 4+row * scale , scale-8, scale-8, null);
			}
		}
		
		g.setColor(Color.white);
		selection.draw(g);
		
		g.setColor(Color.green);
		
		if(mouseWithin) box.draw(g);
	}
	
}
