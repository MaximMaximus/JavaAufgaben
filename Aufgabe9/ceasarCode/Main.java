package ceasarCode;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String text = "";
		int key = 0;

		try {
			System.out.println("Text eingeben: ");
			text = sc.nextLine();
		} catch (IllegalCapitalLetter e) {
			e.printStackTrace();
		} catch (InvalidCharacter e) {
			e.printStackTrace();
		}

		System.out.println("Key eingeben: ");
		key = sc.nextInt();

		text = crypt(text, key);
		System.out.println(text);
		System.out.println("Test");

		sc.close();
	}

	public static String crypt(String text, int key) {
		String output = "";
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') {
				throw new IllegalCapitalLetter();
			}
			if (text.charAt(i) < 'a' || text.charAt(i) > 'z') {
				throw new InvalidCharacter();
			}

			output += (char) ((text.charAt(i) + key - 'a') % 26 + 'a');
		}

		return output;
	}

}
