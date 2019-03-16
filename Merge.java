import java.util.Arrays;

public class Merge {
  //Wrapper function for mergesortH
  public static void mergesort(int[] data) {
    //Hardcoded case
    if (data.length <= 1)
      return;

    mergesortH(data, 0, data.length - 1);
  }

  private static void mergesortH(int[] data, int lo, int hi) {
    //Base case provided by pseudocode in class
    if (lo >= hi)
      return;

    boolean isEven = (hi - lo + 1) % 2 == 0;
    int midIdx = 0;
    int leftArrSize = 0; //decided that left is always larger
    int rightArrSize = 0;

    if (isEven) {
      midIdx = (hi + lo) / 2 + 1;
      leftArrSize = (hi - lo) / 2 + 1;
      rightArrSize = (hi - lo) / 2 + 1;
    }

    else {
      midIdx = (hi + lo) / 2;
      leftArrSize = (hi - lo) / 2 + 1;
      rightArrSize = (hi - lo) / 2; //in an odd-sized array I made the right side always smaller
    }

    int[] left = new int[leftArrSize];
    int[] right = new int[rightArrSize];

    for (int i = 0; i < left.length; ++i)
      left[i] = data[i];

    if (isEven)
      for (int i = 0; i < right.length; ++i)
        right[i] = data[i + midIdx];

    else
      for (int i = 0; i < right.length; ++i)
        right[i] = data[i + midIdx + 1];

    mergesortH(left, 0, left.length - 1);
    mergesortH(right, 0, right.length - 1);

    int i = 0; //keeps track of index of merged array
    int l = 0; //index of left array
    int r = 0; //index of right array

    while (l < left.length && r < right.length) {
      if (left[l] <= right[r]) {
        data[i] = left[l];
        ++l;
      }

      else {
        data[i] = right[r];
        ++r;
      }

      ++i;
    }

    //The last two whiles are for anything left behind.
    while (l < left.length) {
      data[i] = left[l];
      ++l;
      ++i;
    }

    while (r < right.length) {
      data[i] = right[r];
      ++r;
      ++i;
    }
  }
}
