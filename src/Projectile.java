import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Projectile extends MovingTowerDefenseObject {

  protected int damage;
  protected double velocityProjectile;
  protected double velocityProjectileX;
  protected double velocityProjectileY;

  public Projectile(){
    super();
    this.damage = 1;
  }
  public Projectile(int x, int y, BufferedImage image, double velocityX, double velocityY, int damage){
    super(x, y, image, velocityX, velocityY);
    this.damage = damage;
    this.velocityProjectile = velocityProjectile;
    this.velocityProjectileX = velocityProjectileX;
    this.velocityProjectileY = velocityProjectileY;
  }


    public Projectile(int x, int y, BufferedImage image ,int width, int height, double velocityX, double velocityY, int damage){
      super(x, y, image, width, height,  velocityX, velocityY);
      this.damage = damage;
      this.velocityProjectileX = velocityProjectileY;
      this.velocityProjectileY = velocityProjectileY;

    }

    public Projectile(Projectile p){
      super();
      this.x = p.x;
      this.y = p.y;
      this.velocityProjectile = p.velocityProjectile;
      this.velocityProjectileX = p.velocityProjectileX;
      this.velocityProjectileY = p.velocityProjectileX;
      this.image = p.image;
      this. width = p.width;
      this.height = p.height;
      this.damage = p.damage;
    }

    public void fireAtEnemy(Enemy e){
      this.x -= e.x;
      this.y -= e.y;
      this.velocityProjectileX = this.x;
      this.velocityProjectileY = this.y;
    }

    public void setDamage(int damage){
      this.damage = damage;
    }

    public int getDamage(){
      return damage;
    }
     public void setVelocityProjectileX (int velocityProjectileX){
       this.velocityProjectileX = velocityProjectileX;

     }
     public void setVelocityProjectileY (int velocityProjectileY){
       this.velocityProjectileY = velocityProjectileY;

     }
     public double getVelocityProjectileX(){
       return velocityProjectileX;

     }
     public double getVelocityProjectileY(){
       return velocityProjectileY;

     }


}
