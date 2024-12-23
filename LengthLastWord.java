// 58. Length of Last Word
public class LengthLastWord {
  public int lengthOfLastWord(String s) {
    String[] list = s.trim().split("\\s+");
    return list[list.length - 1].length();
  }
}