import java.util.LinkedList;

public class StackWithLinkedList<T> {
    private LinkedList<T> stack;

    // Constructor to initialize the stack
    public StackWithLinkedList() {
        stack = new LinkedList<>();
    }

    // Push element onto the stack
    public void push(T value) {
        stack.addFirst(value);
    }

    // Pop element from the stack
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stack.removeFirst();
    }

    // Peek at the top element of the stack
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stack.getFirst();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Get the size of the stack
    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        StackWithLinkedList<Integer> stack = new StackWithLinkedList<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element is: " + stack.peek()); // 30
        System.out.println("Stack size: " + stack.size()); // 3

        System.out.println("Popped element: " + stack.pop()); // 30
        System.out.println("Top element after pop: " + stack.peek()); // 20
    }
}
