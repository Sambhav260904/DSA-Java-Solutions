// import java.util.*;

// public class KthLargestElementinanArray {
//     public static int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for (int i = 0; i < nums.length; i++) {
//             pq.add(nums[i]);
//             if (pq.size() > k) {
//                 pq.poll(); // remove the smallest element
//             }
//         }

//         return pq.peek(); // return the kth largest element
//     }

//     public static void main(String[] args) {
//         int res = findKthLargest(new int[] { 3, 2, 1, 5, 66, 4 }, 6);
//         System.out.println(res);
//     }
// }

import java.util.PriorityQueue;

public class KthLargestElementinanArray {
    public static int findKthLargest(int[] nums, int k) {
        // Min-heap of size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Process each number in the array
        for (int num : nums) {
            minHeap.offer(num); // Add the number to the heap

            // If heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element (root of the heap)
            }
        }

        // The root of the heap is the k-th largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int res = findKthLargest(new int[] { 3, 2, 1, 5, 66, 4 }, 1);
        System.out.println(res);
    }
}