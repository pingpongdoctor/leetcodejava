// 443. String Compression
//use two while loops instead of one for loop to easily count the elements and effortlessly manage pointers
public class StringCompression {
  class Solution {
    public int compress(char[] chars) {
      int index = 0;
      int cp = 0;
      int i = 0;
      while (i < chars.length) {
        int count = 0;
        while (i < chars.length && chars[i] == chars[cp]) {
          count++;
          i++;
        }

        chars[index] = chars[cp];
        cp = i;
        index++;

        if (count > 1) {
          char[] letters = Integer.toString(count).toCharArray();
          for (int j = 0; j < letters.length; j++) {
            chars[index] = letters[j];
            index++;
          }
        }
      }

      return index;
    }
  }
}