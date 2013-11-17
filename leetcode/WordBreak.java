package hr.grubic.algorithms.leetcode;

import java.util.Set;

public class WordBreak {

	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null)
			return false;
		if (s.length() == 0 || s.length() == 1) {
			return dict.contains(s);
		}
		int n = s.length();
		for (int i = 1; i <= n; i++) {
			String prefix = s.substring(0, i);
			if (dict.contains(prefix) && wordBreak(s.substring(i, n), dict)) {
				return true;
			}
		}
		return false;
	}

	public boolean wordBreakNonRecursive(String s, Set<String> dict) {
		if (s == null)
			return false;
		if (s.length() == 0 || s.length() == 1) {
			return dict.contains(s);
		}
		int n = s.length();
		boolean[] containsPrefix = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			String prefix = s.substring(0, i);
			if (containsPrefix[i] == false) {
				if (dict.contains(prefix)) 
					containsPrefix[i] = true;
			}
			if (!containsPrefix[i]) continue;
			if (i==n) return true;
			for (int j= i+1; j<=n; j++) {
				if (containsPrefix[j] == false && dict.contains(s.substring(i, j))) {
					containsPrefix[j] = true;
				}
				if (containsPrefix[j] && j==n) {
					return true;
				}
			}
			
			
		}
		return false;
	}
	
}
