/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} inorder
 * @param {number[]} postorder
 * @return {TreeNode}
 */
var buildTree = function(inorder, postorder) {
    return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
};

function helper(inorder, postorder, inBegin, inEnd, posBegin, posEnd) {
    if(inBegin > inEnd)
        return null;
    else if(inBegin == inEnd)
        return new TreeNode(inorder[inBegin]);
    var root = new TreeNode(postorder[posEnd]);
    var inRootPos = inBegin;
    while(inRootPos < inEnd && inorder[inRootPos] != postorder[posEnd])
        inRootPos++;
    var len = inRootPos-inBegin;
    var leftRoot = helper(inorder, postorder, inBegin, inRootPos-1, posBegin, posBegin+len-1);
    var rightRoot = helper(inorder, postorder, inRootPos+1, inEnd, posBegin+len, posEnd-1);
    root.left = leftRoot;
    root.right = rightRoot;
    return root;
}