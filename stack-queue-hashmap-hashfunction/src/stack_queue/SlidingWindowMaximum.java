package stack_queue;

import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove all smaller elements from the end
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offer(i);

            // Store result once the first window is completed
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }

    // For testing
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);

        System.out.print("Sliding Window Maximum: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}

