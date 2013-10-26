package hr.grubic.algorithms.leetcode;

/**
 * 
 *  Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example, given input array A = [1,1,2], your function should return length = 2, and A is now [1,2]. 
 *
 */
public class RemoveDuplicates {

	 public static int removeDuplicates(int[] A) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if (A==null || A.length==0) return 0;
	        int duplicates = 0;
	        int n= A.length;
	        int prev = 0;
	        for (int i=1; i<n; i++) {
	           if (A[prev] != A[i]) {
	        	   prev = i-1;
	        	   A[prev] = A[i];
	           } else {
	        	   duplicates++;
	           }
	        }
	        return n-duplicates;
	    }
	 
	 public static void main(String[]args) {
		 int[] A = new int[] {1,1};
		 System.out.println(removeDuplicates(A));
	 }
}
