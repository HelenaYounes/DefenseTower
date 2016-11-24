import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Tower extends TowerDefenseObject {
	protected int radius;
	protected int speed;
	protected int coolDown;
	protected int coolDownCounter;
	protected Projectile projectile;
	public Tower(int x, int y, BufferedImage image) {
		super(x, y, image);
		this.radius = 10;
		this.speed = 5;
		this.coolDownCounter = 5;
	}

	public Tower(int x, int y, BufferedImage image, int width, int height) {
		super(x, y, image, width, height);
		this.radius = 5;
		this.speed = 5;
		this.coolDownCounter = 3;
	}

	@Override
	public void drawTheImage(Graphics g) {
		super.drawTheImage(g);
	}

	public void runLogic() {
		if(this.coolDownCounter > 0){
			this.coolDownCounter--;
		}
	}

	public Projectile fireAtEnemy(Enemy e){
		if(coolDownCounter>0){
			this.projectile = null;
		}
		else{
			this.coolDownCounter = 10;
			Projectile projectile = new Projectile ();
			projectile.fireAtEnemy(e);
		}

		return this.projectile;
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

	public void setCoolDown(int coolDown) {
		this.coolDown = coolDown;
	}
	public int getCoolDown() {
		return coolDown;
	}


}
