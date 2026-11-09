import java.util.HashMap;

//Counting sort. Time Complexity: O(n). Space complexity: O(1)
class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        int j = 0;

        for(int i = 0; i < 3; i++) {
            if(!map.containsKey(i)) {
                continue;
            }
            while(map.get(i) > 0) {
                nums[j] = i;
                map.put(i, map.get(i) - 1);
                j++;
            }
        }
    }
}