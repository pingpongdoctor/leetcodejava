import java.util.HashMap;
import java.util.Map;

// 13. Roman to Integer
// hashmap solution
public class RomanToInteger {
  public int romanToInt(String s) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);

    int sum = map.get(s.charAt(0));

    for (int i = 1; i < s.length(); i++) {
      char curChar = s.charAt(i);
      char prevChar = s.charAt(i - 1);
      int cur = map.get(curChar);
      int prev = map.get(prevChar);
      sum += cur;
      if (cur > prev) {
        sum -= prev * 2;
      }
    }
    return sum;
  }
}
