package com.java;

public class DeepestPit {

	public static void main(String[] args) {
		int[] A = new int[10];

		A[0] = 0;
		A[1] = 1;
		A[2] = 3;
		A[3] = -2;
		A[4] = 0;
		A[5] = 1;
		A[6] = 0;
		A[7] = -3;
		A[8] = 2;
		A[9] = 3;
		System.out.println(deepest(A));
	}

	private static int deepest(int[] data) {

		if (data.length < 1) {
			return 0;
		}

		int inflection = 0;
		int max = 0;
		int descent = 0;
		boolean ascending = true;
		for (int i = 1; i < data.length; i++) {
			boolean goingup = data[i] == data[i - 1] ? ascending : data[i] >= data[i - 1];
			if (goingup != ascending) {
				ascending = goingup;
				descent = ascending ? (data[inflection] - data[i - 1]) : 0;
				inflection = i - 1;
			}

			max = Math.max(max, Math.min(descent, data[i] - data[inflection]));
		}
		return max;
	}
	
}
