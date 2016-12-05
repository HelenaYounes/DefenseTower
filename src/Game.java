import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;


public class Game extends JPanel implements KeyListener, MouseListener, MouseMotionListener{

	protected BufferedImage background;
	protected TowerDefenseObject tower;
	protected TowerDefenseObject tower2;
	protected ArrayList<Enemy> enemies;
	protected ArrayList<Enemy> enemiesInit;
	protected ArrayList<Tower> towers;
	protected ArrayList<Projectile> projectiles;


	public boolean isPaused;
	public boolean isPlaying;
	public int WIDTH;
	public int HEIGHT;
	//
	public TowerDefenseObject towerSelected;
	//
	public double temp;
	public int key;

	public Game(){
		super();
		this.WIDTH = 580;
		this.HEIGHT = 500;
//		addActionListener(this);
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
			this.initializeEnemies(6, enemyImage);
			this.initializeTowers(3, towerImage, projectileImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void initializeEnemies(int num, BufferedImage img) {
		this.enemies = new ArrayList<Enemy>();
		this.enemiesInit = new ArrayList<Enemy>();
		for (int i = 0; i < num; i++) {
			this.enemiesInit.add(new Enemy(0, 300, img, 5.0, 0.0, 50));
		}
	}

	public void initializeTowers(int num, BufferedImage imgTower, BufferedImage imgProjectile) {
		this.towers = new ArrayList<Tower>();
		this.projectiles = new ArrayList<Projectile>();

		for (int i = 0; i < num; i++) {
			this.towers.add(new Tower(100, 150 * i ,imgTower, 50, 40));
		}
	}
	public void addWaitingEnemies() {
		if (this.enemiesInit.size() < 1) return;
		if (this.enemies.size() > 0) {
			Enemy lastEnemy = this.enemies.get(this.enemies.size() - 1);
			if (lastEnemy.x < lastEnemy.width) {
				return;
			}
		}
		Enemy enemy = enemiesInit.get(0);
		this.enemies.add(enemy);
		enemiesInit.remove(0);
	}

	public void runLogic() {
		this.addWaitingEnemies();

		for (int i = 0; i < this.enemies.size(); i++) {
			this.enemies.get(i).runLogic();
		}

		for (int j = 0; j < this.towers.size(); j++) {
			Tower tower = this.towers.get(j);
			tower.runLogic();
			if (tower.canFire() && this.enemies.size() > 0) {
				Projectile p = tower.fireAtEnemy(this.enemies.get(0));
				this.projectiles.add(p);
			}
		}

		 for(int k = 0; k < this.projectiles.size(); k++){
			 Projectile p = this.projectiles.get(k);
			 p.runLogic();
			 if (this.checkProjectileCollision(p)) {
				 this.projectiles.remove(k);
			 }
		 }
	}

	public boolean inBounds(TowerDefenseObject o) {
		if (o.x < 0 || o.x > this.WIDTH || o.y < 0 || o.y > this.HEIGHT) {
			return false;
		} else {
			return true;
		}
	}

	public boolean checkProjectileCollision(Projectile projectile) {
		if ( !this.inBounds(projectile) ) {
			return true;
		}
		for (int l = 0; l < this.enemies.size(); l++) {
			Enemy e = this.enemies.get(l);
			if (e.contain(projectile.x, projectile.y)) {
				e.hit(projectile.getDamage());
				if ( e.getHealth() <= 0 ) {
					this.enemies.remove(l);
				}
				return true;
			}
		}
		return false;
	}

	public void drawComponents(Graphics g) {
		for (int i = 0; i < this.enemies.size(); i++) {
			this.enemies.get(i).drawTheImage(g);
		}
		for (int j = 0; j < this.towers.size(); j++) {
			this.towers.get(j).drawTheImage(g);
		}
		for(int k = 0; k < this.projectiles.size(); k++){
			this.projectiles.get(k).drawTheImage(g);
		}

	}


	public void paint(Graphics g){

		g.drawImage(this.background, 0, 0, this.WIDTH, this.HEIGHT, null );

		try{

			// GAME LOGIC
			if (this.isPlaying) {
				this.runLogic();
			}
			// RENDER COMPONENTS
			this.drawComponents(g);

			// WAIT 500ms to ANIMATE
			if ( this.towerSelected == null) {
				Thread.sleep(100);
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
		for ( int i = 0; i < this.towers.size(); i++){
			if (this.towers.get(i).contain(x, y)){
				this.isPlaying = false;
				this.towerSelected = this.towers.get(i);
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

	public void start() {
		this.isPlaying = true;
	}

	public void stop() {
		this.isPlaying = false;
	}
}
