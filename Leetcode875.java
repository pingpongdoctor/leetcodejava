/**
Solution 1: Binrary search to search for the optimal speed
questions:
what is the max and min of piles?
what is the max and min of the arr length?
what is the data type of the element?

3  6   7   11

1 to 11

int minimumSpeed = 6;
int min = 4;
int max = 5;

while (min <= max){
    int mid = 4;
    total = 1 + 2 + 2 + 3 = 8
    if total <= h, update minimumSpeed = Math.min(minimumSpeed, mid), max = mid - 1
    if total > h,  min = mid + 1;

    return 4
}

return minimum speed

Time complexity O(nlogk)
Space complexity O(1)

Test
[82,37]
min = 1
max = 82
minSpeed = max_value of integer
mid = 
*/

public class Leetcode875 {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Integer.MIN_VALUE;
        int minSpeed = Integer.MAX_VALUE;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        while (min <= max) {
            int mid = min + (max-min)/2;
            long totalTime = 0;

            for (int pile : piles) {
                totalTime += (long) Math.ceil((double) pile / mid);
            }

            if (totalTime > h) {
                min = mid + 1;
            } else if (totalTime <= h) {
                minSpeed = Math.min(minSpeed,mid);
                max = mid - 1;
            }
        }

        return minSpeed;
    }
}