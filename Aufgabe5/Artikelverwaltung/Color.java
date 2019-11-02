package artikelverwaltung;

public class Color {
	private int red;
	private int green;
	private int blue;
	
	public Color(int r, int g, int b) {
		this.setRed(r);
		this.setGreen(g);
		this.setBlue(b);
	}
	
	public int getRed() {
		return red;
	}
	public void setRed(int red) {
		this.red = red;
	}
	public int getGreen() {
		return green;
	}
	public void setGreen(int green) {
		this.green = green;
	}
	public int getBlue() {
		return blue;
	}
	public void setBlue(int blue) {
		this.blue = blue;
	}

	@Override
	public String toString() {
		return red + " " + green + " " + blue;
	}
	
	

}
