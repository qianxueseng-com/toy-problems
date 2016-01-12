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
    if (root) {
        var temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left) invertTree(root.left);
        if (root.right) invertTree(root.right);
    }

    return root;
};

// 层次遍历
var invertTree = function(root) {

    if (!root) return root;

    var nodeQue = [],
        count = 0,
        len, tempQue, tempNode;

    nodeQue.push(root);

    while (nodeQue.length) {
        len = nodeQue.length;
        tempQue = [];
        count++;

        for (var i = 0; i < len; i++) {
            // 遍历当前层叶子的所有下一层叶子，存入tempQue
            tempNode = nodeQue[i];
            if (tempNode) {
                var temp = tempNode.left;
                tempNode.left = tempNode.right;
                tempNode.right = temp;

                if (tempNode.left) {
                    tempQue.push(tempNode.left);
                }
                if (tempNode.right) {
                    tempQue.push(tempNode.right);
                }
            }
        }
        // 使nodeQue始终只保存一层的叶子
        nodeQue = tempQue;
    }

    return root;
}
