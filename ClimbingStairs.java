// 70. Climbing Stairs

import java.util.HashMap;
import java.util.Map;

class ClimbingStairs {
  Map<Integer,Integer> memo = new HashMap<Integer,Integer>();
  public int climbStairsWithoutMemoize(int n) {
      if (n==1||n==0){
          return 1;
      }
      if(n==2){
          return 2;
      }
      return climbStairsWithoutMemoize(n-1)+climbStairsWithoutMemoize(n-2);
  }
  public int climbStairsWithMemoize(int n) {
      if(n==1){
        return 1;
        }
      if(n==2){
          return 2;
        }

      if(!memo.containsKey(n)){
          memo.put(n,climbStairsWithMemoize(n-1)+climbStairsWithMemoize(n-2));
        }
        return memo.get(n);
    }
}