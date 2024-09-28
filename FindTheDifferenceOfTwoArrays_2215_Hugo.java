import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheDifferenceOfTwoArrays_2215_Hugo{
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // List<Integer> list1 = new ArrayList<>();
        // List<Integer> list2 = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());

        for (int i:nums1){
            set1.add(i);
        }

        for (int j:nums2){
            set2.add(j);
        }

        for (int i:set1){
            if (!set2.contains(i)){
                answer.get(0).add(i);
            }
        }

        for (int j:set2){
            if (!set1.contains(j)){
                answer.get(1).add(j);
            }
        }

        
        return answer;
    }
}