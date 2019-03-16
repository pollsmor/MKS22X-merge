import java.util.Arrays;

public class Merge {
  public static void mergesort(int[] data) {
    //Hardcoded case
    if (data.length <= 1)
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
      if (data.length % 2 == 0)
        right[i] = data[i + midIdx];

      else
        right[i] = data[i + midIdx + 1];
    }

    System.out.println(Arrays.toString(left));
    System.out.println(Arrays.toString(right));
  }
}
