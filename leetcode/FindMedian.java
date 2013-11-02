package hr.grubic.algorithms.leetcode;

/**
 * There are two sorted arrays A and B of size m and n respectively.
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 *
 */
public class FindMedian {
	
	public double findMedianSortedArrays(int A[], int B[]) {
   
        int m = (A== null) ? 0 : A.length;
        int n = (B== null) ? 0 : B.length;
        if (m==0) {
        	return getMedian(B);
        }
        if (n==0) {
        	return getMedian(A);
        }
        if (m==1 && n==1) {
        	return (A[0] + B[0])/2.0;
        } 
        double median;
		int mid = (m+n)/2;
		if ((m+n)%2==0) {
			int a =kthSmallest(A, B, mid);
			int b= kthSmallest(A, B, mid+1);
			median = (a+b)/2.0;
		} else {
			median = kthSmallest(A, B, mid+1); 
		}
        return median;
    }
	
	private double getMedian(int[] arr) {
		int n = arr.length;
		int mid = (n-1)/2;
		return (n%2==0) ? (arr[mid] + arr[mid+1])/2.0 : arr[mid];
	}
	
	private int kthSmallest(int[]A, int[]B, int k) {
		return kthSmallest(A, 0, A.length-1, B, 0, B.length-1, k);
	}
	
	private int kthSmallest(int[]A, int pa, int qa, int[]B, int pb, int qb, int k) {
		if (pa > qa) {
			//we've used up the A array
			return B[pb+k-1];
		}
		if (pb > qb) {
			//we've used up the B array
			return A[pa+k-1];
		}
		int mida = pa+ (qa-pa)/2;
		int midb = pb + (qb-pb)/2;
		
		int p = mida-pa + midb - pb +2;
		
		if (A[mida] > B[midb]) {
			//A[mida] is bigger than everything in A[pa...mida-1]
			//A[mida] is bigger than everything in B[pb... midb]
			if (k<p) {
				//rule out A[mida...qa]
				return kthSmallest(A,pa,mida-1,B,pb,qb,k);
			} else {
				//rule out first half of B; B[pb...midb]
				return kthSmallest(A, pa, qa, B, midb+1, qb, k-(midb+1-pb));
			}
		}else {
			//B[midb] is bigger than everything in B[pb... midb-1]
			//B[midb] is bigger than everything in A[pa...mida]
			if (k<p) {
				//rule out B[midb...qb]
				return kthSmallest(A, pa, qa, B, pb, midb-1, k);
				
			} else {
				return kthSmallest(A, mida+1, qa, B, pb, qb, k-(mida+1-pa));
			}
		}
	}
	
	
	

}
