package hr.grubic.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CandyDistribution {

public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int k = sc.nextInt();
        int[] boxes = new int[n];
        for (int i=0; i<n; i++) {
             boxes[i] = sc.nextInt();
        }
        
        Arrays.sort(boxes);

        int min = Integer.MAX_VALUE;
     
        for (int i=0; i<n-k+1; i++) {
            int unfairness = 0;
        	for (int x=i; x<i+k-1; x++) {
				for (int z=x+1; z<i+k; z++) {
					int diff = boxes[x] - boxes[z];
					unfairness += Math.abs(diff);
				}
			}
        	if (unfairness<min) min=unfairness;
    	}       
        System.out.println(min);
        
        System.out.println(min);
    }

		private static int calculateUnfairness(LinkedList<Integer> queue, int k) {
			int unfairness = 0;
			for (int i=0;i<k-1;i++) {
				for (int j=i+1;j<k;j++) {
					int diff = queue.get(i) - queue.get(j);
					unfairness += Math.abs(diff);
				}
			}
			return unfairness;
		}

		private static int min(int a, int b, int c) {
			if (a<=b && a<=c) return a;
			if (b<=a && b<=c) return b;
			return c;
	}

	private static int max(int a, int b, int c) {
		if (a>=b && a>=c) return a;
		if (b>=a && b>=c) return b;
		return c;
	}
}
