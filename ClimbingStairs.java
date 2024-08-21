// 70. Climbing Stairs

import java.util.ArrayList;
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
    
    public int climbStairsTabulation(int n) {
      if(n==0||n==1){
        return 1;
      }

      ArrayList<Integer> dp = new ArrayList<Integer>();
      dp.add(1);
      dp.add(1);

      for(int i=2; i<=n; i++){
          dp.add(dp.get(i-1)+dp.get(i-2)); 
      }
      return dp.get(n);
    }

    public int climbStairsIterative(int n) {
      if(n<2){
          return 1;
      }

      int prev=1;
      int cur =1;

      for(int i=2; i<=n; i++){
          int temp = cur;
          cur = prev + cur;
          prev = temp;
      }
      return cur;
  }
}