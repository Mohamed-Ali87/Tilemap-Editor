package Code;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MapPanel extends GridPanel  {

	TilePanel tilePN;
	TileMap tilemap;
	
	public MapPanel(TileMapEditor editor) {
		
		super(editor);
		
		tilePN = editor.tilePN;
		tilemap = editor.tilemap;
		
		setBounds(10, 10, 800, 448);
		
		setBackground(bgcolor);
		
	}
	
	public void keyPressed(KeyEvent e) {
		int code = e.getExtendedKeyCode();
		
		if(code == KeyEvent.VK_UP) Camera.moveUp(scale);
		if(code == KeyEvent.VK_DOWN) Camera.moveDown(scale);
		if(code == KeyEvent.VK_RIGHT) Camera.moveRight(scale);
		if(code == KeyEvent.VK_LEFT) Camera.moveLeft(scale);
		
		repaint();
		
	}
	
	public void mousePressed(MouseEvent e) {
		char selectedTile = TilePanel.activeTile;
		//System.out.print(tilePN.activeTile);
		tilemap.change(mx,my, tilePN.activeTile);
		
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		tilemap.draw(g);
	   
		
		g.setColor(Color.red);
		
		if(mouseWithin) box.draw(g);


		
	}
	
	
	

}
