// 153. Find Minimum in Rotated Sorted Array
public class FindMinimumRotatedSortedArray{
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int L = 0;
        int R = nums.length-1;
        
        while(L<=R){
            int midIdx = L + (R-L)/2;
            int mid = nums[midIdx];
            //the left part is sorted
            // L is the smallest on the left
            if(mid>=nums[L]){
                min=Math.min(min,nums[L]);
                L = midIdx+1;
            } else {
                //the right part is sorted
                //mid is the smallest on the right
                min=Math.min(min,mid);
                R = midIdx-1;
            }
        }
        return min;
     }
}