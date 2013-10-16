package hr.grubic.algorithms;

/**
find first missing number in an array of sorted numbers
e.g [4, 5, 6, 7, 9, 11, 14, 18, 19]
output: 8

expected complexity O(logn)
**/
public class SearchMissingNumber {

	public static int findMissing(int[] A) {
		if (A==null || A.length==1) {
			return -1;
		}
		int lo = 0;
		int hi = A.length-1;
		if (A[hi] - A[lo] + 1 == A.length) {
			return -1;
		}
		while (hi-lo>1) {
			int mid = lo + (hi-lo)/2;
			if (A[mid]-A[lo]==mid-lo) {
				//lower part is sorted
				lo=mid;
			} else {
				hi= mid;
			}
			
		}
		return A[lo]+1;
	}
	
	public static int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() functionif
        if (A==null || A.length==0) {
            return 0;
        }
        int lo = 0;
        int hi = A.length-1;
        int mid;
        while (hi>lo) {
            mid = lo+ (hi-lo)/2;
            if (A[mid]==target) {
                return mid;
            }
            if (A[mid]>target) {
                hi=mid-1;
            }else {
                lo=mid+1;
            }
        }
        if (hi>=0 && target>A[hi]) {
            return hi+1;
        } else {
            return lo;
        }
        
    }
	
	public static void main(String[]args) {
		int[]A1 = new int[]{4,5,6,7,9,11,14,18,19};
		int[]A2 = new int[]{4,5,6,7,8,9,11,14,18,19};
		int []A3 = new int[]{3, 5, 6, 7, 8, 9, 10, 11, 14, 18, 19};
		System.out.println(findMissing(A1));
    	System.out.println(findMissing(A2));
	    System.out.println(findMissing(A3));
		System.out.println(searchInsert(new int[]{1,3}, 0));
		
	}
}
