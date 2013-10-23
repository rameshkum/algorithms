package hr.grubic.algorithms.leetcode;

import java.util.ArrayList;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

	For example, given k = 3,
	Return [1,3,3,1]. 
 *
 */
public class PascalTriangle2 {

	public ArrayList<Integer> getRow(int rowIndex) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (rowIndex< 0) {
            return null;
        }
        ArrayList<Integer> row = null;
        ArrayList<Integer> prev = new ArrayList<Integer>();
        if (rowIndex == 0) {
            row = new ArrayList<Integer>();
            row.add(1);
            return row;
        }
        prev.add(1);
        prev.add(1);
        if (rowIndex == 1) {
            return prev;
        }
        for (int j=2; j<=rowIndex; j++) {
            row = new ArrayList<Integer>();
            row.add(1);
            for (int i=1; i<j; i++) {
                row.add(prev.get(i-1)+prev.get(i));
            }
            row.add(1);
            prev = row;
        }
        return row;
    }
}
