package pong_clone;

import java.awt.Graphics2D;

public class Ball {
	GamePanel gamePanel;
	public boolean collision = false;

	public boolean isRight, isLeft, isDown, isUp;

	public boolean freeze = false;

	public int ballX = 0;
	public int ballY = 0;

	int ballHeight = 12;
	int ballWidth = 12;
	public int initialBallSpeed = 4;
	int ballSpeed = 4;

	final int maxBallSpeed = 20;

	int touchCounter = 0;

	public Ball(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		setup();
	}

	public void resetBallSpeed() {
		ballSpeed = initialBallSpeed;
	}

	public void setup() {
		isLeft = true;
		isUp = true;
		isRight = false;
		isDown = false;
		ballX = gamePanel.screenWidth / 2;
		ballY = gamePanel.screenHeight / 2;
	}

	public void update() {
		if (freeze == false) {
			if (isUp) {
				ballY = ballY - ballSpeed;
			}
			if (isDown) {
				ballY = ballY + ballSpeed;
			}
			if (isLeft) {
				ballX = ballX - ballSpeed;
			}
			if (isRight) {
				ballX = ballX + ballSpeed;
			}
		}
	}

	public void checkCollision(Player player) {
		if (ballY <= 0) {
			isDown = true;
			isUp = false;
		} else if (ballY + ballHeight >= gamePanel.screenHeight) {
			isDown = false;
			isUp = true;
		}
		// Chequea colision en el lado derecho de la paleta
		if (((ballX <= player.x + player.playerWidth && ballX > player.x)
				|| (ballX + ballWidth >= player.x + player.playerWidth && ballX < player.x))
				&& (ballY <= player.y + player.playerHeight && ballY >= player.y)) {
			setCollision();
		} else if ((ballX + ballWidth >= player.x && ballX + ballWidth < player.x + player.playerWidth)
				&& (ballY + ballWidth >= player.y
						&& ballY + ballWidth + ballHeight <= player.y + player.playerWidth + player.playerHeight)) {
			setCollision();
		}
		if (ballX <= 0 || ballX >= gamePanel.screenWidth) {
			setup();
		}
	}

	public void handlePlayerScore() {
		if (this.freeze == true && gamePanel.scored == true) {
			if (ballX <= 0) {
				gamePanel.incrementp1Score();
			} else if (ballX >= gamePanel.screenWidth) {
				gamePanel.incrementp2Score();
			}
		}
		gamePanel.scored = false;
	}

	public void setCollision() {
		collision = true;
		if (collision && touchCounter == 5 && ballSpeed < maxBallSpeed) {
			ballSpeed++;
			touchCounter = 0;
		}
		if (isLeft && collision) {
			isLeft = false;
			isRight = true;
			collision = false;
		}

		if (isRight && collision) {
			isRight = false;
			isLeft = true;
			collision = false;
		}
		touchCounter++;
	}

	public void paintBall(Graphics2D g2d) {
		g2d.fillRect(ballX, ballY, ballWidth, ballHeight);
	}

}
