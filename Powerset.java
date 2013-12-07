package hr.grubic.algorithms;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Powerset {

	public static ArrayList<ArrayList<Integer>> powerset(ArrayList<Integer> set) {
		if (set==null) return null;
		return powerset(set, 0);
	}
	
	private static ArrayList<ArrayList<Integer>> powerset(
			ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>>powSet;
		//add empty set
		if (index == set.size()) {
			powSet = new ArrayList<ArrayList<Integer>>();
			powSet.add(new ArrayList<Integer>());
		} else {
			Integer first = set.get(index);
			//generate powerset for the rest
			powSet = powerset(set, index+1);
			ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : powSet) {
				ArrayList<Integer> newSubset = new ArrayList<Integer>();
				newSubset.addAll(subset);
				newSubset.add(first);
				allSubsets.add(newSubset);
			}
			powSet.addAll(allSubsets);
		}
		return powSet;
	}
	
	private static ArrayList<ArrayList<Integer>> powersetIterative(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>>powSet = new ArrayList<ArrayList<Integer>>();
		 int k = set.size();
		 BitSet bs = new BitSet(k);
		 int n = (int) Math.pow(2, k);
		 for (int i=0; i<n; i++) {
			 bs = generateBinary(i,k);
			 ArrayList<Integer> currentSet = new ArrayList<Integer>();
			 for (int l=0; l<k; l++) {
				 if (bs.get(l)) {
					 currentSet.add(set.get(l));
				 }
			 }
			 powSet.add(currentSet);
		 }
		 return powSet;
	}

	private static BitSet generateBinary(int i, int k) {
		BitSet bs = new BitSet(k);
		while (i>0) {
			int r = i%2;
			i/=2;
			if (r==1) bs.set(k-1);
			k--;
		}
		return bs;
	}

	private static int gcd(int t, int r) {
		if (t ==0) return r;
		r = r % t;
		return gcd(r,t);
	}
	
	
	public static void getPaths(char[][]A, int i, int j, ArrayList<Character> path, ArrayList<ArrayList<Character>> allPaths) {
		int n = A.length;
		if (i>=n || j>=n) return;
		if (i==n-1 && j==n-1) {
			path.add(A[i][j]);
			allPaths.add(new ArrayList<Character>(path));
			return;
		}
		path.add(A[i][j]);
		getPaths(A, i, j+1, new ArrayList<Character>(path), allPaths);
		getPaths(A, i+1, j, path, allPaths);
		
		path.remove(path.size()-1);
	}
	
	public static void main(String[] args) {
		char[][] A = new char[3][3];
		A[0] = new char[]{'a', 'b', 'c'};
		A[1] = new char[]{'d', 'e', 'f'};
		A[2] = new char[]{'g', 'h', 'i'};
		ArrayList<ArrayList<Character>> allPaths = new ArrayList<ArrayList<Character>>();
		ArrayList<Character> path = new ArrayList<Character>();
		getPaths(A,0 , 0, path, allPaths);
		for (ArrayList<Character> list: allPaths) {
			System.out.println(list);
		}
		String s = "maja";
		String s2 = "ajam";
		String s3 = "aajm";
		
		System.out.println(s.hashCode());
		System.out.println(s2.hashCode());
		
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		System.out.println(powersetIterative(set));
		
	}
}
