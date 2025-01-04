// 125. Valid Palindrome
// two pointers
// use isLetterOrDigit static method of Character class
public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    char[] letters = s.toCharArray();
    int L = 0;
    int R = letters.length - 1;
    boolean rs = true;
    while (L < R) {
      char c1 = Character.toLowerCase(letters[L]);
      char c2 = Character.toLowerCase(letters[R]);
      while (L < R && !Character.isLetterOrDigit(c1)) {
        L++;
        c1 = Character.toLowerCase(letters[L]);
      }
      while (L < R && !Character.isLetterOrDigit(c2)) {
        R--;
        c2 = Character.toLowerCase(letters[R]);
      }
      if (c1 != c2) {
        rs = false;
        break;
      } else {
        L++;
        R--;
      }
    }
    return rs;
  }
}