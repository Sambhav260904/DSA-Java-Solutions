public class kadanes_Algorithm {

    public static int maxSubArraySum(int[] nums) {
        // Initialize variables
        int maxEndingHere = nums[0];  // Maximum sum ending at the current position
        int maxSoFar = nums[0];       // Maximum sum found so far
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Update maxEndingHere by either adding the current element to the existing subarray
            // or starting a new subarray with the current element
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            
            // Update maxSoFar if we find a new maximum subarray sum
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;  // This is the maximum sum subarray
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum is: " + maxSubArraySum(nums));
    }
}

