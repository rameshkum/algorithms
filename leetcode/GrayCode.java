package hr.grubic.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2

Note:
For a given n, a gray code sequence is not uniquely defined. 
 *
 */
public class GrayCode {
	
	
	public static void yarg(String prefix, int n, List<Integer> solution) {
        if (n == 0)  {
        	System.out.println("yarg "+ prefix);
        	solution.add(binaryStringToInteger(prefix));
        }
        else {
            gray(prefix + "1", n - 1, solution);
            yarg(prefix + "0", n - 1, solution);
        }
    }  

    // append order n gray code to end of prefix string, and print
    public static void gray(String prefix, int n, List<Integer> solution) {
        if (n == 0) {
        	System.out.println("gray "+ prefix);
        	solution.add(binaryStringToInteger(prefix));
        }
        else {
            gray(prefix + "0", n - 1, solution);
            yarg(prefix + "1", n - 1, solution);
        }
    }  

    private  static int binaryStringToInteger(String s) {
    	int sum = 0;
    	int a = 0;
    	for (int i=s.length()-1; i>=0; i--) {
    		int digit = s.charAt(i) - 48;
    		sum += digit * Math.pow(2, a);
    		a++;
    	}
    	return sum;
    }
    
	public static void main(String[] args) {
		int a = 3;
		a = a++;
		System.out.println(a);
		List<Integer> solution = new ArrayList<Integer>();
		gray("",3, solution);
		System.out.println(solution);
		System.out.println(binaryStringToInteger("111"));	
	}

}
