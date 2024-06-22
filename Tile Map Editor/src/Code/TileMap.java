package Code;

import java.awt.*;
import java.awt.Graphics;
import java.io.*;
import java.awt.Image;
import java.awt.Toolkit;

public class TileMap {

	int S;
	
	private String[] map;
	
	 Image[] tile;
	
	private Image background;
	
	private String[] tileName;
	private String backgroundName;
	
	private boolean[][]collisionData;
	
	
	
	public TileMap(String[] map, Image[] tile, Image background, int scale) {
		
		S = scale;
		
		this.map = map;
		this.tile = tile;
		this.background = background;
		
	}
	
	public TileMap(String filename, int scale) {
		
		S = scale;
		
		collisionData = new boolean[17][24];
		collisionData[16][23] = true;
		
		loadMap(filename);
		loadAssets();
		
		
	}
	
	public void toggleCollision(int row, int col) {
	    // Toggle collision for the specified location
	    collisionData[row][col] = !collisionData[row][col];
	}
	
	//Method updates collision data
	 public void setCollision(int row, int col, boolean hasCollision) {
		 if (row >= 0 && row < collisionData.length && col >= 0 && col < collisionData[0].length) {
		        collisionData[row][col] = hasCollision;
		    } else {
		        // Handle out-of-bounds indices or log an error.
		        System.err.println("Warning: Attempted to set collision out of bounds.");
		    }
	    }

	    // Methods for collision checks
	    public boolean hasCollision(int row, int col) {
	        return collisionData[row][col];
	    }
	
	
	public void loadMap(String filename) {
		
		File file = new File(filename);
		
		try {
	    BufferedReader input = new BufferedReader(new FileReader(file));
	    
	    int n = Integer.parseInt(input.readLine());
	    
	    map = new String[n]; 
	    
	    for(int row = 0; row < n; row++) {
	    	map[row] = input.readLine();
	    }
	    
	    n = Integer.parseInt(input.readLine());
	    
	    tile = new Image[n]; 
	    tileName = new String[n];
	    
	    for(int i = 0; i < n; i++) {
	    	tileName[i] = input.readLine();
	    }
	    
	    backgroundName = input.readLine();
	    
	    input.close();
		}
		
		catch(IOException x) {};
	}
	
	public void loadAssets() {
		
		for(int i = 0; i < tile.length; i++) {
			tile[i] = getImage(tileName[i]);
		}
		
		
		background = getImage(backgroundName);
	}
	
	public void saveMap(String filename) {
		
		File file = new File(filename);
		
		try {
			
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			
			output.write(map.length + "\n");
			
			for(int row = 0; row < map.length; row++) {
				output.write(map[row] + "\n");
			}
				
			output.write(tileName.length + "\n");
			
			for(int i = 0; i < tileName.length; i++) {
				output.write(tileName[i] + "\n");
			}
			
			output.write(backgroundName);
			output.close();
		}
		
		catch(IOException x) {}
		
	}
	
	
	
	public void change(int x, int y, char c) {
	    // Calculate row and col
	    int row = (y + Camera.y) / S;
	    int col = (x + Camera.x) / S;

	    // Check if row is within valid bounds
	    if (row >= 0 && row < map.length) {
	        String mapRow = map[row];
	        
	        // Check if col is within valid bounds for the specific row
	        if (col >= 0 && col < mapRow.length()) {
	            // Update the map only if the row and col are valid
	            map[row] = mapRow.substring(0, col) + c + mapRow.substring(col + 1);
	        } else {
	            // Handle out-of-bounds col (e.g., log a message or ignore)
	            System.err.println("Warning: Column is out of bounds.");
	        }
	    } else {
	        // Handle out-of-bounds row (e.g., log a message or ignore)
	        System.err.println("Warning: Row is out of bounds.");
	    }
	    
	}

	
	

	public char charAt(int row, int col) {
		return map[row].charAt(col);
	}
	
	public void draw(Graphics g) {
		
		g.drawImage(background, 0,0, 800,448, null);
		for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length(); col++) {
                char c = map[row].charAt(col);
                
                if (c != '.') {
                	
                	g.drawImage(tile[c - 'A'], S * col - Camera.x, S * row - Camera.y, S, S, null);
                }
                
              //  if (hasCollision(row, col)) {
                    // Draw a red overlay for collision tiles
              //      g.setColor(new Color(255, 0, 0, 128)); // Semi-transparent red
                    
           //     }
              
                
                
                }
            }
	}
	
	public Image getImage(String filename) {
		return Toolkit.getDefaultToolkit().getImage(filename);
	}
	
	
	
}
