import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Projectile extends MovingTowerDefenseObject {

  protected int damage;
  protected double velocity;
  protected double velocityX;
  protected double velocityY;

  public Projectile(){
    super();
    this.damage = 1;
  }
  public Projectile(int x, int y, BufferedImage image, double velocityX, double velocityY, int damage){
    super(x, y, image, velocityX, velocityY);
    this.damage = damage;
    this.velocity = velocity;
    this.velocityX = velocityX;
    this.velocityY = velocityY;
  }


    public Projectile(int x, int y, BufferedImage image ,int width, int height, double velocityX, double velocityY, int damage){
      super(x, y, image, width, height,  velocityX, velocityY);
      this.damage = damage;
      this.velocityX = velocityY;
      this.velocityY = velocityY;

    }

    public Projectile(Projectile p){
      super();
      this.x = p.x;
      this.y = p.y;
      this.velocity = p.velocity;
      this.velocityX = p.velocityX;
      this.velocityY = p.velocityX;
      this.image = p.image;
      this. width = p.width;
      this.height = p.height;
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
