class Solution {
    public int sumNumbers(TreeNode root) {
        int sum = 0, currSum = 0;
        Stack<TreeNode> stack = new Stack<>();  // Stack to hold nodes
        Stack<Integer> sumStack = new Stack<>();  // Stack to hold corresponding sums

        // Traverse the tree using iterative inorder traversal
        while(root != null || !stack.isEmpty()) {
            // Traverse left subtree, updating the current sum accordingly
            while(root != null) {
                stack.push(root);
                currSum = currSum * 10 + root.val;  // Update current sum with the node value
                sumStack.push(currSum);
                root = root.left;
            }
            TreeNode node = stack.pop(); // Pop the node from the stack
            currSum = sumStack.pop();  // Update the current sum
            
            // Check if it's a leaf node, if yes, update the total sum with the number formed
            if(node.left == null && node.right == null)
                sum += currSum;
            
            root = node.right;  // Traverse right subtree
        }
        return sum;  // Return the total sum of numbers formed
    }
}

// Time Complexity: O(N) - N is the number of nodes in the tree
// Space Complexity: O(h) - h is the height of the tree, due to the recursive call stack during traversal
