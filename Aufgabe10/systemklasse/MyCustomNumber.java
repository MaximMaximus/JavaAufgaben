package systemklasse;

public class MyCustomNumber {
	
	private double _value;
	
	public MyCustomNumber(double value) {
		this._value = value;
	}
	
	public double getSquare() {
		return this._value * this._value;
	}
	
	public double doubleValue() {
		return (double) this._value;
	}
	
	public float floatValue() {
		return (float) this._value;
	}
	
	public int intValue() {
		return (int) this._value;
	}
	
	public long longValue() {
		return (long) this._value;
	}

}
