package pong_clone;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("pong clone");
		
		GamePanel gamePanel = new GamePanel();
		
		frame.add(gamePanel);
		
		frame.pack();
		
		frame.setVisible(true);
		
		gamePanel.start();
	}
}
