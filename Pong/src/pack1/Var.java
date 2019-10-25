package pack1;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class Var {

	static JFrame jf1;
	static int screenwidth = 800, screenheight = 600;

	static int x = 20, y = 185;
	static int gegnerx = 740, gegnery = 185;
	static int ballx = 600, bally = 400;

	static boolean moveup = false, movedown = false;

	static int balldirx = 1, balldiry = -1;

	static int playerPoints = 0, gegnerPoints = 0;

	static Font pixelfont;

	public Var() {
		// TODO Auto-generated constructor stub

		/*
		 * try { pixelfont = Font.createFont(Font.TRUETYPE_FONT, new
		 * File("coders_crux.ttf")).deriveFont(125f); GraphicsEnvironment ge =
		 * GraphicsEnvironment.getLocalGraphicsEnvironment();
		 * ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new
		 * File("coders_crux.ttf"))); } catch (FontFormatException | IOException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */

		try {
			pixelfont = Font.createFont(Font.TRUETYPE_FONT, Var.class.getResourceAsStream("coders_crux.ttf"))
					.deriveFont(125f);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(pixelfont);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
