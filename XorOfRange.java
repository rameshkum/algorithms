package net.codejava.lambda;

public class XorOfRange {

	public static void main(String[] args) {

		int value = findXORofRange(5,8);
		
		System.out.println("Value: "+value);
		System.out.println("Value: "+ (short) (5 ^ 8));
	}
	public static int findXORofRange(int m, int n) {
	    int[] patternTracker;

	    if(m % 2 == 0)
	        patternTracker = new int[] {n, 1, n^1, 0};
	    else
	        patternTracker = new int[] {m, m^n, m-1, (m-1)^n};

	    return patternTracker[(n-m) % 4];
	}
}
