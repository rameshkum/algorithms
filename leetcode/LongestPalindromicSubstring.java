package hr.grubic.algorithms.leetcode;

public class LongestPalindromicSubstring {

	private static String longestPalindromicSubstring(String s) {
		int max = Integer.MIN_VALUE;
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
	
	private static boolean isPalindrome(String s) {
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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "pbzoozaghdr";
		System.out.println(longestPalindromicSubstring(s));

	}

}
