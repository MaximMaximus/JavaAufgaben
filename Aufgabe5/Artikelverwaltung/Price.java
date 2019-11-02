package artikelverwaltung;

public class Price {
	private double value;
	private String currency;

	public Price(double val, String curr) {
		this.setValue(val);
		this.setCurrency(curr);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return this.value + " " + this.currency;
	}
	
	
}
