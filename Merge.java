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

    int midIdx = data.length / 2;
    int[] left; //decided that left is always larger
    int[] right = new int[midIdx];

    if (data.length % 2 == 0) //even-sized array
      left = new int[midIdx];

    else //odd-sized array
      left = new int[midIdx + 1];

    //Copy into left array
    for (int i = 0; i < left.length; ++i)
      left[i] = data[i];

    for (int i = 0; i < right.length; ++i) {
      if (data.length % 2 == 0) //copy into right if even-sized array
        right[i] = data[i + midIdx];

      else //copy into right if odd-sized array
        right[i] = data[i + midIdx + 1];
    }
  }
}
