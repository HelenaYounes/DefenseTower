import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Tower extends TowerDefenseObject {
	private int radius;
	private int speed;
	private int coolDown;
	private int coolDownCounter;

	public Tower(int x, int y, BufferedImage image) {
		super(x, y, image);
		this.coolDownCounter = 0;
	}

	public Tower(int x, int y, BufferedImage image, int width, int height) {
		super(x, y, image, width, height);
		this.coolDownCounter = 0;
	}
	
	@Override
	public void drawTheImage(Graphics g){
		super.drawTheImage(g);
		if(this.coolDownCounter > 0){
			this.coolDownCounter--;
		}	
		
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getCoolDown() {
		return coolDown;
	}

	public void setCoolDown(int coolDown) {
		this.coolDown = coolDown;
	}

}
