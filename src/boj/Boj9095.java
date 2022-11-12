package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9095 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int Tcase = Integer.parseInt(br.readLine());
    int[] arr = new int[12];
    int[] tests = new int[Tcase];

    arr[1] = 1;
    arr[2] = 2;
    arr[3] = 4;
    for (int i = 4; i < 12; i++) {
      arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
    }

    for (int i = 0; i < Tcase; i++) {
      tests[i] = Integer.parseInt(br.readLine());
    }

    for (int i = 0; i < Tcase; i++) {
      int v = tests[i];
      System.out.println(arr[v]);
    }
  }

}
