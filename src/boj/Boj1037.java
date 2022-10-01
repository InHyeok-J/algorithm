package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
*  약수
*/

public class Boj1037 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int NCount = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < NCount; i++) {
      int a = Integer.parseInt(st.nextToken());
      max = Math.max(max, a);
      min = Math.min(min, a);
    }
    System.out.println(max*min);
  }
}
