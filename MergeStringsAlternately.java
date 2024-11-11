// 1768. Merge Strings Alternately
public class MergeStringsAlternately {
  public String mergeAlternately(String word1, String word2) {
    StringBuilder word = new StringBuilder();
    int len1 = word1.length();
    int len2 = word2.length();
    int len = Math.min(len1, len2);
    int i = 0;
    while (i < len) {
      // concatenation creates new String object every time
      // use StringBuilder class and its append method helps add character to the end
      // of the value of the orriginal String object
      word.append(word1.charAt(i));
      word.append(word2.charAt(i));
      i++;
    }
    if (len1 > len2) {
      while (i < len1) {
        word.append(word1.charAt(i));
        i++;
      }
    }
    if (len2 > len1) {
      while (i < len2) {
        word.append(word2.charAt(i));
        i++;
      }
    }
    return word.toString();
  }
}