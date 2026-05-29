import java.util.HashSet;

public class ContainsDuplicate {
    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int m = l + (r - l) / 2;

        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);

        merge(nums, l, m, r);
    }

    private void merge(int[] nums, int l, int m, int r) {
        int ls = m - l + 1;
        int rs = r - m;

        int[] L = new int[ls];
        int[] R = new int[rs];

        for (int i = 0; i < ls; i++) {
            L[i] = nums[l + i];
        }

        for (int j = 0; j < rs; j++) {
            R[j] = nums[m + 1 + j];
        }

        int k = l;

        int i = 0;
        int j = 0;

        while (i < ls && j < rs) {
            if (L[i] <= R[j]) {
                nums[k] = L[i];
                i++;
            } else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < ls) {
            nums[k] = L[i];
            i++;
            k++;
        }

        while (j < rs) {
            nums[k] = R[j];
            j++;
            k++;
        }
    }

    // 0(nlogn + n)
    public boolean containsDuplicateUsingMergeSort(int[] nums) {
        boolean isDuplicate = false;

        if (nums.length <= 1) {
            return isDuplicate;
        }

        mergeSort(nums, 0, nums.length - 1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                isDuplicate = true;
                break;
            }
        }

        return isDuplicate;
    }

    // O(n)
    public boolean containsDuplicateUsingSet(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();

        for(int num : nums) {
            if(set.contains(num)) {
                return true;
            };
            set.add(num);
        }

        return false;
    }
}
