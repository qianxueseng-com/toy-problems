/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        Stack<TreeNode> treeStack = new Stack<TreeNode>();
        treeStack.push(root);
        while(!treeStack.isEmpty()) {
            TreeNode cur = treeStack.pop();
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            if(cur.left != null)
                treeStack.push(cur.left);
            if(cur.right != null)
                treeStack.push(cur.right);
        }
        return root;
    }
}