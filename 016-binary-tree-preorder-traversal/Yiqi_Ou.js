/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal = function(root) {
    var stack = [], res = [];
    if(root === null)
        return res;
    var cur = root;
    while(cur !== null || stack.length) {
        if(cur !== null) {
            res.push(cur.val);
            if(cur.right !== null)
                stack.push(cur.right);
            cur = cur.left;
        }
        else {
            cur = stack.pop();
        }
    }
    return res;
};