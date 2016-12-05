import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JPanel implements ActionListener{

	public JLabel score;
	public JLabel lives;
	public JLabel money;
	public JButton add;
	public JButton start;
	public JButton pause;
	public JButton reset;
	public Game game;
	public Tower towerA;

	public Menu(Game game){
		super();
		this.game = game;
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setVisible(true);
		this.setLayout(layout);
		// this.setLayout(new BorderLayout());
		this.start = new JButton("START");
		this.start.addActionListener(this);
		this.add = new JButton("ADD TOWER");
		this.add.addActionListener(this);
		this.pause = new JButton("PAUSE");
		this.pause.addActionListener(this);
		// this.reset = new JButton("RESET");
		// reset.addActionListener(this);
		this.score = new JLabel();
		this.lives = new JLabel();
		this.money = new JLabel();
		this.score.setVisible(true);
		this.add(start);
		this.add(pause);
		this.add(add);
		// this.add(reset);
		this.add(this.score);
		this.add(this.money);
		this.add(this.lives);
	}

	public void actionPerformed(ActionEvent e){
		if	(e.getSource() == this.pause) {
			this.game.stop();
		} else if (e.getSource() == this.start) {
			this.game.start();
		} else if (e.getSource() == this.add) {
			this.game.addTower(300, 2, 10);
		}
	}



	public void paint(Graphics g) {
		super.paint(g);
		this.score.setText("Score: " + game.getScore());
		this.money.setText("Lives: " + game.getLives());
		this.lives.setText("Money: " + game.getMoney());
		repaint();
	}


}
