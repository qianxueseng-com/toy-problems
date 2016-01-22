/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function(preorder, inorder) {
    return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
};

function helper(preorder, inorder, preBegin, preEnd, inBegin, inEnd) {
    if(preBegin > preEnd)   
        return null;
    else if(preBegin == preEnd)
        return new TreeNode(preorder[preBegin]);
    var root = new TreeNode(preorder[preBegin]);
    var inRootPos = inBegin;
    while(inRootPos < inEnd && inorder[inRootPos] !== preorder[preBegin])
        inRootPos++;
    var leftSubLen = inRootPos-inBegin;
    var leftRoot = helper(preorder, inorder, preBegin+1, preBegin+leftSubLen, inBegin, inRootPos-1);
    var rightRoot = helper(preorder, inorder, preBegin+leftSubLen+1, preEnd, inRootPos+1, inEnd);
    root.left = leftRoot;
    root.right = rightRoot;
    return root;
}