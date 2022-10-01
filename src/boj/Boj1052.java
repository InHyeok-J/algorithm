package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *  물병
 */
public class Boj1052 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int getCount = 0;

    for (int i = 0; i < K - 1; i++) {
      double n = 0;
      int k = 0;
      while (n < N) {
        n = Math.pow(2, k);
        k++;
      }
      N -= (int) n / 2;
    }
    double n = 0;
    int k = 0;
    while (n < N) {
      n = Math.pow(2, k);
      k++;
    }
    //해당 만큼 빌린다.
    getCount = (int) n - N;

    if (getCount == 0) {
      System.out.println(0);
    } else {
      System.out.println(getCount);
    }

  }
}
