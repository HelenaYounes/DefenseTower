import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Enemy extends MovingTowerDefenseObject {
  protected int health;

  public Enemy(int x, int y, BufferedImage image, double velocityX, double velocityY, int health){
    super(x, y, image, velocityX, velocityY);
    this.health = health;
  }

  public Enemy(int x, int y, BufferedImage image, int width, int height, double velocityX, double velocityY, int health){
    super(x, y, image, width, height);
    this.health = health;
  }

  public void setHealth(int health){
    this.health = health;
  }

  public int getHealth(){
    return this.health;
  }

  public void hit(int health){
    this.health -= health;
  }

}
