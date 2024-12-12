//88. Merge Sorted Array
public class MergeSortedArray {
  // use quicksort to sort inplace
  public void quickSort(int[] list, int s, int e) {
    if (s < e) {
      int l = s;
      int pivot = list[e];
      for (int i = s; i < e; i++) {
        if (list[i] < pivot) {
          int tmp = list[l];
          list[l] = list[i];
          list[i] = tmp;
          l++;
        }
      }
      list[e] = list[l];
      list[l] = pivot;
      quickSort(list, s, l - 1);
      quickSort(list, l + 1, e);
    }
  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int j = 0;
    for (int i = m; i < nums1.length; i++) {
      nums1[i] = nums2[j];
      j++;
    }
    quickSort(nums1, 0, nums1.length - 1);
  }

  // use two pointers to compare two elements from the right most index
  // this is apart of merge sort algorithm
  public void merge2(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;
    while (i >= 0 && j >= 0) {
      if (nums1[i] >= nums2[j]) {
        nums1[k] = nums1[i];
        i--;
      } else {
        nums1[k] = nums2[j];
        j--;
      }
      k--;
    }
    while (i >= 0) {
      nums1[k] = nums1[i];
      i--;
      k--;
    }
    while (j >= 0) {
      nums1[k] = nums2[j];
      j--;
      k--;
    }
  }
}