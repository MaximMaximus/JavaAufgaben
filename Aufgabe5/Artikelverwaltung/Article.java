package artikelverwaltung;

public class Article {
	private int articlenumber;
	private String description;
	private Price price;
	private Color color;

	public Article(int number, String text, Price value, Color rgb) {
		this.setArticlenumber(number);
		this.setDescription(text);
		this.setPrice(value);
		this.setColor(rgb);
	}

	public int getArticlenumber() {
		return articlenumber;
	}

	public void setArticlenumber(int articlenumber) {
		this.articlenumber = articlenumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Article:\narticlenumber = " + articlenumber + ",\ndescription = " + description + ",\nprice = "
				+ this.getPrice().toString() + ",\ncolor = " + this.getColor().toString() + "\n-- --\n";
	}

}
