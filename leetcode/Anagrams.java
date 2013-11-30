package hr.grubic.algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem statement: Given an array of strings, return all groups of strings
 * that are anagrams. Note: All inputs will be in lower-case.
 * 
 * @author maja
 * 
 */
public class Anagrams {

	private static int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
			41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };

	public static ArrayList<String> anagrams(String[] strs) {
		if (strs == null) {
			return null;
		}
		ArrayList<String> solution = new ArrayList<String>();
		Map<Integer, ArrayList<String>> hashValues = new HashMap<Integer, ArrayList<String>>();
		for (int i = 0; i < strs.length; i++) {
			String str = strs[i];
			if (str == null)
				continue;
			int hash = calculateCode(str);
			ArrayList<String> values;
			if (hashValues.containsKey(hash)) {
				values = hashValues.get(hash);
			} else {
				values = new ArrayList<String>();
			}
			values.add(str);
			hashValues.put(hash, values);
		}

		for (Map.Entry<Integer, ArrayList<String>> entry : hashValues
				.entrySet()) {
			if (entry.getValue().size() == 1)
				continue;
			for (String s : entry.getValue()) {
				solution.add(s);
			}
		}

		return solution;
	}

	/**
	 * Code depends only on letters in the string, not on their order
	 * 
	 * @param s
	 * @return
	 */
	private static int calculateCode(String s) {
		int result = 1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			result = result * primes[c - 'a'];
		}
		return result;
	}
}
