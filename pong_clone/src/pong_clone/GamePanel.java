package pong_clone;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.lang.System.Logger;
import java.util.ResourceBundle;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	final int originalTileSize = 16;
	final int scale = 3;

	final int tileSize = originalTileSize * scale;

	final int maxScreenCols = 16;

	final int maxScreenRows = 12;

	final int screenWidth = tileSize * maxScreenCols;
	final int screenHeight = tileSize * maxScreenRows;

	final int fps = 60;

	final int playerInitialX = 20;
	final int playerInitialY = 10;

	final int player2InitialX = screenWidth - 40;
	final int player2InitialY = 10;

	Ball ball = new Ball(this);

	int ballDirectionX = ball.ballX - ball.ballSpeed;
	int ballDirectionY = ball.ballY - ball.ballSpeed;

	Thread gameThread;

	KeyHandler keyHandler;
	Player player;

	KeyHandler keyHandler2 = new KeyHandler(KeyEvent.VK_I, KeyEvent.VK_K);
	Player player2 = new Player(this, keyHandler2, player2InitialX, player2InitialY);
	int paddleSpeed = 8;

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setupPlayer();
		this.setDoubleBuffered(true);
		this.addKeyListener(keyHandler2);
		this.setFocusable(true);
	}

	public void setupPlayer() {
		keyHandler = new KeyHandler(KeyEvent.VK_W, KeyEvent.VK_S);
		player = new Player(this, keyHandler, playerInitialX, playerInitialX);
		this.addKeyListener(keyHandler);
	}

	public void start() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		double drawInterval = 1000000000 / fps;
		double nextDrawTime = System.nanoTime() + drawInterval;

		while (gameThread != null) {
			update();

			repaint();

			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime /= 1000000;

				if (remainingTime < 0) {
					remainingTime = 0;
				}

				Thread.sleep((long) remainingTime);
				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void update() {

		player.update(paddleSpeed, screenHeight);

		player2.update(paddleSpeed, screenHeight);

		ball.checkCollision(player);

		ball.checkCollision(player2);

		ball.update();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		player.paintPlayerPaddle(g2d);
		player2.paintPlayerPaddle(g2d);
		ball.paintBall(g2d);

		g2d.dispose();
	}

}
