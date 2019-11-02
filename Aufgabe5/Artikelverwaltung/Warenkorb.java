package artikelverwaltung;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Warenkorb {

	private List<Article> articles = new ArrayList<Article>();

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public int getSize() {
		return this.getArticles().size();
	}

	public boolean remove(int articleNumber) {
		for (Article art : this.getArticles()) {
			if (articleNumber == art.getArticlenumber()) {
				this.getArticles().remove(art);
				return true;
			}
		}
		return false;
	}

	public void print() {
		double gesamtpreis = 0;
		for (Article art : this.getArticles()) {
			System.out.println(art.toString());
			gesamtpreis += art.getPrice().getValue();
		}
		System.out.println("Gesamtpreis: " + gesamtpreis + " €\n");
	}

	public int getNewArtNr() {
		int artikelnummer = 0;
		for (int i = 0; i < 5; i++) {
			artikelnummer += Math.random() * 9 + 1;
			artikelnummer *= 10;
		}
		artikelnummer /= 10;
		return artikelnummer;
	}

}
