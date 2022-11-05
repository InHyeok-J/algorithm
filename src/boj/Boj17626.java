package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj17626 {

  static int[] arr = new int[50001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    arr[1] = 1;
    for (int i = 2; i <= N; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = 1; j * j <= i; j++) {
        int temp = i - j * j;
        min = Math.min(min, arr[temp]);
      }
      arr[i] = min + 1;
    }
    System.out.println(arr[N]);
  }

}
