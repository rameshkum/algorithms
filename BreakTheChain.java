package com.java;

public class BreakTheChain {

	public static void main(String[] args) {

		int A[] = new int[]{4, 3, 1};
		int B[] = new int[]{2, 2, 1};
		int C[] = new int[]{-1, 0, 1};
		
		System.out.println(solution(A,B,C));
	}

	static int solution(int[] A, int[] B, int[] C) {
		if (A == null || B == null || C == null)
			return -1;
		if (A.length == 0 || B.length == 0 || C.length == 0)
			return -1;
		if (A.length != B.length && A.length != C.length)
			return -1;

		int bLen = B.length;
		int[] B2 = new int[bLen];
		for (int i = 0; i < bLen; i++)
			B2[i] = (i == 0 ? 0 : B2[i - 1]) + B[i]; // cumulative sum

		int ret = -1;
		int skip = 0;
		for (int i = 0; i < A.length; i++) {
			skip = C[i] + 1;
			if (A[i] - (B2[bLen - 1] - (skip > 0 ? B2[skip - 1] : 0)) < 0) {
				ret = bLen - skip - 1;
				break;
			}
		}
		return ret;
	}

}
