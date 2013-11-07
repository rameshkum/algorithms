package hr.grubic.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class SecondLargest {
	
	public static Integer findSecondLargest(List<Integer> list) {
		if (list == null) {
			return null;
		}
		if (list.size() == 1) {
			return list.get(0);
		}
		List<List<Integer>> structure = buildUpStructure(list);
		System.out.println(structure);
		return secondLargest(structure);
		
	}

	public static List<List<Integer>> buildUpStructure(List<Integer> list) {
		List<List<Integer>> newList = new ArrayList<List<Integer>>();
		List<Integer> tmpList = new ArrayList<Integer>(list);
		newList.add(tmpList);
		int n = list.size();
		while (n>1) {
			tmpList = new ArrayList<Integer>();
			for (int i = 0; i<n; i=i+2) {
				Integer i1 = list.get(i);
				Integer i2 = list.get(i+1);
				tmpList.add(Math.max(i1, i2));
			}
			n/= 2;
			newList.add(tmpList);	
			list = tmpList;
		}
		return newList;
	}
	
	public static Integer secondLargest(List<List<Integer>> structure) {
		int n = structure.size();
		int rootIndex = 0;
		Integer largest = structure.get(n-1).get(rootIndex);
	    List<Integer> tmpList = structure.get(n-2);
	    Integer secondLargest = Integer.MIN_VALUE;
	    Integer leftAdjacent = -1;
	    Integer rightAdjacent = -1;
		for (int i = n-2; i>=0; i--) {
			rootIndex*=2;
			tmpList = structure.get(i);
			leftAdjacent = tmpList.get(rootIndex);
			rightAdjacent = tmpList.get(rootIndex+1); 
			if (leftAdjacent.equals(largest)) {
				if (rightAdjacent > secondLargest) {
					secondLargest = rightAdjacent;
				}
			}
			if (rightAdjacent.equals(largest)) {
				if (leftAdjacent > secondLargest) {
					secondLargest = leftAdjacent;
				}
				rootIndex=rootIndex+1;
			}
		}
		
		return secondLargest;
	}
	
	public static int kThLargest(int[] A, int k) {
		for (int i=0; i<k;i++) {
			int iMax = i;
			for (int j=i+1; j<A.length; j++) {
				if (A[j] > A[iMax]) {
					iMax = j;
				}
			}
			if (iMax != i) {
				int tmp = A[i];
				A[i] = A[iMax];
				A[iMax] = tmp;
			}
		}
		return A[k-1];
	}
	
	public static int secondLargest(int[] A) {
		int max = A[0];
		int secondMax = Integer.MIN_VALUE;
		for (int j = 1; j < A.length; j++) {
			if (A[j] > max) {
				secondMax = max;
				max = A[j];
			} else if (A[j] > secondMax) {
				secondMax = A[j];
			}
		}

		return secondMax;
	}
	
	

	public static void main(String[] args) {
		Integer[] array = new Integer[] {
				14, 35, 3, 28, 59, 5, 44, 50, 76, 12,  48, 53, 1, 8, 6, 27};
		int[] A = new int[] {
				32, 35, 3, 28, 13, 5, 44, 50, 14, 76};
		System.out.println(buildUpStructure(Arrays.asList(array)));
		System.out.println(secondLargest(A));
	//	System.out.println(buildUpStructure(Arrays.asList(array)));
	}
	
}
