import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JPanel implements ActionListener{

	public JLabel scoreBoard;
	public JButton start;
	public JButton pause;
	public JButton reset;
	public Game game;

	public Menu(Game game){
		super();
		this.game = game;
	    BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
	    this.setVisible(true);
	    this.setLayout(layout);
//		this.setLayout(new BorderLayout());
		this.start = new JButton("START");
		this.start.addActionListener(this);
		this.pause = new JButton("PAUSE");
		this.pause.addActionListener(this);
		this.reset = new JButton("RESET");
//		reset.addActionListener(this);
		this.reset.setVisible(true);
		this.start.setVisible(true);
		this.pause.setVisible(true);
		String score = this.game.getScore();
		this.scoreBoard = new JLabel();
		this.scoreBoard.setVisible(true);

		add(start);
		add(pause);
		add(reset);
//		this.add(scoreBoard);

		pause.requestFocusInWindow();
		repaint();
	}

	public void actionPerformed(ActionEvent e){
		if	(e.getSource() == this.pause){
			this.game.stop();

		}
		
		else if(e.getSource() == this.start){
		
				this.game.start();
		}
    }
		


	public void paint(Graphics g){
	}


}
