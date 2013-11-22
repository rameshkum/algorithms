package hr.grubic.algorithms.leetcode;

public class DistinctSubsequences {

	public static int numDistinct(String S, String T) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
         if (S==null || T==null) return 0;
         if (S.length() == 0) return 0;
        
         int r = S.length();
		 int c = T.length();
		 if (c > r) return 0;
		 if (r==c) {
		     return S.equals(T) ? 1: 0;
		 }
		 int[][] data = new int[r][c];
		 data[0][0] = (S.charAt(0) == T.charAt(0)) ? 1 : 0;
		 for (int j=0; j<c;j++) {
			 for (int i=1; i<r; i++) {
			     data[i][j] = data[i-1][j];
				 if (S.charAt(i) == T.charAt(j)) {
					 data[i][j] = (j==0) ? data[i][j] + 1 : data[i][j] + data[i-1][j-1] ;
				 }
			 }
		 }
		 return data[r-1][c-1];
    }
	 
	public static void main(String[] args) {
		numDistinct("ddd", "dd");
	}
	 
}
