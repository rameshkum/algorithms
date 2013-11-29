package hr.grubic.algorithms.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagrams {
	private static int calculate(String s) {
        int n = s.length();
       if (n%2 !=0) {
           return -1;
       }
       
       char[] a = s.substring(0, n/2).toCharArray();
       char[] b = s.substring(n/2, n).toCharArray();
       int nr = 0;
       int[] letters = new int[26];
       for (int i=0; i<a.length; i++) {
    	   int c = a[i];
    	   letters[c-'a']++;
       }
       for (int i=0; i<b.length; i++) {
    	   int c = b[i];
    	   letters[c-'a']--;
       }
       for (int i=0; i<letters.length; i++) {
    	   if (letters[i]>0) {
    		   nr += letters[i];
    	   }
       }
       return nr;
  }

   public static void main(String[] args) {
	   BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

	   String line;
	   try {
		   line = in.readLine();
		   int T = Integer.valueOf(line);

	       for (int i=0; i<T; i++) {
	           line = in.readLine();
	           System.out.println(calculate(line));
	       }
	} catch (IOException e) {
		e.printStackTrace();
	}
	  
   }
}
