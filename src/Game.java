import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;


public class Game extends JPanel implements KeyListener{

	protected BufferedImage background;
	protected TowerDefenseObject tower;
	protected TowerDefenseObject tower2;
	protected Enemy enemy;
	public boolean isPaused;
	public boolean isPlaying;
	public double temp;
	public int key;

	public Game(){
		super();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		try {
			this.isPlaying = true;
			this.background = ImageIO.read(new File("background.png"));
			BufferedImage towerImage = ImageIO.read(new File("enemy.jpg"));
			BufferedImage enemyImage = ImageIO.read(new File("ball.jpeg"));
			this.tower = new MovingTowerDefenseObject(80,150,towerImage, 0, 0);
			this.enemy = new Enemy(550, 240, enemyImage, 50, 0, 100);
			this.tower2 = new MovingTowerDefenseObject(80, 250, towerImage, 0, 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void paint(Graphics g){

		g.drawImage(this.background, 0, 0, 580, 500, null );

		try{
			if (this.isPlaying) {
				this.enemy.runLogic();
				this.tower.runLogic();
				this.tower2.runLogic();
			}
			this.enemy.drawTheImage(g);
			this.tower.drawTheImage(g);
			this.tower2.drawTheImage(g);
			Thread.sleep(500);
			repaint();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
	    int key = e.getKeyCode();
	    if (key == KeyEvent.VK_SPACE){
	      this.isPlaying = !this.isPlaying;
	    }
	}
}
