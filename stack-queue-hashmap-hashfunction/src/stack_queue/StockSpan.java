package stack_queue;

import java.util.Stack;

public class StockSpan {

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop all smaller or equal prices
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, span is entire range till now
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push current index
            stack.push(i);
        }

        return span;
    }

    // For testing
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices);

        System.out.print("Stock Spans: ");
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}

