/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	//recursion version
	public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftRes = maxDepth(root.left);
        int rightRes = maxDepth(root.right);
        return Math.max(leftRes, rightRes) + 1;
    }
	
	//the iterative version1: the idea is to do a layer order traversal.
	//It uses two queues: treeQueue and layerQueue. layerQueue keeps track
	//of the layer of the corresponding treeNode. 
	public int maxDepth(TreeNode root) {
        LinkedList<TreeNode> treeQueue = new LinkedList<>();
        LinkedList<Integer> layerQueue = new LinkedList<>();
        if(root == null) return 0;
        treeQueue.offer(root);
        layerQueue.offer(1);
        int res = 1;
        while(!treeQueue.isEmpty()) {
            int layer = layerQueue.poll();
            TreeNode cur = treeQueue.poll();
            res = Math.max(res, layer);
            if(cur.left != null) {
                treeQueue.offer(cur.left);
                layerQueue.offer(layer+1);
            }
            if(cur.right != null) {
                treeQueue.offer(cur.right);
                layerQueue.offer(layer+1);
            }
        }
        return res;
    }
	
	//iterative version2: the iterative version1 use o(2n) space.
	//o(n) for tree queue and o(n) for layer queue. We can actually 
	//save o(n) layer queue space by defining a variable called curLayerNum, nextLayerNum
	//curLayerNum is the number of tree Nodes in this layer and nextLayerNum is the number
	//of treeNodes in next layer. Each time we visit a node, curLayerNum--. If it has left child
	// nextLayerNum++ and if it has right child, nextLayerNum++. In this way, when curLayerNum
	//equals to 0, we know we are going to traverse the next layer. So set curLayerNum = nextLayerNum
	//, nextLayerNum = 0.
    public int maxDepth(TreeNode root) {
    	LinkedList<TreeNode> queue = new LinkedList<>();
        if(root == null)    return 0;
        queue.offer(root);
        int curLayerNum = 1;
        int nextLayerNum = 0;
        int res = 0;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            curLayerNum--;
            if(cur.left != null) {
                queue.offer(cur.left);
                nextLayerNum++;
            }
            if(cur.right != null) {
                queue.offer(cur.right);
                nextLayerNum++;
            }
            if(curLayerNum == 0) {
                curLayerNum = nextLayerNum;
                nextLayerNum = 0;
                res++;
            }
        }
        return res;
    }
}