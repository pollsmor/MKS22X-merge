import java.util.Arrays;

public class Driver {
  public static void main(String[] args) {
    int[] arr = {6, 98421, 10, 91, 8, -9, 7, -195};
    int[] arr2 = {22, 2, 3, 4, 6, 7, 10, 91, 3021, -9, 98421};
    int[] arr3 = {999, 999, 4, 1, 0, 3, 2, 999, 999, 999};

    Merge.mergesort(arr);
    System.out.println();
    Merge.mergesort(arr2);
    System.out.println();
    Merge.mergesort(arr3);
    System.out.println();
  }
}
