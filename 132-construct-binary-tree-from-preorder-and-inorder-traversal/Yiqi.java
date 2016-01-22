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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd) {
        if(preBegin > preEnd)
            return null;
        else if(preBegin == preEnd)
            return new TreeNode(preorder[preBegin]);
        TreeNode root = new TreeNode(preorder[preBegin]);
        //find root position
        int inRootPos = inBegin;
        while(inRootPos < inEnd && inorder[inRootPos] != preorder[preBegin])
            inRootPos++;
        int leftSubTreeNum = inRootPos-inBegin;
        TreeNode leftRoot = helper(preorder, inorder, preBegin+1, preBegin+leftSubTreeNum, inBegin, inRootPos-1);
        TreeNode rightRoot = helper(preorder, inorder, preBegin+leftSubTreeNum+1, preEnd, inRootPos+1, inEnd);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }
}