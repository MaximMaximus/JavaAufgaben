package buchstabenmixer;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = "";
		
		System.out.println("Bitte ein Wort eingeben:");
		text = sc.nextLine();
		
		System.out.println(buchstabenmixer(text));

	}
	
	public static String buchstabenmixer(String text) {
		String anfang = text.substring(0, text.length()/2);
		String ende = text.substring(text.length()/2, text.length());
		ende += anfang;
		return ende;
	}

}
