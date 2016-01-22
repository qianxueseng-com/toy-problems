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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int inBegin, int inEnd, int posBegin, int posEnd) {
        if(inBegin > inEnd)
            return null;
        else if(inBegin == inEnd)
            return new TreeNode(inorder[inBegin]);
        TreeNode root = new TreeNode(postorder[posEnd]);
        //find root position in inorder array
        int rootPos = inBegin;
        while(rootPos < inEnd && inorder[rootPos] != postorder[posEnd])
            rootPos++;
        int len = rootPos-inBegin;
        TreeNode leftRoot = helper(inorder, postorder, inBegin, rootPos-1, posBegin, posBegin+len-1);
        TreeNode rightRoot = helper(inorder, postorder, rootPos+1, inEnd, posBegin+len, posEnd-1);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }
}