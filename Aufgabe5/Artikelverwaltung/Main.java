package artikelverwaltung;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static EingabeTester inputTester = new EingabeTester();
	public static List<Article> articles = new ArrayList<Article>();
	public static Warenkorb warenkorb = new Warenkorb();

	public static void main(String[] args) {

		warenkorb.setArticles(articles);

		// Test
		Price redShirtCost = new Price(10, "€");
		Color redShirtColor = new Color(10, 10, 10);
		Article redShirt = new Article(1, "Rotes Hemd", redShirtCost, redShirtColor);
		articles.add(redShirt);
		Price redShirtCost1 = new Price(122.22, "€");
		Color redShirtColor1 = new Color(10, 10, 10);
		Article redShirt1 = new Article(2, "Rotes Hemd", redShirtCost1, redShirtColor1);
		articles.add(redShirt1);

		Scanner sc = new Scanner(System.in);
		int wahl = 0;

		do {
			System.out.println("Artikelverwaltung");
			System.out.println("1. Artikel hinzufügen");
			System.out.println("2. Alle Artikel anzeigen");
			System.out.println("3. Artikelnummer suchen");
			System.out.println("4. Nach Preis suchen");
			System.out.println("5. Anzahl der Artikel ausgeben");
			System.out.println("6. Artikel löschen");
			System.out.println("7. Artikel und Gesamtpreis ausgeben");
			System.out.println("8. Neue Artikelnummer erstellen");
			System.out.println("0. Beenden");
			wahl = inputTester.testeInt();
			switch (wahl) {
			case 1:
				articles.add(newArticle());
				break;
			case 2:
				printArticle(articles);
				break;
			case 3:
				searchNumber();
				break;
			case 4:
				searchPrice();
				break;
			case 5:
				System.out.println("Menge der Artikel: " + warenkorb.getSize());
				break;
			case 6:
				System.out.println("Artikelnummer eingeben:");
				wahl = inputTester.testeInt();
				if (warenkorb.remove(wahl) == true) {
					System.out.println("Artikel entfernt");
				} else {
					System.out.println("Ungültige Eingabe!");
				}
				break;
			case 7:
				warenkorb.print();
				break;
			case 8:
				int number = 0;
				do {
					number = warenkorb.getNewArtNr();
				} while (checkNumber(warenkorb.getArticles(), number) == true);
				System.out.println("Neue Nummer: " + number);
				break;
			case 0:
				System.out.println("Ende");
				break;
			default:
				System.out.println("Ungültige Eingabe");
			}

		} while (wahl != 0);

		sc.close();
	}

	public static Article newArticle() {
		int nummer = setNumber();
		String name = enterName();
		Price preis = enterPrice();
		Color farbe = enterColor();
		Article neu = new Article(nummer, name, preis, farbe);
		return neu;
	}

	public static int setNumber() {
		Scanner sc = new Scanner(System.in);
		int nummer = 0;
		System.out.println("Bitte Artikelnummer eingeben");
		do {
			nummer = inputTester.testeInt();
			boolean nummerExist = checkNumber(articles, nummer);
			if (nummerExist == true) {
				System.out.println("Artikelnummer bereits vorhanden!");
				System.out.println("Neue Nummer eingeben:");
			} else if (nummer > 0 && nummer < 10) {
				System.out.println("Nummer erfasst");
				break;
			} else {
				System.out.println("Ungültige Eingabe!");
			}
		} while (true);
		return nummer;
	}

	public static boolean checkNumber(List<Article> art, int number) {
		for (int i = 0; i < art.size(); i++) {
			if (number == art.get(i).getArticlenumber()) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkPrice(List<Article> art, double price) {
		for (int i = 0; i < art.size(); i++) {
			if (price >= art.get(i).getPrice().getValue()) {
				return true;
			}
		}
		return false;
	}

	public static void searchNumber() {
		Scanner sc = new Scanner(System.in);
		int nummer = 0;
		System.out.println("Bitte Artikelnummer eingeben");
		do {
			nummer = inputTester.testeInt();
			boolean nummerExist = checkNumber(articles, nummer);
			if (nummerExist == true) {
				System.out.println("Artikelnummer vorhanden!");
				printSpecArtikle(articles, nummer);
				break;
			} else if (nummer <= 0 && nummer > 10) {
				System.out.println("Ungültige Eingabe!");
			} else {
				System.out.println("Nummer nicht gefunden!");
				break;
			}
		} while (true);
	}

	public static void searchPrice() {
		Scanner sc = new Scanner(System.in);
		double preis = 0;
		System.out.println("Bitte obere Preisgrenze eingeben:");
		do {
			preis = inputTester.testeDouble();
			if (preis <= 0) {
				System.out.println("Ungültige Eingabe!");
			} else if (checkPrice(articles, preis) == true) {
				System.out.println("Artikel gefunden:");
				printArticleByPrice(articles, preis);
				break;
			} else {
				System.out.println("Keine ARtiekl gefunden!");
				break;
			}
		} while (true);
	}

	public static String enterName() {
		Scanner sc = new Scanner(System.in);
		String name;
		do {
			System.out.println("Bitte Artikelnamen eingeben: ");
			name = sc.next();
			if (name.length() < 1) {
				System.out.println("Ungültige Eingabe!");
			} else {
				break;
			}
		} while (name.length() < 1);
		return name;
	}

	public static Price enterPrice() {
		Scanner sc = new Scanner(System.in);
		int euro = 0;
		int cent = 0;
		double betrag = 0.0f;
		String currency = "";

		System.out.println("Preiseingabe:");
		do {
			System.out.println("Bitte den Eurobetrag eingeben (Zahl vor dem Komma): ");
			euro = inputTester.testeInt();
			if (euro < 1) {
				System.out.println("Ungültige Eingabe!");
			} else {
				break;
			}
		} while (true);

		do {
			System.out.println("Bitte den Centbetrag eingeben (Zahl nach dem Komma): ");
			cent = inputTester.testeInt();
			if (cent < 1) {
				System.out.println("Ungültige Eingabe!");
			} else {
				break;
			}
		} while (true);

		do {
			System.out.println("Bitte Währung eingeben (z.B. €): ");
			currency = sc.next();
			if (currency.length() < 1) {
				System.out.println("Ungültige Eingabe!");
			} else {
				break;
			}
		} while (currency.length() < 1);
		betrag = (double) ((double) euro + ((double) cent / 100));
		Price neu = new Price(betrag, currency);
		return neu;
	}

	public static Color enterColor() {
		Scanner sc = new Scanner(System.in);
		int r = 0;
		int g = 0;
		int b = 0;

		do {
			System.out.println("Bitte den Rot-Wert eingeben: ");
			r = inputTester.testeInt();
			if (r < 0) {
				System.out.println("Ungültige Eingabe!");
			} else {
				break;
			}
		} while (true);
		do {
			System.out.println("Bitte den Grün-Wert eingeben: ");
			g = inputTester.testeInt();
			if (g < 0) {
				System.out.println("Ungültige Eingabe!");
			} else {
				break;
			}
		} while (true);
		do {
			System.out.println("Bitte den Blau-Wert eingeben: ");
			b = inputTester.testeInt();
			if (b < 0) {
				System.out.println("Ungültige Eingabe!");
			} else {
				break;
			}
		} while (true);
		Color neu = new Color(r, g, b);
		return neu;

	}

	public static void printArticle(List<Article> article) {
		if (article.isEmpty() == false) {
			for (Article art : article) {
				System.out.println(art.toString());
			}
		} else {
			System.out.println("Keine Artikel vorhanden!");
		}
	}

	public static void printSpecArtikle(List<Article> article, int nummer) {
		for (Article art : article) {
			if (art.getArticlenumber() == nummer) {
				System.out.println(art.toString());
			}
		}
	}

	public static void printArticleByPrice(List<Article> article, double preis) {
		for (Article art : article) {
			if (art.getPrice().getValue() <= preis) {
				System.out.println(art.toString());
			}
		}

	}
}
