import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;


public class Tower extends TowerDefenseObject {
	protected int radius;
	protected int speed;
	protected int damage;
	protected int coolDown;
	protected int coolDownCounter;
	protected Projectile projectile;
	protected boolean canFire;

	public Tower(int x, int y, BufferedImage image) {
		super(x, y, image);
		this.radius = 10;
		this.speed = 2;
		this.coolDownCounter = 10;
		this.damage = 10;
	}

	public Tower(int x, int y, BufferedImage image, int width, int height) {
		super(x, y, image, width, height);
		this.radius = 5;
		this.speed = 2;
		this.coolDownCounter = 10;
		this.damage = 10;
	}

	public Tower(int x, int y, BufferedImage image, int width, int height, int speed, int damage) {
		super(x, y, image, width, height);
		this.radius = 5;
		this.speed = speed;
		this.damage = damage;
		this.coolDownCounter = 10;
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
			int x = this.x + this.width / 2;
			int y = this.y + this.height / 2;
			double velocity = 10.0;
			int size = 10;
			BufferedImage projectileImage = this.projectileImage;
			this.projectile = new Projectile(
				x,
				y,
				this.projectileImage,
				size,
				size,
				velocity,
				this.damage
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
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getDamage() {
		return this.damage;
	}

	public void mouseClicked(MouseEvent e) {
//		if( e.getPoint ==  )
		System.out.println(e);

	}



}
