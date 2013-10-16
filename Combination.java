package hr.grubic.algorithms;

import java.util.ArrayList;

public class Combination {
	// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	
    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> currList = new ArrayList<Integer>();
        combine(n,k,1, currList, solution);
        return solution;
    }
    
    private static void combine(int n, int k, int i, ArrayList<Integer> currList, 
        ArrayList<ArrayList<Integer>> solution) {
        if (currList.size() == k && !solution.contains(currList)) {
            solution.add(currList);
            currList = new ArrayList<Integer>();
            return;
        } else if (currList.size() > k) {
            return;
        } else {
            for (int j=i; j<=n; j++) {
                ArrayList<Integer> cList = new ArrayList<Integer>(currList);
                cList.add(j);
                combine(n,k,j+1,cList,solution);
            }
        }
    }
    
    public static void main(String[] args) {
       System.out.println(Combination.combine(7, 3));
    }
}
