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

    for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
      if (haystack.substring(i, needle.length() + i).equals(needle)) {
        rs = i;
        break;
      }
    }

    return rs;

  }
}