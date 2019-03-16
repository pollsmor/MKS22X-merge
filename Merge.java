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
      for (int i = lo; i < midIdx; ++i) {
        left[i - lo] = data[i];
      }

      for (int i = midIdx; i <= hi; ++i) {
        right[i - midIdx] = data[i];
      }

      System.out.println(Arrays.toString(left));
      System.out.println(Arrays.toString(right));
      System.out.println();

      mergesortH(data, lo, midIdx - 1);
      mergesortH(data, midIdx, hi);
    }

    else { //odd-sized array
      for (int i = lo; i <= midIdx; ++i) {
        left[i - lo] = data[i];
      }

      for (int i = midIdx + 1; i <= hi; ++i) {
        right[i - midIdx - 1] = data[i];
      }

      System.out.println(Arrays.toString(left));
      System.out.println(Arrays.toString(right));
      System.out.println();

      mergesortH(data, lo, midIdx);
      mergesortH(data, midIdx + 1, hi);
    }
  }
}
