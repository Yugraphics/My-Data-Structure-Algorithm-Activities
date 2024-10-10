class LinkedListImplementation<T> {
    // Node class representing each element in the LinkedList
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;  // Head (first) node of the LinkedList

    // Constructor to initialize an empty LinkedList
    public LinkedListImplementation() {  // Fix constructor name here
        head = null;
    }

    // Add a new element to the end of the list
    public void add(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Remove an element from the list by value
    public void remove(T data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // If the head node holds the data to be removed
        if (head.data.equals(data)) {
            head = head.next;
            System.out.println("Removed: " + data);
            return;
        }

        Node current = head;
        Node prev = null;

        // Traverse the list to find the node to be removed
        while (current != null && !current.data.equals(data)) {
            prev = current;
            current = current.next;
        }

        // If the data is not found
        if (current == null) {
            System.out.println("Element not found.");
            return;
        }

        // Unlink the node from the list
        prev.next = current.next;
        System.out.println("Removed: " + data);
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Print the elements in the list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListImplementation<Integer> list = new LinkedListImplementation<>();  // Change here to match the class name

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("Linked List:");
        list.printList();  // Output: 10 20 30

        list.remove(20);
        System.out.println("After removing 20:");
        list.printList();  // Output: 10 30

        list.remove(40);   // Element not found
        list.remove(10);
        list.printList();  // Output: 30
    }
}
