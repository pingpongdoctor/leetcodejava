// 12. Integer to Roman
// Math solution
public class IntegerToRoman {
  public String intToRoman(int num) {
    int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    StringBuilder rs = new StringBuilder();
    int i = 0;
    while (i < values.length) {
      while (i < values.length - 1 && num < values[i]) {
        i++;
      }
      while (num >= values[i]) {
        rs.append(symbols[i]);
        num -= values[i];
      }
      i++;
    }
    return rs.toString();
  }
}