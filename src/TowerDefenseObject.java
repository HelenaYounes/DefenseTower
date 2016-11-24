import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class TowerDefenseObject {
	protected BufferedImage image;
	protected int height;
	protected int width;
	public int x;
	protected int y;

	public TowerDefenseObject() {
		this.height = 20;
		this.width = 20;
		this.x = 500;
		this.y = 500;

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
		this.width = image.getWidth()/8;
		this.height = image.getHeight()/8;
	}

	public TowerDefenseObject(int x, int y, BufferedImage image, int width, int height ){
		this.x = x;
		this.y = y;
		this.image = image;
		this.width = width;
		this.height = height;
	}
	
	public boolean contain(double x, double y){
		if(x > this.x && x < (this.x + this.width) && y > this.y && y < (this.y + this.height)){
			return true;
		} else {
			return false;
		}
	}
	
	public void drawTheImage(Graphics g) {
		g.drawImage(this.image, this.x, this.y, this.width, this.height, null);
	}

	public void runLogic() {
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
