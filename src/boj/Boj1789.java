package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1789 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long N = Long.parseLong(br.readLine());
    long result = 0L;
    long divid = N;
    for (int i = 1; i <= N; i++) {
      divid -= i;
      result++;

      if (divid < i + 1) {
        break;
      }
    }
    System.out.println(result);
  }
}
