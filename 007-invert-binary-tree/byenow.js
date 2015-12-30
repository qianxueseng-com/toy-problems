/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var invertTree = function(root) {
    //判断root是否合理
    if(root===null){
        return null;
    }else{
        var node=root.left;
        root.left=root.right;
        root.right=node;
    }
    //判断左右分支是否存在
    if(root.left){
        invertTree(root.left);
    }
    if(root.right){
        invertTree(root.right);
    }
    return root;
};
