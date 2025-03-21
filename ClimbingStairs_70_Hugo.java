
// 70. Climbing Stairs
import java.util.HashMap;
import java.util.Map;

class ClimbingStairs_70_Hugo {
    Map<Integer, Integer> track = new HashMap<>();

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        if (track.containsKey(n)) {
            return track.get(n);
        } else {
            int currentSteps = climbStairs(n - 1) + climbStairs(n - 2);
            track.put(n, currentSteps);
            return currentSteps;
        }

    }

}