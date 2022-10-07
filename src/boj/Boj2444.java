package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2444 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());

    for (int i = 1; i <= 2 * N - 1; i++) {
      if (i < N) {
        for (int j = 0; j < N - i; j++) {
          sb.append(" ");
        }
        for (int k = 0; k < 2 * i - 1; k++) {
          sb.append("*");
        }
      } else if (i > N) {
        for (int j = 0; j < i - N; j++) {
          sb.append(" ");
        }
        for (int k = 0; k < 2 * N - (2 * (i - N) + 1); k++) {
          sb.append("*");
        }
      } else {
        for (int k = 0; k < 2 * N - 1; k++) {
          sb.append("*");
        }
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}
