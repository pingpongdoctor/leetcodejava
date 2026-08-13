/**
Solution 1: use a hashmap to store sorted string as key and the value is the list of the strings that are anagrams. At each iteration of a loop that iterates all elements of the array, we generate a character array of that string and sort it using Arrays.sort method. Afterwards, we use the sorted array to generate a new sorted string. We then check if the current string after being sorted is included in the map. If yes, we add it to the list of anagrams which is the value of the sorted string key. After the loop ends, we add all values of the keys to a list and return the list.
  0        1       2       3       4       5
"eat"   "tea"   "tan"   "ate"   "nat"   "bat"
                                          i

sortedStr = aet

key     value
aet        {eat, tea, ate}
ant         {tan, nat}
abt             {bat}

Time complexity: O(nklogk)
Space complexity: O(nk)

*/

public class Leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            
            if(map.containsKey(sortedString)) {
                map.get(sortedString).add(strs[i]);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                map.put(sortedString, newList);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> val : map.values()) {
            result.add(val);
        }

        return result;
    }
}