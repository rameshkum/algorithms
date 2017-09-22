package com.java;

import java.util.HashSet;
import java.util.Set;

/**
 Method to Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

For another example, given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 @author rameshkum

 */
public class MissingInteger {

	public static void main(String[] args) {
		int A[] = new int[] { 1, 3, 6, 4, 1, 2 };

		System.out.println("Solution for Missing integer is: " + solution(A));
	}

	public static int solution(int[] A) {
		int num = 1;
		Set<Integer> integers = new HashSet<Integer>();
		int i = 0;
		for (System.out.println("Initialization Value:" + i); i < A.length; System.out
				.println("After increment the value:" + i)) {
			integers.add(A[i]);

			while (integers.contains(num)) {
				num++;
			}
			i++;
		}

		return num;
	}
}
