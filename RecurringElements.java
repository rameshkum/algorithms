package hr.grubic.algorithms;

public class RecurringElements {

	public int[] findTwoRecurring(int[]A) {
		if (A==null) return null;
		int[] recurring = new int[2];
		int k =0;
		for(int i=0; i<A.length; i++) {
			int index = Math.abs(A[i]);
			if ( A[index] > 0) {
				A[index] *= -1;
			} else {
				recurring[k] = Math.abs(A[index]);
				k++;
			}
		}
		return recurring;
	}
	
	public static int findFirstMissingPositive(int[]A){
		if (A==null) return -1;
		int startIndex = segragate(A);
		for (int i=startIndex; i<A.length; i++) {
			int absAi = Math.abs(A[i]);
			int index = absAi-1;
			
			if (index+startIndex>= A.length) continue;
			if (index < 0) continue;
			if (A[index+startIndex]>0) {
				A[index+startIndex] *= -1;
			}
			
 		}
		int firstMissing = 1;
		for (int i=startIndex; i<A.length; i++) {
			if (A[i] > 0) {
				firstMissing = i - startIndex + 1;
				return firstMissing;
			}
		}
	
		return (A.length-startIndex+1);
	}

	private static int segragate(int[] A) {
		int firstPositive = 0;
		if (A.length == 1) return 0;
		for (int i=0; i<A.length; i++) {
			if (A[i]<=0) {
				int tmp = A[i];
				A[i] = A[firstPositive];
				A[firstPositive] = tmp;
				firstPositive++;
			}
		}
		return firstPositive;
	}
	
	public static void main(String[] args) {
		int[] A = {2, 3, 7, 6, 8, -1, -10, 15};
		int[] B = { 2, 3, -7, 6, 8, 1, -10, 15 };
		System.out.println(findFirstMissingPositive(A));
		System.out.println(findFirstMissingPositive(B));
		System.out.println(findFirstMissingPositive(new int[] {2,1}));
	}
}
