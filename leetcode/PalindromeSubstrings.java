package hr.grubic.algorithms.leetcode;


public class PalindromeSubstrings {

	public String longestPalindrome(String s) {
        if (s==null) return null;
        if (s.length()<=1) return s;
        String maxSub = "";
		for (int n=s.length(); n>0; n--) {
			for (int i=0; i<s.length(); i++) {
				if (i+n>s.length()) break;
				String sub = s.substring(i, i+n);
				if (isPalindrome(sub)) {
					return sub;
				}
			}
		}
		return maxSub;
    }
    
    private boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length()-1;
		while (i<j) {
			if (s.charAt(i) !=s.charAt(j)) {
				return false;
			};
			i++;
			j--;
		}
		return true;
	}
}