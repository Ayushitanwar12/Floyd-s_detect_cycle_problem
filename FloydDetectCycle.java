// Definition for singly-linked list.
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    // Constructor to initialize a new node with a value
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class FloydDetectCycle {

    // Method to detect cycle in the linked list using Floyd's Tortoise and Hare algorithm
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // Empty list or single node cannot form a cycle
        }

        // Two pointers: slow and fast
        ListNode fast = head;
        ListNode slow = head;

        // Traverse the list with slow moving one step at a time, fast moving two steps at a time
        while (fast != null && fast.next != null) {
            slow = slow.next;             // Slow moves 1 step
            fast = fast.next.next;        // Fast moves 2 steps

            // If slow and fast meet, there is a cycle
            if (fast == slow) {
                return true;
            }
        }

        // If fast pointer reaches the end, there is no cycle
        return false;
    }

    // Main method for testing the function
    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 2 (cycle)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next.next; // Creates a cycle, 5 -> 3

        // Create a FloydDetectCycle object to call hasCycle() method
        FloydDetectCycle sol = new FloydDetectCycle();

        // Test if the list has a cycle
        boolean result = sol.hasCycle(head);
        System.out.println(result); // Output: true

        // Test case: no cycle
        ListNode noCycleHead = new ListNode(1);
        noCycleHead.next = new ListNode(2);
        noCycleHead.next.next = new ListNode(3);

        result = sol.hasCycle(noCycleHead);
        System.out.println(result); // Output: false
    }
}



