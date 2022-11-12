package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1463 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N + 1];
    arr[0] = 0;
    arr[1] = 0;
    for (int i = 2; i <= N; i++) {
      if (i % 2 == 0 && i % 3 == 0) {
        arr[i] = Math.min(arr[i / 2], arr[i / 3]) + 1;
      } else if (i % 2 == 0) {
        arr[i] = Math.min(arr[i / 2], arr[i - 1]) + 1;
      } else if (i % 3 == 0) {
        arr[i] = Math.min(arr[i / 3], arr[i - 1]) + 1;
      } else {
        arr[i] = arr[i - 1] + 1;
      }
    }
    System.out.println(arr[N]);
  }
}
