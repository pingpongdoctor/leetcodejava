// 33. Search in Rotated Sorted Array
// apply binary search in an unsorted array
// find the sorted part
// check if target is in the sorted part to decide where to move L and R pointers
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int L = 0;
        int R = nums.length-1;

        while(L<=R){
            int midIdx = L + (R-L)/2;
            int mid = nums[midIdx];
            int left = nums[L];
            int right = nums[R];

            if(mid==target){
                return midIdx;
            }

            if(mid>=left){
                if(target>=left && target<=mid){
                    R = midIdx - 1;
                } else {
                    L = midIdx + 1;
                }
            } else {
                if(target>=mid && target<=right){
                    L = midIdx + 1;
                } else {
                    R = midIdx - 1;
                }
            }
        }  

        return -1;
    }
}
