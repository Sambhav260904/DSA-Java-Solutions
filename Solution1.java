class Solution1 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        System.out.println(n);

        // Step 1: Mark numbers (num < 0) and (num >= n) with a special marker number
        // (n+1)
        // We can ignore those because if all numbers are in the range 1 to n, then the
        // answer must be n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        for (int i : nums) {
            System.out.print(i);
        }
        System.out.println();
        // Step 2: Mark each cell appearing in the array, by converting the index for
        // that number to negative
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n) {
                continue;
            }
            num--; // -1 for zero index based array (so the number 1 will be at index 0)
            if (nums[num] > 0) { // Prevent double negative operations
                nums[num] = -1 * nums[num];
            }
        }
        for (int i : nums) {
            System.out.print(i);
        }

        // Step 3: Find the first cell which isn't negative (doesn't appear in the
        // array)
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }

        // Step 4: If no positive numbers were found, that means the array contains all
        // numbers 1..n
        return n + 1;
    }

    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        int[] nums = { };
        // System.out.println();
        System.out.println("the result is: " + s1.firstMissingPositive(nums)); // Output should be 2
    }
}
