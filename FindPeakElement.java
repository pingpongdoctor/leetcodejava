// 162. Find Peak Element
//Binary search
public class FindPeakElement {
  public int findPeakElement(int[] nums) {
    if(nums.length==1){
        return 0;
    }
    int L = 0;
    int R = nums.length-1;
    
    while(L<=R){
        int mid = L + (R-L)/2;
        int cur = nums[mid];
        int before = mid==0 ? cur-1 : nums[mid-1];
        int after = mid==nums.length-1 ? cur-1 : nums[mid+1];
        if(cur>before && cur>after){
            return mid;
        } else if(cur<=after){
            L = mid+1;
        } else if(cur<=before){
            R = mid-1;
        }
    }
    return -1;
}
}