import java.util.Arrays;

//2300. Successful Pairs of Spells and Potions
public class SuccessfulPairsSpellsPotions {
  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    Arrays.sort(potions);
    int[] rs = new int[spells.length];

    for (int i = 0; i < spells.length; i++) {
      int L = 0;
      int R = potions.length - 1;

      while (L <= R) {
        int mid = (L + R) / 2;
        if ((long) spells[i] * potions[mid] >= success) {
          R = mid - 1;
        } else {
          L = mid + 1;
        }
      }

      rs[i] = potions.length - L;
    }

    return rs;
  }
}