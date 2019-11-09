package hamsterprogramm;

public class Hamster extends FeldObjekt {

	private String name;
	private int x;
	private int y;
	private int kornCounter;
	private LeeresFeld leeresFeld = new LeeresFeld(' ');

	public Hamster(char symbol) {
		super(symbol);
	}

	public Hamster(char symbol, String name, int x, int y, int kornCounter) {
		super(symbol);
		this.name = name;
		this.x = x;
		this.y = y;
		this.kornCounter = kornCounter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getKornCounter() {
		return kornCounter;
	}

	public void setKornCounter(int kornCounter) {
		this.kornCounter = kornCounter;
	}

	public void linksDrehen() {
		switch (this.getSymbol()) {
		case '^':
			this.setSymbol('<');
			break;
		case '<':
			this.setSymbol('v');
			break;
		case 'v':
			this.setSymbol('>');
			break;
		case '>':
			this.setSymbol('^');
			break;
		}
	}

	public void rechtsDrehen() {
		switch (this.getSymbol()) {
		case '^':
			this.setSymbol('>');
			break;
		case '>':
			this.setSymbol('v');
			break;
		case 'v':
			this.setSymbol('<');
			break;
		case '<':
			this.setSymbol('^');
			break;
		}
	}

	public FeldObjekt[][] laufVorwaerts(FeldObjekt[][] feld) {
		int neuX = 0;
		int neuY = 0;

		switch (this.getSymbol()) {
		case '^':
			neuX = this.getX();
			neuY = this.getY() - 1;
			break;
		case '>':
			neuX = this.getX() + 1;
			neuY = this.getY();
			break;
		case 'v':
			neuX = this.getX();
			neuY = this.getY() + 1;
			break;
		case '<':
			neuX = this.getX() - 1;
			neuY = this.getY();
			break;
		}
				
		if(feld[neuY][neuX].getClass().equals(Wand.class)) {
			System.out.println("Vorsicht Wand!");
		} else {
			if(feld[neuY][neuX].getClass().equals(Korn.class)) {
				System.out.println("Korn gefressen!");
				this.kornCounter++;
			}
			feld[this.getY()][this.getX()] = this.leeresFeld;
			feld[neuY][neuX] = this;
			this.setY(neuY);
			this.setX(neuX);
		}
		
		return feld;
	}

}
