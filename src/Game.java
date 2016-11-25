import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;


public class Game extends JPanel implements KeyListener, MouseListener, MouseMotionListener{

	protected BufferedImage background;
	protected TowerDefenseObject tower;
	protected TowerDefenseObject tower2;
	protected Enemy enemy;
	protected Enemy[] enemies;
	protected Tower[] towers;
	protected Projectile[] projectiles;


	public boolean isPaused;
	public boolean isPlaying;
	//
	public TowerDefenseObject towerSelected;
	//
	public double temp;
	public int key;

	public Game(){
		super();
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		try {
			this.isPlaying = true;
			this.background = ImageIO.read(new File("background.png"));
			BufferedImage towerImage = ImageIO.read(new File("enemy.jpg"));
			BufferedImage enemyImage = ImageIO.read(new File("ball.jpeg"));
			BufferedImage projectileImage = ImageIO.read(new File("projectile.jpg"));
			this.initializeEnemies(5, enemyImage);
			this.initializeTowers(3, 10, towerImage, projectileImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initializeEnemies(int num, BufferedImage img) {
		this.enemies = new Enemy[num];
		for (int i = 0; i < num; i++) {
			this.enemies[i] = new Enemy(500 + 20*i, 300, img, 100.0, 0.0, 50);
		}
	}

	public void initializeTowers(int num, int fleche, BufferedImage imgTower, BufferedImage imgProjectile) {
		this.towers = new Tower[num];
		this.projectiles = new Projectile[fleche];
		for (int i = 0; i < num; i++) {
			this.towers[i] = new Tower(100, 150 * i ,imgTower, 50, 40);
			Tower tower = this.towers[i];
			for(int j = 0; j < projectiles.length; j++){
				this.projectiles[j] = new Projectile(tower.x,tower.y, imgProjectile, 50.0, 40.0, 10);
			}
		}
	}

	public void runLogic() {
		for (int i = 0; i < this.enemies.length; i++) {
			this.enemies[i].runLogic();
		}
		for (int j = 0; j < this.towers.length; j++) {
			this.towers[j].runLogic();
			this.towers[j].fireAtEnemy(this.enemies[j]);
		}
		 for(int k = 0; k < this.projectiles.length; k++){
			 this.projectiles[k].runLogic();
		 }
	}

	public void drawComponents(Graphics g) {
		for (int i = 0; i < this.enemies.length; i++) {
			this.enemies[i].drawTheImage(g);
		}
		for (int j = 0; j < this.towers.length; j++) {
			this.towers[j].drawTheImage(g);
		}
		for(int k = 0; k < this.projectiles.length; k++){
			this.projectiles[k].drawTheImage(g);
		}

	}


	public void paint(Graphics g){

		g.drawImage(this.background, 0, 0, 580, 500, null );

		try{

			// GAME LOGIC
			if (this.isPlaying) {
				this.runLogic();
			}
			// RENDER COMPONENTS
			this.drawComponents(g);

			// WAIT 500ms to ANIMATE
			if ( this.towerSelected == null) {
				Thread.sleep(500);
			}
			repaint();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent arg0) { }

	public void mouseExited(MouseEvent arg0) { }

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		//check towers if cliked
		for ( int i = 0; i < this.towers.length; i++){
			boolean contains = this.towers[i].contain(x, y);
			//
			if (contains == true){
				this.isPlaying = false;
				this.towerSelected = this.towers[i];
				System.out.println("Hello");
			}
		}

	}

	public void mouseReleased(MouseEvent e) 	{
		if (this.towerSelected != null) {
			this.towerSelected = null;
			this.isPlaying = true;
			System.out.println("released");
		}
	 }

 	public void mouseMoved(MouseEvent e){
 	}

	public void mouseDragged(MouseEvent e) 	{
		if ( this.towerSelected != null) {
			this.towerSelected.x = e.getX();
			this.towerSelected.y = e.getY();
			repaint();
			System.out.println("dragging");
		}
		System.out.println("moved");

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
