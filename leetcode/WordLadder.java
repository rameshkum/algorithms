package hr.grubic.algorithms.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	
	public static int ladderLength(String start, String end, Set<String> dict) {
	    int ret = 0;
	    if (start == end)
	        return 0;

	    Set<String> added = new HashSet<String>();
	    Queue<String> que = new LinkedList<String>();
	  
	    que.add(start);
	    added.add(start);
	    int lev1 = 1;
	    int lev2 = 0;
	    
	    while (!que.isEmpty()) {
	        String s = que.poll();
	        --lev1;
	     
	        for (int i = 0; i < s.length(); ++i) {
	            for (char j = 'a'; j < 'z'; ++j) {
	                char[] tArray = s.toCharArray();
	                tArray[i] = j;
	                String newS = new String(tArray);
	                if (newS.equals(end)){
	                    return ret+2;
	                }
	                if (!added.contains(newS) && (dict.contains(newS)|| end.equals(newS))) {
	                	que.add(newS);
	                	added.add(newS);
	                	lev2++;
	                }
	             }
	            
	        }
	        if (lev1 == 0) {
	            ++ret;
	            lev1 = lev2;
	            lev2 = 0;
	        }
	    }

	    return 0;
	}
	
	public static void main(String[] args) {
		HashSet<String> dictionary = new HashSet<String>();
		dictionary.add("hot");
		dictionary.add("dog");
		dictionary.add("dot");
		dictionary.add("lot");
		dictionary.add("log");		
		System.out.println(ladderLength("hit", "cog", dictionary));
		 
	}
}
