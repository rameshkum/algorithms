package hr.grubic.algorithms.leetcode;

import java.util.Stack;

public class Trapping {

    public static int trap(int[] A) {
        if (A==null || A.length==0)  return 0;
        int i=0;
        while (i<A.length && A[i]==0 ) {
            i++;
        }
        if (i>=A.length) return 0;
        int vol = 0;
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = 0;
        for (int j=1; j<A.length; j++) {
        	left[j] = Math.max(A[j-1], left[j-1]);
        }
        for (int j=A.length-2; j>=0; j--) {
        	right[j] = Math.max(A[j+1], right[j+1]);
        }
        
        for ( i=0;i<A.length;i++){
            if (Math.min(left[i],right[i])-A[i] >0 ){
                vol += Math.min(left[i],right[i])-A[i];
            }
        }
         
        return vol;
    }
    
    private static int histogramWithStack(int[] A) {
    	if (A==null || A.length ==0) return 0;
    	Stack<Integer> stack = new Stack<Integer>();
    	int n = A.length;
    	int[] area = new int[n];
    	for (int i=0; i<n; i++) {
    		while (!stack.isEmpty() && A[i]<=A[stack.peek()]) {
    			stack.pop();
    		}
    		if (stack.isEmpty()) {
    			area[i] = i;
    		} else {
    			area[i] = i- stack.peek()-1;
    		}
    		stack.push(i);
    	}
    	printArray(area);
    	stack.clear();
    	for (int i=n-1; i>=0; i--) {
    		while (!stack.isEmpty() && A[i]<=A[stack.peek()]) {
    			stack.pop();
    		}
    		if (stack.isEmpty()) {
    			area[i] += n-i-1;
    		} else {
    			area[i] += stack.peek()-i-1;
    		}
    		
    		stack.push(i);
    	}
    	printArray(area);
    	int max = Integer.MIN_VALUE;
    	for (int i=0; i<n; i++) {
    		area[i] = A[i] * (area[i]+1);
    		if (area[i]>max) {
    			max = area[i];
    		}
    	}
    	return max;
    }
    
    private static void printArray(int[] arr) {
    	for (int i=0; i<arr.length; i++) {
    		System.out.print(arr[i]);
    	}
    	System.out.println();
    }
    
    private static int histogram(int[]A) {
    	return histogram(A, 0, A.length-1);
    }
    
    private static int histogram(int[]A, int lo, int hi) {
    	if (lo > hi)  return Integer.MIN_VALUE;
        if (lo == hi)  return A[lo];
     
    	int min = findMin(A, lo, hi);
    	int m1 = Math.max(histogram(A, lo, min-1), histogram(A, min+1, hi));
    	int m2 = Math.max(m1, A[min]*(hi-lo+1));
    	return m2;
    }
    
    private static int findMin(int[] A, int lo, int hi) {
    	int min = A[lo];
    	int minIndex = lo;
    	for (int i=lo+1; i<=hi; i++) {
    		if (A[i]<min) {
    			min = A[i];
    			minIndex = i;
    		}
    	}
    	return minIndex;
    }
    
    public static void main(String[] args) {
    	int[] a = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
    	System.out.println(trap(a));
    }
    
    
}
