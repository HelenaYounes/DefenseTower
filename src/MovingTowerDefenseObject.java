import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class MovingTowerDefenseObject extends TowerDefenseObject {
	public double velocityX;
	public double velocityY;

	public MovingTowerDefenseObject(int x, int y, BufferedImage image, double velocityX, double velocityY) {
		super(x, y, image);
		this.velocityX = velocityX;
		this.velocityY = velocityY;
	}

	public MovingTowerDefenseObject(int x, int y, BufferedImage image, int width, int height, double velocityX, double velocityY) {
		super(x, y, image, width, height);
		this.velocityX = velocityX;
		this.velocityY = velocityY;
	}
	@Override
	public void drawTheImage(Graphics g){
		super.drawTheImage(g);
		this.x = (int) (this.x + this.velocityX);
		this.y = (int) (this.y + this.velocityY);
		

		
	}

	public double getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}

	public double getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}

}
