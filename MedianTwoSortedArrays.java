// 4. Median of Two Sorted Arrays
// Binary search two arrays to find the right partitions
public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        
        int half = (m+n+1)/2;
        int l = 0;
        int r = m;
        while(l<=r){
            int pX = l + (r-l)/2;
            int pY = half - pX;
            int maxX = pX==0 ? Integer.MIN_VALUE : nums1[pX-1];
            int minX = pX==m ? Integer.MAX_VALUE : nums1[pX];
            int maxY = pY==0 ? Integer.MIN_VALUE : nums2[pY-1];
            int minY = pY==n ? Integer.MAX_VALUE : nums2[pY];

            if(maxX<=minY && maxY<=minX){
                if((m+n)%2==0){
                    return ((double) (Math.max(maxX,maxY) + Math.min(minX,minY)))/2;
                } else {
                    return (double) Math.max(maxX,maxY);
                }
            } else if(maxX>minY){
                r = pX - 1;
            } else {
                l = pX + 1;
            }
        }
        return 0.0;
    }
}
