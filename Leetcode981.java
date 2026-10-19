/**
 * Solution: Map each key to a list of Entry (value, timestamp) objects. Timestamps for a key
 * are strictly increasing, so each list is already sorted and get() uses binary search to find
 * the greatest timestamp <= the query.
 *
 * Time complexity: O(1) amortized for set, O(log m) for get, where m is the number of entries for the key
 * Space complexity: O(n), where n is the total number of entries saved in the map
 */

public class Leetcode981 {
    private class Entry {
        String val;
        int timestamp;
        public Entry(String val, int timestamp) {
            this.val = val;
            this.timestamp = timestamp;
        }
    }

    private final HashMap<String, List<Entry>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String val, int timestamp) {
        Entry newEntry = new Entry(val, timestamp);
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(newEntry);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }

        List<Entry> list = map.get(key);
        int l = 0;
        int r = list.size() - 1;
        String result = "";

        while (l <= r) {
            int m = l + (r - l)/2;
            Entry cur = list.get(m);
            int curTimestamp = cur.timestamp;
            String val = cur.val;

            if(curTimestamp == timestamp) {
                return val;
            }

            if(curTimestamp < timestamp) {
                result = val;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */