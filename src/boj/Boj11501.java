package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *  11501 주식
 * 그리디
 */
public class Boj11501 {

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      int days = Integer.parseInt(br.readLine());
      Long[] stockDays = new Long[days];
      st = new StringTokenizer(br.readLine());

      for (int k = 0; k < days; k++) {
        Long temp = Long.parseLong(st.nextToken());
        stockDays[k] = temp;
      }
      solution(days, stockDays);
    }
    System.out.println(sb);
  }

  public static void solution(int N, Long[] stocks) {
    long result = 0;
    long max = 0;
    for (int i = N - 1; i >= 0; i--) {
      if (stocks[i] > max) {
        max = stocks[i];
      } else {
        result += max - stocks[i];
      }
    }
    sb.append(result).append("\n");
  }

}
