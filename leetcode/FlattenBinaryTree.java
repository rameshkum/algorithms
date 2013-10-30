package hr.grubic.algorithms.leetcode;

/**
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6

The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

 *
 *
 */
public class FlattenBinaryTree {

	public class TreeNode {
		   int val;
		   TreeNode left;
		   TreeNode right;
		   TreeNode(int x) { val = x; }
	}
	
	 public void flatten(TreeNode root) {
	      if (root== null) return;
	      TreeNode left = root.left;
	      TreeNode right = root.right;
	      
	      if (left != null) {
	    	  root.right = left;
	    	  root.left = null;
	    	  
	    	  TreeNode tmp = left;
	    	  while (tmp.right != null) {
	    		  tmp = tmp.right;
	    	  }
	    	  tmp.right = right;
	      }
	      
	      flatten(root.right);
	       
	    }

}
