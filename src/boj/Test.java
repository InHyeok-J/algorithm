package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test {

  static int m, n;

  public static void main(String[] args) throws IOException {
//    int[] arr = {1, 2, 3, 4};
//    m = 4;
//    n = 4;
//    boolean[] visited = new boolean[m];
//    perm(arr, new int[n], visited, 0, m, n);
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(1);
    arr.add(1);
    arr.add(1);
    arr.add(1);
    System.out.println();
    arr.remove(0);

    for(int i : arr){
      System.out.print(i);
    }
    System.out.println();
  }

  static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
    if (depth == r) {
      for (int i : output) {
        System.out.print(i + " ");
      }
      System.out.println();
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        output[depth] = arr[i];
        perm(arr, output, visited, depth + 1, n, r);
        visited[i] = false;
      }
    }
  }

}
