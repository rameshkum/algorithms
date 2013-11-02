package hr.grubic.algorithms.leetcode;

public class GasStation {

	 public static int canCompleteCircuit(int[] gas, int[] cost) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if (gas == null || cost == null) return -1;
	        int n = gas.length;

	        int sum = 0;
	        boolean canTravel = true;
	        int i;
	        for (i=0; i<n; i++) {
	            int k=0;
	            int j = (i+1) % n;
	            while (k<n) {
	            	sum += gas[j];
	                sum -= cost[(j+n-1)%n];
	                
	                if (sum < 0) break;
	                k++;
	                j = (j+n) %n;
	            }
	            if (sum >= 0) {
	                return i;
	            }
	        }
	        return -1;
	    }
	 
	 public static void main(String[] args) {
		System.out.println(canCompleteCircuit(new int[]{1,2}, new int[]{2,1}));
	}
}
