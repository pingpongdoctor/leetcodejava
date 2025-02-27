public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int minSum = 0;
        int min = nums[0];
        int maxSum = 0;
        int max = nums[0];
        int total = 0;
        for(int i = 0; i<nums.length; i++){
            if(minSum>0){
                minSum = 0;
            }
            minSum+=nums[i];
            min = Math.min(min,minSum);

            if(maxSum<0){
                maxSum=0;
            }
            maxSum+=nums[i];
            max = Math.max(max,maxSum);

            total+=nums[i];
        }

        return max>0 ? Math.max(max,total-min) : max;
    }
}
