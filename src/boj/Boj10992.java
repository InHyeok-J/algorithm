package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10992 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    for (int i = 1; i <= N; i++) {
      if (i == 1) {
        for (int j = 0; j < N - i; j++) {
          sb.append(" ");
        }
        sb.append("*");
      } else if (i == N) {
        for (int j = 0; j < 2 * N - 1; j++) {
          sb.append("*");
        }
      } else {
        for (int j = 0; j < N - i; j++) {
          sb.append(" ");
        }
        sb.append("*");
        for (int j = 0; j < 2 * (i - 1) - 1; j++) {
          sb.append(" ");
        }
        sb.append("*");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

}
