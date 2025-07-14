package stack_queue;

import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> stackEnqueue;
    private Stack<Integer> stackDequeue;

    public QueueUsingStack() {
        stackEnqueue = new Stack<>();
        stackDequeue = new Stack<>();
    }

    // Enqueue operation - O(1)
    public void enqueue(int x) {
        stackEnqueue.push(x);
    }

    // Dequeue operation - Amortized O(1)
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (stackDequeue.isEmpty()) {
            transfer();
        }
        return stackDequeue.pop();
    }

    // Peek operation - Amortized O(1)
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (stackDequeue.isEmpty()) {
            transfer();
        }
        return stackDequeue.peek();
    }

    // Check if queue is empty - O(1)
    public boolean isEmpty() {
        return stackEnqueue.isEmpty() && stackDequeue.isEmpty();
    }

    // Transfer elements from enqueue stack to dequeue stack
    private void transfer() {
        while (!stackEnqueue.isEmpty()) {
            stackDequeue.push(stackEnqueue.pop());
        }
    }

    // For testing
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue()); // 10
        queue.enqueue(40);
        System.out.println(queue.peek());    // 20
        System.out.println(queue.dequeue()); // 20
        System.out.println(queue.dequeue()); // 30
        System.out.println(queue.dequeue()); // 40
        System.out.println(queue.isEmpty()); // true
    }
}

