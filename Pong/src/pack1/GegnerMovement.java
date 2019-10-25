package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class GegnerMovement {
	Timer move;

	public GegnerMovement() {
		// TODO Auto-generated constructor stub
		move = new Timer();
		move.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (Var.ballx >= Var.screenwidth / 2 - 10) {
					if (Var.bally == Var.gegnery) {

					} else if (Var.bally > Var.gegnery + 75) {
						if (Var.gegnery <= Var.screenheight - 200) {
							Var.gegnery += 2;
						}
					} else if (Var.bally < Var.gegnery + 75) {
						if (Var.gegnery >= 20) {
							Var.gegnery -= 2;
						}
					}
				}

			}

		}, 0, 6);
	}

}
