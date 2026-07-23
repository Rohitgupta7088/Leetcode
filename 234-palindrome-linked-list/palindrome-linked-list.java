/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        List<Integer> ll = new ArrayList<>();
        while(temp != null){
            ll.add(temp.val);
            temp = temp.next;
        }

        for(int i=0; i<ll.size()/2; i++){
            if(ll.get(i) != ll.get(ll.size()-1-i)){
                return false;
            }
        }

        return true;
    }
}