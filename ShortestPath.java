
package hr.grubic;

import java.util.ArrayList;

/*Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. */
public class ShortestPath {
	 public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
	       if (triangle == null || triangle.size() == 0) return 0;
	       return minSum(triangle, 0, 0, 0);
	    }
	 
	 public static int minSum(ArrayList<ArrayList<Integer>> triangle, int k, int i, int currentSum) {
		 if (k == triangle.size()) {
			 return currentSum;
		 }
		 ArrayList<Integer> currentRow = triangle.get(k);
		 
		 currentSum += currentRow.get(i);
		 int sum1 = minSum(triangle, k+1, i, currentSum);
		 int sum2 = minSum(triangle, k+1, i+1, currentSum); 
		 if (sum1 <= sum2) return sum1;
		 return sum2;
		 
	 }
	 
	 public static int minSumNonRecursive(ArrayList<ArrayList<Integer>> triangle) {
		 int n = triangle.size();
		 for(int i = n - 2; i >= 0; i--)
	     {
			 ArrayList<Integer> currentRow = triangle.get(i);
			 for(int j = 0; j < currentRow.size(); j++)	{
				 currentRow.set(j, currentRow.get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
			 }
	     }   
	     return triangle.get(0).get(0);
		 
	 }

	 public static void main(String[] args)  {
		 ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		 ArrayList<Integer> firstRow = new ArrayList<Integer>();
		 firstRow.add(2);
		 ArrayList<Integer> secondRow = new ArrayList<Integer>();
		 secondRow.add(3); secondRow.add(4);
		 ArrayList<Integer> thirdRow = new ArrayList<Integer>();
		 thirdRow.add(4); thirdRow.add(1); thirdRow.add(6);
		 ArrayList<Integer> fourthRow = new ArrayList<Integer>();
		 fourthRow.add(4); fourthRow.add(4); fourthRow.add(8); fourthRow.add(0);
		 triangle.add(firstRow);
		 triangle.add(secondRow);
		 triangle.add(thirdRow);
		 triangle.add(fourthRow);
		 System.out.println(minimumTotal(triangle));
		 System.out.println(minSumNonRecursive(triangle));
	 }
}
