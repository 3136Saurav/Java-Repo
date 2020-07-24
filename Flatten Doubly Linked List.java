/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null)
            return head;
        
        Node curr = head;
        Node prev = null;
        // Node next = curr.next;
        Stack<Node> stack = new Stack<>();
        
        while (curr != null) {
            if (curr.child != null) {
                Node next = curr.next;
                if (next != null)
                    stack.push(next);
                Node child = curr.child;
                curr.next = child;
                child.prev = curr;
                curr.child = null;
            }
            prev = curr;
            curr = curr.next;
        }
        
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            prev.next = temp;
            temp.prev = prev;
            curr = temp;
            while (curr.next != null) {
                curr = curr.next;
            }
            prev = curr;
        }
        
        return head;
    }
}
