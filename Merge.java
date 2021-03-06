import java.util.Arrays;

public class Merge {
  //Wrapper function for mergesortH
  public static void mergesort(int[] data) {
    //Hardcoded case
    if (data.length <= 1)
      return;

    //temp array optimization
    int[] temp = new int[data.length];
    for (int i = 0; i < data.length; ++i)
      temp[i] = data[i];

    mergesortO(data, temp, 0, data.length - 1);
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

  //Optimized merge sort by swapping between 2 arrays
  private static void mergesortO(int[] data, int[] temp, int lo, int hi) {
    //Thanks Ethan for telling us that a good size for insertion is 25 and less!
    if (hi - lo <= 25) {
      insertionsort(data, lo, hi);
      return;
    }

    boolean isEven = (hi - lo + 1) % 2 == 0;
    int midIdx = 0;

    if (isEven)
      midIdx = (hi - lo) / 2 + lo; //algorithm to calculate midIdx was faulty

    else
      midIdx = (hi - lo) / 2 + lo; //same

    mergesortO(temp, data, lo, midIdx);
    mergesortO(temp, data, midIdx + 1, hi);

    int i = lo; //keeps track of index of merged array
    int l = lo; //index of left array
    int r = midIdx + 1; //index of right array

    while (l <= midIdx && r <= hi) {
      if (temp[l] <= temp[r]) {
        data[i] = temp[l];
        ++l;
      }

      else {
        data[i] = temp[r];
        ++r;
      }

      ++i;
    }

    //The last two whiles are for anything left behind.
    //e.g one side may contain all of the small numbers. Obviously only one will trigger.
    while (l <= midIdx) {
      data[i] = temp[l];
      ++l;
      ++i;
    }

    while (r <= hi) {
      data[i] = temp[r];
      ++r;
      ++i;
    }
  }

  //Insertion sort for further optimization of mergesort
  public static void insertionsort(int[] data, int lo, int hi) {
    for (int i = lo + 1; i <= hi; ++i) { //Start at 1 b/c we assume 0 is sorted already
      int valueAtI = data[i]; //To have something to compare with
      int j = i - 1; //Start from 1 before <?> so that I can loop backwards from it
      //System.out.println(Arrays.toString(data)); //for testing purposes

      while (j >= lo && data[j] > valueAtI) { //Keep shifting left, until I find a pos. where valueAtI is larger than j
        data[j + 1] = data[j]; //Keep shifting everything to the right
        --j; //Loop backwards b/c looping forwards will be slower with larger data sets
      }

      data[j + 1] = valueAtI; //We want data[j] but the while loop does a final --i, we add an index to get j
    }
  }
}
