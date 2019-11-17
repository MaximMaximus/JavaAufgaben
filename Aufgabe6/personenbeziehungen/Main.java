package personenbeziehungen;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String s1 = "Jim likes Larry and Jean, but hates Kim.";
		String s2 = "Bob loves Jean, and likes Larry and Kim.";
		String s3 = "Jean loves Bob, likes Jim, but hates Kim.";
		String s4 = "Kim hates Jim, likes Larry and Bob.";
		String s5 = "Larry loves Martin, and hates Karl and Jean.";

		System.out.println(relation(s1));
		System.out.println(relation(s2));
		System.out.println(relation(s3));
		System.out.println(relation(s4));
		System.out.println(relation(s5));

	}

	public static String relation(String text) {
		// string.equals(string)
		String output = "";
		String textCopy = "";
		String person = "";
		ArrayList<String> loves = new ArrayList<String>();
		ArrayList<String> likes = new ArrayList<String>();
		ArrayList<String> hates = new ArrayList<String>();

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) != ',' && text.charAt(i) != '.') {
				textCopy += text.charAt(i);
			}
		}

		String[] words = textCopy.split(" ");

		for (int i = 0; i < words.length; i++) {
			if (i == 0) {
				person += words[i];
			}
			if (words[i].equals("loves")) {
				loves.add(words[i + 1]);
				if (i + 3 <= words[i].length() + 2) {
					if (words[i + 2].equals("and") && !(words[i + 3].equals("likes") || words[i + 3].equals("hates"))) {
						loves.add(words[i + 3]);
					}
				}
			} else if (words[i].equals("likes")) {
				likes.add(words[i + 1]);
				if (i + 3 <= words[i].length() + 2) {
					if (words[i + 2].equals("and") && !(words[i + 3].equals("loves") || words[i + 3].equals("hates"))) {
						likes.add(words[i + 3]);
					}
				}
			} else if (words[i].equals("hates")) {
				hates.add(words[i + 1]);
				if (i + 3 <= words[i].length() + 2) {
					if (words[i + 2].equals("and") && !(words[i + 3].equals("loves") || words[i + 3].equals("likes"))) {
						hates.add(words[i + 3]);
					}
				}
			}
		}

		output += person;
		
		output += ": likes: ";
		output += likes;

		output += " loves: ";
		output += loves;

		output += " hates: ";
		output += hates;

		return output;
	}

}
