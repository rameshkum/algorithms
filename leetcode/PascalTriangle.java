package hr.grubic.algorithms.leetcode;

import java.util.ArrayList;

/*Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/
public class PascalTriangle {

	
	
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
        if (numRows <= 0) {
           return solution;
       }
       ArrayList<Integer> row = new ArrayList<Integer>();
       row.add(1);
       solution.add(row);
       if (numRows == 1) {    
           return solution;
       }
       row = new ArrayList<Integer>();
       row.add(1);
       row.add(1);
       solution.add(row);
       if (numRows == 2) {
           return solution;
       }
       for (int j=2; j<numRows; j++) {
           row = new ArrayList<Integer>();
           row.add(1);
           ArrayList<Integer> prev = solution.get(j-1);
           for (int i=1; i<j; i++) {
               row.add(prev.get(i-1)+prev.get(i));
           }
           row.add(1);
          solution.add(row);
       }
       return solution;
   }
       
}
