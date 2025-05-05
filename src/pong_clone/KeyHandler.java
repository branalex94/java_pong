package pong_clone;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	public boolean upPressed, downPressed;

	private int upKey;
	private int downKey;

	public KeyHandler(int upKey, int downKey) {
		this.upKey = upKey;
		this.downKey = downKey;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == upKey) {
			upPressed = true;
		}
		if (code == downKey) {
			downPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();

		if (code == upKey) {
			upPressed = false;
		}
		if (code == downKey) {
			downPressed = false;
		}
	}

}
