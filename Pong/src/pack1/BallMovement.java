package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class BallMovement {
Timer move;
	public BallMovement() {
		// TODO Auto-generated constructor stub
		move = new Timer();
		move.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Var.ballx += Var.balldirx;
				Var.bally += Var.balldiry;
			}
			
		}, 0, 2);
		
	}

}
