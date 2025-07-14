package stack_queue;

import java.util.Stack;

public class SortStack {

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sortStack(stack); // sort remaining stack
            insertInSortedOrder(stack, top);
        }
    }

    // Helper function to insert an element in sorted order
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            int top = stack.pop();
            insertInSortedOrder(stack, element);
            stack.push(top); // push back the stored element
        }
    }

    // For testing
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}

