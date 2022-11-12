package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11726 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long[] arr = new long[1001];
    arr[1] = 1;
    arr[2] = 2;
    for (int i = 3; i <= N; i++) {
      arr[i] = arr[i - 1] % 10007 + arr[i - 2] % 10007;
//      System.out.println(arr[i]);
    }

    System.out.println(arr[N] % 10007);
  }
}
