/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum;

    // Main function to compute the sum of numbers formed by root-to-leaf paths
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        
        // Initialize sum to accumulate the sum of numbers formed by root-to-leaf paths
        sum = 0;
        inOrder(root, 0); // Call helper function for inorder traversal with initial current sum as 0
        return sum;
    }

    // Helper function for inorder traversal
    private void inOrder(TreeNode root, int currSum) {
        if(root == null)
            return;
        
        // Traverse left subtree, update current sum accordingly
        inOrder(root.left, currSum * 10 + root.val);

        // Check if it's a leaf node, if yes, update the total sum with the number formed
        if(root.left == null && root.right == null)
            sum += currSum * 10 + root.val;
        
        // Traverse right subtree, update current sum accordingly
        inOrder(root.right, currSum * 10 + root.val);
    }
}

//Time Complexity: O(N) - N is the number of nodes in the tree
//Space Complexity: O(h) - h is the height of the tree, due to the recursive call stack during traversal
