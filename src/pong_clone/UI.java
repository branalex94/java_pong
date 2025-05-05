package pong_clone;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {
	public int p1Score = 0;
	public int p2Score = 0;
	public boolean showScore = true;
	Font font_arial = new Font("Arial", Font.BOLD, 40);

	GamePanel gamePanel;

	public UI(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	public void paintUI(Graphics2D g2d) {
		if (showScore) {
			String scoreText = p1Score + " - " + p2Score;
			int textWidth = (int) g2d.getFontMetrics().getStringBounds(scoreText, g2d).getWidth();
			g2d.setFont(font_arial);
			g2d.setColor(Color.white);
			g2d.drawString(scoreText, gamePanel.screenWidth / 2 - textWidth, 40);
			g2d.dispose();
		}
	}
}
