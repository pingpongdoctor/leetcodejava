// 875. Koko Eating Bananas
//change hours to long primitive type since long data range is from -2^63 to 2^63 - 1
public class EatingBananas {
  public int minEatingSpeed(int[] piles, int h) {
      int low = 1;
      int high = 1000000000;
      int k = 0;
      while(low<=high){
          int mid = low + (high - low)/2;
          if(canEatAll(piles, h, mid)){
              k = mid;
              high = mid - 1;
          } else {
              low = mid + 1;
          }
      }
      return k;
  }

  private boolean canEatAll(int[] piles, int h, int k){
      long eatTime = 0;
      for(int i = 0; i<piles.length; i++){
          eatTime = eatTime + (piles[i]/k);
          if(piles[i]%k != 0){eatTime++;}
      }
      return eatTime<=h;
  }
}