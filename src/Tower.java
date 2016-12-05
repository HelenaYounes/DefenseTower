import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;


public class Tower extends TowerDefenseObject {
	protected int radius;
	protected int speed;
	protected int coolDown;
	protected int coolDownCounter;
	protected Projectile projectile;
	protected boolean canFire;

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
		this.coolDownCounter = 5;
	}

	@Override
	public void drawTheImage(Graphics g) {
		super.drawTheImage(g);
	}

	public void runLogic() {
		if(this.coolDownCounter > 0){
			this.coolDownCounter -= this.speed;
		}
	}

	public Projectile fireAtEnemy(Enemy e){
		if (this.canFire) {
			this.projectile = null;
		} else {
			this.coolDownCounter = 10;
			int x = this.x;
			int y = this.y;
			double velocity = 50.0;
			int dmg = 10;
			int size = 10;
			BufferedImage projectileImage = this.projectileImage;
			this.projectile = new Projectile(
				x,
				y,
				this.projectileImage,
				size,
				size,
				velocity,
				dmg
			);
			this.projectile.fireAtEnemy(e);
		}

		return this.projectile;
	}

	public boolean canFire(){
		return (this.coolDownCounter < 1);
	}

	public int getRadius() {
		return this.radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getSpeed() {
		return this.speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setCoolDown(int coolDown) {
		this.coolDown = coolDown;
	}
	public int getCoolDown() {
		return this.coolDown;
	}

	public void mouseClicked(MouseEvent e) {
//		if( e.getPoint ==  )
		System.out.println(e);

	}



}
