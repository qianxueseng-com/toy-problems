/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} node
 * @return {void} Do not return anything, modify node in-place instead.
 *///链表的操作有点麻烦，还是要多看几遍
var deleteNode = function(node) {
    if (node === null) return;
    node.val = node.next.val;
    node.next = node.next.next;
};
