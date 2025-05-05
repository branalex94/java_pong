package pong_clone;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	public boolean upPressed, downPressed;

	private int upKey;
	private int downKey;

	private boolean isAi;

	public KeyHandler(int upKey, int downKey, boolean isAi) {
		this.upKey = upKey;
		this.downKey = downKey;
		this.isAi = isAi;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (isAi == false) {
			int code = e.getKeyCode();
			if (code == upKey) {
				upPressed = true;
			}
			if (code == downKey) {
				downPressed = true;
			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (isAi == false) {
			int code = e.getKeyCode();

			if (code == upKey) {
				upPressed = false;
			}
			if (code == downKey) {
				downPressed = false;
			}
		}
	}

}
