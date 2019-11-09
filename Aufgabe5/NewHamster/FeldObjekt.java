package hamsterprogramm;

public class FeldObjekt {
	
	public FeldObjekt(char symbol) {
		super();
		this.symbol = symbol;
	}
	
	private char symbol;

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

}
