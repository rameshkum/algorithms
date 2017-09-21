package com.java;

public class ArithSliceCount {

	public static void main(String[] args) {
		int[] A = new int[] { -1, 1, 3, 3, 3, 2, 1, 0 };
		System.out.println("Longest arithmatic slice count: "+getLAS(A));
	}

	public static final int limit = 1000000000;

	public static int getLAS(int[] A) {
		int count = 0;
		if (A.length <= 2)
			return count;
		int i = 1;
		while (i + 1 < A.length) {
			int k = i + 1;
			if (2 * A[i] == A[i - 1] + A[k]) {
				count++;
				if (count > limit)
					return -1;
				while (k + 1 < A.length && 2 * A[k] == A[k - 1] + A[k + 1]) {
					k++;
					count += (k - i);
					if (count > limit)
						return -1;
				}
			}
			i = k;
		}
		return count;
	}

}
