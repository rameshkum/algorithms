package hr.grubic.algorithms;

import java.util.Scanner;

public class LCS {
	private static int LCS(final String s1, final String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
     
        int[][] data = new int[n1+1][n2+1];
        for (int i=0; i<n1; i++) {
            data[i][0] = 0;
        }
        for (int i=0;i<n2;i++) {
            data[0][i] = 0;
        }
  
        for (int i=1; i<=n1;i++) {
            for (int j=1; j<=n2;j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    data[i][j] = data[i-1][j-1]+1;
                } else {
                    data[i][j] = Math.max(data[i-1][j], data[i][j-1]);
                }
            }
        }
        for (int i=0; i<n1;i++) {
            for (int j=1; j<n2;j++) {
               System.out.print(data[i][j]);
            }
            System.out.println();
        }
        return data[n1][n2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        
        System.out.println(LCS(s1, s2));
    }

}
