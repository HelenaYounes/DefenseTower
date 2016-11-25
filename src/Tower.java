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
		if (this.canFire) {
			this.projectile = null;
		}
		else{
			this.coolDownCounter = 10;
			int x = this.x;
			int y = this.y;
			BufferedImage projectileImage = this.projectileImage;
			double vy = ;
			double vx; = 
			int damage = ;
			this.projectile = new Projectile (this.tower.x, this.tower.Y, this.projectileImage, this.projectile.velocityX, , dmg );
			this.projectile.fireAtEnemy(e);
		}

		return this.projectile;
	}

	public boolean canFire(){
		this.canFire = false;
		if(this.coolDownCounter<1){
			this.canFire = true;
		}
		return canFire;
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

	public void mouseClicked(MouseEvent e) {
//		if( e.getPoint ==  )
		System.out.println(e);

	}



}
