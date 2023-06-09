
public class task1 {

    private static class Node {
        Node next;
        int value;
    }

    Node head;

    public void addToHead(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head != null)
            newNode.next = head;
        head = newNode;
    }

    public void removeFromHead() {
        if (head != null) {
            head = head.next;
        }
    }

    public boolean ValueInNodes(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value)
                return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    public void addToTail(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head == null)
            head = Node;
        else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
    }

    public void removeFromTail() {
        if (head != null) {
            Node preTailNode = head;
            while (preTailNode.next != null) {
                if (preTailNode.next.next == null) {
                    preTailNode.next = null;
                    return;
                }
                preTailNode = preTailNode.next;
            }
            head = null;
        }
    }

    public void reversNodes() {
        if (head != null && head.next != null)
            reversNodes(head.next, head);
    }

    private void reversNodes(Node currentNode, Node prevNode) {
        if (currentNode.next == null) {
            head = currentNode;
        } else {
            reversNodes(currentNode.next, currentNode);
        }
        currentNode.next = prevNode;
        prevNode.next = null;
    }
}