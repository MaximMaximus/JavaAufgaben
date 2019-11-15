package viergewinnt;

public class Spieler {
	
	private String playerName;
	private int playerY;
	private int playerX;
	private char playerSymbol;
	private boolean gewonnen;
	
	public Spieler(String name, char symbol) {
		this.playerName = name;
		this.playerSymbol = symbol;
		this.playerY = 0;
		this.playerX = 0;
	}
	
	public boolean isGewonnen() {
		return gewonnen;
	}

	public void setGewonnen(boolean gewonnen) {
		this.gewonnen = gewonnen;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerY() {
		return playerY;
	}

	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}

	public int getPlayerX() {
		return playerX;
	}

	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}

	public char getPlayerSymbol() {
		return playerSymbol;
	}

	public void setPlayerSymbol(char playerSymbol) {
		this.playerSymbol = playerSymbol;
	}
	
}
