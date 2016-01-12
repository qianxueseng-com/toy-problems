/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function(root) {
    if(!(root instanceof TreeNode))
        return 0;
    var leftRes = maxDepth(root.left);
    var rightRes = maxDepth(root.right);
    return Math.max(leftRes, rightRes) + 1;
};


//iterative version
var maxDepth = function(root) {
    if(!(root instanceof TreeNode))
        return 0;
    var queue = [];
    queue.push(root);
    var curLevelNum = 1, nextLevelNum = 0, res = 0;
    while(queue.length) {
        var tree = queue.shift();
        curLevelNum--;
        if(tree.left) {
            queue.push(tree.left);
            nextLevelNum++;
        }
        if(tree.right) {
            queue.push(tree.right);
            nextLevelNum++;
        }
        if(curLevelNum === 0) {
            curLevelNum = nextLevelNum;
            nextLevelNum = 0;
            res++;
        }
    }
    return res;
};