package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *  캠핑
 */
public class Boj4796 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    StringBuilder sb = new StringBuilder();
    int i = 1;
    while (true) {
      int result = 0;
      st = new StringTokenizer(br.readLine());
      int L = Integer.parseInt(st.nextToken());
      int P = Integer.parseInt(st.nextToken());
      int V = Integer.parseInt(st.nextToken());
      if ((L + P + V) == 0) {
        break;
      }
      int day = V / P;
      int remain = V - (day * P);
      result += day * L;
      if (remain > L) {
        result += L;
      } else {
        result += remain;
      }
      sb.append("Case " + i + ": " + result).append("\n");
      i++;

    }
    System.out.println(sb);
  }
}
