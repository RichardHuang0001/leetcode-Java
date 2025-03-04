package 链表;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {}
    public ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    /**
     * Creates a linked list from a List of integers, with an optional cycle.
     * @param nums The values to create nodes for
     * @param pos Position to create a cycle to (-1 means no cycle)
     * @return Head of the created linked list
     */
    public static ListNode createList(List<Integer> nums, int pos) {
        if (nums == null || nums.isEmpty()) {
            return null;
        }

        ListNode head = new ListNode(nums.get(0));
        ListNode current = head;
        ListNode cycleNode = null;

        // Create all nodes in the list
        for (int i = 1; i < nums.size(); i++) {
            current.next = new ListNode(nums.get(i));
            current = current.next;

            // Store the node at position pos for creating a cycle later
            if (i == pos) {
                cycleNode = current;
            }
        }

        // Create a cycle if pos is valid
        if (pos >= 0 && pos < nums.size()) {
            // The last node should point to the node at position pos
            // If pos == 0, that's the head
            if (pos == 0) {
                current.next = head;
            } else {
                current.next = cycleNode;
            }
        }

        return head;
    }

    /**
     * Generates a string representation of the linked list.
     * If there's a cycle, it identifies where the cycle begins.
     * NOTE: This will run infinitely if there's a cycle and you don't detect it!
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Set<ListNode> visited = new HashSet<>();
        ListNode current = this;

        sb.append("[");

        while (current != null) {
            if (visited.contains(current)) {
                // We've detected a cycle
                sb.append(" → (cycle to node with value " + current.val + ")");
                break;
            }

            visited.add(current);
            sb.append(current.val);

            if (current.next != null && !visited.contains(current.next)) {
                sb.append(" → ");
            }

            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    /**
     * Helper method to create a linked list without a cycle.
     */
    public static ListNode createList(List<Integer> nums) {
        return createList(nums, -1);  // -1 indicates no cycle
    }
}

