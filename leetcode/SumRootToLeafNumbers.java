package hr.grubic.algorithms.leetcode;

public class SumRootToLeafNumbers {

	private int totalSum = 0;
	   
	public int sumNumbers(TreeNode root) {
	     totalSum = 0;
	     sumNumbers(root, 0);
	     return totalSum;
	        
	}
	
	private void sumNumbers(TreeNode root, int sum) {
		if (root == null) {
			return;
		}
		sum = sum*10 + root.val;
		if (root.left == null && root.right == null) {
			totalSum += sum;
			return;
		}
		sumNumbers(root.left, sum);
		sumNumbers(root.right, sum);
	}
}
