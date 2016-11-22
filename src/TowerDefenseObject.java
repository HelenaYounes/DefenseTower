import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class TowerDefenseObject {
	private BufferedImage image;
	private int height;
	private int width;
	private int x;
	private int y;
	
	public TowerDefenseObject() {
		this.height = 80;
		this.width = 80;
		this.x = 0;
		this.y = 200;
		
		try {
			this.image = ImageIO.read(new File("singetower.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public TowerDefenseObject(int x, int y, BufferedImage image){
		this.x = x;
		this.y = y; 
		this.image = image;
		this.width = image.getWidth();
		this.height = image.getHeight();
	}
	
	public TowerDefenseObject(int x, int y, BufferedImage image, int width, int height ){
		this.x = x;
		this.y = y;
		this.image = image; 
		this.width = width; 
		this.height = height;
	}
	
	public void drawTheImage(Graphics g) {
		g.drawImage(this.image, this.x, this.y, this.width, this.height, null);
	}

}
