import java.util.Arrays;
import java.util.PriorityQueue;

/**
The distance between z and (0,0) is √x2 + y2), in which z is the piint we find and x,y are coordinates
the closest points would have the smallet distance calculated using Euclidean fomular

Solution 1: form the array that includes static arrays which include distance and the index of the points in the original array using (a,b) -> Integer.compare(a[1],b[1])

sort the array based on the distance and return k closest points using the newly formed array.

Time complexity O(nlogn)
Space complexity O(n)
*/

public class Leetcode973{
    public int[][] kClosest1(int[][] points, int k) {
        long[][] array = new long[points.length][2];

        for(int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            long distance = (long)(x*x) + (long)(y*y);
            array[i] = new long[] {distance, i};
        }

        Arrays.sort(array, (a,b) -> Long.compare(a[0],b[0]));

        int[][] result = new int[k][2];

        int j = 0;
        for (int i = 0; i < k; i++) {
            int curIdx = (int) array[i][1];
            result[j] = points[curIdx];
            j++;
        }

        return result;
    }

    public int[][] kClosest2(int[][] points, int k) {
        PriorityQueue<long[]> maxHeap = new PriorityQueue<>((a,b) -> Long.compare(b[0], a[0]));

        for(int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            long distance = (long)(x*x) + (long)(y*y);
            long[] newArray= new long[] {distance, i};
            maxHeap.add(newArray);

            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int j = 0;
        while (!maxHeap.isEmpty()) {
            result[j] = points[(int) maxHeap.poll()[1]];
            j++;
        }

        return result;
    }
}