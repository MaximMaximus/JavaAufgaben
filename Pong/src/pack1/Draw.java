package pack1;

import java.awt.*;

import javax.swing.JLabel;

public class Draw extends JLabel {

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Screen Background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Var.screenwidth, Var.screenheight);

		
		
		//int randR = (int) (Math.random() * 155 + 100);
		//int randG = (int) (Math.random() * 155 + 100);
		//int randB = (int) (Math.random() * 155 + 100);
		// Screen middleline
		g.setColor(Color.WHITE);
		for (int i = 0; i <= 30; i++) {
			//Color field = new Color(randR, randG, randB);
			//g.setColor(field);
			g.fillRect(Var.screenwidth / 2 - 5, i * 20, 10, 10);
		}

		// Player
		g.setColor(Var.playerColor);
		g.fillRect(Var.x, Var.y, 25, 150);
		g.setColor(Color.WHITE);
		g.drawRect(Var.x, Var.y, 25, 150);

		// gegner
		g.setColor(Var.enemyColor);
		g.fillRect(Var.gegnerx, Var.gegnery, 25, 150);
		g.setColor(Color.WHITE);
		g.drawRect(Var.gegnerx, Var.gegnery, 25, 150);

		// Draw playerscore
		g.setFont(Var.pixelfont);
		g.setColor(Var.playerScoreColor);
		g.drawString("" + Var.playerPoints, Var.screenwidth / 2 - 100, 75);
		
		// Draw gegnerscore
		g.setColor(Var.gegnerScoreColor);
		g.drawString("" + Var.gegnerPoints, Var.screenwidth / 2 + 55, 75);
		
		// Draw ball
		g.setColor(Color.WHITE);
		g.fillRect(Var.ballx, Var.bally, 20, 20);

		repaint();
	}

	public static Color itemColor(boolean collision) {
		Color color = Color.WHITE;
		if (collision == true) {
			color = new Color(0, 153, 255);
		} else {
			color = Color.RED;
		}
		return color;
	}

}
