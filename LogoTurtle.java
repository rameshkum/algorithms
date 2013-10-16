package hr.grubic.algorithms;

public class LogoTurtle {

	
	public static int move(int A[]) {
		if (A==null || A.length == 0) {
			return 0;
		}
		for (int i=0; i<A.length;i++) {
			if (CrossesPath(A, i)) {
				return i+1;
			}
		}
		return 0;
	}
	
	private static boolean CrossesPath(int A[], int n) {
		if (n<3) return false;
		if (A.length==4 && A[n] >=A[n-2] && A[n]>=A[n-1]){
			return true;
		}
		if (n<6) return false;
		if (A[n] >= A[n-4] && A[n]>=A[n-6]) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int A[] = new int[] {1,3,2,5,4,4,6,3,2};
		System.out.println(move(A));
	}
}
