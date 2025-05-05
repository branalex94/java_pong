package pong_clone;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player {

	public int x;
	public int y;
	public int playerWidth;
	public int playerHeight;
	public boolean isColliding;

	public boolean isAi;

	public int initialX;
	public int initialY;

	public KeyHandler keyHandler;

	public GamePanel gamePanel;

	public Player(GamePanel gamePanel, KeyHandler keyHandler, int playerInitialX, int playerInitialY, boolean isAi) {
		this.gamePanel = gamePanel;
		this.keyHandler = keyHandler;
		this.x = playerInitialX;
		this.y = playerInitialY;
		this.initialX = playerInitialX;
		this.initialY = playerInitialY;
		this.isAi = isAi;
		playerWidth = 14;
		playerHeight = 80;
	}

	public void resetPosition() {
		x = initialX;
		y = initialY;
	}

	public void paintPlayerPaddle(Graphics2D g2d) {
		g2d.setColor(Color.white);

		g2d.fillRect(x, y, playerWidth, playerHeight);

	}

	public void goUp() {
		y -= gamePanel.paddleSpeed;
	}

	public void goDown() {
		y += gamePanel.paddleSpeed;
	}

	public void update(int screenHeight) {
		if (keyHandler.upPressed == true) {
			goUp();
		} else if (keyHandler.downPressed == true) {
			goDown();
		}

		if (y <= 0) {
			y = 0;
		}
		if (y + playerHeight >= screenHeight) {
			y = screenHeight - playerHeight;
		}

		if (isAi) {
			handleAiActions();
		}
	}

	public void handleAiActions() {
		if (y < gamePanel.ball.ballY) {
			goDown();
		} else if (y > gamePanel.ball.ballY) {
			goUp();
		}
	}

}
