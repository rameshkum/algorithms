package hr.grubic.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	private static String uniqueSubstrings(String s) {
		int[] letters = new int[26];
		Arrays.fill(letters, -1);
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			int prev = -1;
			for (int k =0; k<sb.length(); k++) {
				if (sb.charAt(k) == c) {
					prev = k;
					break;
				}
			}
			if (prev == -1) {
				sb.append(c);
				continue;
			}
			System.out.println(sb.toString());
			for (int j=prev+1; j<sb.length(); j++) {
				
				if (sb.charAt(j)>c) {
					System.out.println("Found"+ sb.charAt(j) + " at " +j);
					String sub = sb.substring(prev, j);
					System.out.println(sub);
					System.out.println(i);
					if (s.startsWith(sub, i)) {
						char last = sb.charAt(prev);
						sb.deleteCharAt(prev);
						sb.append(last);
					}
				}
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	  /*  Let the input and the output strings be represented as “I[]“ and “O[]“.
	    For each character “c” from the input string I[], do the following validations:
	        If c is not found in O[], append c to O[]
	        If c already exists in O[]:
	            Let “p” be the position of the character c in O[], and “ip” be the position of the character in I[]
	            Find the first character in O[], placed after the position p, that is lexicographically greater than c
	                    If no such character is found,do nothing and continue with the next character validation from the input string
	                    If there is such character:
	                        Let’s remember it’s position in “gp”
	                        Take all the characters from O[], that are found between the positions p and gp
	                        If all of these characters are founded in I[] after the position ip, remove the character from O[] at position p and append the character at the end of O[]
*/
	}
	
	private static String mostBeautiful(Set<String> substrings) {
		Iterator<String> it = substrings.iterator();
		String mb = it.next();
		return mb;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		 //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     //String line = br.readLine();
	     uniqueSubstrings("ccabdcab");
	}

}
