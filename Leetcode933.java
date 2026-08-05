/**
Solution 1: Utilize queue principle FIFO to track the oldest ping and check if it is valid as well as is included in time range. If not, we can poll it out until we find the new front element of the queue that is a valid ping.

[1], [100], [3001], [3002]
Queue
->3002 3001 100->

range is t - 3000 = 2 <= 100

if queue is empty, just add it to the queue and return 1

else, add new ping, calculate range.
If the peek element is in range (queue.peek() >= t-3000), return the current size of the queue
If not in range, use a while loop to keep polling the peek element out until we find a valid ping

Time Complexity: O(n)
Space Complexity: O(n)

Test
["ping", "ping", "ping", "ping"]
[1], [100], [3001], [3002]
Queue
->3002  3001  100->
peek = 1
lowerBound = 2
[1,2,3,]

Solution 2: Using a static array to store the pings where older pings are saved on the left and new pings are added to the right. Use old pointer to track the least recent valid ping and new pointer to track the latest ping. When we find the invalid oldest ping, keep increment the old pointer to skip it.

["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]

1   100   3001 3002
    s
                e

lowerBound = 2
return 1 2 3 


if the array is empty, add the ping and return 1
else
    add the new ping to the array.if the oldest ping is not valid while (arr[old] < t - 3000 && old < new), old++
    return size of the array (number of valid pings)

Time complexity: O(n)
Space complexity: O(1)

Test
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]

0   1    2       3       4
1  100  3001    3002
    s
                  e

1 < 3002 - 3000 = 2

return 1 2  3   
*/

class RecentCounter {
    int[] requests;
    int start;
    int end;

    public RecentCounter() {
        requests = new int[10000];
        start  = -1;
        end = -1;
    }
    
    public int ping(int t) {
        if (requests[0] == 0) {
            requests[0] = t;
            start, end = 0;
            return 1;
        }

        requests[++end] = t;

        while (start < end && requests[start] < t - 3000) {
            start++;
        }

        return end - start + 1;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */