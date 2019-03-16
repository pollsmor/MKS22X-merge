import java.util.Arrays;

public class Merge {
  public static void mergesort(int[] data) {
    //Hardcoded case
    if (data.length <= 1)
      return;

    mergesortH(data, 0, data.length - 1);
  }

  private static void mergesortH(int[] data, int lo, int hi) {
    if (lo >= hi)
      return;

    boolean isEven = (hi - lo + 1) % 2 == 0;
    int midIdx = 0;
    int leftArrSize = 0;
    int rightArrSize = 0;

    if (isEven) {
      midIdx = (hi + lo) / 2 + 1;
      leftArrSize = (hi - lo) / 2 + 1;
      rightArrSize = (hi - lo) / 2 + 1;
    }

    else {
      midIdx = (hi + lo) / 2;
      leftArrSize = (hi - lo) / 2;
      rightArrSize = (hi - lo) / 2;
    }

    int[] left = new int[leftArrSize]; //decided that left is always larger
    int[] right = new int[rightArrSize];

    if (isEven) {
      for (int i = lo; i < midIdx; ++i)
        left[i - lo] = data[i];

      for (int i = midIdx; i <= hi; ++i)
        right[i - midIdx] = data[i];
    }

    else { //odd-sized array
      for (int i = lo; i <= midIdx; ++i)
        left[i - lo] = data[i];

      for (int i = midIdx + 1; i <= hi; ++i)
        right[i - midIdx - 1] = data[i];
    }

    mergesortH(left, 0, left.length - 1);
    mergesortH(right, 0, right.length - 1);

    int i = 0;
    int l = 0;
    int r = 0;

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

    while (l < left.length) {
      data[i] = left[l];
      ++l;
      ++i;
    }

    System.out.println(Arrays.toString(data));
  }
}
