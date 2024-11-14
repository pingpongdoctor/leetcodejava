// 443. String Compression
public class StringCompression {
  class Solution {
    public int compress(char[] chars) {
      StringBuilder s = new StringBuilder();
      s.append(chars[0]);
      int count = 0;
      char cur = chars[0];
      for (int i = 0; i < chars.length; i++) {
        if (chars[i] == cur) {
          count++;
        }

        if (chars[i] != cur || i == chars.length - 1) {
          if (count > 1) {
            s.append(count);
          }
          s.append(chars[i]);
          cur = chars[i];
          count = 1;
        }
        if (i == chars.length - 1 && !Character.isDigit(chars[i])) {
          s.deleteCharAt(s.length() - 1);
        }
      }

      char[] ans = s.toString().toCharArray();
      int len = ans.length;
      for (int i = 0; i < len; i++) {
        chars[i] = ans[i];
      }
      return len;
    }
  }
}