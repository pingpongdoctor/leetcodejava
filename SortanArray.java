public class SortanArray {
    class Solution {
        private void quickSort(int[] nums, int low, int high) {
            if (low > high) {
                return;
            }

            // Random pivot to handle the worse case of a ascending sorted array
            int randomIdx = low + (int) (Math.random() * (high - low + 1));

            int temp = nums[high];
            nums[high] = nums[randomIdx];
            nums[randomIdx] = temp;

            int[] bound = partition(nums, low, high);

            quickSort(nums, low, bound[0] - 1);
            quickSort(nums, bound[1] + 1, high);
        }

        private int[] partition(int[] nums, int low, int high) {
            /* Use 3 partitioning way technique to handle the worst case of having duplicate elements,
            which has O(n^2) times */
            int pivot = nums[high];
            int lt = low;
            int gt = high;
            int i = low;

            while (i <= gt) {
                if (nums[i] < pivot) {
                    int temp = nums[i];
                    nums[i] = nums[lt];
                    nums[lt] = temp;
                    lt++;
                    i++;
                } else if (nums[i] > pivot) {
                    int temp = nums[i];
                    nums[i] = nums[gt];
                    nums[gt] = temp;
                    gt--;
                } else {
                    i++;
                }
            }

            int[] results = { lt, gt };
            return results;
        }

        public int[] sortArray(int[] nums) {
            if (nums.length < 2) {
                return nums;
            }
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }
    }
}
