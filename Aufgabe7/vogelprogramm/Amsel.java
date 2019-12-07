package vogelprogramm;

public class Amsel extends Vogel implements KannFliegen {
	
	public String sayHello = "Mein Name ist";
		
	public Amsel(String name) {
		super(name);
	}

	@Override
	public void singen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String getName() {
		return this.sayHello + " " + this.getClass().getSimpleName() + " " + this.get_name();
	}
	
}
