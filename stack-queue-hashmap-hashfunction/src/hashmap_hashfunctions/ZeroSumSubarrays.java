package hashmap_hashfunctions;

import java.util.*;

public class ZeroSumSubarrays {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int sum = 0;

        // Add base case: sum 0 at index -1
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sumMap.containsKey(sum)) {
                for (int startIndex : sumMap.get(sum)) {
                    result.add(new int[] { startIndex + 1, i });
                }
            }

            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        return result;
    }

    // For testing
    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, -4, -2, -2};

        List<int[]> subarrays = findZeroSumSubarrays(arr);

        System.out.println("Zero-sum subarrays:");
        for (int[] pair : subarrays) {
            System.out.println("Start: " + pair[0] + ", End: " + pair[1]);
        }
    }
}

