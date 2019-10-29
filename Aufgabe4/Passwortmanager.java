
public class Passwortmanager {
	private String password = "pg2machtspass";
	public int versuche = 0;

	public int pruefung(String pass) {
		if (pass.equals(password)) {
			System.out.println("Passwort korrekt!");
			versuche = 0;
			return 1;
		} else if (versuche >= 3) {
			System.out.println("Zu viele Fehlerversuche!");
			return 0;
		} else {
			versuche++;
			System.out.println("Passwort inkorrekt! (Anzahl der Fehlversuche " + versuche + ")");
			return -1;
		}
	}

	public boolean passAendern(String passalt, String passneu) {
		if (passalt.equals(password)) {
			password = passneu;
			System.out.println("Passwort geändert!");
			versuche = 0;
			return true;
		} else {
			versuche++;
			System.out.println("Passwort inkorrekt! (Anzahl der Fehlversuche " + versuche + ")");
			return false;
		}
	}

}
