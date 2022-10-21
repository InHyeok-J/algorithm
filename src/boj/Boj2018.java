package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2018 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());

    int result = 0;
    for (int i = 1; i < N / 2 + 1; i++) {
      int current = i;
      int sum = current;

      while (sum < N) {
        sum += ++current;
      }
      if (sum == N) {
        result++;
      }
    }
    System.out.println(result + 1);
  }
}
