package com.java;

public class PowerOfFour {

	public static void main(String[] args) {

		System.out.println("Power of four or not? "+isPowerOfFour(1));
		System.out.println("Power of four or not? "+checkPowerOf2(3));
	}
    public static boolean isPowerOfFour(int num) {
    	System.out.println("Invoked isPowerOfFour method, power of four for -> "+num);
        if (num <= 0) {
            return false;
        }
        return (num & (num -1)) == 0 && (num & 0x55555555) > 0;
    }
    
    public static boolean checkPowerOf2(int n) {
        if (n <= 0) {
            return false;
        }
        return( n & (n - 1)) == 0;
    }
}
