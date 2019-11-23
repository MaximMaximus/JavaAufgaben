package viergewinnt;

public class Feld {

	private int yAchse = 6;
	private int xAchse = 7;
	private char feld[][] = new char[yAchse][xAchse];
	private char symbol;

	public int getyAchse() {
		return yAchse;
	}

	public int getxAchse() {
		return xAchse;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public char[][] getFeld() {
		return feld;
	}

	public void setFeld(int x, int y, char symbol) {
		this.feld[y][x] = symbol;
	}

	public void clearFeld() {
		for (int y = 0; y < yAchse; y++) {
			for (int x = 0; x < xAchse; x++) {
				this.feld[y][x] = ' ';
			}
		}
	}

	public boolean checkFull(int x) {
		int counter = 0;
		for (int y = 0; y < yAchse; y++) {
			if (this.feld[y][x] != ' ') {
				counter++;
			}
		}
		if (counter == yAchse) {
			return true;
		}
		return false;
	}

	public void placeSymbol(int x, char symbol) {
		for (int y = yAchse - 1; y >= 0; y--) {
			if (this.feld[y][x] == ' ') {
				this.feld[y][x] = symbol;
				break;
			}
		}
	}

	public void drawFeld() {
		System.out.println("| 1 | 2 | 3 | 4 | 5 | 6 | 7 |");
		System.out.println("-----------------------------");
		for (int i = 0; i < yAchse; i++) {
			for (int j = 0; j < xAchse; j++) {
				System.out.print("| " + feld[i][j] + " ");
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println("-----------------------------");
	}

	public boolean checkHorizontal(char symbol) {
		for (int y = 0; y < yAchse; y++) {
			for (int x = 0; x < xAchse; x++) {
				if (x < 4) {
					if (this.feld[y][x] == symbol && this.feld[y][x + 1] == symbol && this.feld[y][x + 2] == symbol
							&& this.feld[y][x + 3] == symbol) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean checkVertikal(char symbol) {
		for (int y = 0; y < yAchse; y++) {
			for (int x = 0; x < xAchse; x++) {
				if (y < 3) {
					if (this.feld[y][x] == symbol && this.feld[y + 1][x] == symbol && this.feld[y + 2][x] == symbol
							&& this.feld[y + 3][x] == symbol) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean checkDiagonalDown(char symbol) {
		for (int y = 0; y < yAchse; y++) {
			for (int x = 0; x < xAchse; x++) {
				if (y < 3 && x < 4) {
					if (this.feld[y][x] == symbol && this.feld[y + 1][x + 1] == symbol
							&& this.feld[y + 2][x + 2] == symbol && this.feld[y + 3][x + 3] == symbol) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean checkDiagonalUp(char symbol) {
		for (int y = 0; y < yAchse; y++) {
			for (int x = 0; x < xAchse; x++) {
				if (y > 2 && x < 4) {
					if (this.feld[y][x] == symbol && this.feld[y - 1][x + 1] == symbol
							&& this.feld[y - 2][x + 2] == symbol && this.feld[y - 3][x + 3] == symbol) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
