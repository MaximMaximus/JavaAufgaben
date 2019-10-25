package pack1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Var.moveup = true;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Var.movedown = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Var.moveup = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Var.movedown = false;
		}

	}

}
