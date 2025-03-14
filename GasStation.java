// 134. Gas Station
// Greedy solution
public class GasStation {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int tank = 0;
    int start = 0;
    int totalGas = 0;
    int totalCost = 0;
    for (int i = 0; i < gas.length; i++) {
      totalGas += gas[i];
      totalCost += cost[i];
      tank += gas[i] - cost[i];
      if (tank < 0) {
        tank = 0;
        start = i + 1;
      }
    }
    return totalGas >= totalCost ? start : -1;
  }
}