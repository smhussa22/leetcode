package src;

class AddTwoNumbers {

    /**
    * Definition for singly-linked list.
    */
    static class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;                                          
        int result = 0;
        ListNode head = new ListNode(0, null);
        ListNode dummy = head;

        while(l1 != null || l2 != null) {

            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            result = (carry + val1 + val2);
            carry = result / 10;
            result %= 10;

            ListNode newNode = new ListNode(result, null);
            dummy.next = newNode;

            dummy = dummy.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }

        if (carry > 0) dummy.next = new ListNode(carry, null);
        return head.next;

    }

    // helper to print list
    private static void printList(ListNode node) {

        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {

        // l1 = 2 -> 4 -> 3
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));

        // l2 = 5 -> 6 -> 4
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));

        ListNode result = addTwoNumbers(l1, l2);
        printList(result); // 7 -> 0 -> 8

    }

}
