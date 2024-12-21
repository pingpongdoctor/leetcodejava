import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//380. Insert Delete GetRandom O(1)
// use arraylist and map
public class InsertDeleteGetRandom {
  List<Integer> set;
  Map<Integer, Integer> map;

  public InsertDeleteGetRandom() {
    set = new ArrayList<>();
    map = new HashMap<>();
  }

  public boolean insert(int val) {
    if (!map.containsKey(val)) {
      set.add(val);
      map.put(val, set.size() - 1);
      return true;
    } else {
      return false;
    }
  }

  public boolean remove(int val) {
    if (map.containsKey(val)) {
      int loc = map.get(val);
      int lastIndex = set.size() - 1;
      int lastElement = set.get(lastIndex);
      if (loc < lastIndex) {
        set.set(loc, lastElement);
        map.put(lastElement, loc);
      }

      set.remove(lastIndex);
      map.remove(val);
      return true;
    } else {
      return false;
    }
  }

  public int getRandom() {
    if (map.size() > 0) {
      int rand = (int) (Math.random() * set.size());
      return set.get(rand);
    } else {
      return 0;
    }
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */