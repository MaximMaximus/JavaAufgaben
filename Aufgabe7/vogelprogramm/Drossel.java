package vogelprogramm;

public class Drossel extends Vogel implements KannFliegen {
	
	public String sayHello = "Ich heiße Drossel";

	public Drossel(String name) {
		super(name);
		// TODO Auto-generated constructor stub
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
