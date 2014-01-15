package hr.grubic.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeSum {

	  public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        if (num == null) return null;
	        Set<ArrayList<Integer>> solution = new HashSet<ArrayList<Integer>>();
	        if (num.length<3) return new ArrayList<ArrayList<Integer>>();
	        Arrays.sort(num);
	      
	        for (int i=0; i<num.length; i++) {
	            int j = i+1;
	            int k = num.length-1;
	            while(j<k) {
	                if (num[i]+num[j] == -num[k]) {
	                    ArrayList<Integer> sol = new ArrayList<Integer>();
	                    sol.add(num[i]);
	                    sol.add(num[j]);
	                    sol.add(num[k]);
	                    solution.add(sol);
	                    
	                    j++;
	                    k--;
	                } else if (num[i]+num[j]< -num[k]) {
	                    j++;
	                } else {
	                    k--;
	                }
	            }
	            
	        }
	        System.out.println(solution);
	        return new ArrayList<ArrayList<Integer>>(solution);
	}
	  
	  public static void main(String[] args) {
		  System.out.println(threeSum(new int[]{0,0,0}));
	  }
}
