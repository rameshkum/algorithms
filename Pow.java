package hr.grubic.algorithms;

public class Pow {

	public static double pow(double x, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (n == 0) return x;
        if (n <0) return 1/pow(x,-n,n); 
        return pow(x,n,n);
    }
    
    private static double pow(double x, int n, int i) {
    	if (i==1) return x;
        return x*pow(x,n,--i);
    }
    
}
