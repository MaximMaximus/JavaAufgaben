package getraenkeautomat;

public class Main {

	public static void main(String[] args) {
		Getraenkeautomat automat1 = new Getraenkeautomat();
		while (true) {
			automat1.inhaltListen();
			automat1.getaenkWaehlen();
			automat1.bericht();
		}

	}

}
