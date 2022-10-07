package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 *  별찍기 11
 */
public class Test {

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int arr[] = {1, 2, 3, 4};
    permutation(arr, 0, arr.length, 2);
  }

  public static void permutation(int[] arr, int depth, int n, int r) {

    if (depth == r) {
      print(arr, r);
      return;
    }

    for (int i = depth; i < n; i++) {
      swap(arr, depth, i);
      permutation(arr, depth + 1, n, r);
      swap(arr, depth, i);
    }
  }

  static void swap(int[] arr, int depth, int i) {
    int temp = arr[depth];
    arr[depth] = arr[i];
    arr[i] = temp;
  }

  static void print(int[] arr, int r) {
    for (int i = 0; i < r; i++) {
      int t = arr[i];
      System.out.print(t + " ");
    }
    System.out.println();
  }
}
