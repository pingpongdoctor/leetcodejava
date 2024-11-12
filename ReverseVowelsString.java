import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// 345. Reverse Vowels of a String
public class ReverseVowelsString {
  // Using stack
  public String reverseVowels(String s) {
    Stack<Character> stack = new Stack<>();
    List<Character> vowelList = new ArrayList<>();
    Collections.addAll(vowelList, 'a', 'e', 'i', 'o', 'u');

    for (int i = 0; i < s.length(); i++) {
      char cur = s.charAt(i);
      if (vowelList.contains(Character.toLowerCase(cur))) {
        stack.push(cur);
      }
    }
    System.out.println(stack);
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char cur = s.charAt(i);
      if (vowelList.contains(Character.toLowerCase(cur))) {
        char peekChar = stack.pop();
        ans.append(peekChar);
      } else {
        ans.append(cur);
      }
    }

    return ans.toString();
  }

  // Optimal solution using indexOf method of String class to check if a char
  // exsistand String constructor with char[] parameter to build a new String
  // representing a sequence of characters
  public String optimalReverseVowels(String s) {
    String vowels = "aeiouAEIOU";
    char[] arrayStr = s.toCharArray();
    int L = 0;
    int R = arrayStr.length - 1;
    while (L <= R) {
      if (vowels.indexOf(arrayStr[L]) == -1) {
        L++;
        continue;
      }
      if (vowels.indexOf(arrayStr[R]) == -1) {
        R--;
        continue;
      }
      if (vowels.indexOf(arrayStr[R]) != -1 && vowels.indexOf(arrayStr[L]) != -1) {
        char temp = arrayStr[R];
        arrayStr[R] = arrayStr[L];
        arrayStr[L] = temp;
        L++;
        R--;
      }
    }
    return new String(arrayStr);
  }
}