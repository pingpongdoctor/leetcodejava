// 1456. Maximum Number of Vowels in a Substring of Given Length
public class MaximumNumberOfVowelsInSubstringOfGivenLength {
  private boolean isVowel(char inputVal) {
    if (inputVal == 'a' || inputVal == 'e' || inputVal == 'i' || inputVal == 'o' || inputVal == 'u') {
      return true;
    }
    return false;
  }

  public int maxVowels(String s, int k) {
    int L = 0;
    int max = 0;
    int curCount = 0;
    for (int R = 0; R < s.length(); R++) {
      if (isVowel(s.charAt(R))) {
        curCount++;
      }
      if (R - L + 1 == k) {
        max = Math.max(max, curCount);
        if (isVowel(s.charAt(L))) {
          curCount--;
        }
        L++;
      }
    }
    return max;
  }
}
