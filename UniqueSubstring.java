package hr.grubic.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * @author maja
 *
 */
public class UniqueSubstring {

	public static String longestSubsequence(String s) {
		 int[] letters = new int[26];
		 Arrays.fill(letters, -1);
		 StringBuilder sb = new StringBuilder();
		 for (int i=0; i<s.length(); i++) {
			 char c = s.charAt(i);
			 if (letters[c-'a'] == -1) {
				 sb.append(c);
			 }
			 letters[c-'a'] = i;
		 }
		 return sb.toString();
	}
	
	public static String longestSubstring(String s) {
		int len = 0;
		int start = 0;
		int tmpStart= 0;
		int maxLen = 0;
	

		 int[] letters = new int[26];
		 Arrays.fill(letters, -1);
		 int i = 0;
		 while (i<s.length()) {
			char c = s.charAt(i);
			int prev = letters[c-'a'];
			letters[c-'a'] = i;
			if (prev == -1) {
				len++;
				i++;
			} else {
				if (len>maxLen) {
					maxLen = len;
					start = tmpStart;
				}
				//substrings.add(s.substring(tmpStart, i));
				Arrays.fill(letters, -1);
				i = tmpStart+1;
				tmpStart = i;
				len = 0;
			}
		 }
		 if (len > maxLen) {
			 maxLen = len;
			 start = tmpStart;
		 }
		
		return s.substring(start, start+maxLen);
	}
	
	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(longestSubstring(s));
	}
}
