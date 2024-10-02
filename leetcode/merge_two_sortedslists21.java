package leetcode;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class merge_two_sortedslists21{
    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //     // Create a dummy node to simplify the merge process
    //     ListNode dummy = new ListNode(0);
    //     ListNode current = dummy;

    //     // Traverse both lists and merge them
    //     while (list1 != null && list2 != null) {
    //         if (list1.val <= list2.val) {
    //             current.next = list1;
    //             list1 = list1.next;
    //         } else {
    //             current.next = list2;
    //             list2 = list2.next;
    //         }
    //         current = current.next;
    //     }

    //     // Append the remaining nodes from list1 or list2
    //     if (list1 != null) {
    //         current.next = list1;
    //     } else {
    //         current.next = list2;
    //     }

    //     // Return the merged list starting from the node next to dummy
    //     return dummy.next;
    // }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Base cases
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Recursive step
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        merge_two_sortedslists21 solution = new merge_two_sortedslists21();

        // Example 1
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = solution.mergeTwoLists(list1, list2);
        printList(result); // Output: [1, 1, 2, 3, 4, 4]

        // Example 2
        ListNode list3 = null;
        ListNode list4 = null;
        result = solution.mergeTwoLists(list3, list4);
        printList(result); // Output: []

        // Example 3
        ListNode list5 = null;
        ListNode list6 = new ListNode(0);
        result = solution.mergeTwoLists(list5, list6);
        printList(result); // Output: [0]
    }

    // Utility method to print the list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
