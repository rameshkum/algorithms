package hr.grubic.algorithms;

/**
 * Given NxN matrix, rotate it by 90 degrees
 *
 */
public class RotateMatrix {

	public static void rotate(int[][]A) {
		int N = A.length;
		//1. step: transpose
		for (int r=0;r<N; r++) {
			for (int c=r+1;c<N;c++) {
				int tmp = A[r][c];
				A[r][c] = A[c][r];
				A[c][r] = tmp;
			}
		}
		//2.step: change columns;
		for (int c=0; c<N/2; c++) {
			for (int r=0; r<N; r++) {
				int tmp = A[r][N-c-1];
				A[r][N-c-1] = A[r][c];
				A[r][c] = tmp;
			}
		}
	}
	
	public static void rotateAlternative(int[][]A) {
		int N = A.length;
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
