package hr.grubic.algorithms.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagrams {
	private static int calculate(String s) {
		int n = s.length();
		if (n % 2 != 0) {
			return -1;
		}

		char[] a = s.substring(0, n / 2).toCharArray();
		char[] b = s.substring(n / 2, n).toCharArray();
		int nr = 0;
		int[] letters = new int[26];
		for (int i = 0; i < a.length; i++) {
			int c = a[i];
			letters[c - 'a']++;
		}
		for (int i = 0; i < b.length; i++) {
			int c = b[i];
			letters[c - 'a']--;
		}
		for (int i = 0; i < letters.length; i++) {
			if (letters[i] > 0) {
				nr += letters[i];
			}
		}
		return nr;
	}
	
	private static boolean anagrams(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		if (n1 != n2) {
			return false;
		}

		char[] a = s1.toCharArray();
		char[] b = s2.toCharArray();
		int nr = 0;
		int[] asciiCharacters = new int[128];
		for (int i = 0; i < a.length; i++) {
			int c = a[i];
			asciiCharacters[c]++;
		}
		for (int i = 0; i < b.length; i++) {
			int c = b[i];
			asciiCharacters[c]--;
		}
		for (int i = 0; i < asciiCharacters.length; i++) {
			if (asciiCharacters[i] > 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String s1;
		String s2;
		try {
			s1 = in.readLine();
			s2 = in.readLine();
			
		   System.out.println(anagrams(s1, s2) ? "Anagrams!" : "Not anagrams!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
