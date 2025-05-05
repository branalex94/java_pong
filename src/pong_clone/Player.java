package pong_clone;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player {

	public int x;
	public int y;
	public int playerWidth;
	public int playerHeight;
	public boolean isColliding;

	public KeyHandler keyHandler;

	public GamePanel gamePanel;

	public Player(GamePanel gamePanel, KeyHandler keyHandler, int playerInitialX, int playerInitialY) {
		this.gamePanel = gamePanel;
		this.keyHandler = keyHandler;
		this.x = playerInitialX;
		this.y = playerInitialY;
		playerWidth = 14;
		playerHeight = 80;
	}

	public void paintPlayerPaddle(Graphics2D g2d) {
		g2d.setColor(Color.white);

		g2d.fillRect(x, y, playerWidth, playerHeight);

	}

	public void update(int paddleSpeed, int screenHeight) {
		if (keyHandler.upPressed == true) {
			y -= paddleSpeed;
		} else if (keyHandler.downPressed == true) {
			y += paddleSpeed;
		}

		if (y <= 0) {
			y = 0;
		}
		if (y + playerHeight >= screenHeight) {
			y = screenHeight - playerHeight;
		}
	}

}
