/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
	//I always delete the first node except the situation the list only
	//has one node
    public void deleteNode(ListNode node) {
    	if(node == null)
            return;
        if(node.next == null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}