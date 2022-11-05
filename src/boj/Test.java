package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Test {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    long[] arr = new long[91];

    arr[0] = 0;
    arr[1] = 1;
    for (int i = 2; i <= N; i++) {
      arr[i] = arr[i - 1] + arr[i - 2];
    }
    System.out.println(arr[N]);
  }

  static int[] memo = new int[10000];

  public static int fobo(int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 1;
    }
    //게산돼있다면 리턴한다.
    if (memo[n] != 0) {
      return memo[n];
    }
    memo[n] = fobo(n - 1) + fobo(n - 2);
    return memo[n];
  }

  static int[] bottomUp = new int[10000];

  public static int bottomUp(int n) {
    bottomUp[0] = 1;
    bottomUp[1] = 1;
    for (int i = 2; i <= n; i++) {
      bottomUp[i] = bottomUp[i - 1] + bottomUp[i - 2];
    }
    return bottomUp[n];
  }

}