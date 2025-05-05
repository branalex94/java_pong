package pong_clone;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameStateKeyHandler implements KeyListener {
	public boolean pausePressed;

	private int pauseKey = KeyEvent.VK_SPACE;

	GamePanel gamePanel;

	public GameStateKeyHandler(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == pauseKey) {
			pausePressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == pauseKey) {
			if (gamePanel.ball.freeze == true) {
				gamePanel.resumeMatch();				
			}
			pausePressed = false;
		}
	}
}
