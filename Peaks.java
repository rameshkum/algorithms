package hr.grubic.algorithms;

/*

A non-empty zero-indexed array A consisting of N integers is given. A peak is an array element which is larger than its neighbours. More precisely, it is an index P such that 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1].

For example, the following array A:

    A[0] = 1 
    A[1] = 5 
    A[2] = 3 
    A[3] = 4 
    A[4] = 3 
    A[5] = 4 
    A[6] = 1 
    A[7] = 2 
    A[8] = 3 
    A[9] = 4 
    A[10] = 6 
    A[11] = 2

has exactly four peaks: elements 1, 3, 5 and 10.

You are going on a trip to a range of mountains whose relative heights are represented by array A. You have to choose how many flags you should take with you. The goal is to set the maximum number of flags on the peaks, according to certain rules.

Flags can only be set on peaks. What's more, if you take K flags, then the distance between any two flags should be greater than or equal to K. The distance between indices P and Q is the absolute value |P − Q|.

For example, given the mountain range represented by array A, above, with N = 12, if you take:

        two flags, you can set them on peaks 1 and 5;
        three flags, you can set them on peaks 1, 5 and 10;
        four flags, you can set only three flags, on peaks 1, 5 and 10.

You can therefore set a maximum of three flags in this case.

Write a function:

    int solution(int A[], int N); 

that, given a non-empty zero-indexed array A of N integers, returns the maximum number of flags that can be set on the peaks of the array.

For example, given N = 12 and the following array A:

    A[0] = 1 
    A[1] = 5 
    A[2] = 3 
    A[3] = 4 
    A[4] = 3 
    A[5] = 4 
    A[6] = 1 
    A[7] = 2 
    A[8] = 3 
    A[9] = 4 
    A[10] = 6 
    A[11] = 2

the function should return 3, as explained above.

Assume that:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [0..1,000,000,000].

Complexity:

        expected worst-case time complexity is O(N);
        expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

Elements of input arrays can be modified.
*/
public class Peaks {
	
	public static int solution(int[] A) {
        // write your code here...
        int nrOfPeaks = 0;
        if (A == null || A.length ==0) {
            return 0;
        }
        int[] peaks = new int[A.length];
        int j = 0;
        for (int i=1; i<A.length-1; i++) {
            if (A[i] > A[i-1] && A[i] > A[i+1]) {
                nrOfPeaks++;
                peaks[j] = i;
                j++;
            }
        }
        int max = 0;
        for (int k=2; k<=nrOfPeaks; k++) {
            int n = k -1;
            int lastPeak = 0;
            int i = 1;
        	while (i<nrOfPeaks && n>0) {
        		if (peaks[i]-peaks[lastPeak] >= k) {
        			lastPeak =i;
        			n--;
        		}
        		i++;
        	}
        	if (n==0 && k>max) {
        		max = k;
        	}
        }
        
        return max;
    }
	
	public static boolean test() {
		 int A[] = new int[] {1,5,3,4,5,4,1,2,3,4,6,2};
 		 int B[] = new int[]{9, 9, 4, 3, 5, 4, 5, 2, 8, 9, 3, 1}; 
		 int C[] = new int[] {1,5,3,4,3,4,1,2,3,4,6,2};
		 int D[] = new int[] {4, 5, 8, 5, 1, 4, 6, 8, 7, 2, 2, 5};
		 int E[] = new int[] {5, 9, 6, 2, 2, 7, 3, 2, 7, 4, 7, 9};
		 int F[] = new int[] {7, 10, 4, 5, 7, 4, 6, 1, 4, 3, 3, 7};
		 if (!(3 == Peaks.solution(A))) return false;
		 if (!(2 == Peaks.solution(B))) return false;
		 if (!(3 == Peaks.solution(C))) return false;
		 if (!(2 == Peaks.solution(D))) return false;
		 if (!(3 == Peaks.solution(E))) return false;
		 if (!(3 == Peaks.solution(F))) return false;
		 return true;
	}
	
	public static void main(String[] args) {
	    System.out.println(Peaks.test());
	}

}
