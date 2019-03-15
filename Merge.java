public class Merge {
  public static void mergesort(int[] data) {
    //Hardcoded case
    if (data.length <= 1)
      return;

    int midIdx = data.length / 2;

    int[] left = new int[midIdx + 1]; //decided that left is always smaller
    int[] right;

    if (midIdx % 2 == 1) //odd-sized array
      right = new int[midIdx + 2];

    else //even-sized array
      right = new int[midIdx + 1];

    //split into left and right arrays
    for (int i = 0; i < data.length; ++i) {
      if (i <= midIdx)
        left[i] = data[i];

      else
        right[i - 2] = data[i];
    }
  }
}
