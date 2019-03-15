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

    //split into left and right arrays
    for (int i = 0; i < data.length; ++i) {
      if (i < midIdx)
        left[i] = data[i];

      else
        right[i - 2] = data[i];
    }

    System.out.println(Arrays.toString(left));
    System.out.println(Arrays.toString(right));
  }
}
