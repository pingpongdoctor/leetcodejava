// 28. Find the Index of the First Occurrence in a String
// two pointers
public class FindIndexFirstOccurrenceString {
  public int strStr(String haystack, String needle) {
    if (needle.length() > haystack.length()) {
      return -1;
    }

    if (needle.length() == haystack.length() && needle.equals(haystack)) {
      return 0;
    }

    if (needle.length() == 1) {
      return haystack.indexOf(needle);
    }

    int rs = -1;

    for (int i = 0; i < haystack.length(); i++) {
      char cur = haystack.charAt(i);

      boolean isValid = false;

      if (cur == needle.charAt(0)) {
        int len = haystack.length() - 1 - i + 1;
        if (len < needle.length()) {
          break;
        }

        for (int j = 1; j < needle.length(); j++) {
          if (haystack.charAt(i + j) != needle.charAt(j)) {
            break;
          }
          if (j == needle.length() - 1) {
            isValid = true;
          }
        }

        if (isValid) {
          rs = i;
          break;
        }
      }
    }

    return rs;

  }
}