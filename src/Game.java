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


public class Game extends JPanel implements KeyListener, MouseListener{

	protected BufferedImage background;
	protected TowerDefenseObject tower;
	protected TowerDefenseObject tower2;
	protected Enemy enemy;
	protected Enemy[] enemies;
	protected Tower[] towers;


	public boolean isPaused;
	public boolean isPlaying;
	public double temp;
	public int key;

	public Game(){
		super();
		addKeyListener(this);
		addMouseListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		try {
			this.isPlaying = true;
			this.background = ImageIO.read(new File("background.png"));
			BufferedImage towerImage = ImageIO.read(new File("enemy.jpg"));
			BufferedImage enemyImage = ImageIO.read(new File("ball.jpeg"));
			this.initializeEnemies(5, enemyImage);
			this.initializeTowers(3, towerImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initializeEnemies(int num, BufferedImage img) {
		this.enemies = new Enemy[num];
		for (int i = 0; i < num; i++) {
			this.enemies[i] = new Enemy(540,  (i + 1) * 100, img, 100.0, 0.0, 50);
		}
	}

	public void initializeTowers(int num, BufferedImage img) {
		this.towers = new Tower[num];
		for (int i = 0; i < num; i++) {
			this.towers[i] = new Tower(100, 150 * i ,img, 50, 40);
		}
	}

	public void runLogic() {
		for (int i = 0; i < this.enemies.length; i++) {
			this.enemies[i].runLogic();
		}
		for (int j = 0; j < this.towers.length; j++) {
			this.towers[j].runLogic();
		}
	}

	public void drawComponents(Graphics g) {
		for (int i = 0; i < this.enemies.length; i++) {
			this.enemies[i].drawTheImage(g);
		}
		for (int j = 0; j < this.towers.length; j++) {
			this.towers[j].drawTheImage(g);
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
			Thread.sleep(500);
			repaint();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void mouseClicked(MouseEvent e) {
//		if( e.getPoint ==  )
		int x = e.getX();
		int y = e.getY();
		boolean contains = tower.contain(x, y);
		System.out.println(contains + " << ");

	}

	public void mouseEntered(MouseEvent arg0) { }

	public void mouseExited(MouseEvent arg0) { }

	public void mousePressed(MouseEvent arg0) { }

	public void mouseReleased(MouseEvent arg0) 	{ }


	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
	    int key = e.getKeyCode();
	    if (key == KeyEvent.VK_SPACE){
	      this.isPlaying = !this.isPlaying;
	    }
	}
}
