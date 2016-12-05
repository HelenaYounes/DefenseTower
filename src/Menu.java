import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Graphics;
import java.awt.BorderLayout;


public class Menu extends JPanel {

	public int score;
	public JLabel scoreBoard;
	
	public Menu(){
		super();

	    BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
	    this.setVisible(true);
	    this.setLayout(layout);
//		this.setLayout(new BorderLayout());
		JButton start = new JButton("START");
		JButton pause = new JButton("PAUSE");
		JButton reset = new JButton("RESET");
		reset.setVisible(true);
		start.setVisible(true);
		pause.setVisible(true);
//		this.scoreBoard = new JLabel("HI");
//		this.scoreBoard.setVisible(true);

		add(start);
		add(pause);
		add(reset);
//		this.add(scoreBoard);

		pause.requestFocusInWindow();
		repaint();
	}
	
	public void paint(Graphics g){
	}
}
