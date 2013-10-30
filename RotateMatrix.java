package hr.grubic.algorithms;

/**
 * Given NxN matrix, rotate it by 90 degrees
 *
 */
public class RotateMatrix {

	public static void rotate(int[][]A) {
		int N = A.length;
		//1. step: transpose
		for (int i=0;i<N; i++) {
			for (int j=i+1;j<N;j++) {
				int tmp = A[i][j];
				A[i][j] = A[j][i];
				A[j][i] = tmp;
			}
		}
		//2.step: change columns
		int i =0;
		int j= N-1;
		while (i<j) {
			for (int k=0;k<N;k++) {
				int tmp = A[k][i];
				A[k][i] = A[k][j];
				A[k][j] = tmp;
			}
			i++;
			j--;
		}
		
		
	}
	
	public static void main(String[]args) {
		int[][]A = new int[][]{{1,2,3,4}, {5,6,7,8},{9,10,11,12}, {13,14,15,16}};
		rotate(A);
		int N = A.length;
		for (int i=0;i<N; i++) {
			for (int j=0;j<N;j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}
}
