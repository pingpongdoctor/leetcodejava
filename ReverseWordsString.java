// 151. Reverse Words in a String
public class ReverseWordsString {
  // two pointers solutions and use regex "\\s+" to split a string into an array
  // of string using separator (delimiter) as multiple spaces
  public String reverseWords(String s) {
    String[] words = s.trim().split("\\s+");
    int L = 0;
    int R = words.length - 1;
    while (L <= R) {
      String temp = words[L];
      words[L] = words[R];
      words[R] = temp;
      L++;
      R--;
    }
    return String.join(" ", words);
  }
}