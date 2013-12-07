package hr.grubic.algorithms;

import java.util.ArrayList;

public class Permutations {

	public static ArrayList<String> permutations(String s) {
		if (s == null) return null;
		ArrayList<String> perms = new ArrayList<String>();
		if (s.length()==0) {
			perms.add("");
			return perms;
		}
		char c = s.charAt(0);
		String sub = s.substring(1);
		ArrayList<String> rest = permutations(sub);
		for (String word: rest){
			for (int i=0; i<=word.length();i++) {
				String newPerm = insertChartAt(c, i, word);
				perms.add(newPerm);
			}
		}
		return perms;
	}

	private static String insertChartAt(char c, int i, String word) {
		if (i==word.length()) {
			return word+c;
		}
		String prev = word.substring(0, i);
		String next = word.substring(i);
		return prev+c+next;
	}
	
	public static void main(String[]args) {
		String s = "abc";
		System.out.println(permutations(s));
	}
}
