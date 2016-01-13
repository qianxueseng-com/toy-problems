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

// 一：递归 深度优先 前序遍历
// Runtime: 184 ms
var maxDepth_1 = function(root) {
    if (!root) return 0;
    return Math.max(maxDepth_1(root.left), maxDepth_1(root.right)) + 1;
};

// 二：循环 分层遍历，记录层数
// Runtime: 170 ms
var maxDepth_2 = function(root) {

    if (!root) return 0;

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

    return count;
}

// 三：循环 分层遍历，记录层数
// 第二种实现，不借助tempQue
// Runtime: 284 ms 可能是因为shift操作比较耗时
var maxDepth_3 = function(root) {

    if (!root) return 0;

    var nodeQue = [],
        count = 0,
        len, tempNode;

    nodeQue.push(root);

    while (nodeQue.length) {
        len = nodeQue.length;
        count++;

        for (var i = 0; i < len; i++) {
            // len保证nodeQue中只有上一层的叶子会被shift取出
            // 遍历当前层叶子的所有下一层叶子
            tempNode = nodeQue.shift();
            if (tempNode) {
                if (tempNode.left) {
                    nodeQue.push(tempNode.left);
                }
                if (tempNode.right) {
                    nodeQue.push(tempNode.right);
                }
            }
        }
    }

    return count;
}

// 四：循环 后序遍历
// Runtime: 192 ms
var maxDepth_4 = function(root) {
    var s = [],
        tag = [],
        p = root,
        deep = 0;

    while (p || s.length !== 0) {
        while (p) {
            s.push(p);
            tag.push(0);
            p = p.left;
        }
        if (tag[tag.length - 1] === 1) {
            deep = deep > s.length ? deep : s.length;
            s.pop();
            tag.pop();
            p = null;
        } else {
            p = s[s.length - 1].right;
            tag[tag.length - 1] = 1;
        }
    }

    return deep;
}
