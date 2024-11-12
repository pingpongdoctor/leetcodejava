import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberCandies {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    int len = candies.length;
    List<Boolean> rs = new ArrayList<>();
    int greatestVal = candies[0];
    for (int i = 0; i < len; i++) {
      if (candies[i] > greatestVal) {
        greatestVal = candies[i];
      }
    }
    for (int i = 0; i < len; i++) {
      rs.add(candies[i] + extraCandies >= greatestVal);
    }
    return rs;
  }
}