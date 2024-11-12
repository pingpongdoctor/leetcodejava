// 605. Can Place Flowers
public class CanPlaceFlowers {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int len = flowerbed.length;

    for (int i = 0; i < len; i++) {
      boolean cur = flowerbed[i] == 0;
      boolean next = i == len - 1 || flowerbed[i + 1] == 0;
      boolean before = i == 0 || flowerbed[i - 1] == 0;

      if (cur && next && before) {
        flowerbed[i] = 1;
        n--;
      }
      if (n <= 0) {
        return true;
      }
    }

    return false;
  }
}