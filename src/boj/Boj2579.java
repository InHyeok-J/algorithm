package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2579 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    if (N == 1) {
      System.out.println(arr[1]);
      return;
    }
    if (N == 2) {
      System.out.println(arr[2] + arr[1]);
      return;
    }

    int[] stepA = new int[N + 1];
    stepA[0] = 0;
    stepA[1] = arr[1];
    stepA[2] = arr[1] + arr[2];

    for (int i = 3; i <= N; i++) {
      int preMax = Math.max(stepA[i - 2], arr[i - 1] + stepA[i - 3]);
      stepA[i] = preMax + arr[i];
    }
    System.out.println(stepA[N]);
  }

}
