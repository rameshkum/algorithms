package hr.grubic.algorithms.leetcode;

import java.util.Set;

public class WordBreak {
    
    public boolean wordBreak(String s, Set<String> dict) {
    	 if (s==null) return false;
         if (s.length() == 0 || s.length() == 1) {
             return dict.contains(s);
         }
         int n = s.length();
        for (int i=1; i<=n; i++) {
        	String prefix = s.substring(0,i);
            if (dict.contains(prefix) && 
            		wordBreak(s.substring(i,n), dict)) {
                return true;
            }
        } 
        return false;
    }
}
