import java.util.LinkedList;

public class QueueWithLinkedList<T> {
    private LinkedList<T> queue;

    // Constructor
    public QueueWithLinkedList() {
        queue = new LinkedList<>();
    }

    // Enqueue element to the end of the queue
    public void enqueue(T element) {
        queue.addLast(element);  // Add to the end of the list (end of the queue)
    }

    // Dequeue element from the front of the queue
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;  // Return null if the queue is empty
        }
        return queue.removeFirst();  // Remove from the front (beginning of the queue)
    }

    // Peek at the front element without removing it
    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;  // Return null if the queue is empty
        }
        return queue.getFirst();  // Get the first element (front of the queue)
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Get the size of the queue
    public int size() {
        return queue.size();
    }

    public static void main(String[] args) {
        QueueWithLinkedList<Integer> queue = new QueueWithLinkedList<>();

        // Enqueue elements to the queue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek());  // Output: 10
        System.out.println("Queue size: " + queue.size());     // Output: 3

        // Dequeue elements from the queue
        System.out.println("Dequeued element: " + queue.dequeue());  // Output: 10
        System.out.println("Queue size: " + queue.size());           // Output: 2
        System.out.println("Front element after dequeue: " + queue.peek());  // Output: 20
    }
}