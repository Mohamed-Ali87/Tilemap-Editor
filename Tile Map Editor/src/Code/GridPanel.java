package Code;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GridPanel extends Panel implements KeyListener, MouseListener, MouseMotionListener  {

	Image offscreen;
	Graphics offscreen_g;
	
	Color bgcolor = Color.LIGHT_GRAY;
	
	int scale;
	
	Rect box;
	
	int mx;
	int my;
	
	boolean mouseWithin = false;
	
	public GridPanel(TileMapEditor editor) {
		
		offscreen = editor.offscreen;
		offscreen_g = editor.offscreen_g;
		
		setLayout(null); 
		
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		scale = editor.tilemap.S;
		box = new Rect(-100, 100, scale, scale);
		
	}
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {

		mx = e.getX();
		my = e.getY();
		
		box.setLocation(mx/scale *scale, my/scale * scale);
		
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		mouseWithin = true;
		
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		mouseWithin = false;
		
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void paint(Graphics g) {
		
		g.setColor(bgcolor);
		
		g.fillRect(0, 0, 1920, 1080);
		
		g.setColor(Color.green);
		
		if(mouseWithin) box.draw(g);
	}
	
	public void update(Graphics g) {
		
		paint(offscreen_g);
		
		g.drawImage(offscreen, 0, 0, null);
		
	}


}