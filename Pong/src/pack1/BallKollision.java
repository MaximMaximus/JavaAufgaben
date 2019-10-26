package pack1;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

public class BallKollision {
	Timer kollision;

	public BallKollision() {
		// TODO Auto-generated constructor stub
		kollision = new Timer();
		kollision.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (Var.bally + 50 >= Var.screenheight) {
					Var.balldiry = -1;
				}

				if (Var.bally <= 20) {
					Var.balldiry = 1;
				}

				if (Var.ballx + 30 >= Var.screenwidth) {
					Var.ballx = Var.screenwidth / 2 - 10;
					Var.bally = Var.screenheight / 2 - 10;

					Var.balldirx = -1;
					Var.playerPoints += 1;
				}

				if (Var.ballx <= 0) {
					Var.ballx = Var.screenwidth / 2 - 10;
					Var.bally = Var.screenheight / 2 - 10;

					Var.balldirx = 1;
					Var.gegnerPoints += 1;
				}

				if (Var.ballx < Var.x + 25 && Var.ballx > Var.x && Var.bally - 20 < Var.y + 150 && Var.bally > Var.y) {
					Var.balldirx = 1;
					// PlayerColor blue
					Var.playerColor = Draw.itemColor(true);
					// EnemyColor red
					Var.enemyColor = Draw.itemColor(false);
				}
				if (Var.ballx < Var.gegnerx && Var.ballx > Var.gegnerx - 20 && Var.bally - 20 < Var.gegnery + 150
						&& Var.bally > Var.gegnery) {
					Var.balldirx = -1;
					// PlayerColor red
					Var.playerColor = Draw.itemColor(false);
					// EnemyColor blue
					Var.enemyColor = Draw.itemColor(true);
				}
				
				if(Var.playerPoints > Var.gegnerPoints) {
					Var.playerScoreColor = Draw.itemColor(true);
					Var.gegnerScoreColor = Draw.itemColor(false);
				} else if (Var.gegnerPoints > Var.playerPoints) {
					Var.playerScoreColor = Draw.itemColor(false);
					Var.gegnerScoreColor = Draw.itemColor(true);
				} else {
					Var.playerScoreColor = Color.WHITE;
					Var.gegnerScoreColor = Color.WHITE;
				}
				
			}

		}, 0, 5);
	}

}
