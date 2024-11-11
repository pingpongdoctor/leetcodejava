// 1071. Greatest Common Divisor of Strings
public class GreatestCommonDivisorStrings {
  private boolean isDivision(String str1, String str2) {
    StringBuilder str = new StringBuilder();
    while (str.length() < str2.length()) {
      str.append(str1);
    }
    return str.toString().equals(str2);
  }

  public String gcdOfStrings(String str1, String str2) {
    int len1 = str1.length();
    int len2 = str2.length();
    int len = Math.min(len1, len2);
    int count = 0;
    String rs = "";
    int i = 0;
    while (i < len) {
      String curSubstring = str1.substring(0, i + 1);
      if (isDivision(curSubstring, str1) && isDivision(curSubstring, str2) && curSubstring.length() > count) {
        rs = curSubstring;
      }
      i++;
    }
    return rs;
  }
}
// optimal solution
