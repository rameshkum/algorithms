package hr.grubic.algorithms;

public class Pow {

	public static double pow(double x, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		 if (n == 0 || x == 1) return 1;
	        if (Math.abs(x) < 0.0001) return 0;
	        int i=2;
	        double solution = (n<0) ? 1/x : x;
	        int z = Math.abs(n);
	        while (i<=z) {
	            if (n<0) {
	                solution*=1/x;
	            } else {
	                solution*=x;
	            }
	            i++;
	        }
	        return solution;
    }

    
}
