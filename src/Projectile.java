import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Projectile extends MovingTowerDefenseObject {
  protected int damage;
  protected double velocity;

  public Projectile(int x, int y, BufferedImage image, int damage, double velocity){
    super(x, y, image, 0.0, 0.0);
    this.damage = damage;
    this.velocity = velocity;

  }
    public Projectile(int x, int y, BufferedImage image, double velocity, int damage) {
      super(x, y, image, 0.0, 0.0);
      this.velocity = velocity;
      this.damage = damage;
    }
    public Projectile(int x, int y, BufferedImage image, int width, int height, double velocity, int damage) {
      super(x, y, image, width, height, 0.0, 0.0);
      this.velocity = velocity;
      this.damage = damage;
    }

    public Projectile(Projectile p){
      super(p.x, p.y, p.image, p.width, p.height, p.velocityX, p.velocityY );
      this.velocity = p.velocity; 
      this.damage = p.damage;
    }

    public void fireAtEnemy(Enemy e){
      double angle = Math.atan2(x, y);
      this.velocityX = Math.cos(angle) * this.velocity;
      this.velocityY = Math.sin(angle) * this.velocity;
      this.x += this.velocityX;
      this.y += this.velocityY;
    }


    public void drawTheImage(Graphics g) {
      super.drawTheImage(g);
    }

    public void runLogic(){
      this.x = (int) (this.x + this.velocityY);
      this.y = (int) (this.y + this.velocity);

    }

    public void setDamage(int damage){
      this.damage = damage;
    }

    public int getDamage(){
      return damage;
    }
     public void setVelocityProjectileX (int velocityX){
       this.velocityX = velocityX;

     }
     public void setVelocityProjectileY (int velocityY){
       this.velocityY = velocityY;

     }
     public double getVelocityProjectileX(){
       return velocityX;

     }
     public double getVelocityProjectileY(){
       return velocityY;

     }


}
