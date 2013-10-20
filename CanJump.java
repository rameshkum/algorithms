package hr.grubic.algorithms;

/**
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false. 
 *
 */
public class CanJump {

	public static boolean canJump(int[]A) {
		if (A== null || A.length == 0) {
			return false;
		}
		if (A.length == 1) return true;
		int x = 0;
		for (int i=0; i<A.length; i++) {
			if (i < x) continue;
			if (i==x) {
				if (x==A.length-1) {
					return true;
				}
				x += A[i];
			}
			if (i > x) return false;
		}
		if (x>=A.length-1) {
			return true;
		}
		return false;
	}
}
